package com.pogo.daoImp;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.bean.AddActionBean;
import com.pogo.bean.AddPlanBean;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.AddAction;
import com.pogo.model.AddPlan;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSales;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseDetails;
import com.pogo.model.ExpenseEntry;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;

import com.pogo.model.ModeOfDispatch;

import com.pogo.model.ServiceProvider;

import com.pogo.model.State;
import com.pogo.model.SupplierMaster;
import com.pogo.model.TeamSegment;
import com.pogo.model.UserEmployee;



@Repository("masterMastersdao")
@SuppressWarnings("unchecked")
public class MasterMastersDaoImpl  implements  MasterMastersDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	
	@Override

	

	public List<CustomerLevels> customerLevelsList(){
		
		return (List<CustomerLevels>) sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();
	}
	@Override
	public void addCustomerLevels(CustomerLevels poref1){
		sessionFactory.getCurrentSession().save(poref1);
	 }
	@Override
	public void deleteCustomerLevels(int id){
		System.out.println("delete");
		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM CustomerLevels WHERE id = "+id).executeUpdate();
	}
	
	@Override
	public List<CustomerLevels> getCustomerLevelsById(String id){
     int f=Integer.parseInt(id);
		
		return (List<CustomerLevels>) sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class)
				.add(Restrictions.eq("id", f)).list();
	}
	@Override
	public void editCustomerLevels(CustomerLevels poref1){
		
		sessionFactory.getCurrentSession().update(poref1);
		//
	}
	
	
	
	@Override
	public List<Country> countryList(){
		
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	
	@Override
	public void addCountry( Country poref1){
		sessionFactory.getCurrentSession().save(poref1);
		//sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public  void  deleteCountry(Integer id){
		System.out.println("delete country");
	     //Country country = new Country();
	     //sessionFactory.getCurrentSession().refresh(country);
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Country WHERE countryId = "+id).executeUpdate();
	}
	
	@Override
  public List<Country> getCountryById (String id){
         int f=Integer.parseInt(id);
		
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class)
				.add(Restrictions.eq("id", f)).list();
	}
	@Override
	public void editCountry(Country poref1){
		
		sessionFactory.getCurrentSession().update(poref1);
		//
	}
	

	

	

	@Override
	public List<State> stateList(){
		
		return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}
	
	@Override
	public void addState( State poref1){
		sessionFactory.getCurrentSession().save(poref1);
		//sessionFactory.getCurrentSession().flush();
		System.out.println("outside save state dao impl");
	}
	
	
	@Override
        public List<Country> getdata (String id){
		
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	
	
		@Override
		public  void  deleteState(Integer id){
			System.out.println("delete state");
			
			sessionFactory.getCurrentSession().createQuery("DELETE FROM State WHERE stateId = "+id).executeUpdate();
		} 
	
	 
		@Override
	  public List<State> getStateById (String id){
	         int f=Integer.parseInt(id);
			
			return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class)
					.add(Restrictions.eq("id", f)).list();
		}
	 @Override
		public void editState(State poref1){
			
			sessionFactory.getCurrentSession().update(poref1);
			//
		}

	 

	 	@Override

		public List<District> districtList(){
			
			return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class).list();
		}
	 	
	 
		@Override
		public void addDistrict( District poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}

		@Override
		public  void  deleteDistrict(Integer id){
			System.out.println("delete district");
			
			sessionFactory.getCurrentSession().createQuery("DELETE FROM District WHERE districtId = "+id).executeUpdate();
		} 
		@Override
		public List<State> getstatelistbycountryid(String cuntryid) {
			int id=Integer.parseInt(cuntryid);
			Criteria state=sessionFactory.getCurrentSession().createCriteria(State.class);
			Criteria country=state.createCriteria("country");
			country.add(Restrictions.eq("countryId", id));
			List<State> list= state.list();
					
					
					//sessionFactory.getCurrentSession().createCriteria(State.class).list();
			return list;
		}
		@Override
	  public List<District> getDistrictById (String id){
	         int f=Integer.parseInt(id);
			
			return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class)
					.add(Restrictions.eq("id", f)).list();
		}
	 @Override
		public void editDistrict(District poref1){
			
			sessionFactory.getCurrentSession().update(poref1);
			
		}
	 


	@Override

		public List<Location> locationList(Integer id){
			
			/* (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class).list();*/
		Criteria location=sessionFactory.getCurrentSession().createCriteria(Location.class);
		Criteria district=location.createCriteria("district");
		district.add(Restrictions.eq("districtId", id));
		List<Location> list= location.list();
			 
			 
			 
			 return list;
		}
	
		@Override
		public void addLocation( Location poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 
		@Override
		public  void  deleteLocation(int id){
			System.out.println("delete location");
			
			sessionFactory.getCurrentSession().createQuery("DELETE FROM Location WHERE locationId = "+id).executeUpdate();
		} 
	 
		@Override
	  public List<Location> getLocationById (String id){
	         int f=Integer.parseInt(id);
			
			return (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class)
					.add(Restrictions.eq("id", f)).list();
		}
	 @Override
		public void editLocation(Location poref1){
			
			sessionFactory.getCurrentSession().update(poref1);
			
		}


	   @Override

		public List<ExpenseMaster> expenseheadList(){
			
			return (List<ExpenseMaster>) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class).list();
		}
	 
		@Override
		public void addExpensehead( ExpenseMaster poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 
		@Override
		public  void  deleteExpenceserheader(int id){
			System.out.println("delete expenseheader");
			
			sessionFactory.getCurrentSession().createQuery("DELETE FROM ExpenseMaster WHERE expensemasterId = "+id).executeUpdate();
		} 
	 
		@Override
	  public List<ExpenseMaster> getExpenceserheaderById (String id){
	         int f=Integer.parseInt(id);
			
			return (List<ExpenseMaster>) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class)
					.add(Restrictions.eq("id", f)).list();
		}
	 @Override
		public void editExpenseHeader(ExpenseMaster poref1){
			
			sessionFactory.getCurrentSession().update(poref1);
			//
		}

	
	 @Override
	 public List<ExpenseMaster> getExpenseListById() {
		 
				ProjectionList proList=Projections.projectionList();
				proList.add(Projections.property("expensehead"));
				//proList.add(Projections.property("customerId"));
				Criteria r= sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class).setProjection(Projections.property("expensehead"));
						
				List<ExpenseMaster> list=r.list();
				return list;
			
	 }
	 
	 
	 
	 @Override
	 public List<ExpenseMaster> getUnitByExpense(String unit) 
	 {
		 return (List<ExpenseMaster>) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class)
				 .add(Restrictions.eq("expensehead", unit)).list();
		
		/* ExpenseMaster e= (ExpenseMaster) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class)
				 .add(Restrictions.eq("expensehead", unit)).uniqueResult();
	 	System.out.println("***************************inside expenese master list********************************"+e);
		 return (List<ExpenseMaster>) e;*/
	 }
	 
	
	 @Override
		public List<CustomerSource> getCustomerSourceList(){
			
			return (List<CustomerSource>) sessionFactory.getCurrentSession().createCriteria(CustomerSource.class).list();
		}
		
		@Override
		public void deleteCustomerSource(int id) {
			sessionFactory.getCurrentSession().createQuery("DELETE FROM CustomerSource WHERE customersourceId = "+id).executeUpdate();
			
		}
		@Override
		public void addCustomerSource(CustomerSource cur) {
			sessionFactory.getCurrentSession().save(cur);
			
		}
		
		
		@Override
		public List<CustomerSource> getCustomerSource(String id) {
			int id1=Integer.parseInt(id);
			return (List<CustomerSource>)sessionFactory.getCurrentSession().createCriteria(CustomerSource.class).add(Restrictions.eq("customersourceId", id1)).list();
		}
		 @Override
			public void editCustomerSource(CustomerSource poref1){
				
				sessionFactory.getCurrentSession().update(poref1);
				//
			}

	
	
	@Override

	public List<District> getdistrictlistbystateid(String stateid) {
		sessionFactory.getCurrentSession().flush();
		int id=Integer.parseInt(stateid);
		Criteria district = sessionFactory.getCurrentSession().createCriteria(District.class);
		Criteria state=district.createCriteria("state");
		state.add(Restrictions.eq("stateId", id));
		List<District> list= district.list();
		return list;
	}
	
	@Override
	public List<ModeOfDispatch> getModeOfDispatchList() {
		
		return (List<ModeOfDispatch>)sessionFactory.getCurrentSession().createCriteria(ModeOfDispatch.class).list();
	}
	
	@Override
	public void addModeOfDispatch( ModeOfDispatch poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	@Override
	public void deleteModeOfDispatch(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ModeOfDispatch WHERE modeofdispatchId = "+id).executeUpdate();
		
	}


	@Override
 public List<ModeOfDispatch> getModeOfDispatchbyId (String id){
        int f=Integer.parseInt(id);
		
		return (List<ModeOfDispatch>) sessionFactory.getCurrentSession().createCriteria(ModeOfDispatch.class)
				.add(Restrictions.eq("id", f)).list();
	}

@Override
public void editModeOfDispatch(ModeOfDispatch modeofdispatch){
	
	sessionFactory.getCurrentSession().update(modeofdispatch);
	//
}

@Override
	public List<ServiceProvider> getServiceProviderList() {
		
		return sessionFactory.getCurrentSession().createCriteria(ServiceProvider.class).list();
	}
	@Override
	public void addServiceProvider(ServiceProvider spb) {
		
		sessionFactory.getCurrentSession().save(spb);
	}





@Override
public List<TeamSegment> getTeamSegmentList() {
	
	return (List<TeamSegment>)sessionFactory.getCurrentSession().createCriteria(TeamSegment.class).list();
}


@Override
public void addteam( TeamSegment poref1){
	sessionFactory.getCurrentSession().save(poref1);
}
@Override
public void deleteteam(int id) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM TeamSegment WHERE teamid = "+id).executeUpdate();
	
}



@Override
public List<TeamSegment> getTeambyId (String id){
    int f=Integer.parseInt(id);
	
	return (List<TeamSegment>) sessionFactory.getCurrentSession().createCriteria(TeamSegment.class)
			.add(Restrictions.eq("id", f)).list();
}

@Override
public void editTeam(TeamSegment team){

sessionFactory.getCurrentSession().update(team);
//
}
@Override
public ServiceProvider getServiceProvider(int id) {
	
	return (ServiceProvider) sessionFactory.getCurrentSession().get(ServiceProvider.class, id);
}
@Override
public void editSourceProviderbyId(ServiceProvider sp) {
	sessionFactory.getCurrentSession().flush();
	sessionFactory.getCurrentSession().update(sp);
}
@Override
public List<Country> getCountryDetails() {
	return sessionFactory.getCurrentSession().createCriteria(Country.class).list();
}
@Override
public List<CustomerLevels> getCustomerStatusDetails() 
{
	return sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).setProjection(Projections.property("status")).list();
}
@Override
public District getDistrictDataById(Integer districtId) {
	return (District) sessionFactory.getCurrentSession().get(District.class, districtId);
}
@Override
public Country getCountryDataById(Integer countryId) {
	return (Country) sessionFactory.getCurrentSession().get(Country.class, countryId);
}
@Override
public List<State> getStateByContryId(int id) {
	return sessionFactory.getCurrentSession().createCriteria(State.class)
			.add(Restrictions.eq("country.countryId", id)).list();
}

@Override
@Transactional
public State getStatesById(Integer stateId) {
	return (State) sessionFactory.getCurrentSession().get(State.class, stateId);
}
@Override
public List<Location> getLocationDetails() {
	return sessionFactory.getCurrentSession().createCriteria(Location.class).list();
}
@Override
public Location getLocations(Integer sublocationId) {
	return (Location) sessionFactory.getCurrentSession().get(Location.class, sublocationId);
}
@Override
public CustomerLevels getCustomerStatusById(Integer customerLevelId) {
	return (CustomerLevels) sessionFactory.getCurrentSession().get(CustomerLevels.class, customerLevelId);
}
@Override
public List<District> getdistrictByStateIdAndCountryId(int id) {
	/*return (List<District>) sessionFactory.getCurrentSession().get(District.class, districtId);*/
	System.out.println("on DaoImpl");
	return sessionFactory.getCurrentSession().createCriteria(District.class)
			.add(Restrictions.eq("state.stateId", id))
			 .list();
}
@Override
public void deleteserviceprovider(int id) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM ServiceProvider WHERE transportationserviceid = "+id).executeUpdate();
	
}


@Override
public State getStateIdByContryId(Integer id) {
	System.out.println(id);
	return (State) sessionFactory.getCurrentSession().get(State.class, id);

}
@Override

public List<AddAction> getactiondata() {
	return sessionFactory.getCurrentSession().createCriteria(AddAction.class).list();
}

public List<AddPlan> getActionList() {
	

	return (List<AddPlan>) sessionFactory.getCurrentSession().createCriteria(AddPlan.class).list();}
@Override
public void saveAddAction(AddAction action) {
	sessionFactory.getCurrentSession().save(action);
	
}

@Override
public List<AddActionBean> ActionList() {
	return (List<AddActionBean>) sessionFactory.getCurrentSession().createCriteria(AddActionBean.class).list();}
@Override
public List<AddAction> actionList() {
	
	return null;
}
@Override
public AddAction getActionDataById(int id) {
	return (AddAction) sessionFactory.getCurrentSession().get(AddAction.class, id);
}

	
@Override
public List<CustomerLevels> getCustomerStatusDetailsList() {
	return sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();

}
@Override

public void editforAddAction(AddAction action) {
	sessionFactory.getCurrentSession().update(action);
	
}
@Override
public List<AddAction> getActionRecord(String id) {
	int id1=Integer.parseInt(id);
	return (List<AddAction>)sessionFactory.getCurrentSession().createCriteria(AddAction.class).add(Restrictions.eq("id", id1)).list();
}
@Override
public void deleteaddAction(int id) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM AddAction WHERE id = "+id).executeUpdate();
	
}
@Override
public void addActionPlan(AddPlan plan) {
	sessionFactory.getCurrentSession().save(plan);
}
@Override
public List<AddPlanBean> PlanList() {
	return (List<AddPlanBean>) sessionFactory.getCurrentSession().createCriteria(AddPlanBean.class).list();
}
@Override
public List<AddPlan> getplandata() {
		return sessionFactory.getCurrentSession().createCriteria(AddPlan.class).list();
}
@Override
public List<AddPlan> getplanRecord(String id) {
	int id1=Integer.parseInt(id);
	return (List<AddPlan>)sessionFactory.getCurrentSession().createCriteria(AddPlan.class).add(Restrictions.eq("id", id1)).list();
}
@Override
public void updateForAddPaln(AddPlan action) {
	sessionFactory.getCurrentSession().update(action);
	
}
@Override
public void deleteAddPlan(AddPlan plan) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM AddPlan WHERE id ="+plan.getId()).executeUpdate();
	//sessionFactory.getCurrentSession().delete(plan);
	
}
@Override
public List<AddPlan> getPlanata() {
	return sessionFactory.getCurrentSession().createCriteria(AddPlan.class).list();
}

@Override
public AddPlan getplanById(int id) {
	return (AddPlan) sessionFactory.getCurrentSession().get(AddPlan.class, id);
}

public void saveSupplierMaster(SupplierMaster sm) {
	sessionFactory.getCurrentSession().save(sm);
}
@Override
public List<SupplierMaster> getSupplierMaster() {
	
	return sessionFactory.getCurrentSession().createCriteria(SupplierMaster.class).list();
}
@Override
public List<SupplierMaster> getSupmst(String id) {
	Integer idd=Integer.parseInt(id);
	return sessionFactory.getCurrentSession().createCriteria(SupplierMaster.class).add(Restrictions.eq("suppliermasterid", idd)).list();
}
@Override
public void editSupplierMaster(SupplierMaster sm) {
	sessionFactory.getCurrentSession().update(sm);
}
@Override
public void deleteSuppilerMst(int id) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM SupplierMaster WHERE suppliermasterid = "+id).executeUpdate();
}



@Override
 public void saveExpenseEntry(ExpenseEntry e)
{
	sessionFactory.getCurrentSession().save(e);
}
@Override
public List<ExpenseEntry> getExpenseReportList(int id) {
	return (List<ExpenseEntry>)sessionFactory.getCurrentSession().createCriteria(ExpenseEntry.class).add(Restrictions.eq("useremp.userempid", id)).list();
}
@Override
public List<ExpenseEntry> getExpenseReportListByDate(String sdate , String edate) {
	return sessionFactory.getCurrentSession()
	.createCriteria(ExpenseEntry.class)
	//.add(Restrictions.eq("userEmp.userempid", id1))
	.add(Restrictions.between("crdate", sdate, edate)).addOrder(Order.asc("crdate"))
	.list();
	
}
@Override
public List<UserEmployee> getAccountManagerList() {
	
	return sessionFactory.getCurrentSession().createCriteria(UserEmployee.class).list();
}
@Override
public List<UserEmployee> getAccountManagerList(String manager) {
	
	return sessionFactory.getCurrentSession()
			.createCriteria(UserEmployee.class)
			.add(Restrictions.eq("firstname", manager)).addOrder(Order.asc("firstname"))
			.list();
}
@Override
public void saveExpenseDetails(ExpenseDetails d) {
    
	   sessionFactory.getCurrentSession().save(d);
	
}







}





