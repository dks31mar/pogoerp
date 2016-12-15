package com.pogo.service;

import java.util.List;

import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;

public interface QuotationService {

	void addQPoDtail(PoQuotationDetailBean poqd);

	void addQPoItemDtail(PoQuotationDetailBean poqd, PoQuotationItemDetailBean poqid);

	List<PoQuotationDetailBean> viewQuotation();

}
