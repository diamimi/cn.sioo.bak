package cn.sioo.service;

import cn.sioo.mapper35.SmsSendHistoryBackupsMapper35;
import cn.sioo.pojo.SmsSendHistoryBackups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by morrigan on 2017/6/12.
 */
@Service
public class SmsSendHistoryBackupsService {

    @Autowired
    private SmsSendHistoryBackupsMapper35 smsSendHistoryBackupsMapper35;


    public List<SmsSendHistoryBackups> selectSenddateBetween(SmsSendHistoryBackups start, SmsSendHistoryBackups end) {
        Example example = new Example(SmsSendHistoryBackups.class);
        example.createCriteria().andBetween("senddate", start.getSenddate(), end.getSenddate());
        return smsSendHistoryBackupsMapper35.selectByExample(example);
    }
}
