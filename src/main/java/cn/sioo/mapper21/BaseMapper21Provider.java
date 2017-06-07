package cn.sioo.mapper21;

import cn.sioo.pojo.SmsUser;
import cn.sioo.pojo.SmsUserControl;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.*;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by morrigan on 2017/6/5.
 */
public class BaseMapper21Provider extends MapperTemplate {
    public BaseMapper21Provider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    public SqlNode selectListLimit(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        String orderBy = "id";
        if (tableName(entityClass).equals("sms_user")) {
            orderBy = new SmsUser().getOrderBy();
        } else if (tableName(entityClass).equals("sms_user_control")) {
            orderBy = new SmsUserControl().getOrderBy();
        }
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);

        List<SqlNode> sqlNodes = new ArrayList<SqlNode>();
        //静态的sql部分:select column ... from table
        sqlNodes.add(new StaticTextSqlNode("SELECT "
                + EntityHelper.getSelectColumns(entityClass)
                + " FROM "
                + tableName(entityClass)));
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        List<SqlNode> ifNodes = new ArrayList<SqlNode>();
        boolean first = true;
        //对所有列循环，生成<if test="property!=null">[AND] column = #{property}</if>
        for (EntityColumn column : columnList) {
            StaticTextSqlNode columnNode
                    = new StaticTextSqlNode((first ? "" : " AND ") + column.getColumn()
                    + " = #{entity." + column.getProperty() + "} ");
            if (column.getJavaType().equals(String.class)) {
                ifNodes.add(new IfSqlNode(columnNode, "entity." + column.getProperty()
                        + " != null and " + "entity." + column.getProperty() + " != '' "));
            } else {
                ifNodes.add(new IfSqlNode(columnNode, "entity." + column.getProperty() + " != null "));
            }
            first = false;
        }
        //将if添加到<where>
        sqlNodes.add(new WhereSqlNode(ms.getConfiguration(), new MixedSqlNode(ifNodes)));

        sqlNodes.add(new StaticTextSqlNode("ORDER BY " + orderBy));

        //处理分页
        //sqlNodes.add(new IfSqlNode(new StaticTextSqlNode(" LIMIT #{limit}"),"offset==0"));
        sqlNodes.add(new IfSqlNode(new StaticTextSqlNode(" LIMIT #{index} , #{size} "), "size>0"));
        return new MixedSqlNode(sqlNodes);
    }
}
