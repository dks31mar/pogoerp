package com.pogo.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.CustomerSalesDao;
import com.pogo.model.AddDiary;
import com.pogo.model.AddFollowUp;
import com.pogo.model.Contact;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;
import com.pogo.model.CustomersFileUplaod;
import com.pogo.model.UserEmployee;
@SuppressWarnings({"unchecked","rawtypes"})
@Repository("customerSalesDao")
public class CustomerSalesDaoImpl implements CustomerSalesDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addCutomer(CustomerSales customerSales) {
		sessionFactory.getCurrentSession().save(customerSales);

	}

	
	@Override
	public List<CustomerSales> getsalesList(String id) {
		if(id.equals("all")){
			return sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).list();
		}else{
			
		int id1=(int)	sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).add(Restrictions.eq("status", id)).setProjection(Projections.property("id")).uniqueResult();
			return sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).add(Restrictions.eq("status.id", id1)).list();
		}
		
	}

	@Override
	public CustomerSales getCustomerDetailsbyId(int id) {
		return (CustomerSales) sessionFactory.getCurrentSession().get(CustomerSales.class, id);
	}

	@Override
	public void updateCustomer(CustomerSales sales) {
		sessionFactory.getCurrentSession().update(sales);

	}

	@Override
	public void saveDiary(AddDiary diary) {
		sessionFactory.getCurrentSession().save(diary);

	}

	@Override
	public void addfollowup(AddFollowUp followUp) {
		sessionFactory.getCurrentSession().save(followUp);

	}

	
	@Override
	public List<CustomerSales> getsalesListById() {
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.property("organisation"));
		// proList.add(Projections.property("customerId"));
		Criteria r = sessionFactory.getCurrentSession().createCriteria(CustomerSales.class)
				.setProjection(Projections.property("organisation"));

		List<CustomerSales> list = r.list();
		return list;
	}

	@Override
	public void saveContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);

	}
	@Override
	public List<AddDiary> getdiarydata(int id,int pid) {
		List<AddDiary> list=null;
		if (pid!=0) {
			list=(List<AddDiary>) sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", pid)).add(Restrictions.eq("enteryuser.userempid", id)).list();
		} else {
			list=(List<AddDiary>) sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("enteryuser.userempid", id)).list();
		}
		return list;
				
				
	}

	
	@Override
	public List<UserEmployee> getDatafromDiary() {
		List<UserEmployee> d = sessionFactory.getCurrentSession().createCriteria(AddDiary.class)
				.setProjection(Projections.distinct(Projections.property("enteryuser"))).list();

		List<UserEmployee> getname = new ArrayList<>();

		for (UserEmployee g : d) {
			UserEmployee s = (UserEmployee) sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
					.add(Restrictions.eq("userempid", g.getUserempid())).uniqueResult();
			getname.add(s);

		}
		return getname;

	}

	@Override
	public Integer getPlanByid(Integer userempid, int id) {
		// List<Integer>
		// d=sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("enteryuser.userempid",
		// userempid)).setProjection(Projections.distinct(Projections.property("planName.id"))).list();
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", id))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();
		System.out.println("id is >>>>>>>>>>               " + id + "                      "
				+ "tottal >>>>>>>>>>>>>>>>>>>       " + d21);

		return d21;
	}

	@Override
	public List<CustomerSales> getCustomerdatabyCompanyName(String organization) {
		CustomerSales s = (CustomerSales) sessionFactory.getCurrentSession().createCriteria(CustomerSales.class)
				.add(Restrictions.eq("organisation", organization)).uniqueResult();
		int statusid = s.getStatus().getId();

		System.out.println(statusid);

		Criteria state = sessionFactory.getCurrentSession().createCriteria(CustomerSales.class);
		Criteria country = state.createCriteria("status");
		country.add(Restrictions.eq("id", statusid));
		
		List list = state.list();

		return list;

	}

	@Override
	public int getTotalsms(Integer userempid, int i) {
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", 1))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();
		System.out.println("id is >>>>>>>>>>               " + i + "                      "
				+ "tottal >>>>>>>>>>>>>>>>>>>       " + d21);

		return d21;
	}

	@Override
	public int getTotalappointment(Integer userempid, int i) {
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", 2))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();
		System.out.println("id is >>>>>>>>>>               " + i + "                      "
				+ "tottal >>>>>>>>>>>>>>>>>>>       " + d21);

		return d21;
	}

	@Override
	public int getTotalemail(Integer userempid, int i) {
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", 3))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();
		System.out.println("id is >>>>>>>>>>               " + i + "                      "
				+ "tottal >>>>>>>>>>>>>>>>>>>       " + d21);

		return d21;
	}

	@Override
	public int getTotalphone(Integer userempid, int i) {
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", 4))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();
		System.out.println("id is >>>>>>>>>>               " + i + "                      "
				+ "tottal >>>>>>>>>>>>>>>>>>>       " + d21);

		return d21;
	}

	@Override
	public int getTotalothers(Integer userempid, int i) {
		int d21 = 0;

		d21 = sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", 5))
				.add(Restrictions.eq("enteryuser.userempid", userempid)).list().size();

		return d21;
	}

	@Override

	public void savefiles(CustomersFileUplaod fileUplaod) {
		sessionFactory.getCurrentSession().save(fileUplaod);
	}
	@Override
	public AddDiary getDiarybyId(int id) {
		return (AddDiary) sessionFactory.getCurrentSession().get(AddDiary.class, id);
	}

	@Override
	public void updateDiary(AddDiary addDiary) {
		sessionFactory.getCurrentSession().update(addDiary);

		
	}

	@Override
	public List<AddDiary> getdiarydata1(int pid) {
	List<AddDiary>	list=(List<AddDiary>) sessionFactory.getCurrentSession().createCriteria(AddDiary.class).add(Restrictions.eq("planName.id", pid)).list();
		return list;
	}

	
	@Override
	public List<AddFollowUp> getfollowUpUserId(String sdate,String edate) {
		
		return sessionFactory.getCurrentSession().createCriteria(AddFollowUp.class)
				.add(Restrictions.between("followupDate", sdate, edate))
				.setProjection(Projections.projectionList()
						.add(Projections.groupProperty("userEmp.userempid")))
				.list();
	}
	@Override
	public List<AddFollowUp> followUpListByUserId(Object id,String sdate,String edate) {
		int id1=(int) id;
		
		return sessionFactory.getCurrentSession()
				.createCriteria(AddFollowUp.class)
				.add(Restrictions.eq("userEmp.userempid", id1))
				.add(Restrictions.between("followupDate", sdate, edate)).addOrder(Order.asc("followupDate"))
				.list();
	}
	@Override
	@Transactional
	public List<AddFollowUp> followUpListByUserId1(String id,String sdate,String edate,String day) {
		int id1=Integer.parseInt( id);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>                    day         "+day);
		List<AddFollowUp> list=new ArrayList<>();
		if(day.equals("00/00/0000")){
			System.out.println("if");
			list=	sessionFactory.getCurrentSession()
					.createCriteria(AddFollowUp.class)
					.add(Restrictions.eq("userEmp.userempid", id1))
					.add(Restrictions.between("followupDate", sdate, edate)).addOrder(Order.asc("followupDate"))
					.list();
			
		}else{
			System.out.println("else");
			list=sessionFactory.getCurrentSession()
			.createCriteria(AddFollowUp.class)
			.add(Restrictions.eq("userEmp.userempid", id1))
			.add(Restrictions.like("followupDate", "%"+day))
			.list();
		
		}
		return list;
	}


	@Override
	public List<CustomerLevels> getlistcustomerlevel() {
		
		return sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();
	}


	@Override
	public int getcountcustomerlevel(CustomerLevels sl) {
		
		return sessionFactory.getCurrentSession().createCriteria(CustomerSales.class).add(Restrictions.eq("status.id", sl.getId())).list().size();
	}
}
