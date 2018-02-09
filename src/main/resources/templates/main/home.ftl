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
		
		<script src="../lib/echarts/echarts.min.js"></script>
		<script src="../lib/echarts/china.js"></script>
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<div class="page-content">
					
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
													近一周登陆人数
												</h6>

											</div>

											<!-- 第一个对应内容 -->
											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="home_loginCount" style="height:240px;background-color: #EEE;padding-right:15px">
														
													</div>
												</div>
											</div>
										</div>
										
									</div>
									
									<script type="text/javascript">
										var dom = document.getElementById("home_loginCount");
										var myChart = echarts.init(dom);
										option = null;
										option = {
										    tooltip: {
										        trigger: 'axis'
										    },
										    grid: {
										        left: '3%',
										        right: '4%',
										        bottom: '3%',
										        containLabel: true
										    },
										    toolbox: {
										        feature: {
										        	dataView: {readOnly: false},
										            saveAsImage: {}
										        }
										    },
										    xAxis: {
										        type: 'category',
										        boundaryGap: false,
										        data: ['${loginRecord.date.date1}','${loginRecord.date.date2}','${loginRecord.date.date3}','${loginRecord.date.date4}','${loginRecord.date.date5}','${loginRecord.date.date6}','${loginRecord.date.date7}']
										    },
										    yAxis: {
										        type: 'value'
										    },
										    series: [
										        {
										            name:'登陆人数',
										            type:'line',
										            stack: '总量',
										            data:[${loginRecord.sum.sum1}, ${loginRecord.sum.sum2}, ${loginRecord.sum.sum3}, ${loginRecord.sum.sum4}, ${loginRecord.sum.sum5}, ${loginRecord.sum.sum6}, ${loginRecord.sum.sum7}]
										        }
										    ]
										};
										if (option && typeof option === "object") {
										    myChart.setOption(option, true);
										}
      								</script>
									
									<!-- ==============================================================-->

									<div class="col-xs-12 col-sm-6 widget-container-col">
										<div class="widget-box widget-color-blue2">
											<!-- 第二个 -->
											<div class="widget-header">
												<h6 class="widget-title bigger lighter">
													<i class="ace-icon fa fa-table"></i>
													全国登陆人数分布统计
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
													<div id="home_loginMap" style="height:240px;background-color: #EEE;">
													
													</div>
												</div>
											</div>
										</div>
									</div><!-- /.span -->
								</div><!-- /.row -->
								
								<script type="text/javascript">
										var dom2 = document.getElementById("home_loginMap");
										var myChart2 = echarts.init(dom2);
										option2 = null;
										
										function randomValue() {
										    return Math.round(Math.random()*1000);
										}
										
										option2 = {
										    tooltip: {},

										    visualMap: {
										        min: 0,
										        max: 1500,
										        left: '3%',
										        right: '4%',
										        bottom: '3%',
										        text: ['最高人数','最低人数'],
										        seriesIndex: [1],
										        inRange: {
										            color: ['#e0ffff', '#006edd']
										        },
										        calculable : true
										    },
										    geo: {
										        map: 'china',
										        roam: true,
										        label: {
										            normal: {
										                show: true,
										                textStyle: {
										                    color: 'rgba(0,0,0,0.4)'
										                }
										            }
										        },
										        itemStyle: {
										            normal:{
										                borderColor: 'rgba(0, 0, 0, 0.2)'
										            },
										            emphasis:{
										                areaColor: null,
										                shadowOffsetX: 0,
										                shadowOffsetY: 0,
										                shadowBlur: 20,
										                borderWidth: 0,
										                shadowColor: 'rgba(0, 0, 0, 0.5)'
										            }
										        }
										    },
										    series : [
										       {
										           type: 'scatter',
										           coordinateSystem: 'geo',
										
										           symbolSize: 20,
										           symbol: 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z',
										           symbolRotate: 35,
										           label: {
										               normal: {
										                   formatter: '{b}',
										                   position: 'right',
										                   show: false
										               },
										               emphasis: {
										                   show: true
										               }
										           },
										           itemStyle: {
										               normal: {
										                    color: '#F06C00'
										               }
										           }
										        },
										        {
										            name: '登录人数',
										            type: 'map',
										            geoIndex: 0,
										            // tooltip: {show: false},
										            data:[
										                {name: '北京', value: randomValue()},
										                {name: '天津', value: randomValue()},
										                {name: '上海', value: randomValue()},
										                {name: '重庆', value: randomValue()},
										                {name: '河北', value: randomValue()},
										                {name: '河南', value: randomValue()},
										                {name: '云南', value: randomValue()},
										                {name: '辽宁', value: randomValue()},
										                {name: '黑龙江', value: randomValue()},
										                {name: '湖南', value: randomValue()},
										                {name: '安徽', value: randomValue()},
										                {name: '山东', value: randomValue()},
										                {name: '新疆', value: randomValue()},
										                {name: '江苏', value: randomValue()},
										                {name: '浙江', value: randomValue()},
										                {name: '江西', value: randomValue()},
										                {name: '湖北', value: randomValue()},
										                {name: '广西', value: randomValue()},
										                {name: '甘肃', value: randomValue()},
										                {name: '山西', value: randomValue()},
										                {name: '内蒙古', value: randomValue()},
										                {name: '陕西', value: randomValue()},
										                {name: '吉林', value: randomValue()},
										                {name: '福建', value: randomValue()},
										                {name: '贵州', value: randomValue()},
										                {name: '广东', value: randomValue()},
										                {name: '青海', value: randomValue()},
										                {name: '西藏', value: randomValue()},
										                {name: '四川', value: randomValue()},
										                {name: '宁夏', value: randomValue()},
										                {name: '海南', value: randomValue()},
										                {name: '台湾', value: randomValue()},
										                {name: '香港', value: randomValue()},
										                {name: '澳门', value: randomValue()}
										            ]
										        }
										    ]
										};
										if (option2 && typeof option2 === "object") {
										    myChart2.setOption(option2, true);
										}
      								</script>


								<!-- ==============================================================-->


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
																	<#list recordList as x>  
																		<tr>
																			<td class="">${x.c_username}</td>
	
																			<td>
																				<a href="#">${x.c_loginIp}</a>
																			</td>
	
																			<td class="hidden-480">
																				<span class="label label-warning">${x.c_createDate}</span>
																			</td>
																		</tr>
																  </#list>
																	
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
