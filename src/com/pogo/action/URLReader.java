package com.pogo.action;


public class URLReader {

	public static void main(String[] args) {
		String s="D:\\PojoErpWorkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringHibernateApp\\resources\\image\\empProfile\\useremp.png";
	s=s.split("resources")[1];
	System.out.println(s);
	}

}