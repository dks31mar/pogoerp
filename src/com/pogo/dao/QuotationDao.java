package com.pogo.dao;

import java.util.List;

import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.model.PoQuotationDetail;
import com.pogo.model.PoQuotationItemDetail;

public interface QuotationDao {

	void addQPoDtail(PoQuotationDetail pqd);

	void addQPoItemDtail(PoQuotationItemDetail pqidd);

	List<PoQuotationDetail> viewQuotation();

	List<PoQuotationItemDetail> getQuotationByref(String qporef);

	String getproductdesbypro(String partno);

	void updateQPoItemDtail(PoQuotationItemDetail pqidd);

	void updateQPoDtail(PoQuotationDetail pqd);

	Integer getqupodetailid(String qorefno);

	void deleteAllQPoItemDtail(PoQuotationDetailBean poqd);

	List<PoQuotationDetail> getquationList();

	List<PoQuotationDetail> getQuationno(String qorefno);

}
