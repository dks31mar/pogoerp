package com.pogo.dao;



import java.util.List;

import com.pogo.model.AddEmailList;

public interface LeadGenerationCampaignsDao {

	void addemail(AddEmailList emaillist);

	List<AddEmailList> mailList();
}
