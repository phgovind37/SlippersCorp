<%-- <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> --%>
<%@include file="includes.jsp" %>
<style>
.loginDiv{
	padding: 10px;
	border: 1px solid #2F96B4;
	background-color: whiteSmoke;
	border-radius: 4px;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	width : 550px;
	height: 250px;
	margin-top : 10%;
}
</style>
<body style="background-image: url('<c:url value="resources/images/login_background.jpg"/>');">
<div class="container">
<div class="row">&nbsp;</div>
<div class="row" align="center">
<div class="span4 loginDiv">
<form action="j_spring_security_check" method="POST">
<table>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td align="right">User Name  &nbsp;</td>
<td align="left"> <input type="text" class="input-large" name="j_username" id="Juname"></td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr>
<td align="right">Password  &nbsp;</td>
<td align="left"><input type="password" class="input-large" name="j_password"></td>
</tr>
<tr><td colspan="2">&nbsp;<br></td></tr>
<tr><td colspan="2">
<c:if test="${'fail' eq param.auth}">
		<div class="alert alert-warning" style="height: 3px;">
		<p style="margin-top: -7px;">Username or Password incorrect</p>
         </div>
	</c:if>
</td></tr>
<tr><td>&nbsp;</td>
<td><input type="submit" value="Login" class="btn btn-info">
&nbsp;&nbsp; <a href="javascript:void(0);">Can't access your account?</a>
</td>
</tr>
</table>
</form>
</div>
</div>
</div>
</body>

<script>
$(document).ready(function(){
	//alert("hi");
});
</script>
<%-- 	<div class="modal" id="myModal">
		<div class="modal-body" >
			<form class="form-horizontal " action="j_spring_security_check"
				method="POST">
				 <div class="control-group">
				 <label class="control-label"  for="j_username">Username</label>
				 <div class="controls">
				<input type="text" class="input-large" name="j_username" id="j_username"
						placeholder = "Enter user name" />
				 </div>
				 </div>
				 <div class="control-group">
				 <label class="control-label" for="j_password">Password</label>
				 <div class="controls">
				  <input type="password"
						class="input-large" name="j_password" id="j_password" placeholder = "Enter password" />
				 </div>
				 </div>
				 <div class="control-group">
				 <div class="controls">
				 <c:if test="${loginError=='loginMsg'}">
				 <span class="error alert">Username or Password incorrect</span>
				 </c:if>
				 </div>
				 </div>
				 <div class="control-group">
			
				 <div class="controls">
				 <input class="btn btn-info" type="submit"
							value="Login" />
				<a href="forgotPassword" style="margin-left: 48px;">Can't access your account?</a>
			<!-- 	<a href="completeAccount" style="margin-left: 48px;">Complete Your Registration</a> -->
				 </div>
				 </div> --%>
					
					
<!-- 					
			</form>
			</div>

		</div>
</div>
</div> -->
