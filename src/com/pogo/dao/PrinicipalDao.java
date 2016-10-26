package com.pogo.dao;

import java.util.List;

import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.ProductMaster;

public interface PrinicipalDao {

	List<ProductMaster> getPartNo(ProductMaster pm);

	List<ProductMaster> getproductDetail(ProductMaster pm);

	void addPoDetails(PoRefEntryItemDetailCopy poRefEntry);

	List<PoRefEntryItemDetailCopy> proList();

	void deleteProduct(PoRefEntryItemDetailCopy prepareModel);

	public List<PoRefEntryItemDetailCopy> getProductEdit(int particular);

	void savePo();


}
