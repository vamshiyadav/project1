<%@include file="header.jsp" %>
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item">
        <img src=<c:url value="/resources/images/2.jpg"/> alt="shoe" width="460" height="345">
      </div>
       
      <div class="item active">
        <img src=<c:url value="/resources/images/bgmen.jpg"/> alt="shoe" width="460" height="345">
      </div>

      <div class="item">
        <img src=<c:url value="/resources/images/img.jpg"/> alt="shoe" width="460" height="345">
      </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div align="center">
<img src=<c:url value="/resources/images/m3.jpg"/> alt="shoe" width="200" height="245">
<img src=<c:url value="/resources/images/wmc2.jpg"/> alt="shoe" width="200" height="245">
</div>
 
<br></br>
<br></br>
<%@include file="footer.jsp"%>

    