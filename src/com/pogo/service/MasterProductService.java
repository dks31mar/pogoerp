package com.pogo.service;

import java.util.List;

import com.pogo.bean.CurrencyBean;
import com.pogo.bean.ProductHeadBean;
import com.pogo.bean.ProductSubHeadBean;
import com.pogo.bean.UnitBean;
import com.pogo.model.Currency;

public interface MasterProductService {

	List<CurrencyBean> getCurrencyDetails();

	void addCurrency(CurrencyBean poref1);

	void deleteCurrency(int id);

	String getCurrency(String id);

	void editCurrency(CurrencyBean poref1);

	List<UnitBean> getUnitsDetails();

	void addUnit(UnitBean poref1);

	void deleteUnit(int id);

	String getUnitById(String id);

	void editUnit(UnitBean poref1);

	List<ProductHeadBean> getProductHeadDetails();

	void addProductHead(ProductHeadBean poref1);

	void deleteProductHead(int id);

	void editProductHead(ProductHeadBean poref1);

	String getProductHeadById(String id);

	void addProductSubHead(ProductSubHeadBean poref1);

}
