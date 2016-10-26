package com.pogo.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pogo.model.PorefSupplierDetail;

public interface CommonDao {

	void getPoReFNo(HttpServletRequest request, PorefSupplierDetail porefId);
	List<PorefSupplierDetail> viewList();
}
