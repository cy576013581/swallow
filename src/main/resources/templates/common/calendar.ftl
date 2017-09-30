<#macro calendar controller>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Full Calendar - Ace Admin</title>
		<meta name="description" content="with draggable and editable events" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/fullcalendar.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace.min.css" id="main-ace-style" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-rtl.min.css" />
		<link href="../lib/toastr/toastr.css" rel="stylesheet"/>
		
		<script src="../lib/aceadmin/assets/js/ace-extra.min.js"></script>
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default" style="display:none">
		</div>
		
		<div class="main-container" id="main-container">
			
			<div class="main-content">
				<div class="page-content">
					<div class="page-content-area">
						<div class="page-header">
							<h1>
								日历面板
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									   管理我的日程安排
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-sm-9">
										<div class="space"></div>
										<div id="calendar"></div>
									</div>
									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h4>拖动标签添加日程</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="external-events">
														<div class="external-event label-grey" data-class="label-grey">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-success" data-class="label-success">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-danger" data-class="label-danger">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-purple" data-class="label-purple">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-yellow" data-class="label-yellow">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-pink" data-class="label-pink">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<div class="external-event label-info" data-class="label-info">
															<i class="ace-icon fa fa-arrows"></i>
															默认日程
														</div>

														<label>
															<input type="checkbox" class="ace ace-checkbox" id="drop-remove" />
															<span class="lbl">拖动后移除标签</span>
														</label>
													</div>
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

		</div><!-- /.main-container -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../lib/aceadmin/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../lib/aceadmin/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../lib/aceadmin/assets/js/bootstrap.min.js"></script>
		<script src="../lib/aceadmin/assets/js/jquery-ui.custom.min.js"></script>
		<script src="../lib/aceadmin/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="../lib/aceadmin/assets/js/date-time/moment.min.js"></script>
		<script src="../lib/aceadmin/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script src="../lib/aceadmin/assets/js/fullcalendar.min.js"></script>
		<script src="../lib/aceadmin/assets/js/bootbox.min.js"></script>

		<!-- ace scripts -->
		<script src="../lib/aceadmin/assets/js/ace-elements.min.js"></script>
		<script src="../lib/aceadmin/assets/js/ace.min.js"></script>
		<script type="text/javascript" src="../lib/toastr/toastr.js"></script>
		<script src="../lib/aceadmin/assets/js/fullcalendar_zh-cn.js"></script>
		<script type="text/javascript">
			
			// 对Date的扩展，将 Date 转化为指定格式的String  
			// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
			// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
			Date.prototype.Format = function (fmt) { //author: meizz   
			    var o = {  
			        "M+": this.getMonth() + 1, //月份   
			        "d+": this.getDate(), //日   
			        "H+": this.getHours(), //小时   
			        "m+": this.getMinutes(), //分   
			        "s+": this.getSeconds(), //秒   
			        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
			        "S": this.getMilliseconds() //毫秒   
			    };  
			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
			    for (var k in o)  
			    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
			    return fmt;  
			}
			
			
			jQuery(function($) {
				$('#external-events div.external-event').each(function() {
			
					var eventObject = {
						title: $.trim($(this).text()) // use the element's text as the event title
					};
			
					$(this).data('eventObject', eventObject);
			
					$(this).draggable({
						zIndex: 999,
						revert: true,      // will cause the event to go back to its
						revertDuration: 0  //  original position after the drag
					});
					
				});
				
			
				/* initialize the calendar
				-----------------------------------------------------------------*/
			
				var date = new Date();
				var d = date.getDate();
				var m = date.getMonth();
				var y = date.getFullYear();
			
				var calendar = $('#calendar').fullCalendar({
					//isRTL: true,
					 buttonHtml: {
						prev: '<i class="ace-icon fa fa-chevron-left"></i>',
						next: '<i class="ace-icon fa fa-chevron-right"></i>'
					},
				
					header: {
						left: 'prev,next today',
						center: 'title',
						right: 'month,agendaWeek,agendaDay'
					},
					events: function(start,end,timezone, callback) {
						//alert(new Date(start).Format("yyyy-MM-dd")+":"+new Date(end).Format("yyyy-MM-dd"));
						$.ajax({
				            url: "${controller}searchAll?s="+new Date().getTime(),
				            dataType: 'json',
				            data: {
				                start: new Date(start).Format("yyyy-MM-dd"), 
								end: new Date(end).Format("yyyy-MM-dd")
				            },
				            success: function(data) { // 获取当前月的数据
				                var events = [];
				                if (data.total >0) {
				                    $.each(data.rows,function(i,c) {
			                            events.push({
			                            	id: c.id,
			                                title: c.c_title,
			                                start: c.c_start, // will be parsed
			                                end: c.c_end,
			                                color: c.c_color
			                            });
				                    });
				                }
				                callback(events);
				            }
				        });
					}
					,
					editable: true,
					droppable: true, // this allows things to be dropped onto the calendar !!!
					drop: function(date, allDay) {
						var originalEventObject = $(this).data('eventObject');
						var $extraEventClass = $(this).attr('data-class');
						var copiedEventObject = $.extend({}, originalEventObject);
						
						copiedEventObject.start = date;
						copiedEventObject.allDay = allDay;
						if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
						var color = $(this).css("background-color");
						var startStr = new Date(date).Format("yyyy-MM-dd");
						var endStr = new Date(new Date(date).getTime()+1000 * 60 * 60 * 24).Format("yyyy-MM-dd");
						//alert(startStr+":"+endStr);
						$.ajax({ 
							url:"${controller}add?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
							type:"POST",
							data: {c_start:startStr,c_end:endStr,c_color:color},
							dataType:"json", //接收返回的数据方式为json
							error:function(XMLHttpRequest,textStatus,errorThrown){
							}, //错误提示 
							success:function(data){ //data为交互成功后，后台返回的数据
								var flag =data.flag;//服务器返回标记
								if(flag){
									$('#calendar').fullCalendar('refetchEvents');
									toastr.success(data.msg);
								}else {
									toastr.error(data.msg);
								}
							}
						});
						
					},
					//日程拖动事件
					/*
					event 是 Event Object 对象，包含当前日程的信息（时间，标题等）
					dayDelta 是日程移动的天数（可能是负数）
					minuteDelta 是日程移动的分钟数（可能是负数），只有在议程周视图有效，其他视图下是0。
					allDay 在月视图下被移动一天或者周视图下的“all-day”时间槽时是true；当移动到周视图下的其他时间槽时是false。
					revertFunc 是一个函数，如果被调用的话，日程会恢复到拖拽前的时间（就是被还原），当ajax失败的时候比较有用。
					jsEvent 是原生的js对象，包含鼠标点击坐标等信息。
					ui 是 jQuery UI 对象。
					view 是当前的 View Object。
					*/
					eventDrop: function( event, dayDelta, minuteDelta, allDay, revertFunc, jsEvent, ui, view ) {
						//alert(new Date(event.start).Format("yyyy-MM-dd")+":"+new Date(event.end).Format("yyyy-MM-dd"));
						$.ajax({ 
							url:"${controller}update?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
							type:"POST",
							data: {id:event.id,c_color:event.color,c_title:event.title,c_start:new Date(event.start).Format("yyyy-MM-dd"),c_end:new Date(event.end).Format("yyyy-MM-dd")},
							dataType:"json", //接收返回的数据方式为json
							error:function(XMLHttpRequest,textStatus,errorThrown){
							}, //错误提示 
							success:function(data){ //data为交互成功后，后台返回的数据
								var flag =data.flag;//服务器返回标记
								if(flag){
									toastr.success(data.msg);
								}else {
									toastr.error(data.msg);
								}
							}
						});
					},
					eventResize: function( event, dayDelta, minuteDelta, revertFunc, jsEvent, ui, view ){
						$.ajax({ 
							url:"${controller}update?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
							type:"POST",
							data: {id:event.id,c_color:event.color,c_title:event.title,c_start:new Date(event.start).Format("yyyy-MM-dd"),c_end:new Date(event.end).Format("yyyy-MM-dd")},
							dataType:"json", //接收返回的数据方式为json
							error:function(XMLHttpRequest,textStatus,errorThrown){
							}, //错误提示 
							success:function(data){ //data为交互成功后，后台返回的数据
								var flag =data.flag;//服务器返回标记
								if(flag){
									toastr.success(data.msg);
								}else {
									toastr.error(data.msg);
								}
							}
						});
					},
					selectable: true,
					selectHelper: true,
					select: function(start, end, allDay) {
						bootbox.setDefaults("locale","zh_CN");  
						bootbox.prompt("创建新的日程:", function(title) {
							if (title !== null) {
								//alert($(this).css("background-color"));
								var endStr = new Date(end).Format("yyyy-MM-dd");
								var startStr = new Date(start).Format("yyyy-MM-dd");
								$.ajax({ 
									url:"${controller}add?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
									type:"POST",
									data: {c_title:title,c_start:startStr,c_end:endStr},
									dataType:"json", //接收返回的数据方式为json
									error:function(XMLHttpRequest,textStatus,errorThrown){
									}, //错误提示 
									success:function(data){ //data为交互成功后，后台返回的数据
										var flag =data.flag;//服务器返回标记
										if(flag){
											$('#calendar').fullCalendar('refetchEvents');
											toastr.success("添加成功！");
										}else {
											toastr.error("添加失败！");
										}
									}
								});
							}
						});
						calendar.fullCalendar('unselect');
						
					}
					,
					eventClick: function(calEvent, jsEvent, view) {
			
						var modal = 
						'<div class="modal fade">\
						  <div class="modal-dialog">\
						   <div class="modal-content">\
							 <div class="modal-body">\
							   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
							   <form class="no-margin">\
								  <label>修改日程内容 &nbsp;</label>\
								  <input class="middle" autocomplete="off" type="text" value="' + calEvent.title + '" />\
								 <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> 保存</button>\
							   </form>\
							 </div>\
							 <div class="modal-footer">\
								<button type="button" class="btn btn-sm btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> 删除日程</button>\
								<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> 退出</button>\
							 </div>\
						  </div>\
						 </div>\
						</div>';
						
						
					
						var modal = $(modal).appendTo('body');
						modal.find('form').on('submit', function(ev){//修改
							ev.preventDefault();
							
							calEvent.title = $(this).find("input[type=text]").val();
							$.ajax({ 
								url:"${controller}update?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
								type:"POST",
								data: {id:parseInt(calEvent._id),c_title:calEvent.title},
								dataType:"json", //接收返回的数据方式为json
								error:function(XMLHttpRequest,textStatus,errorThrown){
								}, //错误提示 
								success:function(data){ //data为交互成功后，后台返回的数据
									var flag =data.flag;//服务器返回标记
									if(flag){
										calendar.fullCalendar('updateEvent', calEvent);
										toastr.success("修改成功！");
									}else {
										toastr.error("修改失败！");
									}
								}
							});
							modal.modal("hide");
						});
						modal.find('button[data-action=delete]').on('click', function() {//删除
							$.ajax({ 
									url:"${controller}delete?s="+new Date().getTime(), //后面加时间戳，防止IE辨认相同的url，只从缓存拿数据
									type:"POST",
									data: {id:calEvent._id},
									dataType:"json", //接收返回的数据方式为json
									error:function(XMLHttpRequest,textStatus,errorThrown){
									}, //错误提示 
									success:function(data){ //data为交互成功后，后台返回的数据
										var flag =data.flag;//服务器返回标记
										if(flag){
											calendar.fullCalendar('removeEvents' , function(ev){
												return (ev._id == calEvent._id);
											})
											toastr.success("删除成功！");
										}else {
											toastr.error("删除失败！");
										}
									}
								});
							modal.modal("hide");
						});
						
						modal.modal('show').on('hidden', function(){//取消
							modal.remove();
						});
			
					}
					
				});
			
			
			});
			
		
		</script>

		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace.onpage-help.css" />
		<link rel="stylesheet" href="../lib/aceadmin/docs/assets/js/themes/sunburst.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="../lib/aceadmin/assets/js/ace/elements.onpage-help.js"></script>
		<script src="../lib/aceadmin/assets/js/ace/ace.onpage-help.js"></script>
		<script src="../lib/aceadmin/docs/assets/js/rainbow.js"></script>
		<script src="../lib/aceadmin/docs/assets/js/language/generic.js"></script>
		<script src="../lib/aceadmin/docs/assets/js/language/html.js"></script>
		<script src="../lib/aceadmin/docs/assets/js/language/css.js"></script>
		<script src="../lib/aceadmin/docs/assets/js/language/javascript.js"></script>
	</body>
</html>
</#macro>