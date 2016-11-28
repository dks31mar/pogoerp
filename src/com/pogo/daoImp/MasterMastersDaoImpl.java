package com.pogo.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pogo.dao.MasterMastersDao;
import com.pogo.model.Country;
import com.pogo.model.Currency;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;

import com.pogo.model.ModeOfDispatch;

import com.pogo.model.ServiceProvider;

import com.pogo.model.State;

import com.pogo.model.TeamSegment;
import com.pogo.model.UserEmployee;

@SuppressWarnings("unchecked")

@Repository("masterMastersdao")
public class MasterMastersDaoImpl  implements  MasterMastersDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
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
		sessionFactory.getCurrentSession().flush();
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
	

	

	@SuppressWarnings("unchecked")

	@Override
	public List<State> stateList(){
		
		return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}
	
	@Override
	public void addState( State poref1){
		sessionFactory.getCurrentSession().save(poref1);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<ModeOfDispatch> getModeOfDispatchList() {
		
		return (List<ModeOfDispatch>)sessionFactory.getCurrentSession().createCriteria(ModeOfDispatch.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addModeOfDispatch( ModeOfDispatch poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	@Override
	public void deleteModeOfDispatch(int id) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ModeOfDispatch WHERE modeofdispatchId = "+id).executeUpdate();
		
	}

@SuppressWarnings("unchecked")
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




@SuppressWarnings("unchecked")
@Override
public List<TeamSegment> getTeamSegmentList() {
	
	return (List<TeamSegment>)sessionFactory.getCurrentSession().createCriteria(TeamSegment.class).list();
}

@SuppressWarnings("unchecked")
@Override
public void addteam( TeamSegment poref1){
	sessionFactory.getCurrentSession().save(poref1);
}
@Override
public void deleteteam(int id) {
	sessionFactory.getCurrentSession().createQuery("DELETE FROM TeamSegment WHERE teamid = "+id).executeUpdate();
	
}

@SuppressWarnings("unchecked")
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
	return sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();
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
public List<District> getdistrictByStateIdAndCountryId(int id, int countryId) {
	return sessionFactory.getCurrentSession().createCriteria(District.class)
			.add(Restrictions.eq("state.stateId", id)).add(Restrictions.eq("country.countryId", countryId)).list();
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


}

