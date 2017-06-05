package cn.sioo.service;

import cn.sioo.mapper21.BaseMapper21;
import cn.sioo.mapper31.BaseMapper31;
import cn.sioo.pojo.BaseEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by morrigan on 2017/6/3.
 */
@Service
public abstract class BaseService<T extends BaseEntity> {


    @Autowired
    private BaseMapper31<T> baseMapper31;

    @Autowired
    private BaseMapper21<T> baseMapper21;

    /**
     * 返回具体的Mapper
     *
     * @return
     */
    private BaseMapper31<T> getMapper31(){
        return this.baseMapper31;
    }

    /**
     * 返回具体的Mapper
     *
     * @return
     */
    private BaseMapper21<T> getMapper21(){
        return this.baseMapper21;
    }


    /**
     * 插入31
     *
     * @param t
     */
    public void insertList(List<T> t) {
        getMapper31().insertList(t);
    }


    /**
     * 查询31数量
     * @param t
     * @return
     */
    public int selectCount31(T t) {
        return getMapper31().selectCount(t);
    }


    /**
     * 查询21数量
     *
     * @return
     */
    public int selectCount21(T t) {
        return getMapper21().selectCount(t);
    }


    /**
     * 查询21数据
     *
     * @param index
     * @param size
     * @return
     */
    public List<T> findList(Class<T> t,int index, int size) {
        Example example=new Example(t);
        example.setOrderByClause("id");
        PageHelper.startPage(index, size);
        List<T> ts = getMapper21().selectByExample(example);
        return ts;
    }


}
