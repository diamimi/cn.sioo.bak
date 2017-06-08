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
    public void test1(){
     /*   List<SmsUser> list21 = smsUserService.selectList21(null);
        List<SmsUser> list31 = smsUserService.selectList31(null);
        List<SmsUser> diffrentAdd = getDiffrentAdd1(list21, list31);
        for (SmsUser smsUser : diffrentAdd) {
            System.out.println(smsUser.getId());
        }*/
    }

    @Test
    public void test2(){
        List<SmsUser> list21=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SmsUser smsUser=new SmsUser();
            smsUser.setId(i);
            list21.add(smsUser);
        }
        List<SmsUser> list31=new ArrayList<>();
        for (int i = 7; i < 17; i++) {
            SmsUser smsUser=new SmsUser();
            smsUser.setId(i);
            list31.add(smsUser);
        }
        List<SmsUser> diffrentAdd1 = getDiffrentAdd1(list21, list31);
        for (SmsUser smsUser : diffrentAdd1) {
            System.out.println(smsUser.getId());
        }
    }


    public List<SmsUser> getDiffrentAdd1(List<SmsUser> list21, List<SmsUser> list31) {
        List<SmsUser> diff = new ArrayList<>();
        List<SmsUser> maxList = list21;
        List<SmsUser> minList = list31;
        if (list31.size() > list21.size()) {
            maxList = list31;
            minList = list21;
        }
        Map<SmsUser, Integer> map = new HashMap<>(maxList.size());
        for (SmsUser smsUser : maxList) {
            map.put(smsUser, 1);
        }
        for (SmsUser smsUser : minList) {
            if (map.get(smsUser) != null) {
                map.put(smsUser, 2);
                continue;
            }
                diff.add(smsUser);
        }
        for (Map.Entry<SmsUser, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && list21.contains(entry.getKey())) {
                diff.add(entry.getKey());
            }
        }
        return diff;

    }





}
