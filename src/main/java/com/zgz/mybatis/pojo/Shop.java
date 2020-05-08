package com.zgz.mybatis.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/8 21:34
 */
@Data
public class Shop {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 商家名称
     */
    private String name;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 经营范围
     */
    private List<Integer> scope;
}
