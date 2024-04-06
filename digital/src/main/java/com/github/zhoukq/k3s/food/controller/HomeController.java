package com.github.zhoukq.k3s.food.controller;

import com.github.zhoukq.k3s.food.entiy.Product;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    public static final UniformRandomProvider RNG = RandomSource.XO_RO_SHI_RO_128_PP.create();

    @RequestMapping("/products")
    public List<Product> welcome() {


        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("iPhone 15", 5999, RNG.nextInt(5, 500)));
        list.add(new Product("Xiaomi 14", 3799, RNG.nextInt(3, 300)));
        list.add(new Product("Huawei Mate 60 Pro", 7999, RNG.nextInt(1, 300)));
        return list;
    }


    private Map<String, List<Product>> loadProductMap() {
        HashMap<String, List<Product>> map = new HashMap<>();
        ArrayList<Product> list = new ArrayList<>();
        list.add(new Product("iPhone 15", 5999, 128));
        list.add(new Product("Xiaomi 14", 3799, 78));
        list.add(new Product("Huawei Mate 60 Pro", 7999, 39));
        map.put("手机数码", list);
        list = new ArrayList<>();
        list.add(new Product("百事可乐", 3, 2377));
        list.add(new Product("风干牛肉", 49.9, 303));
        list.add(new Product("取骨鸡爪", 38.9, 878));
        map.put("零食饮料", list);
        return map;
    }

}
