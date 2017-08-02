jQuery(function($) {
	$('#id-change-style').on(ace.click_event, function() {
		var toggler = $('#menu-toggler');
		var fixed = toggler.hasClass('fixed');
		var display = toggler.hasClass('display');
		
		if(toggler.closest('.navbar').length == 1) {
			$('#menu-toggler').remove();
			toggler = $('#sidebar').before('<a id="menu-toggler" class="menu-toggler" href="#">\
				<span class="sr-only">Toggle sidebar</span>\
				<span class="toggler-text"></span>\
			 </a>').prev();
			 ace.vars['mobile_style'] = 2;

			 var icon = $(this).children().detach();
			 $(this).text('Hide old style toggle button').prepend(icon);
			 
			 $('#id-push-content').closest('div').hide();
			 $('#id-push-content').removeAttr('checked');
			 $('.sidebar').removeClass('push_away');
		 } else {
			$('#menu-toggler').remove();
			toggler = $('.navbar-brand').before('<button id="menu-toggler" class="three-bars pull-left menu-toggler navbar-toggle" type="button">\
				<span class="sr-only">Toggle sidebar</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>\
			</button>').prev();
			ace.vars['mobile_style'] = 1;
			
			var icon = $(this).children().detach();
			$(this).text('Show old style toggle button').prepend(icon);
			
			$('#id-push-content').closest('div').show();
		 }

		 if(fixed) toggler.addClass('fixed');
		 if(display) toggler.addClass('display');
		 
		 if('sidebar_scroll' in ace.helper) ace.helper.sidebar_scroll.reset();

		 return false;
	});
	
	$('#id-push-content').removeAttr('checked').on('click', function() {
		$('.sidebar').toggleClass('push_away');
	});
});