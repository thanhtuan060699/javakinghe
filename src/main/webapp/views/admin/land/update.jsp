<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Thêm tòa nhà</title>
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
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<form action="" role="form" class="form-horizontal" id="formEdit">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Địa chỉ</label>
										<div class="col-sm-8">
											<input type="text" id="address" class="form-control" name="address">
										</div>
									</div>
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Chiều dài</label>
											<div class="col-sm-8">
												<input type="number" id="length" class="form-control" name="length">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Chiều rộng</label>
											<div class="col-sm-8">
												<input type="number" id="width" class="form-control" name="width">
											</div>
									</div>
									<div class="form-group">
											<label for="structure" class="col-sm-3 control-label no-padding-right">Hướng</label>
											<div class="col-sm-8">
												<input type="text" id="direction" class="form-control" name="direction">
											</div>
									</div>
									<div class="form-group">
											<label for="numberOfBasement" class="col-sm-3 control-label no-padding-right">Giá cả</label>
											<div class="col-sm-8">
												<input type="text" id="cost" class="form-control" name="cost">
											</div>
									</div>
									<div class="form-group">
											<label for="numberOfBasement" class="col-sm-3 control-label no-padding-right">Ảnh</label>
											<div class="col-sm-8">
												<input type="file" id="image" class="form-control" name="image">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnUpdateBuilding">Update đất</button>
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