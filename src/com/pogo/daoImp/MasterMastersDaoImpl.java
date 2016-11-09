package com.pogo.daoImp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.CustomerLevelsBean;
import com.pogo.dao.MasterMastersDao;
import com.pogo.model.Country;
import com.pogo.model.CustomerLevels;
import com.pogo.model.District;
import com.pogo.model.ExpenseMaster;
import com.pogo.model.Location;
import com.pogo.model.PorefSupplierDetail;
import com.pogo.model.State;

import com.pogo.model.Unit;
import com.pogo.model.Zones;
@Repository("masterMastersdao")
public class MasterMastersDaoImpl  implements  MasterMastersDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
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
	@SuppressWarnings("unchecked")
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Country> countryList(){
		sessionFactory.getCurrentSession().flush();
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addCountry( Country poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	@SuppressWarnings("unchecked")
	@Override
	public  void  deleteCountry(Integer id){
		System.out.println("delete country");
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Country WHERE countryId = "+id).executeUpdate();
	}
	@SuppressWarnings("unchecked")
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
	

	
	@SuppressWarnings("unchecked")
	public List<State> stateList(){
		sessionFactory.getCurrentSession().flush();
		return (List<State>) sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void addState( State poref1){
		sessionFactory.getCurrentSession().save(poref1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
        public List<Country> getdata (String id){
		sessionFactory.getCurrentSession().flush();
		return (List<Country>) sessionFactory.getCurrentSession().createCriteria(Country.class).list();
	}
	
	 @SuppressWarnings("unchecked")
		@Override
		public  void  deleteState(Integer id){
			System.out.println("delete state");
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().createQuery("DELETE FROM State WHERE stateId = "+id).executeUpdate();
		} 
	 
	 @SuppressWarnings("unchecked")
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

	 
	 @SuppressWarnings("unchecked")
		public List<District> districtList(){
			sessionFactory.getCurrentSession().flush();
			return (List<District>) sessionFactory.getCurrentSession().createCriteria(District.class).list();
		}
	 @SuppressWarnings("unchecked")
		@Override
		public void addDistrict( District poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 @SuppressWarnings("unchecked")
		@Override
		public  void  deleteDistrict(Integer id){
			System.out.println("delete district");
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().createQuery("DELETE FROM District WHERE districtId = "+id).executeUpdate();
		} 
	 @SuppressWarnings("unchecked")
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
	 
	 @SuppressWarnings("unchecked")
		public List<Location> locationList(){
			sessionFactory.getCurrentSession().flush();
			return (List<Location>) sessionFactory.getCurrentSession().createCriteria(Location.class).list();
		}
	 @SuppressWarnings("unchecked")
		@Override
		public void addLocation( Location poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 @SuppressWarnings("unchecked")
		@Override
		public  void  deleteLocation(int id){
			System.out.println("delete location");
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().createQuery("DELETE FROM Location WHERE locationId = "+id).executeUpdate();
		} 
	 @SuppressWarnings("unchecked")
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

	 @SuppressWarnings("unchecked")
		public List<ExpenseMaster> expenseheadList(){
			sessionFactory.getCurrentSession().flush();
			return (List<ExpenseMaster>) sessionFactory.getCurrentSession().createCriteria(ExpenseMaster.class).list();
		}
	 @SuppressWarnings("unchecked")
		@Override
		public void addExpensehead( ExpenseMaster poref1){
			sessionFactory.getCurrentSession().save(poref1);
		}
	 @SuppressWarnings("unchecked")
		@Override
		public  void  deleteExpenceserheader(int id){
			System.out.println("delete expenseheader");
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().createQuery("DELETE FROM ExpenseMaster WHERE expensemasterId = "+id).executeUpdate();
		} 
	 @SuppressWarnings("unchecked")
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
}
