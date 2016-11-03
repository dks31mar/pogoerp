package com.pogo.service;

import java.util.List;

import com.pogo.bean.CurrencyBean;

public interface MasterProductService {

	List<CurrencyBean> getCurrencyDetails();

	void addCurrency(CurrencyBean poref1);

}
