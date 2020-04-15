<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Home Admin" /></title>

<link href="<c:url value='/template/admin/css/styles.css' />"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">

	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->
	<div id="layoutSidenav">

		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- menu -->
		<div id="layoutSidenav_content">
			<dec:body />
			<!-- footer -->
			<%@ include file="/common/admin/footer.jsp"%>
			<!-- footer -->
		</div>

	</div>



	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="<c:url value='/template/admin/js/scripts.js' />"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/chart-area-demo.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/chart-bar-demo.js' />"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script
		src="<c:url value='/template/admin/assets/demo/datatables-demo.js' />"></script>

</body>
</html>