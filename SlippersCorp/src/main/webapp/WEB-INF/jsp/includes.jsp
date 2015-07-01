<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.11.2.min.js'/>" ></script>
<script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>" ></script>
<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />

<%@ page import="com.techconquerors.slippers.ui.NavManager" %>
<%@ page import="com.techconquerors.slippers.ui.NavItem" %>
<%@ page import="com.techconquerors.slippers.ui.Navs" %>

<%
Navs navs = (Navs)NavManager.createNavigation();
request.setAttribute("navs", navs);
%>