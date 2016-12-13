package com.pogo.daoImp;

import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pogo.bean.SubMenuBean;
import com.pogo.dao.HomePageDao;
@Repository("homePageDao")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class HomePageDaoImp implements HomePageDao{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List getMenuOfSubMenu(int id,String menuName) {
		
		List<String> optionId=sessionFactory.getCurrentSession().createSQLQuery("select sys.optionID from sysmenuoptions sys inner join communitymenuoptions com ON com.OptionID = sys.OptionID inner join user_option usr ON usr.OptionID = sys.OptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=1 and sys.level=1 AND sys.optiondescription='"+menuName+"' order by seqNo,optionid").list();
		String parentId="0";
		Iterator itr=optionId.iterator();
		parentId=(String) itr.next();
		System.out.println(optionId);
		List subMenu=sessionFactory.getCurrentSession().createSQLQuery("select sys.optiondescription from sysmenuoptions as sys inner join user_option usr ON usr.OptionID=sys.parentOptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=2 and sys.level=2 and parentOptionId="+parentId+" order by seqNo").list();
		System.out.println("%%%%%%%%%%%%%%%%%%%%  SUBMENUUUUUU  %%%%%%%%%%%%%%%%%%%%%%%%%           "+subMenu);
		return subMenu;
	}
	@Override
	public List<SubMenuBean> getSubMenuDetails(int id, String menuName) {
		List<String> optionId=sessionFactory.getCurrentSession().createSQLQuery("select sys.optionID from sysmenuoptions sys inner join communitymenuoptions com ON com.OptionID = sys.OptionID inner join user_option usr ON usr.OptionID = sys.OptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=1 and sys.level=1 AND sys.optiondescription='"+menuName+"' order by seqNo,optionid").list();
		System.out.println(optionId.size());
		String parentId="0";
		Iterator itr=optionId.iterator();
		try{
			parentId=(String) itr.next();
		}catch(Exception e){
			
		}
		
		System.out.println(optionId);
		List<SubMenuBean> subMenu=sessionFactory.getCurrentSession().createSQLQuery("select sys.optiondescription,sys.formname from sysmenuoptions as sys inner join user_option usr ON usr.OptionID=sys.parentOptionID where sys.ismenu='Y' and usr.EmpID="+id+" and sys.openin=2 and sys.level=2 and parentOptionId="+parentId+" order by seqNo").setResultTransformer(Transformers.aliasToBean(SubMenuBean.class)).list();
		System.out.println("Submenu list ********************    \n"+subMenu);

		return subMenu;
	}
	
	
//	@Override
//	public List getSubMenu() {
//		
//		return sessionFactory.getCurrentSession().createSQLQuery("select optiondescription from sysmenuoptions where openin=1 and level=1 and parentoptionid=1000000000").list();
//	}
	
}
