package cn.sioo.thread;

import cn.sioo.pojo.SmsReleaseTemplate;
import cn.sioo.service.SmsReleaseTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/8.
 */
public class SmsReleaseTemplateThread implements Runnable {

    public static Logger LOGGER = LoggerFactory.getLogger(SmsReleaseTemplateThread.class);
    public SmsReleaseTemplateService smsReleaseTemplateService;


    public SmsReleaseTemplateThread(SmsReleaseTemplateService smsReleaseTemplateService) {
        this.smsReleaseTemplateService = smsReleaseTemplateService;
    }


    public List<SmsReleaseTemplate> getDiffrentAdd(List<SmsReleaseTemplate> list21, List<SmsReleaseTemplate> list31) {
        List<SmsReleaseTemplate> diff = new ArrayList<>();
        Map<Integer, SmsReleaseTemplate> map = new HashMap<>();
        for (SmsReleaseTemplate SmsReleaseTemplate : list31) {
            map.put(SmsReleaseTemplate.getId(), SmsReleaseTemplate);
        }
        for (SmsReleaseTemplate SmsReleaseTemplate : list21) {
            if (!(map.get(SmsReleaseTemplate.getId()) != null
                    && map.get(SmsReleaseTemplate.getId() ).equals(SmsReleaseTemplate))) {
                diff.add(SmsReleaseTemplate);
            }
        }
        return diff;
    }

    public List<Integer> getDiffrentDel(List<SmsReleaseTemplate> list21, List<SmsReleaseTemplate> list31) {
        if(list31.size()-list21.size()>=1&&list31.size()-list21.size()<=5){
            List<Integer> diff = new ArrayList<>();
            Map<Integer, SmsReleaseTemplate> map = new HashMap<>();
            for (SmsReleaseTemplate SmsReleaseTemplate : list21) {
                map.put(SmsReleaseTemplate.getId(), SmsReleaseTemplate);
            }
            for (SmsReleaseTemplate SmsReleaseTemplate : list31) {
                if (!(map.get(SmsReleaseTemplate.getId()) != null
                        && map.get(SmsReleaseTemplate.getId() ).equals(SmsReleaseTemplate))) {
                    diff.add(SmsReleaseTemplate.getId());
                }
            }
            return diff;
        }
        return null;
    }



    @Override
    public void run() {
        try {
            List<SmsReleaseTemplate> list21 = smsReleaseTemplateService.selectList21(null);
            List<SmsReleaseTemplate> list31 = smsReleaseTemplateService.selectList31(null);
            List<SmsReleaseTemplate> diffrentAdd = getDiffrentAdd(list21, list31);
            if (diffrentAdd.size() > 0) {
                LOGGER.info("SmsReleaseTemplate,数量:{}", diffrentAdd.size());
                List<Integer> ids=new ArrayList<>();
                for (SmsReleaseTemplate SmsReleaseTemplate : diffrentAdd) {
                    ids.add(SmsReleaseTemplate.getId());
                }
                smsReleaseTemplateService.delByIds(ids);
                if (diffrentAdd.size() > 3000) {
                    int limitSize = 3000;
                    int part = diffrentAdd.size() / limitSize;
                    for (int i = 0; i < part; i++) {
                        List<SmsReleaseTemplate> subList = diffrentAdd.subList(0, limitSize);
                        smsReleaseTemplateService.insertList(subList);
                        diffrentAdd.subList(0, limitSize).clear();
                    }
                    if (!diffrentAdd.isEmpty()) {
                        smsReleaseTemplateService.insertList(diffrentAdd);
                    }
                } else {
                    smsReleaseTemplateService.insertList(diffrentAdd);
                }
            }
            List<Integer> diffrentDel = getDiffrentDel(list21, list31);
            if(diffrentDel!=null&&diffrentDel.size()>0){
                smsReleaseTemplateService.delByIds(diffrentDel);
                LOGGER.info("SmsReleaseTemplate,减去数量:{}", diffrentDel.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
