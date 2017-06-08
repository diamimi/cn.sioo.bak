package cn.sioo.thread;

import cn.sioo.pojo.SmsUserSignstore;
import cn.sioo.service.SmsUserSignstoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/3.
 */
public class SmsUserSignstoreDelThread implements Runnable {


    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserSignstoreDelThread.class);

    public SmsUserSignstoreService smsUserSignstoreService;

    public SmsUserSignstoreDelThread(SmsUserSignstoreService smsUserSignstoreService) {
       this.smsUserSignstoreService=smsUserSignstoreService;
    }


    public List<Integer> getDiffrentDel(List<SmsUserSignstore> list21, List<SmsUserSignstore> list31) {
        List<Integer> diff = new ArrayList<>();
        List<SmsUserSignstore> maxList = list21;
        List<SmsUserSignstore> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<Integer, Integer> map = new HashMap<>(maxList.size());
        for (SmsUserSignstore SmsUserSignstore : maxList) {
            map.put(SmsUserSignstore.getId(), 1);
        }
        for (SmsUserSignstore SmsUserSignstore : minList) {
            if (map.get(SmsUserSignstore.getId()) != null) {
                map.put(SmsUserSignstore.getId(), 2);
                continue;
            }
            diff.add(SmsUserSignstore.getId());
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && list31.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }

    @Override
    public void run() {
        try {
            long begin = System.currentTimeMillis();
            List<SmsUserSignstore> list21 = smsUserSignstoreService.selectList21(null);
            List<SmsUserSignstore> list31 = smsUserSignstoreService.selectList31(null);
            List<Integer> diffrentDel = getDiffrentDel(list21, list31);
            if (diffrentDel.size() > 0) {
                smsUserSignstoreService.delByIds(diffrentDel);
            }
            LOGGER.info("备份耗时:{},{}", (System.currentTimeMillis() - begin), "SmsUserSignstore 删除");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
