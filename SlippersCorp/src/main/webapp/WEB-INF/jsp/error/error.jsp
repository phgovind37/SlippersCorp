<%@include file="/WEB-INF/jsp/includes.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-site-verification" content="kbVsezdtVI49XMi-wW4Bio834qWhswU620pb5dyB3RM" />
<title>Something went wrong...</title>

<c:if test="${not empty param.code}">
	<c:choose>
		<c:when test="${param.code == '404'}"><c:redirect url="/pageNotFound" /></c:when>
		<c:when test="${param.code == '403'}"><c:redirect url="/accessDenied" /></c:when>
	</c:choose>
</c:if>
<style type="text/css">
body{
background-image: url('<ic:resource value="/resources/images/gutter.jpg"/>');

background-repeat: inherit;
height:100%;
}

</style>
</head>
<body>

<div class="container" id="background">
<p align="center" style="margin-top: 50px;">
Ah' looks its not working out with this page.<br>
Sorry about that but we can take you back to home page. <a href='<c:url value="/"/>'>Click here to reach </a>
<br />Please use <a href="javascript:FreshWidget.show();">Help and Support</a> button to let us know what you
tried to access so we can fix that problem.,</p>
</div>


<%-- <jsp:scriptlet> --%>
<% 
  Object throwableObj = request.getAttribute("javax.servlet.error.exception");
  if(throwableObj instanceof Throwable) {
	Throwable exception = (Throwable) throwableObj;%><%="<pre>"%><%
  	exception.printStackTrace(new java.io.PrintWriter(out));%><%="</pre>"%><%
  }
  %>
<%-- </jsp:scriptlet> --%>

 <script type="text/javascript" src="https://s3.amazonaws.com/assets.freshdesk.com/widget/freshwidget.js"></script>
<style type="text/css" media="screen, projection">
	@import url(https://s3.amazonaws.com/assets.freshdesk.com/widget/freshwidget.css); 
</style> 
<script type="text/javascript">
	if( FreshWidget ) {
		FreshWidget.init("", {
			"queryString": "", 
			"buttonText": "Help & Support", 
			"buttonColor": "white", 
			"buttonBg": "#0088CC", 
			"alignment": "2", 
			"offset": "220px", 
			"url": "https://insticonnect.freshdesk.com", 
			"assetUrl": "https://s3.amazonaws.com/assets.freshdesk.com/widget"
		});
	}
</script>
<script>
if(window.location.protocol === "https") {

  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-43665274-1', 'insticonnect.com');
  ga('send', 'pageview');

}
</script>
</body>
</html>