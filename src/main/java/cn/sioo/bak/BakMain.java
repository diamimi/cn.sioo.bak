package cn.sioo.bak;

import cn.sioo.pojo.SmsUserSignstore;
import cn.sioo.service.*;
import cn.sioo.thread.BaseThread;
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
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring/bak.xml","spring/mybatis21.xml","spring/mybatis31.xml"});
        SmsUserService smsUserService = ac.getBean(SmsUserService.class);
        SmsUserConsumeService smsUserConsumeService = ac.getBean(SmsUserConsumeService.class);
        GatewayChannelService gatewayChannelServiceg=ac.getBean(GatewayChannelService.class);
        ChannelDayCountService channelDayCountService=ac.getBean(ChannelDayCountService.class);
        SmsAccountService smsAccountService=ac.getBean(SmsAccountService.class);
        SmsReleaseTemplateService smsReleaseTemplateService=ac.getBean(SmsReleaseTemplateService.class);
        SmsUserControlService smsUserControlService=ac.getBean(SmsUserControlService.class);
        SmsUserSignstoreService smsUserSignstoreService=ac.getBean(SmsUserSignstoreService.class);


        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);


       // service.scheduleAtFixedRate(new BaseThread(smsUserService,new SmsUser(),"TIME"), 1, 150, TimeUnit.SECONDS);
       // service.scheduleAtFixedRate(new BaseThread(smsUserConsumeService,new SmsUserConsume(),"ID"), 1, 150, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new BaseThread(gatewayChannelServiceg,new GatewayChannel(),"ID"), 1, 150, TimeUnit.SECONDS);
        //service.scheduleAtFixedRate(new BaseThread(channelDayCountService,new ChannelDayCount(),"ID"), 1, 150, TimeUnit.SECONDS);
       // service.scheduleAtFixedRate(new BaseThread(smsAccountService,new SmsAccount(),"ID"), 1, 150, TimeUnit.SECONDS);
       // service.scheduleAtFixedRate(new BaseThread(smsReleaseTemplateService,new SmsReleaseTemplate(),"ID"), 1, 150, TimeUnit.SECONDS);
       // service.scheduleAtFixedRate(new BaseThread(smsUserControlService,new SmsUserControl(),"UID"), 1, 150, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new BaseThread(smsUserSignstoreService,new SmsUserSignstore(),"ID"), 1, 150, TimeUnit.SECONDS);
    }

}
