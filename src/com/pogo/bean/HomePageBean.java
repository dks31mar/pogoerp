package com.pogo.bean;

import java.util.List;
@SuppressWarnings("rawtypes")
public class HomePageBean {

	
	private int  empId ;
    private int menuItemId;
    private String add;
    private String edit;
    private String delete;
    private String view;
    private List rightsList ;
    private String[] menuItems;
    private int returnStatus ;
    private List level1MenuOptionList ;
    private List level2MenuOptionList ;
    private List level3MenuOptionList ;
    private List restMenuOptionList ;
    private List menuOptionList;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public List getRightsList() {
		return rightsList;
	}
	public void setRightsList(List rightsList) {
		this.rightsList = rightsList;
	}
	public String[] getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(String[] menuItems) {
		this.menuItems = menuItems;
	}
	public int getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}
	public List getLevel1MenuOptionList() {
		return level1MenuOptionList;
	}
	public void setLevel1MenuOptionList(List level1MenuOptionList) {
		this.level1MenuOptionList = level1MenuOptionList;
	}
	public List getLevel2MenuOptionList() {
		return level2MenuOptionList;
	}
	public void setLevel2MenuOptionList(List level2MenuOptionList) {
		this.level2MenuOptionList = level2MenuOptionList;
	}
	public List getLevel3MenuOptionList() {
		return level3MenuOptionList;
	}
	public void setLevel3MenuOptionList(List level3MenuOptionList) {
		this.level3MenuOptionList = level3MenuOptionList;
	}
	public List getRestMenuOptionList() {
		return restMenuOptionList;
	}
	public void setRestMenuOptionList(List restMenuOptionList) {
		this.restMenuOptionList = restMenuOptionList;
	}
	public List getMenuOptionList() {
		return menuOptionList;
	}
	public void setMenuOptionList(List menuOptionList) {
		this.menuOptionList = menuOptionList;
	}
    
    
}
