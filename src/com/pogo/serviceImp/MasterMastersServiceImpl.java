package com.pogo.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.CommonDao;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.CustomerLevels;
import com.pogo.service.MasterMastersService;

@Service("masterMastersService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MasterMastersServiceImpl implements MasterMastersService {
	@Autowired
	private	MasterMastersDao masterMastersdao;

	@Override
	
	public List<CustomerLevels> customerLevelsList(){
		return masterMastersdao.customerLevelsList();
	}
}
