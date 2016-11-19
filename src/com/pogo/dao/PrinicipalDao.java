package com.pogo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductMaster;

public interface PrinicipalDao {

	List<ProductMaster> getPartNo(ProductMaster pm);

	List<ProductMaster> getproductDetail(ProductMaster pm);

	void addPoDetails(PoRefEntryItemDetail poRefEntry);

	List<PoRefEntryItemDetailCopy> proList();

	void deleteProduct(PoRefEntryItemDetailCopy prepareModel);

	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular);

	void savePo();

	void getTotal(HttpServletRequest res);

	Object getGrantTotal(HttpServletRequest res);

	void addPoSupplier(PorefSupplierDetail porefs);


}
