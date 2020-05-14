package com.zgz.mybatis.plugin;

import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 时间分表查询
 *
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/11 22:42
 */
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class FeeDateQueryPlugin implements Interceptor {

    /**
     * 需要拦截处理的方法
     */
    private String mapperMethodId = "com.zgz.mybatis.mapper.FeeMapper.findByFeeDate";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        String id = mappedStatement.getId();
        // 其他方法直接执行
        if (!mapperMethodId.equals(id)) {
            return invocation.proceed();
        }
        // 处理参数日期
        String feeDate = String.valueOf(args[1]);
        feeDate = feeDate.substring(0, 6);
        BoundSql boundSql = mappedStatement.getBoundSql(args[1]);
        // 修改查询sql
        String sql = "select id, fee_amt, fee_date from fee_" + feeDate + " where fee_date = ?";
        // 创建新sql对应sqlSource
        SqlSource sqlSource = new StaticSqlSource(mappedStatement.getConfiguration(), sql, boundSql.getParameterMappings());
        Field field = MappedStatement.class.getDeclaredField("sqlSource");
        field.setAccessible(true);
        // 把新的sqlSource对象赋值给sqlSource
        field.set(mappedStatement, sqlSource);
        // 执行
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
