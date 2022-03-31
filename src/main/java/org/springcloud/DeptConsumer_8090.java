package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "org.springcloud" }) // 添加启动Feign注解,选择需要扫描的包，与Dubbo十分相似
@ComponentScan("org.springcloud") // 扫描包路径下注解
public class DeptConsumer_8090 {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_8090.class, args);
	}

}
