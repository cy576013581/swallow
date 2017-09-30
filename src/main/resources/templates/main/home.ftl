<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Widgets - Ace Admin</title>

		<meta name="description" content="Draggabble Widget Boxes &amp; Containers" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/jquery-ui.custom.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace.min.css" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-skins.min.css" />


		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="../lib/aceadmin/assets/js/ace-extra.min.js"></script>
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="page-content">
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-150"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-40">
								<!-- #section:settings.skins -->
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<!-- /section:settings.skins -->

								<!-- #section:settings.navbar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
									<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<!-- /section:settings.navbar -->

								<!-- #section:settings.sidebar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
									<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<!-- /section:settings.sidebar -->

								<!-- #section:settings.breadcrumbs -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
									<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
								</div>

								<!-- /section:settings.breadcrumbs -->

								<!-- #section:settings.rtl -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
									<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
								</div>

								<!-- /section:settings.rtl -->

								<!-- #section:settings.container -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
									<label class="lbl" for="ace-settings-add-container">
										Inside
										<b>.container</b>
									</label>
								</div>

								<!-- /section:settings.container -->
							</div><!-- /.pull-left -->

							<div class="pull-left width-50">
								<!-- #section:basics/sidebar.options -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
									<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
									<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
									<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
								</div>

								<!-- /section:basics/sidebar.options -->
							</div><!-- /.pull-left -->
						</div><!-- /.ace-settings-box -->
					</div><!-- /.ace-settings-container -->

					<div class="page-content-area">
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12 col-sm-6 widget-container-col">
										<div class="widget-box widget-color-blue">
											<!-- 第一个 -->
											<div class="widget-header">
												<h6 class="widget-title bigger lighter">
													<i class="ace-icon fa fa-table"></i>
													统计表格
												</h6>

												<div class="widget-toolbar">
													<div class="widget-menu">
														<a href="#" data-action="settings">
															<i class="ace-icon fa fa-bars"></i>
														</a>
														
														<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh"></i>
														</a>
													</div>
												</div>
												<!--<div class="widget-toolbar widget-toolbar-light no-border">
													<select id="simple-colorpicker-1" class="hide">
														<option selected="" data-class="blue" value="#307ECC">#307ECC</option>
														<option data-class="blue2" value="#5090C1">#5090C1</option>
														<option data-class="blue3" value="#6379AA">#6379AA</option>
														<option data-class="green" value="#82AF6F">#82AF6F</option>
														<option data-class="green2" value="#2E8965">#2E8965</option>
														<option data-class="green3" value="#5FBC47">#5FBC47</option>
														<option data-class="red" value="#E2755F">#E2755F</option>
														<option data-class="red2" value="#E04141">#E04141</option>
														<option data-class="red3" value="#D15B47">#D15B47</option>
														<option data-class="orange" value="#FFC657">#FFC657</option>
														<option data-class="purple" value="#7E6EB0">#7E6EB0</option>
														<option data-class="pink" value="#CE6F9E">#CE6F9E</option>
														<option data-class="dark" value="#404040">#404040</option>
														<option data-class="grey" value="#848484">#848484</option>
														<option data-class="default" value="#EEE">#EEE</option>
													</select>
												</div>-->
											</div>

											<!-- 第一个对应内容 -->
											<div class="widget-body">
												<div class="widget-main no-padding">
													<div style="height:240px;background-color: #EEE;">
													
													</div>
												</div>
											</div>
										</div>
										
									</div>

									<div class="col-xs-12 col-sm-6 widget-container-col">
										<div class="widget-box widget-color-blue2">
											<!-- 第二个 -->
											<div class="widget-header">
												<h6 class="widget-title bigger lighter">
													<i class="ace-icon fa fa-table"></i>
													Tables & Colors
												</h6>

												<div class="widget-toolbar">
													<div class="widget-menu">
														<a href="#" data-action="settings">
															<i class="ace-icon fa fa-bars"></i>
														</a>
														
														<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh"></i>
														</a>
													</div>
												</div>
											</div>

											<!-- 第二个对应内容 -->
											<div class="widget-body">
												<div class="widget-main no-padding">
													<div style="height:240px;background-color: #EEE;">
													
													</div>
												</div>
											</div>
										</div>
									</div><!-- /.span -->
								</div><!-- /.row -->


								<div class="row">
									<div class="col-sm-6 widget-container-col">
										<div class="widget-box widget-color-blue3">
											<!-- 第3个 -->
											<div class="widget-header">
												<h6 class="widget-title bigger lighter">
													<i class="ace-icon fa fa-table"></i>
													最近用户登录
												</h6>

												<div class="widget-toolbar">
													<div class="widget-menu">
														<a href="#" data-action="settings">
															<i class="ace-icon fa fa-bars"></i>
														</a>
														
														<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh"></i>
														</a>
													</div>
												</div>
											</div>

											<!-- 第3个对应内容 -->
											<div class="widget-body">
												<div class="widget-main no-padding">
													<div class="scrollable" data-height="125">
														<div class="content">
															<table class="table table-striped table-bordered table-hover">
																<thead class="thin-border-bottom">
																	<tr>
																		<th>
																			<i class="ace-icon fa fa-user"></i>
																			用户名
																		</th>

																		<th>
																			IP地址
																		</th>
																		<th>
																			登录时间
																		</th>
																</tr>
																</thead>

																<tbody>
																	<tr>
																		<td class="">Alex</td>

																		<td>
																			<a href="#">alex@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-warning">Pending</span>
																		</td>
																	</tr>

																	<tr>
																		<td class="">Fred</td>

																		<td>
																			<a href="#">fred@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-success arrowed-in arrowed-in-right">Approved</span>
																		</td>
																	</tr>

																	<tr>
																		<td class="">Jack</td>

																		<td>
																			<a href="#">jack@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-warning">Pending</span>
																		</td>
																	</tr>

																	<tr>
																		<td class="">John</td>

																		<td>
																			<a href="#">john@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-inverse arrowed">Blocked</span>
																		</td>
																	</tr>

																	<tr>
																		<td class="">James</td>

																		<td>
																			<a href="#">james@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-info arrowed-in arrowed-in-right">Online</span>
																		</td>
																	</tr>
																	
																	<tr>
																		<td class="">James</td>

																		<td>
																			<a href="#">james@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-info arrowed-in arrowed-in-right">Online</span>
																		</td>
																	</tr>
																	<tr>
																		<td class="">James</td>

																		<td>
																			<a href="#">james@email.com</a>
																		</td>

																		<td class="hidden-480">
																			<span class="label label-info arrowed-in arrowed-in-right">Online</span>
																		</td>
																	</tr>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>

									<!--第四个-->
									<div class="col-sm-6 widget-container-col">
										<div class="widget-box widget-color-purple">
											<div class="widget-header widget-hea1der-small">
												<h6 class="widget-title"><i class="ace-icon fa fa-table"></i>最新消息</h6>

												<div class="widget-toolbar">
													<a href="#" data-action="settings">
														<i class="ace-icon fa fa-bars"></i>
													</a>
													
													<a href="#" data-action="reload">
														<i class="ace-icon fa fa-refresh"></i>
													</a>
												</div>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<!-- #section:custom/scrollbar -->
													<div class="scrollable" data-height="125">
														<div class="content">
															<div class="alert alert-info">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert alert-danger">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert alert-success">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															
															<div class="alert alert-info">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert alert-danger">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert alert-success">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
															<div class="alert">
																Lorem ipsum dolor sit amet, consectetur adipiscing.
															</div>
														</div>
													</div>

													<!-- /section:custom/scrollbar -->
												</div>
											</div>
										</div>
									</div>
								</div>

								
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->

			

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../lib/aceadmin/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../lib/aceadmin/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../lib/aceadmin/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="../lib/aceadmin/assets/js/jquery-ui.custom.min.js"></script>
		<script src="../lib/aceadmin/assets/js/jquery.ui.touch-punch.min.js"></script>

		<!-- ace scripts -->
		<script src="../lib/aceadmin/assets/js/ace-elements.min.js"></script>
		<script src="../lib/aceadmin/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
			
				$('#simple-colorpicker-1').ace_colorpicker({pull_right:true}).on('change', function(){
					var color_class = $(this).find('option:selected').data('class');
					var new_class = 'widget-box';
					if(color_class != 'default')  new_class += ' widget-color-'+color_class;
					$(this).closest('.widget-box').attr('class', new_class);
				});

			
			
				// scrollables
				$('.scrollable').each(function () {
					var $this = $(this);
					$(this).ace_scroll({
						size: $this.data('size') || 240,
						//styleClass: 'scroll-left scroll-margin scroll-thin scroll-dark scroll-light no-track scroll-visible'
					});
				});
				/*$('.scrollable-horizontal').each(function () {
					var $this = $(this);
					$(this).ace_scroll(
					  {
						horizontal: true,
						styleClass: 'scroll-top',//show the scrollbars on top(default is bottom)
						size: $this.data('size') || 500,
						mouseWheelLock: true
					  }
					).css({'padding-top': 12});
				});
				
				$(window).on('resize.scroll_reset', function() {
					$('.scrollable-horizontal').ace_scroll('reset');
				});*/
			
				// widget boxes
				// widget box drag & drop example
			    $('.widget-container-col').sortable({
			        connectWith: '.widget-container-col',
					items:'> .widget-box',
					handle: ace.vars['touch'] ? '.widget-header' : false,
					cancel: '.fullscreen',
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'widget-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					start: function(event, ui) {
						//when an element is moved, it's parent becomes empty with almost zero height.
						//we set a min-height for it to be large enough so that later we can easily drop elements back onto it
						ui.item.parent().css({'min-height':ui.item.height()})
						//ui.sender.css({'min-height':ui.item.height() , 'background-color' : '#F5F5F5'})
					},
					update: function(event, ui) {
						ui.item.parent({'min-height':''})
						//p.style.removeProperty('background-color');
					}
			    });
			
			});
		</script>

	</body>
</html>
