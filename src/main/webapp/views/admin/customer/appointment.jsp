<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lịch trình khách hàng</title>
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
							<li class="active">Lịch trình khách hàng</li>
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<form action="" role="form" class="form-horizontal" id="formEdit">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Ngày tạo</label>
										<div class="col-sm-8">
											<input type="date" id="dateAppointment" class="form-control" name="dateAppointment">
										</div>
									</div>
									
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Ghi chú</label>
											<div class="col-sm-8">
												<input type="text" id="note" class="form-control" name="note">
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnAddAppointment">Thêm cuộc hẹn</button>
											
											</div>
									</div>
									
								</form>
							</div><!-- /.col -->
							<div class="col-xs-12">
										<table id="customerList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													
													<th>Ngày tạo</th>
													<th>Ghi chú</th>
											
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${appointments}">
											<tr>
													<td>${item.dateAppointment}</td>
													<td>${item.note}</td>
													
											</tr>
											</c:forEach>			
											</tbody>
										</table>
								</div>
							
						</div><!-- /.row -->
					
			</div><!-- /.page-content -->
		</div>
		</div>
	</body>

	</html>