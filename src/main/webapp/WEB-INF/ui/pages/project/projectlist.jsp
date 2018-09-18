<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h4>Projects</h4>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>Projects List</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
					<div class="x_content">

						<table class="table table-striped projects">
							<thead>
								<tr>
									<th style="width: 1%">Id</th>
									<th style="width: 20%">Project Name</th>
									<th>Project Manager</th>
									<th>Project Progress</th>
									<th>Status</th>
									<th style="width: 20%">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${projects}" var="project">
									<tr>
										<td>${project.id}</td>
										<td>${project.name} <br /> <small>Created
												${project.startDate}</small></td>
										<td>${project.manager.firstName} ${project.manager.lastName}</td>
										<td class="project_progress">
											<div class="progress progress_sm">
												<div class="progress-bar bg-green" role="progressbar"
													data-transitiongoal="57"></div>
											</div> <small>57% Complete</small>
										</td>
										<td>
											<button type="button" class="btn btn-success btn-xs">In Progress</button>
										</td>
										<td><a href="/web/project/${project.id}" class="btn btn-primary btn-xs"><i
												class="fa fa-folder"></i> View </a> <a href="#"
											class="btn btn-info btn-xs"><i class="fa fa-pencil"></i>
												Edit </a> <a href="#" class="btn btn-danger btn-xs"><i
												class="fa fa-trash-o"></i> Delete </a></td>
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