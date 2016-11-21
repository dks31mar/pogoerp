package com.pogo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductMasterBean;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;

public interface PrinicipalPoService {

	String getPartNo(ProductMasterBean productmasetr);

	String getproductDetail(ProductMasterBean productmasetr);

	void addPoProduct(PoRefEntryItemDetailBean poRefEntry, PorefSupplierDetailBean porefs);

	List<PoRefEntryItemDetailCopy> proList(HttpServletRequest res);

	void deleteProduct(PoRefEntryItemDetailCopy prepareModel);

	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular);

	void viewPo();

	Object getGrantTotal(HttpServletRequest res);

	void addPoSupplier(PorefSupplierDetailBean porefs);

	List<PorefSupplierDetailBean> getSupplierlist();
	
	
}