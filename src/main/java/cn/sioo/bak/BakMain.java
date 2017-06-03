package cn.sioo.bak;

import cn.sioo.pojo.SmsUser;
import cn.sioo.pojo.SmsUserConsume;
import cn.sioo.service.SmsUserConsumeService;
import cn.sioo.service.SmsUserService;
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

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(new BaseThread<SmsUser>(smsUserService), 1, 20, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(new BaseThread<SmsUserConsume>(smsUserConsumeService), 1, 20, TimeUnit.SECONDS);
    }

}
