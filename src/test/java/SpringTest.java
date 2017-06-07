import cn.sioo.pojo.SmsUserControl;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.service.SmsUserControlService;
import cn.sioo.service.SmsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by morrigan on 2017/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/bak.xml", "classpath:spring/mybatis21.xml", "classpath:spring/mybatis31.xml"})
public class SpringTest {

    @Autowired
    private SmsUserService smsUserService;

    @Autowired
    private SmsUserConsumeService smsUserConsumeService;

    @Autowired
    private SmsUserControlService smsUserControlService;

    @Test
    public void count31() {
        int count1 = smsUserService.selectCount31(null);
        int count2 = smsUserConsumeService.selectCount31(null);
        System.out.println(count1);
        System.out.println(count2);
    }

    @Test
    public void count21() {
        int count = smsUserConsumeService.selectCount21(null);
        System.out.println(count);
    }




    @Test
    public void getDiffrent(){
        List<SmsUserControl> list21 =smsUserControlService.selectList21(null);
        List<SmsUserControl> list31= smsUserControlService.selectList31(null);
        List<SmsUserControl> diffrent = getDiffrentDel(list21, list31);
        for (SmsUserControl smsUserControl : diffrent) {
            System.out.println(smsUserControl.getUid());
        }
    }


    public List<SmsUserControl> getDiffrentAdd(List<SmsUserControl> list21, List<SmsUserControl> list31) {
        List<SmsUserControl> diff = new ArrayList<>();
        List<SmsUserControl> maxList = list21;
        List<SmsUserControl> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<SmsUserControl, Integer> map = new HashMap<>(maxList.size());
        for (SmsUserControl smsUserControl : maxList) {
            map.put(smsUserControl, 1);
        }
        for (SmsUserControl smsUserControl : minList) {
            if (map.get(smsUserControl) != null) {
                map.put(smsUserControl, 2);
                continue;
            }
            diff.add(smsUserControl);
        }
        for (Map.Entry<SmsUserControl, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1&&list21.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }


    public List<SmsUserControl> getDiffrentDel(List<SmsUserControl> list21, List<SmsUserControl> list31) {
        List<SmsUserControl> diff = new ArrayList<>();
        List<SmsUserControl> maxList = list21;
        List<SmsUserControl> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<SmsUserControl, Integer> map = new HashMap<>(maxList.size());
        for (SmsUserControl smsUserControl : maxList) {
            map.put(smsUserControl, 1);
        }
        for (SmsUserControl smsUserControl : minList) {
            if (map.get(smsUserControl) != null) {
                map.put(smsUserControl, 2);
                continue;
            }
            diff.add(smsUserControl);
        }
        for (Map.Entry<SmsUserControl, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1&&list31.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }


    @Test
    public void delByIDS(){
        List<Integer> list=new ArrayList<>();
        list.add(25);
        list.add(26);
        smsUserControlService.delByIds(list);
    }

}
