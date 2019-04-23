package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("sesrial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	
	private Long deptno;
	private String dname;
	private String db_source;
	
	public static void main(String[] args) {
		Dept d = new Dept();
		
	}
	
}
