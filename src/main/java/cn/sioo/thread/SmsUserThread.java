package cn.sioo.thread;

import cn.sioo.pojo.SmsUser;
import cn.sioo.service.SmsUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/8.
 */
public class SmsUserThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserThread.class);

    public SmsUserService smsUserService;


    public SmsUserThread(SmsUserService smsUserService) {
        this.smsUserService = smsUserService;
    }



    public List<SmsUser> getDiffrentAdd(List<SmsUser> list21, List<SmsUser> list31) {
        List<SmsUser> diff = new ArrayList<>();
        Map<Integer, SmsUser> map = new HashMap<>();
        for (SmsUser smsUser : list31) {
            map.put(smsUser.getId(), smsUser);
        }
        for (SmsUser smsUser : list21) {
            if (!(map.get(smsUser.getId()) != null &&map.get(smsUser.getId()).equals(smsUser))) {
                diff.add(smsUser);
            }

        }
        return diff;
    }

    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            List<SmsUser> list21 = smsUserService.selectList21(null);
            List<SmsUser> list31 = smsUserService.selectList31(null);
            List<SmsUser> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("更新SmsUser,数量:{}",diffrentAdd.size());
                List<Integer> ids=new ArrayList<>();
                for (SmsUser smsUser : diffrentAdd) {
                    ids.add(smsUser.getId());
                }
                smsUserService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUser> subList = diffrentAdd.subList(0, limitSize);
                        smsUserService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserService.insertList(diffrentAdd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
