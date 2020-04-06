<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="buildingURL" value="/admin-building"/>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách tòa nhà</title>
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
															<form action="${buildingURL}" method="get" id="formSearchBuilding">
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="name">Địa chỉ</label>
																	<input type="text" id="address" class="form-control" name="address">
																</div>
																<div class="col-sm-4">
																	<label for="buildingArea">Hướng</label>
																	<input type="text" id="direction" class="form-control" name="direction">
																</div>
																<div class="col-sm-4">
																	<label for="numberOfBasement">Chiều dài</label>
																	<input type="number" id="length" class="form-control" name="length">
																</div>
															</div>
															<div class="form-group">
																	
																	<div class="col-sm-4 ">
																		<label for="ward">Chiều rộng</label>
																		<input type="number" id="width" class="form-control" name="width">
																	</div>
																	<div class="col-sm-4">
																			<label for="street">Giá</label>
																			<input type="text" id="cost" class="form-control" name="cost">
																	</div>
															</div>
														
															<div class="form-group">
																	<div class="col-sm-8">
																			<button type="button" class="btn btn-primary" id="btnSearchBuilding">Tìm kiếm</button>
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
										<a  href='<c:url value='/admin-land?action=EDIT'/>' class="btn btn-white btn-info btn-bold" data-toggle="tolltip" title="Thêm tòa nhà">
											<i class="fa fa-plus-circle" aria-hidden="true"></i>
										</a>
										<button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Xóa tòa nhà" id="btnDeleteBuilding">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
										
									</div>
								</div>
					
								<div class="col-xs-12">
										<table id="buildingList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th >
												   </th>
													<th>Địa chỉ</th>
													<th>Hướng</th>
													<th>Ảnh</th>
													<th>Chiều dài</th>
													<th>Chiều rộng</th>
													<th>Thao tác</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${lands}">
											<tr>
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													<td>${item.address}</td>
													<td>${item.direction}</td>
													<td><img src="files/${item.image}"  width="42" height="42"></td>
													<td>${item.length}</td>
													<td>${item.width}</td>
													
													<td>
														<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Giao nhà cho nhân viên" onclick="assignmentBuilding(${item.id})" >
															<i class="fa fa-reply-all" aria-hidden="true"></i>
														</button>
														<a  href='<c:url value='/admin-land?action=UPDATE&id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Update tòa nhà" onclick="updateBuilding(${item.id})" >
															<i class="fa fa-refresh" aria-hidden="true"></i>
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
		<div id="assignmentBuildingModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
						<table class="table" id="staffList">
								<thead>
								  <tr>
									<th>Chọn nhân viên</th>
									<th>Tên nhân viên</th>
								  </tr>
								</thead>
								<tbody>
								 
								</tbody>
					    </table>
							  <input type="hidden" id="buildingId" name="buildingId" value="">
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal" id="btnAssignBuilding">Giao tòa nhà</button>
				  <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			  </div>
			</div>
		</div>
	</body>

	</html>