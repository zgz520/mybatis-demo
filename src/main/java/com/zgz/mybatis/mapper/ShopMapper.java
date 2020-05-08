package com.zgz.mybatis.mapper;

import com.zgz.mybatis.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/8 21:36
 */
@Mapper
public interface ShopMapper {


    /**
     * 保存
     *
     * @param shop 商店信息
     * @return 商店信息
     */
    int insert(Shop shop);


    /**
     * 通过主键id查询
     *
     * @param id 主键id
     * @return 商店
     */
    Shop findById(Integer id);
}
