import cn.sioo.pojo.SmsUser;
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
    public void test1() {
  /*      List<SmsUser> list21 = smsUserService.selectList21(null);
        List<SmsUser> list31 = smsUserService.selectList31(null);*/
        List<SmsUser> list21 = new ArrayList<SmsUser>();
        List<SmsUser> list31 = new ArrayList<SmsUser>();
        SmsUser smsUser1=new SmsUser();
        SmsUser smsUser2=new SmsUser();
        smsUser1.setId(2);
        smsUser1.setSms(22);
        smsUser2.setId(2);
        smsUser2.setSms(222);
        list21.add(smsUser1);
        list31.add(smsUser2);
        List<SmsUser> diffrentAdd = getDiffrentAdd(list21, list31);
        for (SmsUser smsUser : diffrentAdd) {
            System.out.println(smsUser.getId());
        }
    }


    public List<SmsUser> getDiffrentAdd(List<SmsUser> list2, List<SmsUser> list31) {
        List<SmsUser> diff = new ArrayList<>();
       /* List<SmsUser> maxList = list2;
        List<SmsUser> minList = list31;
        if (list31.size() > list2.size()) {
            maxList = list31;
            minList = list2;
        }*/
        Map<Integer, SmsUser> map = new HashMap<>();
        for (SmsUser smsUser : list31) {
            map.put(smsUser.getId(), smsUser);
        }
        for (SmsUser smsUser : list2) {
            if (map.get(smsUser.getId()) != null && map.get(smsUser.getId()).equals(smsUser)) {
                smsUser.setDiff(2);
                map.put(smsUser.getId(), smsUser);
                continue;
            }
            diff.add(smsUser);
        }
        for (Map.Entry<Integer, SmsUser> entry : map.entrySet()) {
            if (entry.getValue().getDiff() == 1&&list2.contains(entry.getValue())) {
                diff.add(entry.getValue());
            }
        }
        return diff;
    }


}
