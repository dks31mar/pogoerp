package com.pogo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pogo.model.PorefSupplierDetail;

public interface CommonService {

	void getPoRefNo(HttpServletRequest request);
	/************************************************** use by shweta ***************************************************/
	List<PorefSupplierDetail> viewList();
	/************************************************** use by shweta ***************************************************/

}
