<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h4>Post</h4>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<small>Add new Post</small>
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<br />
						<form id="demo-form2" data-parsley-validate
							class="form-horizontal form-label-left"
							onsubmit="return addPost()" action="/api/post">

							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12"
									for="first-name">Post Name <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input type="text" id="postName" required="required"
										class="form-control col-md-7 col-xs-12">
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
									<button class="btn btn-primary" type="reset">Reset</button>
									<button type="submit" class="btn btn-success">Submit</button>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							All Posts
						</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"><i
									class="fa fa-wrench"></i></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Settings 1</a></li>
									<li><a href="#">Settings 2</a></li>
								</ul></li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>

					<div class="x_content">
						<div class="table-responsive">
							<table class="table table-striped jambo_table bulk_action">
								<thead>
									<tr class="headings">
										<th><input type="checkbox" id="check-all" class="flat">
										</th>
										<th class="column-title">Id</th>
										<th class="column-title">Name</th>
										<th class="column-title">Edit</th>
										<th class="column-title">Delete</th>
									</tr>
								</thead>

								<tbody id="postBody">
									<c:forEach items="${posts}" var="post">
										<tr class="even pointer">
											<td class="a-center "><input type="checkbox"
												class="flat" name="table_records"></td>
											<td>${post.id}</td>
											<td>${post.title}</td>
											<td class=" last"><a href="#"><i class="fa fa-edit"></i></a></td>
											<td class=" last"><a href="#"><i
													class="fa fa-remove"></i></a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
	function addPost() {

		var postName = $("#postName").val();
		var post = {
			"title" : postName
		}

		$
				.ajax({
					type : "POST",
					url : "/api/post",
					data : JSON.stringify(post),
					contentType : "application/json",
					dataType : 'json',
					success : function(response, textStatus, xhr) {
						try {
							if (xhr.status == 201) {
								var template = '<tr class="even pointer">';
								template += '<td class="a-center "><input type="checkbox" class="flat" name="table_records"></td>';
								template += '<td>' + response.id + '</td>';
								template += '<td>' + response.title + '</td>';
								template += '<td class=" last"><a href="#"><i class="fa fa-edit"></i></a></td>';
								template += '<td class=" last"><a href="#"><i class="fa fa-remove"></i></a></td>';
								template += '</tr>';
								$('#postBody').append(template)
							} else if (xhr.status == 201) {
								console.log(response);
							}
						} catch (e) {
							console.log(e);
						}

					},
					error : function(e) {
						console.log(e);
					}
				});

		return false;
	}
</script>