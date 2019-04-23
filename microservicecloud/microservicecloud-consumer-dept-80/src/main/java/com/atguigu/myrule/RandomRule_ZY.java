package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class RandomRule_ZY extends AbstractLoadBalancerRule{
	
	private int total=0; //总共调用次数
	private int currentIndex=0;//当前服务机器号
	
	public Server choose(ILoadBalancer lb, Object key) {
		
		if(lb == null) {
			return null;
		}
		Server server = null;
		
		while(server == null){
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			
			int serverCount = allList.size();
			
			if(serverCount == 0) {
				return null;
			}
			
			if(total<5) {
				server = upList.get(currentIndex);
				total++;
			}else {
				total=0;
				currentIndex++;
				if(currentIndex >=upList.size()) {
					currentIndex = 0;
				}
			}
		}
		
		
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(),key);
	}
	
	
	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub
		
	}

}
