package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.atguigu.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService() {

			@Override
			public boolean add(Dept dept) {
				return false;
			}

			@Override
			public Dept get(Long deptno) {
				return null;
			}

			@Override
			public List<Dept> list() {
				return null;
			}
			
		};
	}

}
