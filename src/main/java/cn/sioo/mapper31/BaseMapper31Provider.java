package cn.sioo.mapper31;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by morrigan on 2017/6/5.
 */
public class BaseMapper31Provider extends MapperTemplate {


    public BaseMapper31Provider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String insertList(MappedStatement ms) {
        Class<?> entityClass = this.getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, true, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        Iterator var5 = columnList.iterator();

        while(var5.hasNext()) {
            EntityColumn column = (EntityColumn)var5.next();
            if(!column.isId() && column.isInsertable()) {
                sql.append(column.getColumnHolder("record") + ",");
            }
        }

        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }

    public String delByIds(MappedStatement ms) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> entityClass = this.getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, this.tableName(entityClass)));
        sql.append(" WHERE id in");
        sql.append(" <foreach item=\"list\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">");
        sql.append("#{list}");
        sql.append("</foreach>");
        return sql.toString();
    }

    public String delByUids(MappedStatement ms) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> entityClass = this.getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.deleteFromTable(entityClass, this.tableName(entityClass)));
        sql.append(" WHERE  uid in");
        sql.append(" <foreach item=\"list\" collection=\"list\" open=\"(\" separator=\",\" close=\")\">");
        sql.append("#{list}");
        sql.append("</foreach>");
        return sql.toString();
    }
}
