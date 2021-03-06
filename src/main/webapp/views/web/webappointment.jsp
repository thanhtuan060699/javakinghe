<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ENs" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

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
										<label for="name" class="col-sm-3 control-label no-padding-right">Họ tên</label>
										<div class="col-sm-8">
											<input type="text" id="name" class="form-control" name="name">
										</div>
									</div>
									
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Số điện thoại</label>
											<div class="col-sm-8">
												<input type="text" id="phoneNumber" class="form-control" name="phoneNumber">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Địa chỉ</label>
											<div class="col-sm-8">
												<input type="text" id="address" class="form-control" name="address">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnAddCustomer">Đặt lịch xem đất</button>
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