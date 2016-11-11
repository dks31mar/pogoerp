package com.pogo.daoImp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.dao.MasterMastersDao;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.CustomerSource;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.ServiceProvider;
import com.pogo.model.State;
@SuppressWarnings("unchecked")
@Repository("masterMastersdao")
public class MasterMastersDaoImpl  implements  MasterMastersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<CustomerLevels> customerLevelsList(){
		sessionFactory.getCurrentSession().flush();
		return (List<CustomerLevels>) sessionFactory.getCurrentSession().createCriteria(CustomerLevels.class).list();
	}
	@Override
	public void addCustomerLevels(CustomerLevels poref1){
		sessionFactory.getCurrentSession().save(poref1);
	 }
	@Override
	public void deleteCustomerLevels(int id){
		System.out.println("delete");
		sessionFactory.getCurrentSession().flush();
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
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().update(poref1);
		//sessionFactory.getCurrentSession().flush();
	}
	
	
	
	@Override
	public List<Country> countryList(){
		sessionFactory.getCurrentSession().flush();
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	
	@Override
	public void addCountry( Country poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	
	@Override
	public  void  deleteCountry(Integer id){
		System.out.println("delete country");
		sessionFactory.getCurrentSession().flush();
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
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().update(poref1);
		//sessionFactory.getCurrentSession().flush();
	}
	

	
	@Override
	public List<State> stateList(){
		sessionFactory.getCurrentSession().flush();
		return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}
	
	@Override
	public void addState( State poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	
	
	@Override
        public List<Country> getdata (String id){
		sessionFactory.getCurrentSession().flush();
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	
	
		@Override
		public  void  deleteState(Integer id){
			System.out.println("delete state");
			sessionFactory.getCurrentSession().flush();
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
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().update(poref1);
			//sessionFactory.getCurrentSession().flush();
		}

	 
	 	@Override
		public List<District> districtList(){
			sessionFactory.getCurrentSession().flush();
			return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class).list();
		}
	 
		@Override
		public void addDistrict( District poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}

		@Override
		public  void  deleteDistrict(Integer id){
			System.out.println("delete district");
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().createQuery("DELETE FROM District WHERE districtId = "+id).executeUpdate();
		} 
	
		@Override
	  public List<District> getDistrictById (String id){
	         int f=Integer.parseInt(id);
			
			return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class)
					.add(Restrictions.eq("id", f)).list();
		}
	 @Override
		public void editDistrict(District poref1){
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().update(poref1);
			//sessionFactory.getCurrentSession().flush();
		}
	 
	@Override
		public List<Location> locationList(){
			sessionFactory.getCurrentSession().flush();
			return (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class).list();
		}
	
		@Override
		public void addLocation( Location poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 
		@Override
		public  void  deleteLocation(int id){
			System.out.println("delete location");
			sessionFactory.getCurrentSession().flush();
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
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().update(poref1);
			//sessionFactory.getCurrentSession().flush();
		}

	@Override
		public List<ExpenseMaster> expenseheadList(){
			sessionFactory.getCurrentSession().flush();
			return (List<ExpenseMaster>) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class).list();
		}
	 
		@Override
		public void addExpensehead( ExpenseMaster poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 
		@Override
		public  void  deleteExpenceserheader(int id){
			System.out.println("delete expenseheader");
			sessionFactory.getCurrentSession().flush();
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
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().update(poref1);
			//sessionFactory.getCurrentSession().flush();
		}

	 
	 @Override
		public List<CustomerSource> getCustomerSourceList(){
			sessionFactory.getCurrentSession().flush();
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
				sessionFactory.getCurrentSession().flush();
				sessionFactory.getCurrentSession().update(poref1);
				//sessionFactory.getCurrentSession().flush();
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
	public List<ServiceProvider> getServiceProviderList() {
		
		return sessionFactory.getCurrentSession().createCriteria(ServiceProvider.class).list();
	}
	@Override
	public void addServiceProvider(ServiceProvider spb) {
		
		sessionFactory.getCurrentSession().save(spb);
	}

}
