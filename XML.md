xml主要用于存储数据用1.0版本  。

## xml的应用：

**1.不同系统之间传输数据**

​       qq之间发送数据

<img src="C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588059403578.png" alt="1588059403578" style="zoom: 200%;" />

**2.用来表示生活中有关系的数据**

​     国家  城市  省会

![1588059515073](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588059515073.png)

**3.经常用在配置文件中**  

​     比如连接数据库，需要数据库的用户名密码 数据库名称

​    如果要修改数据库信息，不需要修改源代码，只需要修改配置文件

## XML文档的声明

**1.xml文档声明**

- ​          创建文件 后缀名.xml 

- ​          如果要写xml，第一步必须要有一个文档声明

  | <?xml version="1.0" encodeing="utf-8”?> //必须第一行第一列  <person>      <name>zhangsan</name>   //写成中文会乱码      <age>18</age>  </person> |
  | ------------------------------------------------------------ |
  | 乱码问题的解决：  ![1588060119211](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588060119211.png)                                                                    ![1588060136924](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588060136924.png)保存时的编码和设置时的编码一致 |
  | 属性：  -version 使用1.0  -encoding gbk：（默认）中文简体 utf-8：包含中文  iso8895-1：不包含中文        standalone：是否需要依赖其他文件 yes/no |

**2. 定义元素（标签）**

- ​              又开始必须有结束:<person></person>
- ​             标签内没有内容可以:<person/>
- ​             合理嵌套:<aa><bb></bb></aa>
- ​             一个xml文件有且只有一个根标签

![1588060179928](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588060179928.png)

- ​              xml中标签的命名规则：可以是中文

![1588060208163](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588060208163.png)

**3.定义属性**

- 标记型文档，可以有多个不同的属性

  <person id1="aaa" id2="bbb"></person>

![1588078405460](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078405460.png)

**4.注释：不能放到第一行**

![1588078440345](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078440345.png)

5.**特殊字符**

![1588078540242](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078540242.png)

张三 20 a（小于号当成标签了）

<img src="C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078504638.png" alt="1588078504638" style="zoom:200%;" />

<img src="C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078512272.png" alt="1588078512272" style="zoom:200%;" />

**6.CDATA区（了解）**  

解决多个字符需要转义的问题：

![1588078639848](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078639848.png)

<img src="C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078646731.png" alt="1588078646731" style="zoom:200%;" />

**7.PI指令（处理指令）了解**

![1588078715681](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078715681.png)

可以在xml中设置样式

demo.css

![1588078769455](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078769455.png)

demo.xml

![1588078788094](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078788094.png)

![1588078796564](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078796564.png)

## XML约束简介

**为什么要约束？**

<img src="C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588078842405.png" alt="1588078842405" style="zoom:200%;" />

人不能有猫的属性，但猫符合语法，这时需要约束

有两种约束：dtd和schema

# DTD（文档类型定义）

## 介绍 

- 创建一个文件 后缀名 .dtd 

  步骤：

  ​    1.在xml文件中有多少元素，有几个元素，在dtd文件中写几个<!ELEMENT>

  ​    2.判断元素是简单元素，还是复杂元素
  
  ​            复杂元素：有 子元素
  
  ​                   <!ELEMENT 元素名称（子元素）>
  
  ​            简单元素：没有子元素
  
  ​                   <!ELEMENT 元素名称  (#PCDATA) >

​              3.需要在xml文件中引入dtd文件

​                         <!DOCTYPE 根元素名称 SYSTM "dtd文件的路径"

​                 xml文件

![1588325416944](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588325416944.png)

​                 dtd文件（约束）

​               ![1588325461486](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588325461486.png)

​         例：

​         ![1588325523347](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588325523347.png)

​                      标签<a></a>不符合dtd的约束，但还是会成功显示。

![](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588325672337.png)

-    打开xml'文件使用的是浏览器，浏览器只负责校验xml的语法，不负责校验约束。如果想要校验xml，就需要使用工具（在src中创建dtd文件和xml文件，IDEA自动编译出错）

## 引入方式

- 引入外部的dtd文件

  ​              <!DOCTYPE 根元素名称 SYSTEM "dtd路径">

- 使用内部dtd文件

![1588326374272](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588326374272.png)

​             出错的情况：

![1588326420275](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588326420275.png)

- 使用外部的dtd文件（网络上的dtd文件）struts中会用到。

  ​      <!DOCTYPE 根元素 PUBLIC  "DTD名称" "DTD文档的URL">

​               ![1588326648915](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588326648915.png)

## 使用DTD定义元素

- 语法：<!ELEMENT 元素名 约束>
- 简单元素<!ELEMENT name (#PCDATA)>       规定name为字符串类型

​                        <!ELEMENT name EMPTY>              规定name必须为空

​                        <!ELEMENT name  ANY>                 规定name为任意

- 复杂元素<!ELEMENT 元素名称 (子元素)>     规定子元素只能出现一次

  ​              子元素直接使用","隔开。表示元素出现的次序。

  ​              子元素用|隔开表示元素只能出现1个，否则会出错。

  ​           ![1588327485399](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588327485399.png)

​                      name +： name属性可以出现多次，但不能没有。

![1588327138469](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588327138469.png)

​                      age?:可以出现0次或者1次

​                  ![1588327263478](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588327263478.png)

​                   sex*：可以出现任意次数，0次、1次或多次

## 使用DTD定义属性

- 语法：<!ATTLIST 元素名称

  ​                           属性名称 属性名称 属性的约束

  ​             >

```&lt;/age
<!xml version="1.0" ecoding="UTF-8?">
<!DOCTYPE person[
    <!ELEMENT person(name,age,sex,school,birthday)>
    <!ELEMENT name(#PCDATA)>
    <!ATTLIST name             <!--ID-->
        ID3 ID #REQUIRED
    <!ELEMENT age(#PCDATA)>
    <!ATTLIST age              <!--枚举-->
        ID2(AA|BB|CC) #REQUIRED
    <!ELEMENT sex EMPTY>
    <!ELEMENT school ANY>
    <!ELEMENT birthday(#PCDATA)>
    <!ATTLIST birthday           <!--CDATA-->
         ID1 CDATA #REQUIRED
     >      
]
<person>
    <name ID3="A1">zhangsan</name>
    <age ID2="AA">20</age>
    <sex></sex>
    <school>111</school>
    <birthday ID1="AAA">2015</birthday>
</person>
```

- 属性值类型：

     CDATA:表示属性为字符串类型。

     ENUMERATED(dtd没有此关键字)：表示枚举，只能在一定的范围内出现值，且每次只能出现其中一个。

  ​                             红绿灯效果；

  ​                             (aa|bb|cc)

​          ID:表示只能是字母或_开头

- 属性约束设置：

  ​          #REQUIRED:表示该属性必须出现。

  ​          #IMPLOED:表示属性可有可无 。

  ​         #FIXED:表示属性的取值为一个固定值。  #DIXED "AAA"

​                直接值： <!ELEMENT school (#PCDATA)>

​                                 <!ATTLIST school

​                                         ID5  DATATA "www"

​                                  >

​                             <school ID5="ttt">111</school>    是正确的   ID5=ttt

​                             <school>111</school>           是正确的   ID5=www

![1588329521998](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588329521998.png)

## 定义实体

![1588329614636](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588329614636.png)

```
<!xml version="1.0" ecoding="UTF-8?">
<!DOCTYPE person[
    <!ELEMENT person(name,age,sex,school,birthday)>
    <!ELEMENT name(#PCDATA)>
    <!ATTLIST name             <!--ID-->
        ID3 ID #REQUIRED
    <!ELEMENT age(#PCDATA)>
    <!ATTLIST age              <!--枚举-->
        ID2(AA|BB|CC) #REQUIRED
    <!ELEMENT sex EMPTY>
    <!ELEMENT school ANY>
    <!ELEMENT birthday(#PCDATA)>
    <!ATTLIST birthday           <!--CDATA-->
         ID1 CDATA #REQUIRED
     >
     <!ENTITY TEST "HAHAHAHA">   //定义实体需要写在内部的DTD里，写在外部dtd中浏览器可能不能识别
]
<person>
    <name ID3="A1">&TEST;</name>    //引用实体 显示：<name ID3="A1">HAHAHAHA</name>
    <age ID2="AA">20</age>
    <sex></sex>
    <school>111</school>
    <birthday ID1="AAA">2015</birthday>
</person>


```

## W3C案例

TV.dtd

```XML
<!ELEMENT TVSCHEDULE (CHANNEL+)>
<!ELEMENT CHANNEL (BANNER,DAY+)>
<!ELEMENT BANNER (#PCDATA)>
<!ELEMENT DAY (DATE,(HOLIDAY|PROGRAMSLOT+)+)>
<!ELEMENT HOLIDAY (#PCDATA)>
<!ELEMENT DATE (#PCDATA)>
<!ELEMENT PROGRAMSLOT (TIME,TITLE,DESCRIPTION?)>
<!ELEMENT TIME (#PCDATA)>
<!ELEMENT TITLE (#PCDATA)> 
<!ELEMENT DESCRIPTION (#PCDATA)>

<!ATTLIST TVSCHEDULE NAME CDATA #REQUIRED>
<!ATTLIST CHANNEL CHAN CDATA #REQUIRED>
<!ATTLIST PROGRAMSLOT VTR CDATA #IMPLIED>
<!ATTLIST TITLE RATING CDATA #IMPLIED>
<!ATTLIST TITLE LANGUAGE CDATA #IMPLIED>
```

TV.xml

```XML
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE TVSCHEDULE SYSTEM "TV.dtd">
<TVSCHEDULE NAME="CCTY">
    <CHANNEL CHAN="CCCC">
        <BANNER>aaaaa</BANNER>
        <DAY>
            <DATE>20150101</DATE>
            <HOLIDAY>*****</HOLIDAY>
        </DAY>
        <DAY>
            <DATE>20150202</DATE>
            <PROGRAMSLOT VTR="SSS">
                <TIME>1990</TIME>
                <TITLE>test</TITLE>
            </PROGRAMSLOT>
        </DAY>
    </CHANNEL>
</TVSCHEDULE>
```

# XML解析

## XML解析简介（涉及Java代码）***

- xml是标记型文档
- js使用dom来解析标记型文档
  - ​    根据html的层级结构，在内存中分配一个树形结构，把html的标签，属性和文本都封装成对象
  - document对象、 element对象、属性对象、文本对象、Node

节点对象

- xml的解析方式（技术）：dom和sax

  DOM:Document Object Model,文档对象模型，是W3C推荐的处理项目xml的一种方式。

  SAX：Simple API for XML,Z这种方式不是官方标准，属于开源社区XML-DEV，几乎所有的xml解析器都支持它。

举例：

```xml
<?sml version="1.0"?>
<root>
    <head>
        <title>example</title>
    </head>
    <body>
        <p>content1</p>
        <p>content2</p>
    </body>
    <foot>
        <author name="lisi"/>
    </foot>
</root>
```

**用DOM进行解析**：根据xml的层级结构，在内存中分配一个树形结构，吧xml中每部分都封装成对象。

![1588486841857](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588486841857.png)

优点：方便做增删改操作。

缺点：文件过大，容易造成内存溢出。

**用SAX进行解析**：采用事件驱动，边读边解析。从上道到下一行一行解析，解析到某一个对象，返回对象名称。

优点：不会造成内存溢出，方便实现查询

缺点：不能进行增删改操作。

### JAXP API查看

想要解析xml，首先需要解析器。

#### sun公司提供了针对dom和sax的解析器：jaxp（Java自己的）

- JAXP(Java API for XML Processing)开发包是JavaSE的一部分，它由一下几个包及其子包组成：

  - org.w3c.dom:提供DOM方式解析XML的标准接口
  - org.xml.sax:提供SAX方式解析XML的标准接口
  - javax.xml:提供了解析xml文档的类

- javax.xml.parsers包中，定义了几个工厂类。我们可以调用这些工厂类，得到对XML文档进行解析的DOM和SAX解析器对象

  **DOM方式**

  - DocumentBuilder：解析器类 ，是一个抽象类 。不能new 。

    ​    1.此类的实例可以从 DocumentBuilderFactory.newDocumentBuilder()方法获取

    ​    2.解析xml  ：parse("xml路径") 返回的时Document整个文档  。返回的document是一个接口 ，父节点是Node，如果我们在document里面找不到想要的方法，就到Node里面去找。

    ​    3.在document里面的方法：

    ​         **getElementByTagName(String tagname)**:这个方法可以得到标签，返回集合NodeList 

    ​         **createElement(String tagName)**:创建标签

    ​         **createTextNode(String data)**:创建文本

    ​         getElementsByTagName(String tagname): 返回NodeList按文档顺序返回包含在文档中且具有给定标记名称的所有Element和NodeList

    ​     4.在Node中的方法：

    ​          **appendChild(Node newChild)**:把文本添加到标签下面

    ​          **removeChild(Node oldChild)**:删除节点

    ​          **getParentNode():**获取父节点

    ​       5.在NodeList中的方法：

    ​          **getLength()：**得到集合的长度

    ​          **item(int index):**根据下标取到具体的值 

    遍历：
  
    ```Java
    for(int i=0;i<list.getLength();i++){
        list.item(i);
  }
    ```

    ​         **getTextContent()**:得到标签中的内容

  - DocumentBuilderFactory：解析器工厂，抽象类。不能new 

    ​    此类可以用newInstance()获取DocumentBuilderFactory的实例

    **SAX方式**
  
    事件驱动，边读边解析，不能实现增删改操作，只能查询
  
  - SAXParser：解析器的类 (抽象类，不能new)
  
      1.此类的实例可以从SAXParserFactory.newSAXParser()方法获得    
  
    2. parse(File f,DefaultHandler dh)  传入xml路径，事件处理器（相当于在一个方法中绑定了一个事件,自动执行事件）
  
    3. DefaultHandler中的方法：
  
         ![1588747394284](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588747394284.png)
  
  - SAXParserFactory：解析器工厂（抽象类）
  
    此类的实例可以通过newInstance()方法获得
    
    p1.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<person>
    <p1>
        <name>zhangsan</name>
        <age>20</age>
    </p1>
    <p1>
        <name>lisi</name>
        <age>30</age>
    </p1>
</person>
```

#### 遍历所有(SAX)

TestSax.java

```java
public class TestSax{
    public static void main(String[] args)throws Exception{
        //创建解析器工厂
        SAXParserFactory saXParserFactory=SAXParserFactory.newInsatnce();
        //创建解析器
        SAXParser saxParser=sazParserFactory.newSAXParser();
        //执行parse方法，第一个参数xml路径，第二个参数是事件处理器
        saxParser.parser("src/p1.xml",new MyDefault1);  //dh=DefaultHandler
        //自己创建一个类继承dh并重写三个方法，在上面传进来即可执行
    }
}
class MyDefault1 extends DefaultHandler{
    @Override
    public void startElement(String uri,String localName,String                           qName,Attributes attributes)throws SAXException{
        System.out.print("<"+qName+">");
    }
    @Override
    public void characters(char[] ch,int start,int length)
                  throws SAXException{
        System.out.println(new String(ch,start,lengrh));
    }
    @Override
    public void endElement(String uri,String localName,String qName)
                  throws SAXException{
        System.out.println("</"+qName">");
    }
}
```

执行结果：

![1588818110834](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588818110834.png)

#### 获取所有name元素的值（SAX）

TestSax.java

```java
public class TestSax{
    public static void main(String[] args)throws Exception{
        //创建解析器工厂
        SAXParserFactory saXParserFactory=SAXParserFactory.newInsatnce();
        //创建解析器
        SAXParser saxParser=sazParserFactory.newSAXParser();
        //执行parse方法，第一个参数xml路径，第二个参数是事件处理器
        saxParser.parser("src/p1.xml",new MyDefault2);  //dh=DefaultHandler
        //自己创建一个类继承dh并重写三个方法，在上面传进来即可执行
    }
}
class MyDefault2 extends DefaultHandler{
    boolean flag=false;
    @Override
    public void startElement(String uri,String localName,String                           qName,Attributes attributes)throws SAXException{
       //判断qName是否是name元素
        if("name".equals(qName)){
            flag=true;
        }
    }
    @Override
    public void characters(char[] ch,int start,int length)
                  throws SAXException{
     //当flag值是true时，表示解析到name元素
        if(flag==true){
            System.out.println(new String(ch,start,length));
        }
    }
    @Override
    public void endElement(String uri,String localName,String qName)
                  throws SAXException{
        //把flag设置为false，表示name元素结束
        if("name".equals(qName)){
            flag=false;
        }
    }
}
```

执行结果：

zhangsan

lisi

#### 获取第一个name元素的值（SAX)

TestSax.java

```Java
public class TestSax{
    public static void main(String[] args)throws Exception{
        //创建解析器工厂
        SAXParserFactory saXParserFactory=SAXParserFactory.newInsatnce();
        //创建解析器
        SAXParser saxParser=sazParserFactory.newSAXParser();
        //执行parse方法，第一个参数xml路径，第二个参数是事件处理器
        saxParser.parser("src/p1.xml",new MyDefault2);  //dh=DefaultHandler
        //自己创建一个类继承dh并重写三个方法，在上面传进来即可执行
    }
}
class MyDefault2 extends DefaultHandler{
    boolean flag=false;
    int idx=1;
    @Override
    public void startElement(String uri,String localName,String                           qName,Attributes attributes)throws SAXException{
       //判断qName是否是name元素
        if("name".equals(qName)){
            flag=true;
        }
    }
    @Override
    public void characters(char[] ch,int start,int length)
                  throws SAXException{
     //当flag值是true时，表示解析到name元素
        //索引为1
        if(flag==true&&idx==1){
            System.out.println(new String(ch,start,length));
        }
    }
    @Override
    public void endElement(String uri,String localName,String qName)
                  throws SAXException{
        //把flag设置为false，表示name元素结束
        if("name".equals(qName)){
            flag=false;
            idx++;
        }
    }
}
```

执行结果：zhangsan

改if(flag==true && idx=2)时

执行结果为：lisi

#### 使用jaxp实现查询操作（DOM)

person.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<person>
    <p1>
        <name>zhangsan</name>
        <age>20</age>
    </p1>
    <p1>
        <name>lisi</name>
        <age>30</age>
    </p1>
</person>
```

查询xml中所有name标签的值

cn.itcast.jaxptest包中创建TestJaxp.java

```Java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
        //查询所有name元素的值
        /* 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到所有的name元素
         * 5.遍历集合，得到每一个name元素
         **/
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        Document document=builer.parse("src/persion.xml");
        NodeList list=document.getElementsByTagName("name");
        for(int i=0;i<list.getLength();i++){
            Node name1=list.item(i);   //得到每一个name元素
            String s=name1.getTestContent();    //得到name元素里的值
            System.out.println(s); //会打印出zhangsan  lisi
        }
    }
}
```

#### 使用JAXP查询某一个节点(DOM)

查询person.xml中第一个name元素的值

 TestJaxp.java

```Java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
        selectSin();   //zhangsan
    }
        public static void selectSin() throws Exception{    //查询xml中第一个name元素的值
        /*1.创建解析器工厂
         *2.根据解析器工厂创建解析器
         *3.解析xml返回document
         *4.得到所有name元素
         *5.返回集合，使用里面的方法item获取 具体的元素
         *6.得到具体的值，使用getTextContent()
         **/
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        Document document=builer.parse("src/persion.xml");
        NodeList list=document.getElementsByTagName("name");
        Node name1=list.item(0);       //使用下标得到第一个元素 item(i) 会返回lisi
        String s1=name1.getTextContent();   //得到name里面具体的值
        System.out.println(s1);
        }
}
```

#### 使用JAXP添加节点(DOM)

在person.xml的第一个<p1>标签中添加性别<sex>

TestJaxp.java

```java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
       addSex(); 
    }
    //在 第一个<p1>下面添加<sex>nv</sex>
    public static void addSex() throws Exception{
        /* 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到第一个p1：得到所有的p1，使用item方法的到第一个
         * 5.创建sex标签：createElement
         *6.创建文本：createTestNode
         *7.把文本添加到sex下：appendChild
         *8.把sex添加到第一个p1下
         *9.回写到xml
         **/
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        Document document=builer.parse("src/persion.xml");
        NodeList list=document.getElementsByTagName("p1");  //得到所有的p1
        Node p1=list.item(0);
        Element sex1=document.createElement("sex");           //创建标签
        Text text1=document.createTestNode("nv");       //创建文本
        sex1.appendChild(text1);   //把文本添加到sex1下
        p1.appendChild(sex1); //把sex1添加到p1下面
        //回写到person .xml
        TransformerFactory  transformerFactor=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        transformer.tansform(new DOMSource(document),new StreamResult("src/person.xml"));
    }
}
```

#### 使用JAXP修改节点(DOM)

在person.xml中修改第一个p1下面的sex内容是nan

TestJaxp.java

```Java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
       modifySex(); 
    }
    //在 第一个<p1>下面修改为<sex>nan</sex>
    public static void modifySex() throws Exception{
        /* 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到sex 用item方法
         * 5.修改sex中的值 用setTextContent方法
         * 6.回写到xml
         **/
        //创建解析器工厂
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        //得到document
        Document document=builer.parse("src/persion.xml");
        //得到sex
        Node sex1=document.getElementsByTagName("sex").item(0);  
        //修改sex的值****
        sex1.setTextContent("nan");
        p1.appendChild(sex1); //把sex1添加到p1下面
        //回写到person .xml
        TransformerFactory  transformerFactor=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        transformer.tansform(new DOMSource(document),new StreamResult("src/person.xml"));
    }
}
```

#### 使用JAXP删除节点(DOM)

在person.xml中删除sex节点 

TestJaxp.java

```Java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
       delSex(); 
    }
    //在 第一个<p1>下面删除<sex>
    public static void delSex() throws Exception{
        /* 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         * 4.得到sex 用item方法
         * 5.获取sex的父节点
         * 6.使用父节点删除 用removeChild方法
         * 7.回写到xml
         **/
        //创建解析器工厂
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        //得到document
        Document document=builer.parse("src/persion.xml");
        //得到sex元素
        Node sex1=document.getElementsByTagName("sex").item(0);  
        //得到sex1的父节点
        Node p1=sex1.getParentNode();
        //删除操作
        p1.removeChild(sex1);
        //回写到person .xml
        TransformerFactory  transformerFactor=TransformerFactory.newInstance();
        Transformer transformer=transformerFactory.newTransformer();
        transformer.tansform(new DOMSource(document),new StreamResult("src/person.xml"));
    }
}
```

#### 使用JAXP来遍历节点(DOM)

把person.xml中的所有元素名称打印出来

TestJaxp.java

```Java
import org.w3c.dom;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class TestJaxp{
    public static void main(String[] args) throws Exception{
       listElement(); 
    }
    //把所有元素名称打印出来
    public static void listElement() throws Exception{
        /* 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml返回document
         *===使用递归实现
         * 4.得到根节点
         * 5.得到根节点的子节点
         * 6.得到子节点的子节点
         **/
        //创建解析器工厂
        DocumentBuilderFactory  builderFactory=DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder=builderFactory.newDocumentBuilder();
        //得到document
        Document document=builer.parse("src/persion.xml");
        //递归方法实现遍历
        list1(document);
    }
    private static void list1(Node node){ 
        //判断他是元素类型时才打印
        if(node.getNodeType()==Node.ELEMENT_NODE){
           System.out.println(node.getNodeName());
        }
        //得到一层子节点
        NodeList list=node.getChildNodes();
        for(int i=0;i<list.length();i++){
            Node node1=list.item(i);
            list1(node1);
        }
    }
}
```

### 

## dom4j

1.导入包：dom4j-1.6.jar

2.得到document

```java 
SAXReader reader=new SAXReader();
Document document=reader.read(url);
```

*document的父接口是Node：如果在document里找不到，到Node里找

*document里的方法：getRootElement():获取根节点，返回的时Element

*Element也是一个接口，父接口是Node

​       -—Element和Node里的方法：

​             getParent():获取父节点

​             addElement():添加标签

### 获取所有name元素的值

![1588993567196](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588993567196.png)

p1.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<person>
    <p1>
        <name>zhangsan</name>
        <age>20</age>
    </p1>
    <p1>
        <name>lisi</name>
        <age>30</age>
    </p1>
</person>
```

TestDem4j.java

```java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dem4j Element;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        selectName();
    }
    public static void selectName()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到p1
        //5.得到p1下面的name
        //得到name的值
        // 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到p1
        List<Element> list=root.elements("p1");
        //遍历list
        for(Element element:list){
            //element是每一个p1元素 
            //得到p1下面的name元素
            Element name1=element.element("name");
            //得到name里的值
            String s=name1.getText();
            System.out.println(s);
        }
    }
}
```

执行结果：

zhangsan

lisi

### 获取第一个name元素的值





TestDom4j.java

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dem4j Element;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        selectSin();
    }
    public static void selectSin()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1元素
        //5.得到p1下面的name
        //6.得到name的值
        // 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.elements("p1");
        //得到p1下的name
        Element name1=p1.element("name");
        //得到name里的值
        String s=name1.getText();
        System.out.println(s);
    }
}
```

执行结果：

zhangsan

### 获取第二个name元素里的值

TestDom4j.java

```java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dem4j Element;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        selectSecond();
    }
    public static void selectSecond()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到所有p1
        //5.遍历得到第二个p1
        //6.得到p1下的name
        //7.得到name的值
        // 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到p1
        List<Element> list=root.elements("p1");
        //得到第二个p1，
        Element p2=list.get(1);
       //得到p1下面的name元素
        Element name2=p2.element("name");
       //得到name里的值
       String s=name2.getText();
      System.out.println(s2); 
    }
}
```

执行结果：

lisi

### 实现在末尾添加节点的操作

在第一个p1标签末尾添加一个<sex>

TestDom4j.java

```java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dem4j Element;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        addSex();
    }
    public static void addSex()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.在p1下添加元素
        //6.添加的元素下添加文本
        //7.回写
        // 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到p1
        Element p1=root.element("p1");
        //在p1下直接添加元素
       Element sex1=p1.addElement("sex");
       //在sex下添加文本
       sex1.setText("nv");
        //回写
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
        //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter-new XMLWriter(new FileOutputStream("sec/p1.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
```

### 在特定的位置添加 元素

p1.xml

![1589152698607](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1589152698607.png)

需求：在第一个p1的age标签之前添加<school>en</school>

```java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        addAgeBefore();
    }
    public static void addAgeBefore()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.获取p1下面的所有元素  elements()，返回list，在list指定位置添加元素，,在元素下创建文本add（int index，E element）
        //6.回写
        // 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //获取p1下的所有元素
       List<Element> list=p1.elements();
        //创建元素
        Element school=DocumentHelper.createElement("school");
        //在school下创建文本
        school.setText("en");
       //在指定位置添加
       list.add(1,school);
        //回写
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
        //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter-new XMLWriter(new FileOutputStream("sec/p1.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
```

### dom4j里面封装方法的操作

Dom4jUtils.java    工具类     

封装// 创建解析器
        SAXReader saxReader=new SAXReader();
        //得到document
        Document documment=saxReader.read("src/p1.xml");

```Java
public class Dom4jUtils{
    //返回Document
    public static Document getDocument(String path){
        try{
        // 创建解析器
        SAXReader reader=new SAXReader();
        //得到document
        Document documment=saxReader.read(path);
        return document;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}    
```

修改前面的代码

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        addAgeBefore();
    }
    public static void addAgeBefore()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.获取p1下面的所有元素  elements()，返回list，在list指定位置添加元素，,在元素下创建文本add（int index，E element）
        //6.回写
        // 创建解析器
        //SAXReader saxReader=new SAXReader();
        //得到document
        // Document documment=saxReader.read("src/p1.xml");
        Document document=Dom4jUtils.getDocument("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //获取p1下的所有元素
       List<Element> list=p1.elements();
        //创建元素
        Element school=DocumentHelper.createElement("school");
        //在school下创建文本
        school.setText("en");
       //在指定位置添加
       list.add(1,school);
        //回写
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
        //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("sec/p1.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
```

封装回写操作

//回写
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
     //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream("sec/p1.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();

```Java
public class Dom4jUtils{
    //返回Document
    public static Document getDocument(String path){
        try{
        // 创建解析器
        SAXReader reader=new SAXReader();
        //得到document
        Document documment=saxReader.read(path);
        return document;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //回写xml的方法
    public static void xmlWriters(String path,Document document){
        try{
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
     //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(""),format);
        xmlWriter.write(document);
        xmlWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

修改前面的代码

```java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        addAgeBefore();
    }
    public static void addAgeBefore()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.获取p1下面的所有元素  elements()，返回list，在list指定位置添加元素，,在元素下创建文本add（int index，E element）
        //6.回写
        // 创建解析器
        Document document=Dom4jUtils.getDocument("src/p1.xml");
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //获取p1下的所有元素
       List<Element> list=p1.elements();
        //创建元素
        Element school=DocumentHelper.createElement("school");
        //在school下创建文本
        school.setText("en");
       //在指定位置添加
       list.add(1,school);
        //回写xxml
        Dom4jUtils.xmlWriters("src/p1.xml",document);
        
    }
}
```

封装路径

```Java
public class Dom4jUtils{
    public static final String PATH="src/p1.xml";
    //返回Document
    public static Document getDocument(String path){
        try{
        // 创建解析器
        SAXReader reader=new SAXReader();
        //得到document
        Document documment=saxReader.read(path);
        return document;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //回写xml的方法
    public static void xmlWriters(String path,Document document){
        try{
        OutputFormat format=OutputFormat.createPrettyPrint();  //有缩进的格式
     //OutputFormat format=OutputFormat.createCompactFormat();  压缩的格式
        XMLWriter xmlWriter=new XMLWriter(new FileOutputStream(""),format);
        xmlWriter.write(document);
        xmlWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
```

修改上面的代码

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        addAgeBefore();
    }
    public static void addAgeBefore()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.获取p1下面的所有元素  elements()，返回list，在list指定位置添加元素，,在元素下创建文本add（int index，E element）
        //6.回写
        // 创建解析器
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //获取p1下的所有元素
       List<Element> list=p1.elements();
        //创建元素
        Element school=DocumentHelper.createElement("school");
        //在school下创建文本
        school.setText("en");
       //在指定位置添加
       list.add(1,school);
        //回写xml
        Dom4jUtils.xmlWriters(Dom4jUtils.PATH,document); 
    }
}
```

### 修改节点的操作

修改第一个p1下面的age元素的20为300

![1589412462210](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1589412462210.png)

TestDom4j.java

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dem4j Element;
import java.util.List;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        modifyAge();
    }
    public static void modifyAge()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到所有p1
        //5.遍历得到第一个p1
        //6.得到第一个p1下面的age
        //7.修改值为30
        //8.回写xml
        // 创建解析器
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //得到p1下面的age
        Element age=p1.element("age");
        age.setText("300");
        //回写
        Dom4jUtils.xmlWriters(Dom4jUtils.PATH,document);
    }
}
```

### 删除节点的操作

删除p1下的school

![1589412947050](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1589412947050.png)

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
import cn.itcast.utils.Dom4jUtils;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        delSch();
    }
    public static void delSch()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.得到第一个p1下的school
        //6.使用p1删除school
        //7.回写
        // 创建解析器
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //得到p1下的school
        Element sch=p1.element("school");
        //通过父节点删除 首先的到父节点，这里已经有了，也可以用getParent（）方法
        p1.remove(sch);
        //回写xml
        Dom4jUtils.xmlWriters(Dom4jUtils.PATH,document); 
    }
}
```

### 获取属性值的操作

获取id1里面的值

![1589413422924](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1589413422924.png)

```Java
import org.dom4j.io.SAXreader;
import org dom4j Document;
import org dom4j DocumentHelper;
import org dem4j Element;
import org dom4j io.OutputFormat;
import org dom4j.io.XMLWriter;
import java.util.List;
import cn.itcast.utils.Dom4jUtils;
pubic class TestDem4j{
    public static void main(String[] args)throws Exception{
        getValues();
    }
    public static void getValues()throws Exception{
        //1.创建解析器
        //2.得到document
        //3.得到根节点
        //4.得到第一个p1
        //5.得到p1里的属性值
        // 创建解析器
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //得到根节点
        Element root=document.getRootElement();
        //得到第一个p1
        Element p1=root.element("p1");
        //得到p1里的属性值
        String value=p1.attributeValue("id1");
        System.out.println(value)
    }
}
```

执行结果：aaaa

### dom4j对XPATH的支持

直接获取某个元素

第一种形式

>/AAA/DDD/BBB:表示一层一层，AAA下面的DDD下面的BBB

第二种形式

>//BBB:所有的BBB
>
>//DDD/BBB:所有的DDD下的BBB

第三种形式

>/AAA/CCC/DDD/*:表示AAA下的CCC下的DDD下的所有元素
>
>/ * / * / * / BBB:表示三层下的BBB
>
>//*：表示所有

第四种形式

>/AAA/BBB[1]:AAA下的第一个BBB
>
>/AAA/BBB[last()]:AAA下的最后一个BBB

第五种形式

>//@id:只要标签上有id属性就都得到
>
>//BBB[@id]:只要BBB上面有id属性就都得到

第六中形式

>//BBB[@id='b1']: 属性id为b1的BBB
>
>//BBB[@name='bbb']：有属性name且值为bbb的BBB元素
>
>//BBB[normalize-space(@name)='bbb']:选择含有属性name且值（在用normalize-spac函数去掉前后空格后为bbb的BBB元素

*默认情况下dom4j不支持XPATH,如果想要在dom4j里面有XPATH需要实现以下步骤

>1.引入支持xpath的jar包，使用jaxen-1.1-bate-6.jar
>
>2.支持xpath的两种方法：
>
>​           获取多个节点：selectNodes("xpath的表达式")        
>
>​           获取一个节点：selectSingleNode("xpath的表达式")

![1589443498784](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1589443498784.png)

例1：查询xml中所有元素的值://name

```Java
public class TestDom4jXpath{
    public static void main(String[] args)throws Exception{
        test();
    }
    public static void test()throws Exception{
        //1.得到document
        //2.直接使用selectNodes方法得到所有的name元素
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //使用selectNodes
        List<Node>list=document.selectNodes("//name");
        //遍历list集合
        for(Node node:list){
            //node是每一个name元素,得到name元素中的值
            String s=node.getText();
            System.out.println(s);
        }
    }
}
```

 获取第一个p1下的那么的值   //p1[@id1='aaaa']/name

例：

```java 
public class TestDom4jXpath{
    public static void main(String[] args)throws Exception{
        test();
    }
    public static void test()throws Exception{
        //1.得到document
        //2.直接使用selectSINGLENode方法得到所有的name元素
        Document document=Dom4jUtils.getDocument(Dom4jUtils.PATH);
        //使用selectslngleNode
        Node name1=document.selectSingleNode("P1[@ID1='aaaa']/name");
       //得到name元素中的值
            String s=name1.getText();
            System.out.println(s);
        
    }
}
```

执行结果：zhangsan





在Maven中需要导入

![1590927650843](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1590927650843.png)







# Schema：基于xml的DTD替代者

## Schema的介绍

- XML Schema也是一种用于定义和描述XML文档结构和内容的模式语言，符合XML语法结构，其出现时为了克服DTD的局限性。
- 一个XML文件可以有多个Schema，多个schema使用名称空间区分（类似于Java中的包名）。
- DTD里面有PCDATA类型，但是在schema里面可以支持更多的数据类型 
  - 比如：年龄 只能是整数，在shcema可以直接定义一个整数类型。
- XML Schema比DTD定义的约束能力非常强大，可以对XML实例文档做出细致的语义限制。
- XML Schema不能像DTD一样定义实体，比DTD更复杂。

## Schema的开发过程

![1588586729688](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588586729688.png)

1.创建一个schema文件：.xsd    根节点为<schema></schema>

​     1.1看XML中有多少元素就写多少 <element name=""></element>

​     1.2看简单元素还是复杂元素

```xml
         复杂元素: <element name="person">
                      <complexType>
                          <sequence>
                              简单元素，顺序不能改变
                          </sequence>
属性定义：必须写在这个位置        <stribute name="id1" type="int" use="required"></stribute>
                       </complexType>
                    </element>
定义完属性<stribute></stribute>后:
    person.xml改为xsi:schemaLocation="http://www.itcast.cn/20151111 1.xsd" id1="123">
<sequence>表示顺序不能改变</sequence>
<all>表示只能出现一次</all>

<choice>表示只能出现简单元素中的一个</choice>
          简单元素<element name="name" type="string"></element>
                 <element name="age" type="int"></element>
maxOccurs:
<element name="name" type="string" maxOccurs="unbounded"></element>
unbounded表示可以出现任何次数
<any>表示任意元素</any>
```
​    1.3在被约束文件中引入约束文件

```xml
<person xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
        表示xml是一个被约束的文件
xmlns="http://www.itcast.cn/20151111"
        是约束文档里面targetNamespace
xsi:schemaLocation="http://www.itcast.cn/20151111 1.xsd">
        targetNnamespace 空格  约束文档的地址路径
```





2.在schema文件中

​     2.1属性 ：

xmlns="http://www.w3.org/2001/XMLSchema"  表示当前xml文件是一个约束文件

targetNamespace="http://www.itcast.cn/20151111" 使用schema约束文件可以直接通过这个地址引入约束条件

elementFormDefault="qualified" 表示质量良好

1.xsd

```xml
<?xml Version="1.0" encoding="UTF-8"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema"  
targetNamespace="http://www.itcast.cn/20151111"
elementFormDefault="qualified">
    <element name="person">
        <complexType>
            <sequence>
                <element name="name" type="string"></element>
                <element name="age" type="int"></element>
             </sequence>
        </complexType>
    </element>
</schema>
```

person.xml

：xsi表示这是一个命名空间

```xml
<?xml version="1.0" encoding="UTF-8"?>
<person xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"    
xmlns="http://www.itcast.cn/20151111"
xsi:schemaLocation="http://www.itcast.cn/20151111 1.xsd">
        <name>zhangsan</name>
        <age>20</age>
</person>
```

例子：node.xsd

![1588590025405](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588590025405.png)

命名空间的理解：

![1588592306550](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588592306550.png)



![1588592387253](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588592387253.png)



![1588592467801](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588592467801.png)



![1588592624538](C:\Users\dell\AppData\Roaming\Typora\typora-user-images\1588592624538.png)

### 

## 

# 案例

## 

### 









