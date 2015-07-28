  <%@ include file="/WEB-INF/jsp/includes.jsp" %>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 89%;
      margin: auto;
  }
  </style>
  
<div class="container-fluid">
<div class="row" style="background-color: white; margin-left: 0px;">
<marquee ><h4 style="margin-top: -2px;">
<font color="red">Welcome to the slippers fashion world <span style="margin-left: 800px;">&nbsp;</span>
  Welcome to the slippers fashion world</font></h4></marquee>
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height:420px;margin-top: -7px;">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    <li data-target="#myCarousel" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img style="height:400px;margin-top:10px;" src="<c:url value='/resources/images/slippers1.jpg'/>" alt="slippers1">
    </div>
    <div class="item">
      <img style="height:400px;margin-top:10px;" src="<c:url value='/resources/images/slippers2.jpg'/>" alt="slippers2">
    </div>
    <div class="item">
      <img style="height:400px;margin-top:10px;" src="<c:url value='/resources/images/slippers3.jpg'/>" alt="slippers3">
    </div>
    <div class="item">
      <img style="height:400px;margin-top:10px;" src="<c:url value='/resources/images/slippers4.jpg'/>" alt="slippers4">
    </div>
    <div class="item">
      <img style="height:400px;margin-top:10px;" src="<c:url value='/resources/images/slippers5.jpg'/>" alt="slippers5">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <img style="height:30px;margin-top:200px;" src="<c:url value='/resources/images/leftarrow.png'/>" alt="slippers5">
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next" style="margin-right: 15px;">
   <img style="height:30px;margin-top:200px;margin-right: -20px;" src="<c:url value='/resources/images/rightarrow.png'/>" alt="slippers5">
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<div style="height: 10px;">&nbsp;</div>
</div>
