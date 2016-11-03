package com.pogo.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.CurrencyBean;
import com.pogo.bean.UserEmployeeBean;
import com.pogo.dao.MasterProductDao;
import com.pogo.model.Currency;
import com.pogo.model.UserEmployee;
import com.pogo.service.MasterProductService;
@Service("masterProductService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterProductServiceImp implements MasterProductService{

	
	@Autowired
	private MasterProductDao masterProductDao;

	@Override
	public List<CurrencyBean> getCurrencyDetails() {
		List<Currency> getdetails =masterProductDao.getCurrencyData();
		List<CurrencyBean> lists=new ArrayList<CurrencyBean>();
		for(Currency list: getdetails)
		{
			CurrencyBean data=new CurrencyBean();
			data.setCurrencyname(list.getCurrencyname());
			data.setCurrencysymbol(list.getCurrencysymbol());
			//data.setFirstname(list.getFirstname() + list.getLastname() );
			data.setCurrencytype(list.getCurrencytype());
			lists.add(data);
		}
			
		
		return lists;
	}

	@Override
	public void addCurrency(CurrencyBean poref1) {
		Currency cur=new Currency();
		cur.setCurrencyname(poref1.getCurrencyname());
		cur.setCurrencysymbol(poref1.getCurrencysymbol());
		cur.setCurrencytype(poref1.getCurrencytype());
		masterProductDao.addCurrency(cur);
	}
}
