package com.pogo.service;

import java.util.List;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetail;

public interface PrinicipalPoService {

	String getPartNo(ProductMasterBean productmasetr);

	String getproductDetail(ProductMasterBean productmasetr);

	void addPoProduct(PoRefEntryItemDetail poRefEntry);

	List<PoRefEntryItemDetail> proList();

	void deleteProduct(PoRefEntryItemDetail prepareModel);

	public List<PoRefEntryItemDetail> getProductEdit(int particular);

	void viewPo();
	
	
}