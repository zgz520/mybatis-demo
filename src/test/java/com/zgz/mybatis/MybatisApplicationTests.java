package com.zgz.mybatis;

import com.zgz.mybatis.pojo.Shop;
import com.zgz.mybatis.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private ShopService shopService;

    @Test
    void contextLoads() {
        Shop shop = new Shop();
        shop.setName("我的商店");
        shop.setAddress("上海市浦东新区");
        List<Integer> scope = new ArrayList<>();
        scope.add(1);
        scope.add(2);
        scope.add(3);
        shop.setScope(scope);
        shopService.insert(shop);

        Shop save = shopService.findById(1);
        System.out.println(save.toString());
    }

}
