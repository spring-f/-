package com.tensquare.qa;

import com.tensquare.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // 使用Feign客户端的方式发现服务
public class QaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaApplication.class, args);
    }

    /**
     * 将id生成器放到容器中
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }

}
