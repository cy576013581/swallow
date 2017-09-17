<#macro file controller width="800px" height="180px">
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="../lib/toastr/toastr.css" rel="stylesheet"/>
    <link href="../lib/dropzone/dropzone.css" rel="stylesheet"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/dropzone/dropzone.js"></script>
    <script type="text/javascript" src="../lib/layer/layer.js"></script>
    <script type="text/javascript" src="../lib/toastr/toastr.js"></script>
    <style>
    	#dropz{
    		border: 2px dashed #0087F7;
		    border-radius:1 5px;
		    background: white;
		    cursor: pointer;
		    text-align: center;
    	}
    </style>
</head>
<body>
		<form id="dropz" enctype="multipart/form-data" action="${controller}upload" class="dropzone dz-clickable dz-started" style="width:${width};height:${height};">
		</form>

	<script type="text/javascript">
	    $(function(){
	    	var dropz = new Dropzone("#dropz", {
		        url: "${controller}upload",
		        maxFiles: 6,
		        paramName: "file", 
			    maxFilesize: 20, // MB
				addRemoveLinks : true,
		    });
	    });
	</script>
</body>
</html>
</#macro>