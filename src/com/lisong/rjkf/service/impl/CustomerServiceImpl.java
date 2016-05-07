package com.lisong.rjkf.service.impl;

import com.lisong.rjkf.bean.Customer;
import com.lisong.rjkf.common.exception.ServiceException;
import com.lisong.rjkf.dao.CustomerDao;
import com.lisong.rjkf.service.ICustmoerService;


public class CustomerServiceImpl implements ICustmoerService{
	private CustomerDao customerDao = new CustomerDao();
	
	@Override
	public void register(Customer customer) throws ServiceException {
		Customer dbcustomer=customerDao.findByName(customer.getName());
		if(dbcustomer == null){
			customerDao.save(dbcustomer);
		}else{
			throw new ServiceException("用户已经存在");
		}
	}

}
