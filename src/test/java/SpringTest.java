import cn.sioo.pojo.SmsUser;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.service.SmsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
    public void findList(){
        List<SmsUser> smsUsers = smsUserService.selectListLimit(new SmsUser(), 0, 15);
        for (SmsUser smsUser : smsUsers) {
            System.out.println(smsUser.getId()+"_"+smsUser.getLinkman());
        }
    }



}
