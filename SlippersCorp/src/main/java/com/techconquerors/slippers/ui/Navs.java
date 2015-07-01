package com.techconquerors.slippers.ui;

import java.util.ArrayList;
import java.util.List;

public class Navs {
		private List<NavItem> navItems = new ArrayList<NavItem>();

		public List<NavItem> getNavItems() {
			return navItems;
		}

		public void setNavItems(List<NavItem> navItems) {
			this.navItems = navItems;
		}
		
		public void addItem(NavItem item){
			navItems.add(item);
		}

}
