package com.pogo.action;

public class test {

	public static void main(String[] args) {
	double f=2310000.0;
	String s="YIPL/16-17/052";
	s.split("/");
	int i=Integer.parseInt(s.split("/")[2]);
	String s1=s.split("/")[0]+"/"+s.split("/")[1]+"/"+"0"+(i+1);
	System.out.println(s1);
	}
}
