# spring-boot
初探spring-boot
springMVC+Mybatis+freemarker+easyui+Mysql
这是spring—boot的学习demo，准备将其打造成我的整体开发框架


#### 添加个人日程管理
this is domain <br>
//主键
int id;

//用户
String username;

//事件
String title;

//开始时间
Datetime start;

//结束时间
Datetime end;

//事件级别
int level;

#### 添加实体基类
public class BaseEntity {
    protected Integer id;
    protected Date createTime;
    protected Integer createId;
    protected Date updateTime;
    protected Integer updateId;
    protected Boolean deleted;
    //省略setter getter
}
