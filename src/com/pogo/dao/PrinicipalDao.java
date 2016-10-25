package com.pogo.dao;

import java.util.List;

import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.ProductMaster;

public interface PrinicipalDao {

	List<ProductMaster> getPartNo(ProductMaster pm);

	List<ProductMaster> getproductDetail(ProductMaster pm);

	void addPoDetails(PoRefEntryItemDetail poRefEntry);

	List<PoRefEntryItemDetail> proList();

	void deleteProduct(PoRefEntryItemDetail prepareModel);

	public List<PoRefEntryItemDetail> getProductEdit(int particular);

	void savePo();


}
