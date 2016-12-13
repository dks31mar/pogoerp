package com.pogo.daoImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UEncoder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.Employee1Bean;
import com.pogo.dao.LoginDao;
import com.pogo.model.CompanyPogoOptions;
import com.pogo.model.PogoMenuOptions;
import com.pogo.model.User;
import com.pogo.model.UserEmployee;
import com.pogo.model.UserOption;
@Repository("loginDao")
@SuppressWarnings({ "unused", "rawtypes" ,"unchecked"})
public class LoginDaoImp implements LoginDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	
	public boolean isValidUser(User userBean,HttpServletRequest request) {
		int userId=0;
		
			Criteria w=sessionFactory.getCurrentSession().createCriteria(UserEmployee.class)
					.add(Restrictions.disjunction()
							.add(Restrictions.or(Restrictions.eq("loginname", userBean.getUserName()), Restrictions.eq("eamil", userBean.getUserName()))))
					.add(Restrictions.eq("password", userBean.getPassword())).add(Restrictions.eq("active", true));
try{
	UserEmployee u=(UserEmployee)w.uniqueResult();
	System.out.println(u.getUsermobile());
	String name=u.getFirstname()+" "+u.getLastname();
//		userId=0;
	userId=u.getUserempid();
	HttpSession session=request.getSession();
	session.setAttribute("userid", userId);
	session.setAttribute("username",name);
	System.out.println(userId);
	if(userId>0){
		
		return true;
	}
	
}catch(Exception e){
	return false;
}
		

return false;
}
	
	@Override
	public Map getLeftMenuData(HttpServletRequest request,int id,PogoMenuOptions pmob) {
		List<String> optiondescription=sessionFactory.getCurrentSession().createSQLQuery("select sys.optiondescription from sysmenuoptions sys inner join communitymenuoptions com ON com.OptionID = sys.OptionID inner join user_option usr ON usr.OptionID = sys.OptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openIn=0 and level=0 order by seqNo").list();
		List<String> optionID=sessionFactory.getCurrentSession().createSQLQuery("select sys.optionID from sysmenuoptions sys inner join communitymenuoptions com ON com.OptionID = sys.OptionID inner join user_option usr ON usr.OptionID = sys.OptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=0 and sys.level=0 order by seqNo,optionid").list();
		System.out.println("alll option idsssss>>>>>>>>>>>>>>>>>>>>>>     "+optionID);
		List secondLevelMenu=new ArrayList();
		for(String parentId:optionID){
		List subMenu=sessionFactory.getCurrentSession().createSQLQuery("select sys.optiondescription from sysmenuoptions as sys inner join user_option usr ON usr.OptionID=sys.parentOptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=1 and sys.level=1 and parentOptionId="+parentId+" order by seqNo").list();
		secondLevelMenu.add(subMenu);
		}
		System.out.println("%$%$%$%$%$%$%$%$%$%$%$    "+secondLevelMenu);
		
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> Tmap=new TreeMap<String, Object>(map);
		for (int i = 0; i < optiondescription.size(); i++) {
			Tmap.put(optiondescription.get(i), secondLevelMenu.get(i));
			}
		System.out.println("&&&&&&&&&&&& %%%%%%%%%%%%%%%%%% $$$$$$$$$$$    \n"+Tmap);

	/*String str=Integer.toString(id);
		Criteria q=sessionFactory.getCurrentSession().createCriteria(UserOption.class,"user1212").add(Restrictions.eq("user1212.empId", str));
	List<UserOption> list=q.list();
	//List<CompanyPogoOptions> list2=q.list();
	for (UserOption c:list) {
		System.out.println(c.getCpogooption().getOptionId());
	}
	
	
	//UserOption com=(UserOption)q.uniqueResult();

	//System.out.println(com.getCpogooption().getCoptionId());
		*/
		return Tmap;
	}
	

}
