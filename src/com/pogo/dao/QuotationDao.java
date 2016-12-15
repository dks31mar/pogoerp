package com.pogo.dao;

import java.util.List;

import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.model.PoQuotationDetail;
import com.pogo.model.PoQuotationItemDetail;

public interface QuotationDao {

	void addQPoDtail(PoQuotationDetail pqd);

	void addQPoItemDtail(PoQuotationItemDetail pqidd);

	List<PoQuotationDetail> viewQuotation();

}
