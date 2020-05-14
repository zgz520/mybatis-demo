package com.zgz.mybatis.mapper;

import com.zgz.mybatis.pojo.Fee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/14 21:38
 */

@Mapper
public interface FeeMapper {

    /**
     * 通过费用日期查询
     *
     * @param feeDate 费用日期
     * @return 消费列表
     */
    List<Fee> findByFeeDate(String feeDate);
}
