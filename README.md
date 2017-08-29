# spring-boot
初探spring-boot
springMVC+Mybatis+freemarker+easyui+Mysql
这是spring—boot的学习demo，准备将其打造成个人的整体开发框架

*添加个人日程管理

*2017.8.22 添加Redis缓存、测试实例和安全加密工具类

*2017.8.23 mybatis添加mapperxml、grid修改下拉框bug

*2017.8.24 添加BaseEntity以及相应的数据库存储

*2017.8.24 添加用户登录记录，修改获取IP的类

*2017.8.25 添加用户登录记录查询查看，查看功能还需修改，以使封装的easyui框架适应field.option这种格式的属性
		   发现分页查询时#BUG  在列表页点击下一页之后再次点击查询，查询的数据不能被赋值，当第二次点击查询的时候可以正常的显示。目前暂时找不到问题出在哪，
		   服务端返回的数据是正常的，应该是数据绑定的时候出问题了。但是如果不点击下一页，可以正常工作
		   
*2017.8.24 grid修改基本完成，calendar还需完善
