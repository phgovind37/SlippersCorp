<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<style type="text/css">
.navbar-nav > li > a {
padding-top:5px !important; 
padding-bottom:5px !important;
}
.navbar {
min-height:32px !important;
margin-bottom: 10px;
}
.navbar .nav > li:first-child > a {
	background: none;
}
.dropdown-menu{
 min-width: 120px !important;
 }
.navbar .nav > li > a {
	padding: 6px 15px;
	color: #D6D7D6;
	text-shadow: none;
	font-weight: bold;
	background: url("<c:url value='/resources/images/navbar-separator.png'/>") no-repeat left top;
}

.navbar .nav > li > a:hover,
.navbar .nav > li:hover > a{
	background-color: #08100b;
	color: #ffffff;
    background-image: linear-gradient(to bottom, #08100b, #6a6a6a);
}

.navbar .nav li.dropdown > .dropdown-toggle .caret {
    border-bottom-color: #A2A2A2;
    border-top-color: #A2A2A2;
    border-left: 5px solid transparent;
    border-right: 5px solid transparent;
    margin-left: 5px;
}

.navbar .nav li.dropdown .dropdown-menu li:first-child a {
	border-top: 0;
}

.navbar .nav li.dropdown .dropdown-menu li a:hover{
	background-color: #ffffff;
    background-image: none;
    color: #000000;
    filter: none;
}

.navbar .nav li.dropdown .dropdown-menu a {
	color: #0098bc;
	border-top: 1px dotted #0098bc;
	margin: 0 10px;
	padding: 3px 10px;
	background-color: #ffffff;
	background-image: none;
}

ul.nav li.dropdown:hover ul.dropdown-menu{
    display: block;
    margin: 0;
}

</style>
<div class="container-fluid">
<div class="row" style="margin-top:-10px; border-color: white;">
<div class="container-fluid">
<span class="span6" style="margin-left: 40px;">
<img alt="Logo Image" src="<c:url value='/resources/images/Logo1.png'/>" width="400px;" height="120px;"/>
</span>
<span class="span6 pull-right" style="margin-top: 100px;">Welcome <a href="#"><b><font color="black">${userName}</font></b></a> &nbsp;
<a href="<c:url value='/employee/edit/'/>"><img style="height:17px;margin-bottom: 3px;" src="<c:url value='/resources/images/settings.jpg'/>" alt="set"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/logout" style="margin-top: 99px; margin-right: 5px;">Logout</a>
</span>
</div>
</div> 
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav" style="margin-left: -30px;">
					<li><a href="<c:url value="/" />"><img alt="home"
							src="<c:url value='/resources/images/ichome.png'/>" /></a></li>
					<c:if test="${not empty navs.navItems}">
						<c:forEach items="${navs.navItems}" var="navItem">
							<li class="dropdown">
							<c:choose>
							<c:when test="${empty navItem.link}">
							<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"><c:out value="${navItem.lable}" /><b class="caret"></b></a>
							</c:when>
							<c:otherwise>
							<a href="<c:url value='${navItem.link}'/>" class="dropdown-toggle" data-toggle="dropdown"
								aria-expanded="true"><c:out value="${navItem.lable}" /></a>
							</c:otherwise>
							</c:choose>
								 <c:if test="${not empty navItem.navItems}">
									<ul class="dropdown-menu">
										<c:forEach items="${navItem.navItems}" var="subNavItem">
											<li><a href="<c:url value='${subNavItem.link}'/>"><c:out value="${subNavItem.lable}" /></a></li>
										</c:forEach>
									</ul>
								</c:if></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

</div>