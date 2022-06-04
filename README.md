雷丰阳JavaWeb
https://www.bilibili.com/video/BV1q4411u7mM

web项目发布到服务器上以后，WebContent底下所有内容放到服务器上，目录就是/Html_Demo

HTML结构、css表现、js行为，我们希望结构、表现、行为三者分离

样式重叠，选最近的样式

http请求头大全
http://tools.jb51.net/table/http_header

浏览器地址长度255

serlvet相当于餐馆的服务员，servletContext相当于餐馆经理

转发和重定向区别，转发只发一次请求

@WebServlet注解取代web.xml中对servlet的配置
@since Servlet 3.0

@override 
这个标志你加不加都不会出问题，如果你确实要表明这个方法就是要覆盖父类的方法，实现多态，那就加上吧。
这个标志会在编译的时候进行检查，如果这个方法是覆盖了父类的方法，ok没问题，
如果父类没这个方法就会编译不通过。


绝对路径在重定向和转发间的不同

重定向以服务器的根开始，因为重定向以浏览器重新访问。浏览器解析都是以服务器的根开始。

转发是服务器内部，服务器解析的都是以项目名开始。getRequestDispatcher。

html页面，也是从服务器的根开始，所以绝对路径也要加项目名。
都推荐使用绝对路径

改名改两处
1.rename
2.项目根目录web project settings

.project文件里面改项目名

jdbc.properties文件如果在WebContent外部署的时候加载不到，需要写在类路径下

项目创建动态项目，3.0

子类对象创建父类构造器会被调用
构造器里有this指的是子类对象

表字段和实体类属性名要完全匹配

面向接口编程

实际的项目中用户名密码在后端还要验证

所地方编码utf-8		eclipse.ini最后一行
-Dfile.encoding=utf-8

避免jsp被直接访问，把它放进WEB-INF保护起来

get请求，表单数据会被带上，请求地址中的数据会被表单覆盖

request.getParameter获取参数
get请求：在请求地址中
post请求：在请求体中

自定义标签未完成

细的分层
1）显示层：页面
2）控制层：Servlet
3）业务逻辑层：Service
4）持久化层：Dao
5）模型层：Bean
6）数据库对应表

异常处理搞成最大
catch (Exception e) {
	e.printStackTrace();
}


javabean
1.空参构造器
2.有参构造器
3.get、set
4.toString

mysql不区分大小写，所以img_path对应javabean中imgPath

<%= 在页面输出

System.out.println不用重启服务器

浏览器不关就是会话期间

double,float在进行运算的时候会产生精度问题
1、大整数运算
2、浮点

unpredictable 不可预测
strict 严格
transitional 不严格

原生属性用proper，自定义属性用attr

VARCHAR检索慢
CHAR费空间检索慢

DOUBLE(11,2)	11位2位小数

实体字段对应mysql表字段
String CHAR(50)、VARCHAR(100)
Date	DATETIME
double	DOUBLE(11,2)
int		INT(2)
Integer	INT(2)

考虑转型异常
Integer.parseInt(pageNo)

数据库dao写完要关连接

子类创建对象会调用父类构造器

tomcat的web.xml有welcome-file-list

js中也可以用el，但是要加双引号，p163

购物车，去超市买东西，在购物车里装着
保存在session，不同会话（浏览器一关），就没了

对于完整性要求不高的不建外键关联，会影响查询速度

uri与url区别
直接打印出来

字符串转int
Integer.parseInt(stuAge)

安装tomcat作为一个服务(windows)
1、管理员权限
	cd tomcat-bin目录
	service.bat install Tomcat6.0

2、删除一个服务
	sc delete Tomcat6.0