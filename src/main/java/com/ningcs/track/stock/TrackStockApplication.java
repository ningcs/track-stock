package com.ningcs.track.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.ningcs.track.stock.mapper")
public class TrackStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackStockApplication.class, args);
    }

}
