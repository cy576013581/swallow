<#import "/common/calendar.ftl" as cal>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>日程管理</title>
	</head>

	<body>
		<@cal.calendar controller="/system/calendar"/>
		
	</body>
</html>