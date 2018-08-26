<#import "/common/grid.ftl" as loginRecord>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统公告</title>
    
</head>
<body>
	<@loginRecord.grid controller="/system/notice" title="公告管理" width="1100px" height="500px"
		fields="id:true: ,c_title:false:系统公告,c_content:false:公告内容,n_order:false:重要等级,c_createDate:false:创建时间,c_updateDate:false:更新时间">
		
	</@loginRecord.grid>
	
	<script language="javascript">
		//重写grid的change事件
		function change(){
			modifyQueryElem("c_createDate","datebox");
		    modifyQueryElem("c_updateDate","datebox");
		    hideEditElem("c_createDate,c_updateDate");
		}
		
		
	</script>
</body>
</html>