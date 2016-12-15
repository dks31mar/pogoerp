package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.hql.ast.tree.SelectClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.PoQuotationDetailBean;
import com.pogo.bean.PoQuotationItemDetailBean;
import com.pogo.dao.QuotationDao;
import com.pogo.model.PoQuotationDetail;
import com.pogo.model.PoQuotationItemDetail;
import com.pogo.service.QuotationService;

@Service("quotationservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuotationServiceImp implements QuotationService{
	@Autowired
	private QuotationDao quotationdao;

	@Override
	@Transactional
	public void addQPoDtail(PoQuotationDetailBean poqd) {
		
		PoQuotationDetail pqd=new PoQuotationDetail();
		pqd.setAddress(poqd.getAddress());
		pqd.setCustname(poqd.getCustname());
		pqd.setEmail(poqd.getEmail());
		pqd.setNettotal(poqd.getNettotal());
		pqd.setQodate(poqd.getQodate());
		pqd.setQorefno(poqd.getQorefno());
		pqd.setQovalid(poqd.getQovalid());
		pqd.setTerms1(poqd.getTerms1());
		pqd.setTerms2(poqd.getTerms2());
		pqd.setTerms3(poqd.getTerms3());
		pqd.setTerms4(poqd.getTerms4());
		pqd.setTerms5(poqd.getTerms5());
		pqd.setTerms6(poqd.getTerms6());
		pqd.setTerms7(poqd.getTerms7());
		pqd.setTerms8(poqd.getTerms8());
		pqd.setTerms9(poqd.getTerms9());
		pqd.setTerms10(poqd.getTerms10());
		quotationdao.addQPoDtail(pqd);
	}

	@Override
	@Transactional
	public void addQPoItemDtail(PoQuotationDetailBean poqd, PoQuotationItemDetailBean poqid) {
		
		PoQuotationDetail pqd=new PoQuotationDetail();
		PoQuotationItemDetail pqidd=new PoQuotationItemDetail();
		pqd.setQorefno(poqd.getQorefno());
		
		pqidd.setPartno(poqid.getPartno());
		pqidd.setUtprice(poqid.getUtprice());
		pqidd.setDisc(poqid.getDisc());
		pqidd.setNetprice(poqid.getNetprice());
		pqidd.setQty(poqid.getQty());
		pqidd.setTotal(poqid.getTotal());
		pqidd.setDelivery(poqid.getDelivery());
		pqidd.setPoquotationdetail(pqd);
		
		
		quotationdao.addQPoItemDtail(pqidd);
	}

	@Override
	public List<PoQuotationDetailBean> viewQuotation() {
		
		List<PoQuotationDetail> poQu=quotationdao.viewQuotation();
		List<PoQuotationDetailBean> bean=new ArrayList<>();
		for(PoQuotationDetail po:poQu){
			PoQuotationDetailBean b=new PoQuotationDetailBean();
			b.setAddress(po.getAddress());
			b.setCustname(po.getCustname());
			b.setQodate(po.getQodate());
			b.setQorefno(po.getQorefno());
			bean.add(b);
		}
		return bean;
	}

}
