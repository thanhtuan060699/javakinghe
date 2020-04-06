<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Admin Page"/></title>
<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />
		
	<!-- text fonts -->
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css' />" />

	<!-- ace styles -->
	<link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />

	<!-- ace settings handler --> 
	
	<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
</head>
<body class="no-skin">
	<!-- Header-->
	<%@ include file="/common/admin/header.jsp" %>
	<!-- End Header -->
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
		</script>
		<!-- Begin menu -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- End menu -->
		
		<!-- Begin body -->
		<dec:body/>
		<!-- End body -->
		
		
		<!-- Begin footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- End footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/js/land-list.js' />"></script>
	<script src="<c:url value='/template/admin/js/land-save.js' />"></script>
	<script src="<c:url value='/template/admin/js/land-upd.js' />"></script>
	<script src="<c:url value='/template/admin/js/customer-list.js' />"></script>
	<script src="<c:url value='/template/admin/js/customer-insert.js' />"></script>
	<script src="<c:url value='/template/admin/js/c-update.js' />"></script>
	<script src="<c:url value='/template/admin/js/c-appointment.js' />"></script>
</body>
</html>