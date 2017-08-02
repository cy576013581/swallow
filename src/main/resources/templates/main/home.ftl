<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>Full Calendar - Ace Admin</title>

		<meta name="description" content="with draggable and editable events" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/fullcalendar.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace.min.css" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-rtl.min.css" />

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="../lib/aceadmin/assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="../lib/aceadmin/assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="../lib/aceadmin/assets/js/html5shiv.min.js"></script>
		<script src="../lib/aceadmin/assets/js/respond.min.js"></script>
		<![endif]-->
	</head>

	<body class="no-skin">
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			
			<div class="main-content">
				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					
					<!-- /section:settings.box -->
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
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-sm-9">
										<div class="space"></div>

										<!-- #section:plugins/data-time.calendar -->
										<div id="calendar"></div>

										<!-- /section:plugins/data-time.calendar -->
									</div>

									<div class="col-sm-3">
										<div class="widget-box transparent">
											<div class="widget-header">
												<h4>拖动标签添加事件</h4>
											</div>

											<div class="widget-body">
												<div class="widget-main no-padding">
													<div id="external-events">
														<div class="external-event label-grey" data-class="label-grey">
															<i class="ace-icon fa fa-arrows"></i>
															事件1
														</div>

														<div class="external-event label-success" data-class="label-success">
															<i class="ace-icon fa fa-arrows"></i>
															事件2
														</div>

														<div class="external-event label-danger" data-class="label-danger">
															<i class="ace-icon fa fa-arrows"></i>
															事件3
														</div>

														<div class="external-event label-purple" data-class="label-purple">
															<i class="ace-icon fa fa-arrows"></i>
															事件4
														</div>

														<div class="external-event label-yellow" data-class="label-yellow">
															<i class="ace-icon fa fa-arrows"></i>
															事件5
														</div>

														<div class="external-event label-pink" data-class="label-pink">
															<i class="ace-icon fa fa-arrows"></i>
															事件6
														</div>

														<div class="external-event label-info" data-class="label-info">
															<i class="ace-icon fa fa-arrows"></i>
															事件7
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

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->

		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='../lib/aceadmin/assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='../lib/aceadmin/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='../lib/aceadmin/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="../lib/aceadmin/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="../lib/aceadmin/assets/js/jquery-ui.custom.min.js"></script>
		<script src="../lib/aceadmin/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="../lib/aceadmin/assets/js/date-time/moment.min.js"></script>
		<script src="../lib/aceadmin/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js"></script>
		<script src="../lib/aceadmin/assets/js/fullcalendar.min.js"></script>
		<script src="../lib/aceadmin/assets/js/bootbox.min.js"></script>

		<!-- ace scripts -->
		<script src="../lib/aceadmin/assets/js/ace-elements.min.js"></script>
		<script src="../lib/aceadmin/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {

/* initialize the external events
	-----------------------------------------------------------------*/

	$('#external-events div.external-event').each(function() {

		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
		// it doesn't need to have a start or end
		var eventObject = {
			title: $.trim($(this).text()) // use the element's text as the event title
		};

		// store the Event Object in the DOM element so we can get to it later
		$(this).data('eventObject', eventObject);

		// make the event draggable using jQuery UI
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

	//alert(new Date(y, m, d-3, 16, 0));
	
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
		events: [
		  {
			title: 'All Day Event',
			start: new Date(y, m, 1),
			className: 'label-important'
		  },
		  {
			title: 'Long Event',
			start: new Date(y, m, d-5),
			end: new Date(y, m, d-2),
			className: 'label-success'
		  },
		  {
			title: 'Some Event',
			start: new Date(y, m, d-3, 16, 0),
			allDay: false
		  }
		]
		,
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar !!!
		drop: function(date, allDay) { // this function is called when something is dropped
		
			// retrieve the dropped element's stored Event Object
			var originalEventObject = $(this).data('eventObject');
			var $extraEventClass = $(this).attr('data-class');
			
			
			// we need to copy it, so that multiple events don't have a reference to the same object
			var copiedEventObject = $.extend({}, originalEventObject);
			
			// assign it the date that was reported
			copiedEventObject.start = date;
			copiedEventObject.allDay = allDay;
			if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
			
			// render the event on the calendar
			// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
			
			// is the "remove after drop" checkbox checked?
			if ($('#drop-remove').is(':checked')) {
				// if so, remove the element from the "Draggable Events" list
				$(this).remove();
			}
			
		}
		,
		selectable: true,
		selectHelper: true,
		select: function(start, end, allDay) {
			
			bootbox.setDefaults("locale","zh_CN");  
			bootbox.prompt("创建新的事件:", function(title) {
				if (title !== null) {
					console.log(new Date(start)+"-"+end+"-"+allDay);
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true // make the event "stick"
					);
				}
			});
			

			calendar.fullCalendar('unselect');
		}
		,
		eventClick: function(calEvent, jsEvent, view) {

			//display a modal
			var modal = 
			'<div class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				 <div class="modal-body">\
				   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
				   <form class="no-margin">\
					  <label>修改事件内容 &nbsp;</label>\
					  <input class="middle" autocomplete="off" type="text" value="' + calEvent.title + '" />\
					 <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> 保存</button>\
				   </form>\
				 </div>\
				 <div class="modal-footer">\
					<button type="button" class="btn btn-sm btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> 删除事件</button>\
					<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> 退出</button>\
				 </div>\
			  </div>\
			 </div>\
			</div>';
		
		
			var modal = $(modal).appendTo('body');
			modal.find('form').on('submit', function(ev){
				ev.preventDefault();

				calEvent.title = $(this).find("input[type=text]").val();
				calendar.fullCalendar('updateEvent', calEvent);
				modal.modal("hide");
			});
			modal.find('button[data-action=delete]').on('click', function() {
				calendar.fullCalendar('removeEvents' , function(ev){
					return (ev._id == calEvent._id);
				})
				modal.modal("hide");
			});
			
			modal.modal('show').on('hidden', function(){
				modal.remove();
			});


			//console.log(calEvent.id);
			//console.log(jsEvent);
			//console.log(view);

			// change the border color just for fun
			//$(this).css('border-color', 'red');

		}
		
	});


})
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