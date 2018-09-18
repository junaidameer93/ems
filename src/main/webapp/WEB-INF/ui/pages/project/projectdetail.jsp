<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>Project Detail</h3>
			</div>

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Go!</button>
						</span>
					</div>
				</div>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>New Partner Contracts Consultancy</h2>
						<ul class="nav navbar-right panel_toolbox">
							<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
							</li>
							<li><a class="close-link"><i class="fa fa-close"></i></a></li>
						</ul>
						<div class="clearfix"></div>
					</div>

					<div class="x_content">

						<div class="col-md-9 col-sm-9 col-xs-12">

							<ul class="stats-overview">
								<li><span class="name"> Estimated budget </span> <span
									class="value text-success"> $ ${project.proposalCost } </span></li>
								<li><span class="name"> Total amount spent </span> <span
									class="value text-success"> 2000 </span></li>
								<li class="hidden-phone"><span class="name">
										Estimated project duration </span> <span class="value text-success">
										20 </span></li>
							</ul>
							<br />

							<div id="mainb" style="height: 350px;"></div>

							<div>

								<h4>Teams working on project</h4>
								<div class="table-responsive">
									<table class="table table-striped jambo_table bulk_action">
										<thead>
											<tr class="headings">
												<th class="column-title">Id</th>
												<th class="column-title">Name</th>
												<th class="column-title">Created</th>
												<th class="column-title">Action</th>
											</tr>
										</thead>

										<tbody id="postBody">
											<c:forEach items="${project.teams}" var="teams">
												<tr class="even pointer">
													<td>${teams.id}</td>
													<td>${teams.teamName}</td>
													<td>${teams.createdAt}</td>
													<td class=" last"><a href="#" class="btn btn-primary btn-xs"><i
												class="fa fa-folder"></i> View </a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>



							</div>


						</div>

						<!-- start project-detail sidebar -->
						<div class="col-md-3 col-sm-3 col-xs-12">

							<section class="panel">

								<div class="x_title">
									<h2>Project Description</h2>
									<div class="clearfix"></div>
								</div>
								<div class="panel-body">
									<h3 class="green">
										<i class="fa fa-paint-brush"></i> Gentelella
									</h3>

									<p>${project.description }</p>
									<br />

									<div class="project_detail">

										<p class="title">Client Company</p>
										<p>Deveint Inc</p>
										<p class="title">Project Manager</p>
										<p>${project.manager.firstName}
											${project.manager.lastName}</p>
									</div>

									<br />
									<h5>Project files</h5>
									<ul class="list-unstyled project_files">
										<li><a href=""><i class="fa fa-file-word-o"></i>
												Functional-requirements.docx</a></li>
										<li><a href=""><i class="fa fa-file-pdf-o"></i>
												UAT.pdf</a></li>
										<li><a href=""><i class="fa fa-mail-forward"></i>
												Email-from-flatbal.mln</a></li>
										<li><a href=""><i class="fa fa-picture-o"></i>
												Logo.png</a></li>
										<li><a href=""><i class="fa fa-file-word-o"></i>
												Contract-10_12_2014.docx</a></li>
									</ul>
									<br />

									<div class="text-center mtop20">
										<a href="#" class="btn btn-sm btn-primary">Add files</a> <a
											href="#" class="btn btn-sm btn-warning">Report contact</a>
									</div>
								</div>

							</section>

						</div>
						<!-- end project-detail sidebar -->

					</div>
				</div>
			</div>
		</div>
	</div>
</div>