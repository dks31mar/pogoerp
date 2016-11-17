package com.pogo.service;

import java.util.List;

import com.pogo.bean.AddEmailListBean;

public interface LeadGenerationCampaignsService {

	void addemail(AddEmailListBean bean);

	List<AddEmailListBean> mailList();

}
