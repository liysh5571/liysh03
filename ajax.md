# ajax简介

1.是什么

>asynchronous javascript and xml:异步的js和xml
>
>它能使用js访问服务器，而且是异步访问服务器。
>
>服务器给客户端的响应一般是整个页面，一个html完整页面，而在ajax中因为是局部刷新，那么服务器就不用再相应整个页面，而只是数据。可以是txt也可以是xml还可以是**json**（js提供的数据交互格式）

2.异步交互和同步交互

2.1同步交互

>*发一个请求，就要等待服务器的响应结束才能发第二个请求，中间这段时间就是“卡”
>
>*刷新的是整个页面

2.2异步交互

>*发一个请求后无需等待服务器的 响应就可以发第二个请求
>
>*可以使用js接收服务器的响应，然后使用js来局部刷新

例子：局部刷新 

WebRoot/js1.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
           window.onload=function(){
               var btn=document.getElementById("btn");
               btn.onclick=function(){
                   var h1=document.getElementById("h1");
                   h1.innerHtml="hello Js";
               };
           };
       </script>  
    </head>
    <body>
        <button id="btn">点击这里</button>
        <h1 id="h1"></h1>
    </body>
</html>
```

# 异步和同步交互图

​                                                                                **同步**

![1590133229626](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590133229626.png)

​                                                                                **异步**

![1590133265017](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590133265017.png)

# ajax的应用场景和优缺点

**应用场景**

*百度的搜索框：当我们在百度中输入一个“传”字时，会出现一个下来列表。这就是一个 局部刷新。同时，当请求 发出后，浏览器还可以进行其他操作，无需等待服务器的响应。

*注册用户：当输入用户名后，把光标移动到其他表单项上时，浏览器会使用AJAX技术向服务器发送请求 ，服务器会查询名为zhangsan的用户是否存在，并返回信息，这是一个局部刷新，并且 在请求发出后，浏览器不用等待 服务器响应结果就可以进行其他操作

**ajax的优缺点**

优点：

>异步交互：增强了用户的体验
>
>性能：因为服务器无需再响应整个页面，只需要响应一部分内容 ，所以服务器的压力减轻了

缺点：

>ajax不能应用在所有场景
>
>ajax无端的增多了 对服务器的访问次数，给服务器带来了压力

# ajax发送异步请求*

1.第一步:ajax其实只需要学习一个对对象：XMLHttpRequest！！

1.1得到XMLHttpRequest：

>大多数浏览器都支持：var xmlHttp=new XMLHttpRequest();
>
>IE6.0: var xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
>
>IE5.5以及更早版本的IE： var xmlHttp=new ActiveXObkect("Microsoft.XMLHTTP");

1.2编写创建XMLHttpRequest对象的函数

```
function createXMLHttpRequest(){
try{
    return new XMLHttpRequest();
}catch(e){
    try{
    return new ActiveXObject("Msxml2.XMLHTTP");
}catch(e){
    try{
        return new ActiveXObject("Microsoft.XMLHTTP");
    }catch(e){
        alert("不符合以上三种浏览器")；
        throw e;
    }
   }
 }
}
```

2.第二步：打开与服务器的链接

xmlHttp.open():用来打开与服务器的链接，它需要三个参数：

​    |-请求方式：可以是GET和POST

​    |-请求的URL：指定服务器端资源，例如：/day/AServlet

​    |-请求是否为异步：如果是true表示发送异步请求，否则为同步请求

>xmlHttp.open("GET","/day/AServlet",true);

3.第三步：发送请求

xmlHttp.send(null):如果不给可能会造成 部分浏览器无法发送

​    |-参数：请求体内容！如果是GET请求，必须给出null。xmlHttp.send("username=zhangSan&password=1");

4.第四步：得到响应

在xmlHttp对象的一个事件上注册监听器：onreadystatechange这个方法会在1，2，3，4时引发

xmlHttp对象一个有5个状态：

​    |-0：初始化未完成状态，只是创建了XMLHttpRequest对象，还未调用open()方法；

​    |-1：请求已开始，open()方法已调用，但还没有调用send()方法

​    |-2：请求发送完成状态，send()方法已调用

​    |-3：开始读取服务器响应，但不表示响应结束

​    |-4：读取服务器响应结束（通常只关心这个状态）

>得到xmlHttp对象的状态
>
>var state=xmlHttp.readyState;// 可能是0，1，2，3，4
>
>得到服务器响应的状态码
>
>var status=xmlHttp.status; //200，404，500
>
>得到服务器响应的内容
>
>var content=xmlHttp.responseText;//得到服务器的响应的文本格式的内容
>
>var content=xmlHttp.responseXML;//得到服务器响应的xml响应的内容，它是Document对象

```
xmlHttp.onreadystatechange=function(){  //xmlHttp的5种状态都会调用本方法
    if(xmlHttp.readyState=4&&xmlHttp.status==200){//双重判断：判断是否为4状态，还要判断是否为200
          //获取服务器的响应内容
          var text=xmlHttp.responseText;
    }
}
```

# 案例：helloajax

day/src/AServlet.java

```java
package cn.itcast.web.servlet;
import java.io.IOException;
public ckass AServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        System.out.println("Hello AJAX");
        response.getWriter().print("Hello Ajax");
    }
}
```

day/WebRoot/ajax1.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
          //创建异步对象
          function createXMLHttpRequest(){
            try{
               return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }catch(e){
                      try{
                          return new ActiveXObject("Microsoft.XMLHTTP");
                      }catch(e){
                          alert("不符合以上三种浏览器")；
                          throw e;
                      }
               }
            }
          }
           window.onload=function(){   //文档加载完毕后执行
               var btn=document.getElementById("btn");
               btn.onclick=function(){  //给按钮的点击事件注册监听
                   //得到服务器的响应，把响应结果显示到h1元素中
                   //1.得到异步对象
                   var xmlHttp=createXMLHttpRequest();
                   //2.打开与服务器的链接
                   xmlHttp.open("GET","<c:url value='/AServlet'>",true);
                   //3.发生请求 
                   xmlHttp.send(null); //get没有请求体但也要给出null，不然火狐浏览器可能不能发送
                   //4.给异步对象注册监听器
                   xmlHttp.onreadystatechange=function(){
                        if(xmlHttp.readyState=4&&xmlHttp.status==200){//双重判断：判断是否为4                                                         状态，还要判断是否为200
                        //获取服务器的响应内容
                        var text=xmlHttp.responseText;
                        //获取h1元素
                        var h1=document.getElementById("h1");
                        h1.innerHTML=TEXT;
                   };
               };
           };
       </script>  
    </head>
    <body>
        <button id="btn">点击这里</button>
        <h1 id="h1"></h1>
    </body>
</html>
```

# 案例：发送POST请求

请求头：Content-Type:application/x-www-form-urlencoded

1.open:xmlHttp.open("POST"...);

2.添加一步：设置Content-Type请求头；

>xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

3.send: xmlHttp.send("username=zhangSan&password=123");

day/src/AServlet.java

```java
package cn.itcast.web.servlet;
import java.io.IOException;
public ckass AServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        System.out.println("Hello AJAX");
        response.getWriter().print("Hello Ajax");
    }
    public void doPOST(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        //解决编码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");//获取请求参数
        System.out.println("Hello 张三post"+username);
        response.getWriter().print("Hello post"+username);
    }
}
```

day/WebRoot/ajax2.jap

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
          //创建异步对象
          function createXMLHttpRequest(){
            try{
               return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }catch(e){
                      try{
                          return new ActiveXObject("Microsoft.XMLHTTP");
                      }catch(e){
                          alert("不符合以上三种浏览器")；
                          throw e;
                      }
               }
            }
          }
           window.onload=function(){   //文档加载完毕后执行
               var btn=document.getElementById("btn");
               btn.onclick=function(){  //给按钮的点击事件注册监听
                   //得到服务器的响应，把响应结果显示到h1元素中
                   //1.得到异步对象
                   var xmlHttp=createXMLHttpRequest();
                   //2.打开与服务器的链接
                   //-------------------第一处修改get为post-------------------
                   xmlHttp.open("POST","<c:url value='/AServlet'>",true);
                   //-------------------第二处添加设置请求头 ------------------
           xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                   //3.发生请求 
                   //------------------发送时指定请求体------------------------
                xmlHttp.send("username=zhangSan&password=123");
                   //4.给异步对象注册监听器
                   xmlHttp.onreadystatechange=function(){
                        if(xmlHttp.readyState=4&&xmlHttp.status==200){//双重判断：判断是否为4                                                         状态，还要判断是否为200
                        //获取服务器的响应内容
                        var text=xmlHttp.responseText;
                        //获取h1元素
                        var h1=document.getElementById("h1");
                        h1.innerHTML=TEXT;
                        }
                   };
               };
           };
       </script>  
    </head>
    <body>
        <button id="btn">点击这里</button>
        <h1 id="h1"></h1>
    </body>
</html>
```

# 案例：用户名是否已被注册

1.编写页面，ajax3.jsp：这是一个注册表单页面

>给用户名文本框添加 onblur（失去焦点）事件的监听
>
>获取文本框的内容，通过异步发送给服务器，得到响应结果
>
>​      如果为1：在文本框后面显示”用户名已被注册“
>
>​      如果为0：什么都不做

2.编写Servlet：ValidateUsernameServlet

>获取客户端传递的用户名参数
>
>判断是否为itcast：是返回1，否返回0

WebRoot/ajax3.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
          //创建异步对象
          function createXMLHttpRequest(){
            try{
               return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }catch(e){
                      try{
                          return new ActiveXObject("Microsoft.XMLHTTP");
                      }catch(e){
                          alert("不符合以上三种浏览器")；
                          throw e;
                      }
               }
            }
          }
           window.onload=function(){   //文档加载完毕后执行
               var userEle=document.getElementById("usernameEle");
               userEle.onblur=function(){  //给文本框的点击事件注册监听
                   //得到服务器的响应，把响应结果显示到h1元素中
                   //1.得到异步对象
                   var xmlHttp=createXMLHttpRequest();
                   //2.打开与服务器的链接
                   //-------------------第一处修改get为post-------------------
                   xmlHttp.open("POST","<c:url value='/ValidateUsernameAServlet'>",true);
                   //-------------------第二处添加设置请求头 ------------------
           xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                   //3.发生请求 
                   //------------------发送时指定请求体------------------------
                xmlHttp.send("username="=userEle.value);
                   //4.给异步对象注册监听器
                   xmlHttp.onreadystatechange=function(){
                        if(xmlHttp.readyState=4&&xmlHttp.status==200){//双重判断：判断是否为4                                                        状态，还要判断是否为200,只关注成功的状态
                        //获取服务器的响应内容，判断是否为 1
                        //是：获取span，添加内容“用户名已被注册”
                        var text=xmlHttp.responseText;
                        var span=document.getElementById("errorSpan"); 
                        if(test=="1"){
                        span.innerHTML="用户名已被注册";
                        }else{
                            span.innerHTML="";
                        }
                      }
                   };
               };
           };
       </script>  
    </head>
<body>
  <h1>演示用户名是否被注册</h1>
  <form action="" method="post">
  用户名：<input type="text" name="username" id="usernameEle"/><span id="errorSpan"></span>
  密  码：<input type="password" name="password"/><br/>
  <input type="submit" value="注册"/>
  </form>
</body>
</html>
```

day/src/ValidateUsernameServlet.java

```java 
package cn.itcast.web.servlet;
import java.io.IOException;
public ckass AServlet extends HttpServlet{
    public void doPOST(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        //解决编码问题
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取请求参数
        String username=request.getParameter("username");
        //判断是否为itcast
        if(username.equalsIgnoreCase("itcast")){
            response.getWriter().print("1");
        }else{
            response.getWriter().print("0");
        }
    }
}
```

# 案例：响应内容为xml

服务器端：

​     ---设置响应头：ContentType：text/xml;cahrset=utf-8

客户端：

​     ---var doc=xmlHttp.responseXML;  //得到的是Document对象

day/WebRoot/ajax4.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
          //创建异步对象
          function createXMLHttpRequest(){
            try{
               return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }catch(e){
                      try{
                          return new ActiveXObject("Microsoft.XMLHTTP");
                      }catch(e){
                          alert("不符合以上三种浏览器")；
                          throw e;
                      }
               }
            }
          }
           window.onload=function(){   //文档加载完毕后执行
               var btn=document.getElementById("btn");
               btn.onclick=function(){  //给按钮的点击事件注册监听
                   //得到服务器的响应，把响应结果显示到h1元素中
                   //1.得到异步对象
                   var xmlHttp=createXMLHttpRequest();
                   //2.打开与服务器的链接
                   xmlHttp.open("GET","<c:url value='/BServlet'>",true);
                   //3.发生请求 
                   xmlHttp.send(null); //get没有请求体但也要给出null，不然火狐浏览器可能不能发送
                   //4.给异步对象注册监听器
                   xmlHttp.onreadystatechange=function(){
                        if(xmlHttp.readyState=4&&xmlHttp.status==200){//双重判断：判断是否为4                                                         状态，还要判断是否为200
                        //获取服务器的响应结果（xml）
                        var doc=xmlHttp.responseXML;
                        //查找文档下名问studnet的所有元素，得到数组，再取下标0yuanus
                       var ele=doc.getElementsByTagName("student")[0];
                       var number;
                            if(window.addEventListerner){
                               name=ele.getAttribute("number")[0].textContent;//其他浏览器
                            }else{
                                name=ele.getElementsByTagName("name")[0].text;//IE
                            }
                       var name=ele.getElementsByTagName("name")[0].text;  //IE支持    
                       var age=ele.getElementsByTagName("age")[0].text;
                       var sex=ele.getElementsByTagName("sex")[0].text;
                            
                       var text=number+","+name+","+age+","+sex;
                            document.getElementById("h1").innerHTML=text;
                        }
                   };
               };
           };
       </script>  
    </head>
    <body>
        <button id="btn">点击这里</button>
        <h1 id="h1"></h1>
    </body>
</html>
```

day/ssrc/BServlet.java 

```java
package cn.itcast.web.servlet;
import java.io.IOExeption;
public class BServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
             throws ServletException,IOException{
        String xml="<students>"+
            "<student number='ITCAST_1001'>"+
            "<name>zhangSan</name>"+
            "<age>18</age>"+
            "<sex>male</sex>"+
            "</student>"+
            "</students>";
        response.setContentType("text/xml;charset=utf-8");
        response.getWriter().print(xml);
    }
}
```

![1590141765681](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590141765681.png)

# 案例：省市联动

![1590142132830](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590142132830.png)

![1590368761044](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590368761044.png)

select.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
 <script>
 //1.在文档加载完毕时发送请求，得到所有省份名称，显示在<select name="provinde"/>中
 //2.在选择了新的省份时，发送请求（参数为省名称），得到xml文档，即<province>元素
//解析xml文档，得到其中所有的<city>,再得到每个<city>元素的内容，即市名，使用市名生成<option>,插入到 <selct name="city">元素中 
     
window.onload=function(){
//请求服务器，加载所有省名称到<select>中
//1.ajax四步    
    var xmlHttp=createXMLHttpRequest();
    xmlHttp.open("GET","/ajaxdemo1/ProvinceServlet",true);//向服务器发送GET请求
    xmlHttp.send(null);//发送请求
    xmlHttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
        //把服务器响应的省份名称，使用逗号分割成字符串数组
        var provinceNameArray=this.responseText.split(",");
        //遍历每个省份名称，使用每个省份名称创建<option>元素，添加到province的<select>中
        for(var i=0;i<provinceNameArray.length;i++){
            var op=document.createElement("option");//创建一个指定名称的元素
            op.value=provinceNameArray[i];//设置op的实际值为当前的省份名称
            var testNode=document.createTextNode(arr[i]);//创建文本节点
            op.appendChild(textNode);//把文本节点添加到op元素中，指定显示值
            document.getElementById("province").appendChild(op);
         }
       }
    }；
    //第二件事：给<select name="province">添加改变监听
    //使用选择 的省份名称请求CityServet，得到<province>元素（xml元素）
    //获取<province>元素中所有的<city>元素，遍历之，获取每个<city>的文本内容，即市名称
    //使用每个市名称创建<option>元素添加到<select name="city">
    var proSelect=document.getElementById("province");
    proSelect.onchange=function(){
    var xmlHttp=createXMLHttpRequest();
    xmlHttp.open("POST","<c:url value='/CityServlet'/>",true);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlenconded");
    xmlHttp.send("pname="+proSelect.value);//把下拉列表中选择的值发送给服务器
    xmlHttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            //把select中所有的option移除（除了请选择）
            var citySelect=document.getElementById("city");
            //获取所有子元素
            var optionEleList=citySelect.getElementsByTagName("option");
            //循环遍历每个option元素，然后在citySelect中移除
            while(optionEleList.length>1){  //留下请选择
                citySelect.removeChild(optionEleList[1]);  //总是删除1下标，因为2会变成1
            } 
            var doc=xmlHttp.responseXML;
            //得到所有city的元素
            var cityEleList=doc.getElementsByTagName("city");
            //循环遍历每个city元素
            for(var i=0;i<cityEleList.lengrh;i++){// 要判断浏览器
                var cityEle=cityEleList.get[i];//得到每个city元素
                var cityName;
                if(window.addEventListener){   //处理浏览器差异
                    cityName=cityEle.textContent;  //支持火狐等
                }else{
                    cityName=cityEle.text;  //支持ie
                }
                //使用市名称创建option元素，添加到<select name="city">中
                var op=document.createElement("option");
                op.value=cityNmae;
                //创建文本节点
                var textNode=document.createTextNode("")
                op.appendChild(textNode);//把文本节点追加到op中
                //把op添加到<select>元素中
                citySelect.appendChild(op);
            }
        }
     }；
   };
};

  </script>
    </head>
    <body>
<h1>省市联动</h1>
省：<select name="province" id="province">
       <option>==请选择省份==</option>
</select>
市：<selsct name="city" id="city">
        <option>==请选择城市==</option>
</selsct>
    </body>
</html>

```

当select.jsp页面打开时，向服务器发送异步请求，得到所有省份的名称（文本数据）。然后使用每个省份名称创建<option>,添加到<select name="province">中。并且为<select name="province">元素添加到onchange事件监听。当选择的省份发生变化时，再向服务器发送异常请求，得到当前选中的省份下所有城市（XML数据）。然后客户端解析XML文档，使用每个城市名称创建<option>,添加到<select name="city">元素中。

服务器端：使用china.xml保存所有省份和城市名称

china.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<china>
    <province name="北京">
        <city>东城区</city>
        <city>西城区</city>
        ......
    </province>
    <province name="天津">
        <city>和平区</city>
        <city>河东区</city>
        .......
    </province>
    <province name="河北">
        <city>石家庄</city>
        <city>衡水</city>
        ......
    </province>
    .......
</china>
```

- ProvunceServlet:负责把所有省份名称响应给客户端，这需要使用dom4j解析china.xml，得到所有<province>元素的name属性值，连接成一个字符串发送给客户端；
- CityServlet:负责得到某个省份元素，然后以字符串形式发送给客户端；

ProvinceServlet.java

当页面加载完毕后马上请求这个Servlet，它需要加载china.xml文件，把所有的省的名称使用字符串发送给客户端

```java
public class ProvinceServlet extends HttpServlet{
    //响应所有省份名称
    public void doGet(HttpServletRequest request,HttpServletResponse response)
                throws ServletException,IOException{
        //注意设置编码
        response.setContentType("text/html;chaeset=utf-8");
        //使用Dom4j解析xml文档
        try{
            InputStream input=this.getClass().getResourseAsStream("/china.xml");
            SAXReader reader=new SAXReader();
            Documnet doc=reader.read(input);
            //xpath查询所有province元素的name属性
            List<Attribute> arrList=doc.selectNodes("//province/@name");
            //用来装载所有name属性
            StringBuilder sb=new StringBuilder();
            //遍历每个属性，获取属性名称，添加到sb中
           for(int i=0;i<arrList.size();i++){
               sb.append(arrList.get(i).getValue());
               if(i<arrList.size()-1){
                   sb.append(",");
               }
           }
            response.getWriter().print(sb);
        }catch(DocumentException e){
            throws new RuntimeException(e);
        }
    }
}
```

CityServlet.java

>CityServlet:当页面选择某个省时，发送请求
>
>得到省份的名称，加载china.xml文件，查出该省份对应的元素对象，把这个元素转换为xml字符串，发送给客户端。

```java
public class CityServlet extends HttpServlet{
    //获取省份名称，加载该省对应的<province>元素
    // 把元素转换成字符串发送给客户端
    public void doPost(HttpServletRequest request,HttpServletResponse response)
               throws ServletException,IOEception{
        request.setCharacterEncoding("utf-8");
        //注意，这里内容类型必须是text/xml，不然客户端得到的不是xml文档对象，而是字符串了**
        response.setContentType("text/xml;charset=utf-8");
        try{
           //获取省份参数
            String pname=request.getParameter("pname");
            InputStream input=this.getClass().getResourceAsStream("/china.xml");
            SAXReader reader=new SAXReader();
            Document doc=reader.read(input);
            //查询指定省份名称的<province>元素
            Element proEle=
                (Element)doc.selectSingleNode("//province[@name=']"+pname+"']");
            //把元素转换成字符串发送给客户端
            String xmlStr=proEle.asXML(); //把元素转换成字符串
            response.getWriter().print(xmlStr);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
```

客户端：

- 在打开selec.jsp页面时就向服务器请求所有省份的名称 ，添加到<select name="province">元素
- 给<select name="province">元素添加onchange事件监听，内容为向服务器发送请求，得到XML文档：<province>元素，然后解析他，添加到<select name="city">中

```jsp
//文档加载完成后
//加载所有省份名称
window.onload=function(){
//请求服务器，加载所有省名称到<select>中
//1.ajax四步    
    var xmlHttp=createXMLHttpRequest();
    xmlHttp.onreadystatechange=callback;//服务器响应完成后执行callback函数
    xmlHttp.open("GET","/ajaxdemo1/ProvinceServlet",true);//向服务器发送GET请求
    xmlHttp.send(null);//发送请求
}；
```

```jsp
//本方法获取服务器响应的所有省份的名称
function callback(){
    if(this.readyState==4 && this.status==200){
        //把服务器响应的省份名称，使用逗号分割成字符串数组
        var provinceNameArray=this.responseText.split(",");
        //遍历每个省份名称，使用每个省份名称创建<option>元素，添加到province的<select>中
        for(var i=0;i<provinceNameArray.length;i++){
            addProvinceOption(provinceNameArray[i]);  
        }
        //为province的<select>元素添加onchange事件监听
        document.getElementById("province").onchange=loadCities;
    }
}
```

```jsp
//本函数在province的<select>元素发送变化时执行
//本函数会使用当前选中的省份名称为参数，向服务器发送请求，获取当前省份下所有城市
function loadCityties(){
    var proName=this.value;  //获取<select>选择的省份名称
    AJAX4步
    var xmlHttp=createXMLHttpRequest();  //创建异常对象
    //指定回调函数
    xmlHttp.onreadystatechange=function(){
         if(xmlHttp.readState==4 && xmlHttp.status==200){
         //得到服务器响应的xml文档对象
         var doc=xmlHttp.responseXML;//注意，这里使用的是responseXML属性，不是responseText；
         //获取文档中所有city元素 
         var cityElemetList=doc.getElementsByName("city");
         //获取html元素：city的<select>
         var citySelect=document.getElemetsById("city");
         //删除city的<select>元素的所有子元素
         removeChildNodes(citySekect);
         //创建<option>元素，指定文本内容为“请选择”
         var qxzOption=document.createElement("option");
         var textNode=document.createTestNode("==请选择==")；
         qxzOption.appendChild(textNode);
          //把“请选择”这个<option>添加到<select>元素 中
         citySlect.appendChild(qxzOption);
         //循环遍历每个服务器端响应的每个<city>元素
         for(var i=0;i<cityElementList.lengthli++){
             var cityEle=cityElementList[i];
             var cityName=null; 
             if(window.addEventListener){      //
                  cityName=cityEle.textContent;                                  
             }else{
                 cityNmae=cityEle.text;                                   
             }
             //使用城市名称创建<option>,并添加到<select>元素中
             addCityOption(cityNmae);
         }
       }
    };
    xmlHttp.open("POST","/ajaxdemo1/CityServlet",true);
    //设置请求头
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-rlencoded");
    //参数为当前选中的省份名称
    xmlHttp.send("provinceName="+proName);
}
```

```jsp
//使用proName创建<option>元素添加到 <select>元素中
function addProvinceOption(proName){
    var option=document.createElement("option");//创建<option>元素
    var textNode=document.createTextNode(proName);//使用省份名称创建文本节点 
    option.appendChild(textNode);//把省份名称的文本节点添加到<option>元素中
    option.setAttribute("value",proName);//使用省份别名来设置<option>元素的value属性
    document.getElementById("province").appendChild(option);//把<option>元素添加到<select>
    元素添加到<select>元素中
}
```

```jsp
//本函数用来创建城市的<option>,并添加到<select>元素中
function addCityOption(cityName){
    var citySelect=document.getElementById("city");//获取id为city的<select>
    var cityOption=document.createElement("option");//创建<option>元素
    var textNode=document.createTextNode(cityName);//使用城市名称创建文本节点
    cityOption.appendChild(textNode);//把文本节点添加到<option>元素中
    cityOption.setAttribute("value",cityName);//设置<option>元素的value属性为城市名称
    citySelect.appendChild(cityOption);//把<option>元素添加到<select>元素中
}
```

```jsp
//删除指定元素的所有子元素
function removeChildNodes(ele){
    var nodes=ele.childNodes;//获取当前元素的所有子元素集合
    while(nodes.length>0){
       ele.removeChild(nodes[0]);
    }
}
```

3.页面的工作

>获取这个字符串，使用逗号分割，得到数组
>
>循环遍历每个字符串（省份的名称），使用每个字符串创建一个<option>元素添加到<select name="province">这个元素中



>把<select name="city">中的所有子元素删除 ，但不要删除<option>==请选手城市==</option>
>
>得到服务器的响应结果，document对象
>
>获取所有的<city>子元素，循环遍历，得到<city>的内容
>
>使用每个<city>的内容创建一个<option>元素。

# XStream

1.作用

可以把javaBean转换为xml，/然后ajax把xml发送到客户端

2.jar包

http://xstream.codehaus.org/

核心jar包：xstream.1.4.7-jar

必须依赖包：xpp3_min-1.1.4c(XML Pull Parser，一款速度很快的XML解析器)

![1590389975990](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590389975990.png)

3.使用步骤

>XStream xstream=new XStream();
>
>String xmlStr=xstream.toXML(javabean);

Demo1.java

```java
public class Demo1{
    //返回JavaBean集合
    public List<Province> getProvinceList(){
        Province p1=new Province();
        p1.setName("北京")；
        p1.addCity(new City("东城区"，"dongchengqu"));
        p1.addCity(new City("昌平区","changpingqu"));
        p2.setName("辽宁")；
        p2.addCity(new City("沈阳"，"shenyang"));
        p2.addCity(new City("葫芦岛","huludao"))；
        List<Province>provinceList=new ArrayList<Porvince>();
        provinceList.add(p1);
        provinceList.add(p2);
        return provinceList;
    }
    @Test
    public void fun1(){
        List<Province> proList=getprovinceList();
        //创建XStream对象
        //调用toXML把集合转换为xml字符串
        XStream xstream=new XStream();
        String s=xstream.toXML(proList);
        System.out.println(s);
    }
    //别名（alias）
    //希望：
    //默认List类型对应<List>元素，希望让List类型对应<china>元素
    //默认province类型对应<cn.itcast.demo1.Province>，希望让他对应<province>
    //默认City类型对应<cn.itcast.demo1.City>,希望他对应<city>元素
    @Test
    public void fun2(){
        List<Province> proList=getprovinceList();
        //创建XStream对象
        //调用toXML把集合转换为xml字符串
        XStream xstream=new XStream();
        //给指定的类型指定别名
        xstream.alias("china",List.class);  //给List'类型指定别名china
        xstream.alias("province",Province.class);//给Province指定别名
        xstream.alias("city",City.class);  
        String s=xstream.toXML(proList);
        System.out.println(s);
    }
    @Test
    public void fun3(){
        List<Province> proList=getprovinceList();
        XStream xstream=new XStream();
        xstream.alias("china",List.class);  //给List'类型指定别名china
        xstream.alias("province",Province.class);//给Province指定别名
        xstream.alias("city",City.class);  
        
        //把province类型的name属性，生成<province>元素的属性
        xstream.useAttributeFor(Province.class,"name");
        String s=xstream.toXML(proList);
        System.out.println(s);
    }
    @Test
    public void fun4(){
        List<Province> proList=getprovinceList();
        XStream xstream=new XStream();
        xstream.alias("china",List.class);  //给List'类型指定别名china
        xstream.alias("province",Province.class);//给Province指定别名
        xstream.alias("city",City.class);  
        xstream.useAttributeFor(Province.class,"name");
        
        //去除<cities>这样的Collection类型的属性
        xstream.addImplicatCollection(Province.class,"cities");
        String s=xstream.toXML(proList);
        System.out.println(s);
    }
    @Test
    public void fun5(){
        List<Province> proList=getprovinceList();
        XStream xstream=new XStream();
        xstream.alias("china",List.class);  //给List'类型指定别名china
        xstream.alias("province",Province.class);//给Province指定别名
        xstream.alias("city",City.class);  
        xstream.useAttributeFor(Province.class,"name");
        xstream.addImplicatCollection(Province.class,"cities");
        
        //让city中的description不生成相应的xml元素
        xstream.omitField(City.class,"description");
        String s=xstream.toXML(proList);
        System.out.println(s);
    }
}
```

fun1

![1590391596184](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590391596184.png)

fun2

![1590392317072](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590392317072.png)

更好看fun3

![1590392665873](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590392665873.png)

去掉citiesfun4

![1590392975039](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590392975039.png)

去掉<description>,去掉不想要的Javabean属性，就是让某些javaBena属性，不生成对应的xml元素 

![1590393205841](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590393205841.png)

City.java

```java
public claSS City{
    private String name; //市名
    private String description;  //描述
    //省略get/set方法
    @Override
    public String toString(){
        return "City[name="+name+",description="+description+"]";
    }
    public City(){
        supper();
    }
    pubic City(String name,String descroption){
        supper();
        this.name=name;
        this.description=description;
    }
}
```



Province.java

```java
public class Province{
    private String name;  //省名
    private List<City> cities=new ArrayList<City>(); 
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public List<City>getCities(){
        return cities;
    }
    public void setCitises(List<City> cities){
        this.cities=cities;
    }
    public void addCity(City city){
        cities.add(city);
    }
}
```

![1590393485425](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590393485425.png)

# JSON

1.是什么

>是js提供的一种数据交换格式，就是把一种语言转换成另一种语言

2.json的语法

>1.{ }：是对象
>
>   属性名必须使用双引号括起来
>
>   属性值：
>
>​        数字、
>
>​        字符串、
>
>​        布尔值 true false
>
>​       数组[]
>
>​        对象、
>
>​         null

3.应用jason

>var person={"name":"zhangSan","age":18,"sex":"male"}

json1.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
           window.onload=function(){
               var person={"name":"zhangSan","age":18,"sex":"male"};
               alert(person.name+","+person.age+","+person.sex);
           };
       </script>  
    </head>
    <body>
        <button id="btn">点击这里</button>
        <h1 id="h1"></h1>
    </body>
</html>
```

json1.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
           window.onload=function(){
               var str="{\"name\":\"zhangSan\",\"age\":18,\"sex\":\"male\"}";
               var person=eval("("+str+")");
               alert(person.name+","+person.age+","+person.sex);
               //解释
               //var str="1+2";
               //var sum=eval("("+str+")");
               //alert(sum);
           };
       </script>  
    </head>
    <body>
       
    </body>
</html>
```

AServlet.java

```java
public class AServlet extends HttpServlet{
    public void doGet(HttpServletRequest,request,HttpServletResponse response)
               throws ServletException,IOException{
        //向客户端发送json串
        String str="{\"name\":\"zhangSan\",\"age\":18,\"sex\":\"male\"}";
        response.getWriter().print(str);
        Sytem.out.println(str);
    }
}
```

json2.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <script>
       function createXMLHttpRequest(){
            try{
               return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");
                }catch(e){
                      try{
                          return new ActiveXObject("Microsoft.XMLHTTP");
                      }catch(e){
                          alert("不符合以上三种浏览器")；
                          throw e;
                      }
               }
            }
          }
        window.onload=function(){
          var btn=document.getElementById("btn");
          btn.onclick=function(){  //给按钮的点击事件上添加监听
             //使用ajax得到服务器响应，把结果显示到h3中
              //1.得到request
              var xmlHttp=createXMLHttpRequest();
              //2.连接
              xmlHttp.open("GET","<c:url value='/AServlet'/>",true);
              //3.发送
              xmlHttp.send(null);
              //4.给xmlHttp的状态改变事件上添加监听
              xmlHttp.onreadystatechange=function(){
                  //双重判断
                  if(xmlHttp.readyState==4 && xmlHttp.status==200){
                      var text=xmlHttp.responseText;// 它是一个json串
                      //执行json串
                      var person=eval("("+text+")");
                      var s=person.name+","+person.age+","+person.sex;
                      document.getElementById("h3").innerHTML=s;
                  }
              }
          };
        };
      </script>
    </head>
    <body>
       <!--点击后响应到h3中-->
        <button id="btn">点击这里</button>
       <h1>json之Hello World</h1> 
        <h3 id="h3"></h3>
    </body>
</html>
```

4.json和xml

可读性：XML更好

解析难度：JSON本身就是js对象，所以更简单

流行度：XML更流行，但在AJAX中JSON更受欢迎

# json-lib

1.是什么

可以把Javabean转换成json串

2.jar包

核心jar包有：json-lib.jar

json-lib的依赖jar包有：

​    commons-lang.jjar

​    commons-beanutils.jar

​    commons-logging.jar

​    commons-collections.jar

​    eamorph-jar

3.核心类

JSONObject-->Map

>toString();
>
>JSONObject map=JSONObject.fromObject(p);  把对象转换成JSAONObject对象

JSONArray-->List

>toString();
>
>JSONArray jsonArray=JSONObject.fromObject(list);把list转换成JSONArray对象

Person.java

```Java
public class  Person{
    private String name;
    private int age;
    private String sex;
    public Person(){
        super();
    }
    public Person(String name,int age,String sex){
        super();
        this.name=name;
        this.age=age;
        this.sex=sex;
    }
    @Override
    public String toString(){
        return"Person[name="+name+",age="+age+",sex="+sex+"]";
    }
}
```

Demo1.java

```java
import net.sf.json.JSONObject;
import org.junit.Test;
//演示JSON-LIB小工具
public class Demo1{
    @Test
    public void fun1(){
        JSONObject map=new JSONObject();
        map.put("name","zhangSan");
        map.put("age",23);
        map.put("sec","male");
        String s=map.toString();
        System.out.println(s);
    }
    //当你有一个Person对象时，可以把Person转换成JSONObject对象
    @Test
    public void fun2(){
        Person p=new Person("lisi",32,"female");
        //把对象转化成JSONObject类型
        JSONObject map=JSONObject.fromObject(p);
        System.out.println(mao.toString());
    }
    //JSONArray
    @Test
    public void fun3(){
        Person p1=new Person("zhangSan",23,"male");
        Person p2=new Person("lisi",32,"female");
        JSONArray list=new JSONArray();
        list.add(p1);
        list.add(p2);
        System.out.println(list.toString());
    }
    @Test
    public void fun4(){
        Person p1=new Person("zhangSan",23,"male");
        Person p2=new Person("lisi",32,"female");
        List<Person> list=new ArrayList<Person>();
        list.add(p1);
        list.add(p2)
        System.out.println(JSONArray.fromObject(list).toString());
    }
}
```

fun1执行结果：

![1590412238455](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590412238455.png)

# 打包ajax生成小工具

/WebRoot/ajax-lib/ajaxutils.js

```java
//创建request对象
function createXMLHttpRequest(){
      try{
         return new XMLHttpRequest();
      }catch(e){
          try{
             return new ActiveXObject("Msxml2.XMLHTTP");
           }catch(e){
                  try{
                      return new ActiveXObject("Microsoft.XMLHTTP");
                   }catch(e){
                      alert("不符合以上三种浏览器")；
                      throw e;
                    }
           }
       }
}
//option包含如下属性
//method,url,asyn,params，callback，type
//请求方式，请求的url，是否异步，请求体,回调方法,服务器响应数据转换成什么类型
function ajax(option){    
    //1.得到xmlHttp
    var mlHttp=createXMLHttpRequest();
    //2.打开连接 
    if(!option.method){  //默认为GET
        option.method="GET";
    }
    if(option.asyn==undefined){  //默认为异步处理
        option.asyn=true;
    }
    xmlHttp.open(option.method,option.url,option.asyn);
    //3.判断是否为 post
    if("POST"==option.method){
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    }
    //4.发送请求 
    xmlHttp.send(option.params);
    //5.注册监听
    xmlHttp.onloadchange=function(){
        if(xmlHttp.readyState==4 && xmlHttp.status==200){
            var data;
            //获取服务器的响应数据，进行转换
            if(!option.type){  //如果type没有赋值，那么默认为文本
                data=xmlHttp.responseText;
            }else if(option.type==="xml"){
                data=xmlHttp.responseXML;
            }else if(option.type=="text"){
                data=xmlHttp.responseText;
            }else if(option.type=="json"){
                var text=xmlHttp.responseText;
                data=eval("("+text+")");
            }
            //调用回调方法
            option.callback(data);
        }
    };
};
```

AServlet.java

```java 
public clas AServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
              throws ServletException,IOException{
        //向客户端发送json串
        String str="{\"name\":\"zhangSan\",\"age\":18,\"sex\":\"mae\"}";
        response.getWriter().print(str);
        System.out.prinltln(str);
    }
}
```

json3.jsp

```jsp
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
     <script src="<c:url value='/ajax-lib/ajaxutils.js'/>">
        window.onload=function(){
            var btn=document.getElementById("btn");
            btn.onclick=function(){
                //1.ajas
                ajax{
                    {
                        url:"<c:url value='/AServlet'/>",
                        tpe:"json",
                        callback:function(data){
                            document.getElementById("h3").innerHTML=
                                          data.name+","+data.age+","+data.sex;
                        }
                    }
                };
            };
        };
     </script>    
    </head>
    <body>
      <button id="btn">点击这里 </button>
      <h1>演示袭击封装的小工具 </h1> 
      <h3 id="h3"></h3>
    </body>
</html>
```

![1590455593216](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590455593216.png)

