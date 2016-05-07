package com.lisong.rjkf.test;

import com.lisong.rjkf.bean.Customer;
import com.lisong.rjkf.common.exception.ServiceException;
import com.lisong.rjkf.dao.CustomerDao;
import com.lisong.rjkf.service.ICustmoerService;
import com.lisong.rjkf.service.impl.CustomerServiceImpl;

public class Test {
	public static void main(String[] args) {
		test2();
	}
	public static void test2(){
		ICustmoerService custmoerService=new CustomerServiceImpl();
		Customer customer=new Customer("黎松", "456", "15579124469", "樟树");
		try {
			custmoerService.register(customer);
		} catch (ServiceException e) {
			System.out.println(e.getMessage());
			System.out.println("处理---");
		}
		
	}
	
	public static void test1(){
		
		
		CustomerDao dao=new CustomerDao();
//     	Customer customer=new Customer("黎松", "456", "15579124469", "樟树");
//		dao.save(customer);
		
		Customer customer = dao.findByName("黎松");
		System.out.println(customer);
		System.out.println("save success");
	}

}
