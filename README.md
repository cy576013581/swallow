# spring-boot
更名为swallow<br>
后台：<br>
**springMVC+Mybatis+freemarke+Mysql+redis<br>**
前端：<br>
**整体：easyui和ace admin<br>文件上传：Dropzone.js<br>日历：calendar<br>弹窗：layer<br>消息提示：toarst**
<br><br>这是spring-boot的学习框架，准备将其打造成个人的整体开发框架

*添加个人日程管理

*2017.8.22 添加Redis缓存、测试实例和安全加密工具类

*2017.8.23 mybatis添加mapperxml、grid修改下拉框bug

*2017.8.24 添加BaseEntity以及相应的数据库存储

*2017.8.24 添加用户登录记录，修改获取IP的类

*2017.8.25 添加用户登录记录查询查看，查看功能还需修改，以使封装的easyui框架适应field.option这种格式的属性
		   发现分页查询时#BUG001  在列表页点击下一页之后再次点击查询，查询的数据不能被赋值，当第二次点击查询的时候可以正常的显示。目前暂时找不到问题出在哪，
		   服务端返回的数据是正常的，应该是数据绑定的时候出问题了。但是如果不点击下一页，可以正常工作
		   
*2017.8.24 grid修改基本完成，calendar还需完善

*2017.9.1 calendar日程管理基本完成，添加文件上传模块

*2017.9.17 添加shiro权限控制，权限分配尚未完成

*2017.9.20 权限配置基本完成，无权限提示还需完善

*2017.9.22 用户密码添加md5加密，修改获取当前用户名的基类方法，json添加msg变量，修复登陆第一次点击不跳转

*2017.9.23 添加JsonUtil工具类，添加fastjson，初步出完善权限拦截器，还待优化
