<%@include file="/WEB-INF/jsp/includes.jsp" %>
<%@page import="java.util.HashMap"%>

<style type="text/css">
#background{
background-image: url('<c:url value="/resources/images/gutter.jpg"/>');

background-repeat: inherit;
height:500px;
}

</style>
<div class="container" id="background">
<p align="center" style="margin-top: 20px;">
<p>Your session has expired. Please sign in again </p>

This Page will Redirect to Another Page within:
<label id="lblTime" style=" font-weight:bold; font-size:large"></label>
</div>


<script type="text/javascript">
$(document).ready(function(){
	ShowCurrentTime();
});
var i = 0;
function ShowCurrentTime() {
var dt = new Date();
document.getElementById("lblTime").innerHTML = 5 - i + " Seconds";
i++;
if (i == 5) {
setTimeout("location.href='/slipperscorp/login'", 0);
}
window.setTimeout("ShowCurrentTime()", 1000); // Here 1000(milliseconds) means 1 sec
}
</script>
