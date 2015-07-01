package com.techconquerors.slippers.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.techconquerors.slippers.common.LoginType;
import com.techconquerors.slippers.security.RoleAnalyser;

public class NavManager {
	private static final String ROLE_EMPLOYEES_MANAGE = "ROLE_EMPLOYEES_MANAGE";
	private static final String ROLE_VENDORS_MANAGE = "ROLE_VENDORS_MANAGE";
	private static final String ROLE_PRODUCTCATEGORY_MANAGE = "ROLE_PRODUCTCATEGORY_MANAGE";
	private static final String ROLE_MENSPRODUCTS_MANAGE = "ROLE_MENSPRODUCTS_MANAGE";
	private static final String ROLE_WOMENSPRODUCTS_MANAGE = "ROLE_WOMENSPRODUCTS_MANAGE";
	private static final String ROLE_KIDSPRODUCTS_MANAGE = "ROLE_KIDSPRODUCTS_MANAGE";
	private static final String ROLE_ORDERS_MANAGE = "ROLE_ORDERS_MANAGE";
	private static final String ROLE_PRODUCTREPORTS_MANAGE = "ROLE_PRODUCTREPORTS_MANAGE";
	private static final String ROLE_ORDERREPORTS_MANAGE = "ROLE_ORDERREPORTS_MANAGE";
	private static final String ROLE_EMPLOYEES_VIEW = "ROLE_EMPLOYEES_VIEW";
	private static final String ROLE_VENDORS_VIEW = "ROLE_VENDORS_VIEW";
	
	/*private static final String ROLE_PRODUCTCATEGORY_VIEW = "ROLE_PRODUCTCATEGORY_VIEW";
	private static final String ROLE_PRODUCTS_VIEW = "ROLE_PRODUCTS_VIEW";*/
	
	private static NavManager navManager;
	private final HashMap<String,NavItem> navItemMap = new HashMap<String,NavItem>();
	private final LinkedHashMap<String,LinkedHashSet<String>> navMap = new LinkedHashMap<String, LinkedHashSet<String>>();
	private final LinkedHashMap<String, LinkedHashMap<String, LinkedHashSet<String>>> navRoleMap = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashSet<String>>>();
	
	private NavManager(){
		navItemMap.put(NavManager.ROLE_EMPLOYEES_MANAGE, new NavItem("Employees", "/service/employees/list"));
		navItemMap.put(NavManager.ROLE_VENDORS_MANAGE, new NavItem("Vendors","/service/vendors/list"));
		navItemMap.put(NavManager.ROLE_PRODUCTCATEGORY_MANAGE, new NavItem("Categories","/service/productcategories/list"));
		navItemMap.put(NavManager.ROLE_MENSPRODUCTS_MANAGE, new NavItem("Mens","/service/mensproducts/list"));
		navItemMap.put(NavManager.ROLE_WOMENSPRODUCTS_MANAGE, new NavItem("Womens","/service/womensproducts/list"));
		navItemMap.put(NavManager.ROLE_KIDSPRODUCTS_MANAGE, new NavItem("Kids","/service/kidsproducts/list"));
		navItemMap.put(NavManager.ROLE_ORDERS_MANAGE, new NavItem("Orders","/service/orders/list"));
		navItemMap.put(NavManager.ROLE_PRODUCTREPORTS_MANAGE, new NavItem("Product Reports","/service/prodctreports/generate"));
		navItemMap.put(NavManager.ROLE_ORDERREPORTS_MANAGE, new NavItem("Order Reports","/service/prodctreports/generate"));
		navItemMap.put(NavManager.ROLE_EMPLOYEES_VIEW, new NavItem("Employees","/service/employees/view"));
		navItemMap.put(NavManager.ROLE_VENDORS_VIEW, new NavItem("Vendors", "/service/verdors/view"));
		/*navItemMap.put(NavManager.ROLE_PRODUCTCATEGORY_VIEW, new NavItem("Product Categories","/service/productcategories/view"));
		navItemMap.put(NavManager.ROLE_PRODUCTS_VIEW, new NavItem("Products","/service/products/view"));*/
		
		final LinkedHashSet<String> employees = new LinkedHashSet<String>();
		employees.add(NavManager.ROLE_EMPLOYEES_MANAGE);
		
		final LinkedHashSet<String> vendors = new LinkedHashSet<String>();
		vendors.add(NavManager.ROLE_VENDORS_MANAGE);
		
		final LinkedHashSet<String> products = new LinkedHashSet<String>();
		products.add(ROLE_PRODUCTCATEGORY_MANAGE);
		products.add(ROLE_MENSPRODUCTS_MANAGE);
		products.add(ROLE_WOMENSPRODUCTS_MANAGE);
		products.add(ROLE_KIDSPRODUCTS_MANAGE);
		
		LinkedHashSet<String> reports = new LinkedHashSet<String>();
		reports.add(ROLE_PRODUCTREPORTS_MANAGE);
		reports.add(ROLE_ORDERREPORTS_MANAGE);
		
		navMap.put("Employees", employees);
		navMap.put("Vendors", vendors);
		navMap.put(ROLE_EMPLOYEES_VIEW, null);
		navMap.put(ROLE_VENDORS_VIEW, null);
		navMap.put("Products", products);
		navMap.put(ROLE_ORDERS_MANAGE, null);
		navMap.put("Reports", reports);
		
		final LinkedHashMap<String, LinkedHashSet<String>> superAdmin = new LinkedHashMap<String, LinkedHashSet<String>>();
		final LinkedHashMap<String, LinkedHashSet<String>> admin = new LinkedHashMap<String, LinkedHashSet<String>>();
		final LinkedHashMap<String, LinkedHashSet<String>> employee = new LinkedHashMap<String, LinkedHashSet<String>>();
		
		for(String temp:navMap.keySet()){
			if(temp.equalsIgnoreCase("Employees") || temp.equalsIgnoreCase("Vendors")){
				admin.put(temp, navMap.get(temp));
			}else{
				if(!(temp.equalsIgnoreCase(ROLE_EMPLOYEES_VIEW) && temp.equalsIgnoreCase(ROLE_VENDORS_VIEW))){
				admin.put(temp, navMap.get(temp));
				}
				employee.put(temp,navMap.get(temp));
			}
		}
		
		navRoleMap.put(LoginType.SUPERADMIN.name(), superAdmin);
		navRoleMap.put(LoginType.ADMIN.name(), admin);
		navRoleMap.put(LoginType.EMPLOYEE.name(), employee);
		
	}
	
	public NavItem getNavigationItemForRole(String role){
		return navItemMap.get(role);
	}
	
	public LinkedHashMap<String,LinkedHashSet<String>> getNavItemsMap(String role){
		return navRoleMap.get(role);
	}
	
	private static NavManager getInstance(){
		if(NavManager.navManager == null){
			NavManager.navManager = new NavManager();
		}
		return navManager;
	}
	
	public static Navs createNavigation(){
		Navs navs = new Navs();
		final NavManager navManager = NavManager.getInstance();
		/*final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal();
		User user = null;
		if(principal instanceof User){
			user = (User)principal;
		}*/
		
		Collection<? extends GrantedAuthority> authorities =  RoleAnalyser.getAuthorities();
		Set<String> auths = new HashSet<String>();
	       Iterator<? extends GrantedAuthority> itr = authorities.iterator();
	       while(itr.hasNext()){
	    	   GrantedAuthority ga = (GrantedAuthority) itr.next(); 
	    	   auths.add(ga.getAuthority());
	       }
	       String userRole = RoleAnalyser.getRole();
	       LinkedHashMap<String,LinkedHashSet<String>> navItemsMap = navManager.getNavItemsMap(userRole); 
	       if(navItemsMap != null && navItemsMap.size() > 0) {
	       for(String key : navItemsMap.keySet()){
	    	   NavItem navItem = null;
	    	   if(auths.contains(key)){
	    		   navItem =navManager.getNavigationItemForRole(key);
	    		   if(navItem == null){
	    			   navItem = new NavItem(key, null) ; 
	    		   }
	    		   
	    	   } else {
	    		  navItem = new NavItem(key, null) ;
	    	   }
	    	   
	    	   LinkedHashSet<String> roles = navItemsMap.get(key);
	    	   if(roles != null){
	    		   for(String role : roles){
	    			   if(auths.contains(role))
	    			   {
	    			     navItem.addNavItem(navManager.getNavigationItemForRole(role));
	    			   }
	    		   }
	    	   }
	    	   if(navItem.getLink() != null || (navItem.getNavItems() != null && navItem.getNavItems().size() > 0)){
	    		   navs.addItem(navItem);
	    	   }
	       }
	}
	       
		return navs;
	}

}
