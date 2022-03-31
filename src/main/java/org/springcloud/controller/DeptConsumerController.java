package org.springcloud.controller;

import java.util.List;

import org.springcloud.pojo.Dept;
import org.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptConsumerController {

	// 在这边没有service接口，
	// 理解：消费者 应不应该有service 结果是不需要执行访问就好
	// 因为需要restful 风格 肯定有RestTempLate spring会提供模板，供我们调用使用

	/**
	 * 注入RestTemplate bean 参数 url，request请求：一般用map，class<T>,
	 */
	@Autowired
	private RestTemplate restTemplate;// 提供多种便捷访问远程http服务的方法，简单的restful服务模板

	private static final String REST_URL = "http://SPRINGCLOUD-PROVIDER-DEPT";


	/**
	 * 通过api中的接口，在feign自动自动注入到feign服务调用方
	 */
	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.deptClientService.queryById(id);
	}

	@RequestMapping("/consumer/dept/add")
	public Boolean add(Dept dept) {
		System.err.println("消费者：" + dept);
		return this.deptClientService.addDept(dept);
	}

	@RequestMapping("/consumer/dept/list")
	public List<Dept> list() {
		return this.deptClientService.queryList();
	}

}
