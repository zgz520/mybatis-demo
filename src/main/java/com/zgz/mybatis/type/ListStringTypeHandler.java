package com.zgz.mybatis.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/8 21:50
 */
public class ListStringTypeHandler extends BaseTypeHandler<List<Integer>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Integer> parameter, JdbcType jdbcType) throws SQLException {
        StringBuilder ids = new StringBuilder();
        for (Integer integer : parameter) {
            ids.append(integer).append(",");
        }
        if (ids.length() > 0) {
            ids.deleteCharAt(ids.length() - 1);
        }
        ps.setString(i, ids.toString());
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String ids = rs.getString(columnName);
        if (StringUtils.isEmpty(ids)) {
            return null;
        }
        return getList(ids);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String ids = rs.getString(columnIndex);
        if (StringUtils.isEmpty(ids)) {
            return null;
        }
        return getList(ids);
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String ids = cs.getString(columnIndex);
        return getList(ids);
    }

    private List<Integer> getList(String str) {
        String[] split = str.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String s : split) {
            idList.add(Integer.valueOf(s));
        }
        return idList;
    }
}
