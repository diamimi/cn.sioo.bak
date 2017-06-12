import cn.sioo.pojo.ChannelDayCount;
import cn.sioo.service.*;
import cn.sioo.util.DateUtils;
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

    @Autowired
    private SmsUserSignstoreService smsUserSignstoreService;

    @Autowired
    private ChannelDayCountService channelDayCountService;

    public List<ChannelDayCount> getDiffrentAdd(List<ChannelDayCount> list21, List<ChannelDayCount> list31) {
        List<ChannelDayCount> diff = new ArrayList<>();
        Map<String, ChannelDayCount> map = new HashMap<>();
        for (ChannelDayCount channelDayCount : list31) {
            map.put(channelDayCount.getChannelId()+","+channelDayCount.getCreateTime(), channelDayCount);
        }
        for (ChannelDayCount channelDayCount : list21) {
            if (!(map.get(channelDayCount.getChannelId()+","+channelDayCount.getCreateTime()) != null
                    &&map.get(channelDayCount.getChannelId()+","+channelDayCount.getCreateTime()).equals(channelDayCount))) {
                diff.add(channelDayCount);
            }
        }
        return diff;
    }


    @Test
    public void test1() {
        int time = DateUtils.getDay();
        ChannelDayCount channelDayCount = new ChannelDayCount();
        channelDayCount.setCreateTime(time-8);
        List<ChannelDayCount> list21 = channelDayCountService.selectList21(channelDayCount);
        List<ChannelDayCount> list31 = channelDayCountService.selectList31(channelDayCount);
        List<ChannelDayCount> diffrentAdd = getDiffrentAdd(list21, list31);
        System.out.println(diffrentAdd.size());

    }





}
