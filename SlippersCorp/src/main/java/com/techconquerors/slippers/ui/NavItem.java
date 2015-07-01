package com.techconquerors.slippers.ui;

import java.util.ArrayList;
import java.util.List;

public class NavItem {
	private String lable;
	private String link;
	private List<NavItem> navItems = new ArrayList<NavItem>();
	
	public NavItem(String lable, String link) {
		super();
		this.lable = lable;
		this.link = link;
	}
	

	public NavItem(String lable, String link, List<NavItem> navItems) {
		super();
		this.lable = lable;
		this.link = link;
		this.navItems = navItems;
	}


	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	public List<NavItem> getNavItems() {
		return navItems;
	}


	public void setNavItems(List<NavItem> navItems) {
		this.navItems = navItems;
	}
	
	public void addNavItem(NavItem item){
		navItems.add(item);
	}
	
}
