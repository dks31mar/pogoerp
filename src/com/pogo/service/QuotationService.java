package com.pogo.service;

import java.util.List;

import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.model.PoQuotationItemDetail;

public interface QuotationService {

	void addQPoDtail(PoQuotationDetailBean poqd);

	void addQPoItemDtail(PoQuotationDetailBean poqd, PoQuotationItemDetailBean poqid);

	List<PoQuotationDetailBean> viewQuotation();

	List<PoQuotationItemDetailBean> getQuotationByref(String qporef);

	String getproductdesbypro(String partno);

	void updateQPoDtail(PoQuotationDetailBean poqd);

	void updateQPoItemDtail(PoQuotationDetailBean poqd, PoQuotationItemDetailBean poqid);

	void deleteAllQPoItemDtail(PoQuotationDetailBean poqd, PoQuotationItemDetailBean poqid);

	String findAllDataOfQuation();

	String getCustomerdatabyCompanyName(String qorefno);

}
