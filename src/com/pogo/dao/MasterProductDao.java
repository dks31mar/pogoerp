package com.pogo.dao;

import java.util.List;

import com.pogo.model.Currency;
import com.pogo.model.ProductHead;
import com.pogo.model.ProductMaster;
import com.pogo.model.ProductSubHead;
import com.pogo.model.Unit;

public interface MasterProductDao {

	List<Currency> getCurrencyData();

	void addCurrency(Currency cur);

	void deleteCurrency(int id);

	List<Currency> getCurrency(String id);

	void editCurrency(Currency cur);

	List<Unit> getUnitsData();

	void addUnit(Unit cur);

	void deleteUnit(int id);

	List<Unit> getUnitById(String id);

	void editUnit(Unit cur);

	List<ProductHead> getProductHeadData();

	void addProductHead(ProductHead cur);

	void deleteProductHead(int id);

	void editProductHead(ProductHead cur);

	List<ProductHead> getProductHeadById(String id);

	void addProductSubHead(ProductSubHead cur);

	List<ProductMaster> getProData();

	void deleteProductData(int id);

	List<ProductMaster> searchProData(String proname);

	List<ProductSubHead> getProductSubHeadData();

	void saveproductdetail(ProductMaster promaster);

	ProductMaster getProductById(int id);

	ProductSubHead getproductsubheadbyid(Integer productsabheadid);

	void editProductById(ProductMaster bean);


}
