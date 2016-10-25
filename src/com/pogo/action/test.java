package com.pogo.action;

import com.pogo.model.ProductMaster;

public class test {

	public static void main(String[] args) {
	
	ProductMaster d=	new ProductMaster();
		d.setProductname("a");
	String s="[['Pack ODS A  50 X 2 mm 3 um',17600.0]]";
	String getpart1=s.replaceAll("\\[", "");
	getpart1=getpart1.replaceAll("\\]", "");
	
	System.out.println(getpart1);
	}
}
