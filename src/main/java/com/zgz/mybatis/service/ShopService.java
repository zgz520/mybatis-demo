package com.zgz.mybatis.service;

import com.zgz.mybatis.mapper.ShopMapper;
import com.zgz.mybatis.pojo.Shop;
import org.springframework.stereotype.Service;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/8 22:09
 */
@Service
public class ShopService {

    private final ShopMapper shopMapper;

    public ShopService(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public int insert(Shop shop) {
        return shopMapper.insert(shop);
    }

    public Shop findById(Integer id) {
        return shopMapper.findById(id);
    }
}
