package cn.sioo.thread;

import cn.sioo.pojo.GatewayChannel;
import cn.sioo.service.GatewayChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/8.
 */
public class GatewayChannelThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(GatewayChannelThread.class);

    public GatewayChannelService gatewayChannelService;


    public GatewayChannelThread(GatewayChannelService gatewayChannelService) {
        this.gatewayChannelService = gatewayChannelService;
    }


    public List<GatewayChannel> getDiffrentAdd(List<GatewayChannel> list21, List<GatewayChannel> list31) {
        List<GatewayChannel> diff = new ArrayList<>();
        Map<Integer, GatewayChannel> map = new HashMap<>();
        for (GatewayChannel gatewayChannel : list31) {
            map.put(gatewayChannel.getId(), gatewayChannel);
        }
        for (GatewayChannel gatewayChannel : list21) {
            if (!(map.get(gatewayChannel.getId()) != null
                    && map.get(gatewayChannel.getId() ).equals(gatewayChannel))) {
                diff.add(gatewayChannel);
            }
        }
        return diff;
    }


    @Override
    public void run() {
        try {
            List<GatewayChannel> list21 = gatewayChannelService.selectList21(null);
            List<GatewayChannel> list31 = gatewayChannelService.selectList31(null);
            List<GatewayChannel> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("GatewayChannel,数量:{}", diffrentAdd.size());
                List<Integer> ids=new ArrayList<>();
                for (GatewayChannel gatewayChannel : diffrentAdd) {
                    ids.add(gatewayChannel.getId());
                }
                gatewayChannelService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<GatewayChannel> subList = diffrentAdd.subList(0, limitSize);
                        gatewayChannelService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        gatewayChannelService.insertList(diffrentAdd);
                    }
                } else {
                    gatewayChannelService.insertList(diffrentAdd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
