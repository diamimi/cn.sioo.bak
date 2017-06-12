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
 * Created by morrigan on 2017/6/8.
 */
public class SmsUserSignstoreThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsUserSignstoreThread.class);

    public SmsUserSignstoreService smsUserSignstoreService;


    public SmsUserSignstoreThread(SmsUserSignstoreService smsUserSignstoreService) {
        this.smsUserSignstoreService = smsUserSignstoreService;
    }


    public List<SmsUserSignstore> getDiffrentAdd(List<SmsUserSignstore> list21, List<SmsUserSignstore> list31) {
        List<SmsUserSignstore> diff = new ArrayList<>();
        Map<Integer, SmsUserSignstore> map = new HashMap<>();
        for (SmsUserSignstore smsUserSignstore : list31) {
            map.put(smsUserSignstore.getId(), smsUserSignstore);
        }
        for (SmsUserSignstore smsUserSignstore : list21) {
            if (!(map.get(smsUserSignstore.getId()) != null
                    && map.get(smsUserSignstore.getId() ).equals(smsUserSignstore))) {
                diff.add(smsUserSignstore);
            }
        }
        return diff;
    }

    public List<Integer> getDiffrentDel(List<SmsUserSignstore> list21, List<SmsUserSignstore> list31) {
        if(list31.size()-list21.size()>=1&&list31.size()-list21.size()<=5){
            List<Integer> diff = new ArrayList<>();
            Map<Integer, SmsUserSignstore> map = new HashMap<>();
            for (SmsUserSignstore smsUserSignstore : list21) {
                map.put(smsUserSignstore.getId(), smsUserSignstore);
            }
            for (SmsUserSignstore smsUserSignstore : list31) {
                if (!(map.get(smsUserSignstore.getId()) != null
                        && map.get(smsUserSignstore.getId() ).equals(smsUserSignstore))) {
                    diff.add(smsUserSignstore.getId());
                }
            }
            return diff;
        }
      return null;
    }



    @Override
    public void run() {
        try {
            List<SmsUserSignstore> list21 = smsUserSignstoreService.selectList21(null);
            List<SmsUserSignstore> list31 = smsUserSignstoreService.selectList31(null);
            List<SmsUserSignstore> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("SmsUserSignstore,数量:{}", diffrentAdd.size());
                List<Integer> ids=new ArrayList<>();
                for (SmsUserSignstore smsUserSignstore : diffrentAdd) {
                    ids.add(smsUserSignstore.getId());
                }
                smsUserSignstoreService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsUserSignstore> subList = diffrentAdd.subList(0, limitSize);
                        smsUserSignstoreService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsUserSignstoreService.insertList(diffrentAdd);
                    }
                } else {
                    smsUserSignstoreService.insertList(diffrentAdd);
                }
                List<Integer> diffrentDel = getDiffrentDel(list21, list31);
                if(diffrentDel!=null&&diffrentDel.size()>0){
                    smsUserSignstoreService.delByIds(diffrentDel);
                    LOGGER.info("SmsUserSignstore,减去数量:{}", diffrentDel.size());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
