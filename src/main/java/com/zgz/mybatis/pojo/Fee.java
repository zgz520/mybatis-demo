package com.zgz.mybatis.pojo;

import lombok.Data;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/14 21:37
 */
@Data
public class Fee {

    /**
     * 费用id
     */
    private Integer id;

    /**
     * 费用
     */
    private Double feeAmt;

    /**
     * 消费日期
     */
    private String feeDate;
}
