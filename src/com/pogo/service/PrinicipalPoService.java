package com.pogo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pogo.bean.PoRefEntryItemDetailBean;
import com.pogo.bean.PorefSupplierDetailBean;
import com.pogo.bean.ProductAcknowledgementBean;
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

	List<PoRefEntryItemDetailBean> getPoDetailByPorefNo(String poref);

	void UpdatePoProduct(PoRefEntryItemDetailBean poref, PorefSupplierDetailBean porefs);

	void updatePoSupplier(PorefSupplierDetailBean porefs);

	void deletePoById(String id);

	List<PoRefEntryItemDetailBean> getPoDetailByPorefId(String poref);

	List<PoRefEntryItemDetailBean> getackDetailByPorefNo(String poref);

	void saveAcknowledData(ProductAcknowledgementBean bean);

	List<ProductAcknowledgementBean> getAckData(String s1, String s2);

	void deleteParticularAck(String s1);

	


	
	
}