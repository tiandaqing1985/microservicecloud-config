package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;

@RestController
public class DeptController_consumer {
	
	@Autowired
	private DeptClientService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{deptno}")
	public Dept get(@PathVariable("deptno")  Long deptno) {
		return this.service.get(deptno);
	}
	
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}
}
