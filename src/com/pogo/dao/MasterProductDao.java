package com.pogo.dao;

import java.util.List;

import com.pogo.model.Currency;

public interface MasterProductDao {

	List<Currency> getCurrencyData();

	void addCurrency(Currency cur);

}
