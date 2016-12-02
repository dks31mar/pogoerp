package com.pogo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pogo.bean.ProductAcknowledgementBean;
import com.pogo.model.InvoiceDetail;
import com.pogo.model.InvoiceTab;
import com.pogo.model.PoRefEntryItemDetail;
import com.pogo.model.PoRefEntryItemDetailCopy;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.ProductAcknowledgement;
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

	List<PorefSupplierDetail> getSupplierlist();

	List<PoRefEntryItemDetail> getPoDetailByPorefNo(String poref);

	void updatePoSupplier(PorefSupplierDetail porefsup);

	PorefSupplierDetail getidbyporefnumber(String s);

	void deletePoById(PoRefEntryItemDetail poref);

	List<PoRefEntryItemDetail> getPoDetailByPorefId(String poref);

	List<PoRefEntryItemDetail> getackDetailByPorefNo(String poref);

	List<ProductAcknowledgement> getPendindQty(String porefNo, String particular);

	void saveAcknowledData(ProductAcknowledgement proack);

	List<ProductAcknowledgement> getAckData(String s1, String s2);

	void deleteParticularAck(String s1);

	PoRefEntryItemDetail getquantybyval(ProductAcknowledgementBean bean);

	List<Double> getqtrybyack(ProductAcknowledgementBean bean);

	List<InvoiceDetail> getpendyqtyfrominvoice(String porefNo, String particular);

	void saveinvoicetab(InvoiceTab it);

	


}
