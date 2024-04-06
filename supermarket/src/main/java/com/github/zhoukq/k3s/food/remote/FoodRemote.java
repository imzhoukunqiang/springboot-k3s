package com.github.zhoukq.k3s.food.remote;

import com.github.zhoukq.k3s.food.entiy.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class FoodRemote implements InitializingBean {
    public static final Logger LOGGER = LoggerFactory.getLogger(FoodRemote.class);

    private RestClient restClient;

    @Value("${remote.foodUrl}")
    private String foodUrl;

    public List<Product> getProductList() {
        try {
            return restClient.get()
                    .uri("/products")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
        } catch (Exception e) {
            LOGGER.error(e.getLocalizedMessage());
            return List.of();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.restClient = RestClient.builder().baseUrl(foodUrl).build();
    }
}
