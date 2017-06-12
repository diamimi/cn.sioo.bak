package cn.sioo.bak;

import cn.sioo.service.*;
import cn.sioo.thread.ChannelDayCountThread;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 备份21数据到31上
 * Created by morrigan on 2017/6/1.
 */
public class BakMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/bak.xml", "spring/mybatis21.xml", "spring/mybatis31.xml"});
        SmsUserService smsUserService = ac.getBean(SmsUserService.class);
        SmsUserConsumeService smsUserConsumeService = ac.getBean(SmsUserConsumeService.class);
        GatewayChannelService gatewayChannelService = ac.getBean(GatewayChannelService.class);
        ChannelDayCountService channelDayCountService = ac.getBean(ChannelDayCountService.class);
        SmsAccountService smsAccountService = ac.getBean(SmsAccountService.class);
        SmsReleaseTemplateService smsReleaseTemplateService = ac.getBean(SmsReleaseTemplateService.class);
        SmsUserControlService smsUserControlService = ac.getBean(SmsUserControlService.class);
        SmsUserSignstoreService smsUserSignstoreService = ac.getBean(SmsUserSignstoreService.class);
        SmsUserDayCountService smsUserDayCountService = ac.getBean(SmsUserDayCountService.class);


        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);


      // service.scheduleAtFixedRate(new BaseThread(channelDayCountService, new ChannelDayCount()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(gatewayChannelService, new GatewayChannel()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsAccountService, new SmsAccount()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsReleaseTemplateService, new SmsReleaseTemplate()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsUserService, new SmsUser()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsUserControlService, new SmsUserControl()), 1, 60, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsUserDayCountService, new SmsUserDayCount()), 1, 90, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(new BaseThread(smsUserSignstoreService, new SmsUserSignstore()), 1, 60, TimeUnit.SECONDS);

        //service.scheduleAtFixedRate(new SmsUserConsumeThread(smsUserConsumeService), 1, 60, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new ChannelDayCountThread(channelDayCountService), 1, 60, TimeUnit.SECONDS);




    }

}
