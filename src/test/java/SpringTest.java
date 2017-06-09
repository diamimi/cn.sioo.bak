import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.service.SmsUserControlService;
import cn.sioo.service.SmsUserService;
import cn.sioo.service.SmsUserSignstoreService;
import cn.sioo.util.DateUtils;
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

    @Autowired
    private SmsUserControlService smsUserControlService;

    @Autowired
    private SmsUserSignstoreService smsUserSignstoreService;



    @Test
    public void test1() {
       int date= DateUtils.getDay()-1;
       SmsUserConsume smsUserConsume=new SmsUserConsume();
       smsUserConsume.setDate(date);
       smsUserConsume.setPageIndex(0);
       smsUserConsume.setPageSize(1000);
        List<SmsUserConsume> list= smsUserConsumeService.selectLConsumeistLimit(smsUserConsume);
        System.out.println(list.size());

    }





}
