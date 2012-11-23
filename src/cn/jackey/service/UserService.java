package cn.jackey.service;

import java.util.List;

public class UserService {
	
	private OrderService orderService;
	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	public void addUser(){
		System.out.println("添加新用户");
		orderService.save();
	}

	
/*	private List<OrderService> list;
	
	public List<OrderService> getList() {
		return list;
	}

	public void setList(List<OrderService> list) {
		this.list = list;
	}*/

}
