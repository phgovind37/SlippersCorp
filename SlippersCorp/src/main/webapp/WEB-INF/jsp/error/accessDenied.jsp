<%@include file="/WEB-INF/jsp/includes.jsp" %>
<%-- <%@ page import="org.springframework.security.core.context.SecurityContextHolder" %> --%>

<style type="text/css">
#background{
background-image: url('<ic:resource value="/resources/images/gutter.jpg"/>');

background-repeat: inherit;
height:500px;
}

</style>
<div class="container" id="background">
<p align="center" style="margin-top: 100px;">
       <strong> Looks like you are not authorized to access this page but we can take you back home. 
       <br/>Click here to reach &nbsp;&nbsp;&nbsp;&nbsp;
    <%--   <%
     if( SecurityContextHolder.getContext().getAuthentication() != null &&
      SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
 		String name = SecurityContextHolder.getContext().getAuthentication().getName();
 		out.println(name+"...........");
    	%>
    	<%= name %>
    	 <a href="<c:url value="/" />">Home</a><br/>
    	<% 
     }else{
      %>
        <a href="<c:url value="/" />">Home123</a><br/>
       <% } %>
       --%>
        <a href="<c:url value="/" />">Home</a><br/>
	Please <a href="#">click here</a> to let us know what page you tried to access.</strong></p>
	</div>
  