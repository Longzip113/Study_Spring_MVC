<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- Bootstrap core CSS -->
  <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css' />" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<c:url value='/template/web/css/small-business.css' />" rel="stylesheet">
</head>
<body>
<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
    <div class="container">
    	<dec:body/>
    </div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->

<!-- Bootstrap core JavaScript -->
  <script src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
  <script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>
</html>