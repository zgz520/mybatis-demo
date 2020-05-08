package com.zgz.mybatis.controller;

import com.zgz.mybatis.pojo.Shop;
import com.zgz.mybatis.service.ShopService;
import org.springframework.stereotype.Controller;

/**
 * @author zgz
 * @version V1.0.0
 * @date 2020/5/8 22:17
 */
@Controller
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    public String save() {
        Shop shop = new Shop();
        shopService.insert(shop);
        return "success";
    }

    public Shop find(Integer id) {
        return shopService.findById(id);
    }
}
