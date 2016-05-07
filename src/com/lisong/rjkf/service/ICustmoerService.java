package com.lisong.rjkf.service;

import com.lisong.rjkf.bean.Customer;
import com.lisong.rjkf.common.exception.ServiceException;

public interface ICustmoerService {
	/**
	 * 注册
	 * */
	void register(Customer customer) throws ServiceException ;

}
