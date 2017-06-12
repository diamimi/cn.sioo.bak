import cn.sioo.pojo.SmsSendHistoryBackups;
import cn.sioo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by morrigan on 2017/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/bak.xml", "classpath:spring/mybatis21.xml", "classpath:spring/mybatis31.xml",
        "classpath:spring/mybatis35.xml"})
public class SpringTest {

    @Autowired
    private SmsUserService smsUserService;

    @Autowired
    private SmsUserConsumeService smsUserConsumeService;

    @Autowired
    private SmsUserControlService smsUserControlService;

    @Autowired
    private SmsUserSignstoreService smsUserSignstoreService;

    @Autowired
    private SmsSendHistoryBackupsService smsSendHistoryBackupsService;

    @Autowired
    private SmsUserHistoryService smsUserHistoryService;


    @Test
    public void test1() throws Exception{
        SmsSendHistoryBackups start = new SmsSendHistoryBackups();
        start.setSenddate(new BigInteger("20170101000000"));
        SmsSendHistoryBackups end = new SmsSendHistoryBackups();
        end.setSenddate(new BigInteger("20170101010000"));
        List<SmsSendHistoryBackups> smsSendHistoryBackups = smsSendHistoryBackupsService.selectSenddateBetween(start, end);
        for (SmsSendHistoryBackups smsSendHistoryBackup : smsSendHistoryBackups) {
            //SmsUserHistory smsUserHistory=new SmsUserHistory();
           // smsUserHistory.setHisid(smsSendHistoryBackup.getId().intValue());
           // int uid = smsUserHistoryService.findUid(smsSendHistoryBackup.getId());
            int uid = smsUserHistoryService.findId();
            //Integer uid = smsUserHistoryService.findUid1(smsUserHistory).get(0).getUid();
            System.out.println(uid);
        }

    }

    @Test
    public void test2(){
        int i = smsUserSignstoreService.selectCount31(null);
        System.out.println(i);
    }


}
