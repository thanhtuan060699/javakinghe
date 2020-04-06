<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="customerURL" value="/admin-customer"/>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách khách hàng</title>
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
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12 col-sm-12">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Tìm Kiếm</h4>

													<div class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<div class="form-horizontal">
															<form action="${customerURL}" method="get" id="formSearchCustomer">
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="fullName">Tên khách hàng</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="numberPhone">Số điện thoại</label>
																	<input type="text" id="phoneNumber" class="form-control" name="phoneNumber">
																</div>
																<div class="col-sm-4">
																	<label for="numberOfBasement">Địa chỉ</label>
																	<input type="text" id="address" class="form-control" name="address">
																</div>
															</div>
															
															<div class="form-group">
																	<div class="col-sm-8">
																	<c:forEach var="item" items="${buildingTypes}" >
																		<label class="checkbox-inline">
																		<input type="checkbox" value="${item.key }" id="buildingTypes" name="buildingTypes"
																				${fn:contains(fn:join(model.buildingTypes,','),item.key)?'checked' :'' }>${item.value }
																		</label>
																	</c:forEach>									
																	</div>
															</div>
															<div class="form-group">
																	<div class="col-sm-8">
																			<button type="button" class="btn btn-primary" id="btnSearchCustomer">Tìm kiếm</button>
																	</div>		
															</div>
															<input type="hidden" value="LIST" name="action" />
														</form>
														</div>
													</div>
												</div>
											</div>
										</div>
								</div>
	
								</div><!-- /.row -->
								<div class="col-xs-12"> <!--  nut -->
									<div class="pull-right">
										<a  href='<c:url value='/admin-customer?signal=EDIT'/>' class="btn btn-white btn-info btn-bold" data-toggle="tolltip" title="Thêm khách hàng">
											<i class="fa fa-plus-circle" aria-hidden="true"></i>
										</a>
										<button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Xóa tòa nhà" id="btnDeleteCustomer">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
									</div>
								</div>
					
								<div class="col-xs-12">
										<table id="customerList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th >
												   </th>
													<th>Tên khách hàng</th>
													<th>Địa chỉ</th>
													<th>Số điện thoại</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${customers}">
											<tr>
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													<td>${item.name}</td>
													<td>${item.address}</td>
													<td>${item.phoneNumber}</td>
													
													
													<td>
														<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Giao nhà cho nhân viên" onclick="assignmentCustomer(${item.id})" >
															<i class="fa fa-reply-all" aria-hidden="true"></i>
														</button>
														<a  href='<c:url value='/admin-customer?signal=UPDATE&id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Giao khách hàng cho nhân viên" onclick="updateCustomer(${item.id})" >
															<i class="fa fa-refresh" aria-hidden="true"></i>
															</button>
														</a>
														<a  href='<c:url value='/admin-customer?signal=APPOINTMENT&id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Lịch trình với khách hàng"  >
															<i class="fa fa-calendar" aria-hidden="true"></i>
															</button>
														</a>
													</td>
												</tr>
											</c:forEach>			
											</tbody>
										</table>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
		</div>
		<div id="assignmentCustomerModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
						<table class="table" id="staffCList">
								<thead>
								  <tr>
									<th>Chọn nhân viên</th>
									<th>Tên nhân viên</th>
								  </tr>
								</thead>
								<tbody>
								  
								</tbody>
					    </table>
							  <input type="hidden" id="userId" name="userId" value="">
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal" id="btnAssignCustomer">Giao khách hàng</button>
				  <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			  </div>
			</div>
		</div>
	</body>

	</html>