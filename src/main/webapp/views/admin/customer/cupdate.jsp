<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Update khách hàng</title>
	</head>

	<body>
		<div class="main-content">
			<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Insert Customer</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<form action="" role="form" class="form-horizontal" id="formEdit">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Tên khách hàng</label>
										<div class="col-sm-8">
											<input type="text" id="fullName" class="form-control" name="fullName">
										</div>
									</div>
									
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Số điện thoại</label>
											<div class="col-sm-8">
												<input type="text" id="numberPhone" class="form-control" name="numberPhone">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Email</label>
											<div class="col-sm-8">
												<input type="text" id="email" class="form-control" name="email">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnUpdateCustomer">Update khách hàng</button>
											<button type="button" class="btn btn-primary">Hủy</button>
											</div>
									</div>
									
								</form>
							</div><!-- /.col -->
						</div><!-- /.row -->
					
			</div><!-- /.page-content -->
		</div>
		</div>
	</body>

	</html>