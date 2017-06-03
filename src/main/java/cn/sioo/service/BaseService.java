package cn.sioo.service;

import cn.sioo.mapper21.BaseMapper21;
import cn.sioo.mapper31.BaseMapper31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
@Service
public class BaseService<T> {

    @Autowired
    private BaseMapper21<T> baseMapper21;

    @Autowired
    private BaseMapper31<T> baseMapper31;


    /**
     * 插入31
     *
     * @param t
     */
    public void insertBatch(List<T> t) {
        baseMapper31.insertBatch(t);
    }

    /**
     * 查询31数量
     *
     * @return
     */
    public int findCount31() {
        return baseMapper31.findCount31();
    }

    /**
     * 查询21数量
     *
     * @return
     */
    public int findCount21() {
        return baseMapper21.findCount21();
    }

    /**
     * 查询21数据
     *
     * @param index
     * @param size
     * @return
     */
    public List<T> findList(int index, int size) {
        return baseMapper21.findList(index, size);
    }
}
