package cn.sioo.service;

import cn.sioo.mapper21.ChannelDayCountMapper21;
import cn.sioo.mapper31.ChannelDayCountMapper31;
import cn.sioo.pojo.ChannelDayCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by morrigan on 2017/6/1.
 */
@Service
public class ChannelDayCountService extends BaseService<ChannelDayCount> {

    @Autowired
    private ChannelDayCountMapper31 channelDayCountMapper31;

    @Autowired
    private ChannelDayCountMapper21 channelDayCountMapper21;

    public void delByChannelIds(List<Integer> ids) {
        channelDayCountMapper31.delByChannelIds(ids);
    }

    public List<ChannelDayCount> selectGreateCreateTime21(ChannelDayCount channelDayCount) {
        Example example=new Example(channelDayCount.getClass());
        example.createCriteria().andGreaterThan("createTime",channelDayCount.getCreateTime());
        return  channelDayCountMapper21.selectByExample(example);
    }

    public List<ChannelDayCount> selectGreateCreateTime31(ChannelDayCount channelDayCount) {
        Example example=new Example(channelDayCount.getClass());
        example.createCriteria().andGreaterThan("createTime",channelDayCount.getCreateTime());
        return  channelDayCountMapper31.selectByExample(example);
    }
}
