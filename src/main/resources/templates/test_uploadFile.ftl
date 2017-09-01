<#import "/common/uploadFile.ftl" as uploadFile>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
    
</head>
<body>
	<@uploadFile.file controller="/system/file/">
		
	</@uploadFile.file>
	
</body>
</html>