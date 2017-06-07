package cn.sioo.service;

import cn.sioo.mapper21.BaseMapper21;
import cn.sioo.mapper31.BaseMapper31;
import cn.sioo.pojo.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */

public abstract class BaseService<T extends BaseEntity> {


    @Autowired
    private BaseMapper31<T> baseMapper31;

    @Autowired
    private BaseMapper21<T> baseMapper21;

    /**
     * 插入31
     *
     * @param t
     */
    public void insertList(List<T> t) {
        baseMapper31.insertList(t);
    }


    /**
     * 查询31数量
     * @param t
     * @return
     */
    public int selectCount31(T t) {
        return baseMapper31.selectCount(t);
    }


    /**
     * 查询21数量
     *
     * @return
     */
    public int selectCount21(T t) {
        return baseMapper21.selectCount(t);
    }


    /**
     * 查询21数据
     * @param t
     * @param index
     * @param size
     * @return
     */
    public List<T> selectListLimit(T t,int index,int size){
        return baseMapper21.selectListLimit(t,index,size);
    }

    public List<T> selectList21(T t){
        return baseMapper21.select(null);
    }

    public List<T> selectList31(T t){
       return baseMapper31.select(null);
    }

    /**
     * 根据id批量删除数据
     * @param ids
     */
    public void delByIds(List<Integer> ids){
       baseMapper31.delByIds(ids);
    }


}
