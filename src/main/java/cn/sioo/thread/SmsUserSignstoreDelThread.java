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

        Map<Integer, Integer> map = new HashMap<>();
        for (SmsUserSignstore SmsUserSignstore : list21) {
            map.put(SmsUserSignstore.getId(), 1);
        }
        for (SmsUserSignstore smsUserSignstore : list31) {
            if (map.get(smsUserSignstore.getId()) == null) {
                diff.add(smsUserSignstore.getId());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
