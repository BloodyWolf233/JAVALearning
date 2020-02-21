# 二、JavaScript

- 2.1 [JavaScript基础](#2.1-JavaScript基础)
- 2.2 [ECMAScript](#2.2-ECMAScript)
- 2.3 [DOM基础](#2.3-DOM基础)
- 2.4 [BOM](#2.4-BOM)
- 2.5 [DOM](#2.5-DOM)
- 2.6 [事件监听机制](#2.6-事件监听机制)

## 2.1 JavaScript基础

- 概念：一门客户端脚本语言

  - 运行在客户端浏览器中的。每一个浏览器都有JavaScript的解析引擎
  - 脚本语言：不需要编译，直接就可以被浏览器解析执行了

- 功能：

  可以来增强用户和html页面的交互过程，可以来控制html元素，让页面有一些动态的效果，增强用户的体验。

- JavaScript发展史：

  1. 1992年，Nombase公司，开发出第一门客户端脚本语言，专门用于表单的校验。命名为 ： C--	，后来更名为：ScriptEase
  2. 1995年，Netscape(网景)公司，开发了一门客户端脚本语言：LiveScript。后来，请来SUN公司的专家，修改LiveScript，命名为JavaScript
  3. 1996年，微软抄袭JavaScript开发出JScript语言
  4. 1997年，ECMA(欧洲计算机制造商协会)，制定出客户端脚本语言的标准：ECMAScript，就是统一了所有客户端脚本语言的编码方式。

- JavaScript = ECMAScript + JavaScript自己特有的东西(BOM+DOM)

## 2.2 ECMAScript：客户端脚本语言的标准

### 2.2.1 基础语法

1. 与HTML结合方式

   1. 内部JS：

      定义`<script>`，标签体内容就是js代码

   2. 外部JS：

      定义`<script>`，通过src属性引入外部的js文件

   > 注意：
   >
   > 1. `<script>`可以定义在html页面的任何地方。但是定义的位置会影响执行顺序
   > 2. `<script>`可以定义多个。

2. 注释

   1. 单行注释：`//注释内容`
   2. 多行注释：`/*注释内容*/`

3. 数据类型

   1. 原始数据类型(基本数据类型)：
      1. number：数字。 整数/小数/NaN(not a number 一个不是数字的数字类型)
      2. string：字符串。 字符串  "abc" "a" 'abc'
      3. boolean: true和false
      4. null：一个对象为空的占位符
      5. undefined：未定义。如果一个变量没有给初始化值，则会被默认赋值为undefined
   2. 引用数据类型：对象

4. 变量

   - 变量：一小块存储数据的内存空间

   - Java语言是强类型语言，而JavaScript是弱类型语言。

     - 强类型：在开辟变量存储空间时，定义了空间将来存储的数据的数据类型。只能存储固定类型的数据
     - 弱类型：在开辟变量存储空间时，不定义空间将来的存储数据类型，可以存放任意类型的数据。

   - 语法：`var 变量名 = 初始化值;`

   - typeof运算符：获取变量的类型。

     > 注：null运算后得到的是object

5. 运算符

   1. 一元运算符：只有一个运算数的运算符
      ++，-- ， +(正号)  

      - ++ --: 自增(自减)
        - ++(--) 在前，先自增(自减)，再运算
        - ++(--) 在后，先运算，再自增(自减)
      - +(-)：正负号

      > 注意：
      >
      > 在JS中，如果运算数不是运算符所要求的类型，那么js引擎会自动的将运算数进行类型转换
      >
      > 其他类型转number：
      >
      > - string转number：按照字面值转换。如果字面值不是数字，则转为NaN（不是数字的数字）
      > - boolean转number：true转为1，false转为0

   2. 算数运算符：`+ - * / % ...`

   3. 赋值运算符：`= += -+....`

   4. 比较运算符：`< >= <= == ===(全等于)`

      比较方式：

      1. 类型相同：直接比较

         > 字符串：按照字典顺序比较。按位逐一比较，直到得出大小为止。

      2. 类型不同：先进行类型转换，再比较

         > ===：全等于。在比较之前，先判断类型，如果类型不一样，则直接返回false

   5. 逻辑运算符：`&& || !`

      其他类型转boolean：

      1. number：0或NaN为假，其他为真
       2. string：除了空字符串("")，其他都是true
       3. null&undefined:都是false
       4. 对象：所有对象都为true

   6. 三元运算符：`表达式 ? 值1 : 值2 `

      ```javascript
      var a = 3;
      var b = 4;
      var c = a > b ? 1:0;
      ```
      

判断表达式的值，如果是true则取值1，如果是false则取值2；

6. 流程控制语句

   1. if...else...

   2. switch:

      - 在java中，switch语句可以接受的数据类型： byte int shor char,枚举(1.5) ,String(1.7)

      - 在JS中,switch语句可以接受任意的原始数据类型

   3. while

   4. do...while

   5. for

7. JS特殊语法

   1. 语句以;结尾，如果一行只有一条语句则 ;可以省略 (不建议)
   2. 变量的定义使用var关键字，也可以不使用
      1. 用： 定义的变量是局部变量
      2. 不用：定义的变量是全局变量(不建议)

8. 练习：99乘法表

```javascript
<!DOCTYPE html>
		<html lang="en">
		<head>
		    <meta charset="UTF-8">
		    <title>99乘法表</title>
		    <style>
		        td{
		            border: 1px solid;
		        }
		
		    </style>
		
		    <script>
		
		        document.write("<table  align='center'>");
	
			        //1.完成基本的for循环嵌套，展示乘法表
			        for (var i = 1; i <= 9 ; i++) {
			            document.write("<tr>");
			            for (var j = 1; j <=i ; j++) {
			                document.write("<td>");
			                //输出  1 * 1 = 1
		                document.write(i + " * " + j + " = " + ( i*j) +"&nbsp;&nbsp;&nbsp;");
		
		                document.write("</td>");
		            }
		            /*//输出换行
		            document.write("<br>");*/
		
		            document.write("</tr>");
		        }
		
		        //2.完成表格嵌套
		        document.write("</table>");
		
		    </script>
		</head>
		<body>
		
		</body>
</html>
```

### 2.2.2 基本对象

1. Function：函数(方法)对象

   1. 创建：

      1. var fun = new Function(形式参数列表,方法体);  //忘掉吧

      2. 方法二

         ```javascript
         function 方法名称(形式参数列表){
             方法体
         }
         ```

      3. 方法三

         ```javascript
         var 方法名 = function(形式参数列表){
             方法体
         }
         ```

   2. 方法：

   3. 属性：

      length：代表形参的个数

   4. 特点：
      
         1. 方法定义是，形参的类型不用写,返回值类型也不写。
         2. 方法是一个对象，如果定义名称相同的方法，会覆盖。
         3. 在JS中，方法的调用只与方法的名称有关，和参数列表无关。
   4. 在方法声明中有一个隐藏的内置对象（数组），arguments,封装所有的实际参数。
      
   5. 调用：

      方法名称(实际参数列表);

2. Array：数组对象

   1. 创建：

      1. `var arr = new Array(元素列表);`
      2. `var arr = new Array(默认长度);`
      3. `var arr = [元素列表];`

   2. 常用方法

      1. join(参数)：将数组中的元素按照指定的分隔符拼接为字符串
      2. push()：向数组的末尾添加一个或更多元素，并返回新的长度。

   3. 属性

      length：数组的长度

   4. 特点：
             1. JS中，数组元素的类型可变的。
             2. JS中，数组长度可变的。

3. Boolean

4. Data：日期对象

   1. 创建：`var date = new Date();`
   2. 常用方法：
      1. toLocaleString()：返回当前date对象对应的时间本地字符串格式
      2. getTime()：获取毫秒值。返回当前如期对象描述的时间到1970年1月1日零点的毫秒值差

5. Math：数学对象

   1. 创建：

      特点：Math对象不用创建，直接使用。  Math.方法名();

   2. 常用方法：

      1. om()：返回 0 ~ 1 之间的随机数。 含0不含1
      2. ceil(x)：对数进行上舍入。
      3. floor(x)：对数进行下舍入。            
      4. round(x)：把数四舍五入为最接近的整数。

6. Number

7. String

8. RegExp：正则表达式对象

   1. 正则表达式：定义字符串的组成规则。

      1. 单个字符：[]

         如： [a] [ab] [a-zA-Z0-9_]

         - 特殊符号代表特殊含义的单个字符:

           \d:单个数字字符 [0-9]

           \w:单个单词字符[a-zA-Z0-9_]

      1. 量词符号：

         ?：表示出现0次或1次

         *：表示出现0次或多次

         +：出现1次或多次

         {m,n}：表示 m<= 数量 <= n

         - m如果缺省：{,n} 最多n次
         - n如果缺省：{m,} 最少m次

      2. 开始结束符号

         - ^：开始
         - $：结束

   2. 正则对象：

      1. 创建
         1. var reg = new RegExp("正则表达式");
         2. var reg = /正则表达式/;
2. 常用方法
         1. tet(参数):验证指定的字符串是否符合正则定义的规范
   
9. Global

   1. 特点：全局对象，这个Global中封装的方法不需要对象就可以直接调用。  方法名();

   2. 常用方法：

      1. encodeURI()：url编码

      2. decodeURI()：url解码

      3.  encodeURIComponent()：url编码,编码的字符更多

      4. decodeURIComponent()：url解码

      5. parseInt()：将字符串转为数字

         逐一判断每一个字符是否是数字，直到不是数字为止，将前边数字部分转为number

      6. isNaN()：判断一个值是否是NaN

         NaN六亲不认，连自己都不认。NaN参与的==比较全部问false

      7. eval()：讲JavaScript 字符串，并把它作为脚本代码来执行。

   3. URL编码

      例如：`我是帅逼` =  `%E6%88%91%E6%98%AF%E5%B8%85%E9%80%BC`

## 2.3 DOM基础

- 功能：控制html文档的内容

- 获取页面标签(元素)对象：Element

  document.getElementById("id值"):通过元素的id获取元素对象

- 操作Element对象：

  1.  修改属性值：
       		1. 明确获取的对象是哪一个？
       		2. 查看API文档，找其中有哪些属性可以设置

  2. 修改标签体内容：

     属性：innerHTML

     1. 获取元素对象
     2. 使用innerHTML属性修改标签体内容

![](../img/02/DOM树.bmp)

### 2.3.1 事件

- 功能： 某些组件被执行了某些操作后，触发某些代码的执行。

  例如： xxx被xxx,我就xxx

  - 我方水晶被摧毁后，我就责备对友。
  - 敌方水晶被摧毁后，我就夸奖自己。

- 如何绑定事件

  1. 直接在html标签上，指定事件的属性(操作)，属性值就是js代码

     事件：onclick---单击事件

  2. 通过js获取元素对象，指定事件属性，设置一个函数

```javascript
<body>
    <img id="light" src="img/off.gif"  onclick="fun();">
    <img id="light2" src="img/off.gif">
        <script>
            function fun(){
                alert('我被点了');
                alert('我又被点了');
            }

            function fun2(){
                alert('咋老点我？');
            }

            //1.获取light2对象
            var light2 = document.getElementById("light2");
            //2.绑定事件
            light2.onclick = fun2;
        </script>
</body>
```

### 2.3.2 案例1：点灯开关

- 分析：
  1. 获取图片对象
  2. 绑定单击事件
  3. 每次点击切换图片
- 规则：
  - 如果灯是开的 on,切换图片为 off
  - 如果灯是关的 off,切换图片为 on

```javascript
<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>电灯开关</title>
	
	</head>
	<body>
	
	<img id="light" src="img/off.gif">
	
	<script>
	    //1.获取图片对象
	    var light = document.getElementById("light");
	
	    var flag = false;//代表灯是灭的。 off图片
	
	    //2.绑定单击事件
	    light.onclick = function(){
	        if(flag){//判断如果灯是开的，则灭掉
	            light.src = "img/off.gif";
	            flag = false;
	
	        }else{
	            //如果灯是灭的，则打开
	
	            light.src = "img/on.gif";
	            flag = true;
	        }
	    }
	    
	</script>
	</body>
	</html>
```

## 2.4 BOM

1. 概念：Browser Object Model 浏览器对象模型
	
* 将浏览器的各个组成部分封装成对象。
	
2. 组成：
	* Window：窗口对象
	* Navigator：浏览器对象
	* Screen：显示器屏幕对象
	* History：历史记录对象
	* Location：地址栏对象

3. Window：窗口对象
    1. 创建
    
    2. 方法
    
       1. 与弹出框有关的方法：
          1. alert()：显示带有一段消息和一个确认按钮的警告框。
          2. confirm()：显示带有一段消息以及确认按钮和取消按钮的对话框。
             - 如果用户点击确定按钮，则方法返回true
             - 如果用户点击取消按钮，则方法返回false
          3. prompt()：显示可提示用户输入的对话框。
             - 返回值：获取用户输入的值
       2. 与打开关闭有关的方法：
          1. close()：关闭浏览器窗口。
             - 谁调用我 ，我关谁
          2. open()：打开一个新的浏览器窗口
             - 返回新的Window对象
       3. 与定时器有关的方式
          1. setTimeout()：在指定的毫秒数后调用函数或计算表达式。
             - 参数：
               1. js代码或者方法对象
               2. 毫秒值
             - 返回值：唯一标识，用于取消定时器
          2. clearTimeout()：取消由 setTimeout() 方法设置的 timeout。
          3. setInterval()：按照指定的周期（以毫秒计）来调用函数或计算表达式。
          4. clearInterval()：取消由 setInterval() 设置的 timeout。
    
    3. 属性：
    
       1. 获取其他BOM对象
    
          history
    
          location
    
          Navigator
    
          Screen
    
       2. 获取DOM对象
    
          document
    
    4. 特点
    
       - Window对象不需要创建可以直接使用 window使用。 window.方法名();
       - window引用可以省略。 方法名();
    
4. Location：地址栏对象

    1. 创建(获取)：
        1. window.location
        2. location
    2. 常用方法：
        1. reload()：重新加载当前文档。刷新
    3. 属性
        1. href：设置或返回完整的 URL。

5. History：历史记录对象

    1. 创建(获取)：

        1. window.history
        2. history

    2. 常用方法：

        1. back()：加载 history 列表中的前一个 URL。

        2. forward()：加载 history 列表中的下一个 URL。

        3. go(参数)：加载 history 列表中的某个具体页面。

            参数：

            - 正数：前进几个历史记录
            - 负数：后退几个历史记录

    3. 属性

        1. length：返回当前窗口历史列表中的 URL 数量。

## 2.5 DOM

- 概念： Document Object Model 文档对象模型

  - 将标记语言文档的各个组成部分，封装为对象。可以使用这些对象，对标记语言文档进行CRUD的动态操作

- W3C DOM 标准被分为 3 个不同的部分：

  - 核心 DOM - 针对任何结构化文档的标准模型

    - Document：文档对象

    - Element：元素对象

    - Attribute：属性对象

    - Text：文本对象

    - Comment:注释对象

      

    - Node：节点对象，其他5个的父对象

  - XML DOM - 针对 XML 文档的标准模型

  - HTML DOM - 针对 HTML 文档的标准模型

### 2.5.1 核心DOM模型

- Document：文档对象

  1. 创建(获取)：在html dom模型中可以使用window对象来获取
     1. window.document
     2. document
  2. 方法：
     1. 获取Element对象：
        1. getElementById()：根据id属性值获取元素对象。id属性值一般唯一
        2. getElementsByTagName()：根据元素名称获取元素对象们。返回值是一个数组
        3. getElementsByClassName()：根据Class属性值获取元素对象们。返回值是一个数组
        4. getElementsByName()：根据name属性值获取元素对象们。返回值是一个数组
     2. 创建其他DOM对象：
        1. createAttribute(name)
        2. createComment()
        3. createElement()
        4. createTextNode()
     3. 属性

- Element：元素对象

  1. 获取/创建：通过document来获取和创建
  2. 方法：
     1. removeAttribute()：删除属性
     2. setAttribute()：设置属性

- Node：节点对象，其他5个的父对象

  1. 特点：所有dom对象都可以被认为是一个节点

  2. 方法：

     CRUD dom树：

     1. appendChild()：向节点的子节点列表的结尾添加新的子节点。
     2. removeChild()：删除（并返回）当前节点的指定子节点。
     3. replaceChild()：用新节点替换一个子节点。

  3. 属性：

     1. parentNode 返回节点的父节点。

> 注意：
>
> 超链接功能：
>
> 1. 可以被点击：样式
> 2. 点击后跳转到href指定的url
>
> 如果不想跳转，可以`href="javascript:void(0);"`

### 2.5.2 HTML DOM

1. 标签体的设置和获取：innerHTML

2. 使用html元素对象的属性

3. 控制元素样式

   1. 使用元素的style属性来设置

      例如：

      ```javascript
      //修改样式方式1
      div1.style.border = "1px solid red";
      div1.style.width = "200px";
      //font-size--> fontSize
      div1.style.fontSize = "20px";
      ```

   2. 提前定义好类选择器的样式，通过元素的className属性来设置其class属性值。

## 2.6 事件监听机制

- 概念：某些组件被执行了某些操作后，触发某些代码的执行。
  - 事件：某些操作。如：单击，双击，键盘按下了，鼠标移动了
  - 事件源：组件。如：按钮 文本输入框...
  - 监听器：代码。
  - 注册监听：将事件，事件源，监听器结合在一起。当事件源上发生了某个事件，则触发执行某个监听器代码。
- 常见的事件：
  1. 点击事件：
     1. onclick：单击事件
     2. ondblclick：双击事件
  2. 焦点事件：
     1. onblur：失去焦点
     2. onfocus:元素获得焦点。
  3. 加载事件：
     1. onload：一张页面或一幅图像完成加载。
  4. 鼠标事件：
     1. onmousedown：鼠标按钮被按下。
     2. onmouseup：鼠标按键被松开。
     3. onmousemove：鼠标被移动。
     4. onmouseover：鼠标移到某元素之上。
     5. onmouseout：鼠标从某元素移开。
  5. 键盘事件：
     1.  onkeydown：某个键盘按键被按下。
     2. onkeyup：某个键盘按键被松开。
     3. onkeypress：某个键盘按键被按下并松开。
  6. 选择和改变：
     1. onchange：域的内容被改变。
     2. onselect：文本被选中。
  7. 表单事件：
     1. onsubmit：确认按钮被点击。
     2. onreset：重置按钮被点击。

## 2.7 综合案例

### 2.7.1 表格全选

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格全选</title>
    <style>
        table{
            border: 1px solid;
            width: 500px;
            margin-left: 30%;
        }

        td,th{
            text-align: center;
            border: 1px solid;
        }
        div{
            margin-top: 10px;
            margin-left: 30%;
        }

        .out{
            background-color: white;
        }
        .over{
            background-color: pink;
        }
    </style>

  <script>
      /*
        分析：
            1.全选：
                * 获取所有的checkbox
                * 遍历cb，设置每一个cb的状态为选中  checked

       */


      //1.在页面加载完后绑定事件
      window.onload = function(){
          //2.给全选按钮绑定单击事件
          document.getElementById("selectAll").onclick = function(){
                //全选
                //1.获取所有的checkbox
                var cbs = document.getElementsByName("cb");
                //2.遍历
                  for (var i = 0; i < cbs.length; i++) {
                      //3.设置每一个cb的状态为选中  checked
                      cbs[i].checked = true;
                  }
          }

          document.getElementById("unSelectAll").onclick = function(){
              //全不选
              //1.获取所有的checkbox
              var cbs = document.getElementsByName("cb");
              //2.遍历
              for (var i = 0; i < cbs.length; i++) {
                  //3.设置每一个cb的状态为未选中  checked
                  cbs[i].checked = false;
              }
          }

          document.getElementById("selectRev").onclick = function(){
              //反选
              //1.获取所有的checkbox
              var cbs = document.getElementsByName("cb");
              //2.遍历
              for (var i = 0; i < cbs.length; i++) {
                  //3.设置每一个cb的状态为相反
                  cbs[i].checked = !cbs[i].checked;
              }
          }

          document.getElementById("firstCb").onclick = function(){
              //第一个cb点击
              //1.获取所有的checkbox
              var cbs = document.getElementsByName("cb");
              //获取第一个cb

              //2.遍历
              for (var i = 0; i < cbs.length; i++) {
                  //3.设置每一个cb的状态和第一个cb的状态一样
                  cbs[i].checked =  this.checked;
              }
          }

          //给所有tr绑定鼠标移到元素之上和移出元素事件
          var trs = document.getElementsByTagName("tr");
          //2.遍历
          for (var i = 0; i < trs.length; i++) {
              //移到元素之上
              trs[i].onmouseover = function(){
                    this.className = "over";
              }

              //移出元素
              trs[i].onmouseout = function(){
                     this.className = "out";
              }

          }

      }



  </script>

</head>
<body>

<table>
    <caption>学生信息表</caption>
    <tr>
        <th><input type="checkbox" name="cb" id="firstCb"></th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>操作</th>
    </tr>

    <tr>
        <td><input type="checkbox"  name="cb" ></td>
        <td>1</td>
        <td>令狐冲</td>
        <td>男</td>
        <td><a href="javascript:void(0);">删除</a></td>
    </tr>

    <tr>
        <td><input type="checkbox"  name="cb" ></td>
        <td>2</td>
        <td>任我行</td>
        <td>男</td>
        <td><a href="javascript:void(0);">删除</a></td>
    </tr>

    <tr>
        <td><input type="checkbox"  name="cb" ></td>
        <td>3</td>
        <td>岳不群</td>
        <td>?</td>
        <td><a href="javascript:void(0);">删除</a></td>
    </tr>

</table>
<div>
    <input type="button" id="selectAll" value="全选">
    <input type="button" id="unSelectAll" value="全不选">
    <input type="button" id="selectRev" value="反选">
</div>
</body>
</html>
```



### 2.7.2 表单检验

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
<style>
    *{
        margin: 0px;
        padding: 0px;
        box-sizing: border-box;
    }
    body{
        background: url("img/register_bg.png") no-repeat center;
        padding-top: 25px;
    }

    .rg_layout{
        width: 900px;
        height: 500px;
        border: 8px solid #EEEEEE;
        background-color: white;
        /*让div水平居中*/
        margin: auto;
    }

    .rg_left{
        /*border: 1px solid red;*/
        float: left;
        margin: 15px;
    }
    .rg_left > p:first-child{
        color:#FFD026;
        font-size: 20px;
    }

    .rg_left > p:last-child{
        color:#A6A6A6;
        font-size: 20px;

    }


    .rg_center{
        float: left;
       /* border: 1px solid red;*/

    }

    .rg_right{
        /*border: 1px solid red;*/
        float: right;
        margin: 15px;
    }

    .rg_right > p:first-child{
        font-size: 15px;

    }
    .rg_right p a {
        color:pink;
    }

    .td_left{
        width: 100px;
        text-align: right;
        height: 45px;
    }
    .td_right{
        padding-left: 50px ;
    }

    #username,#password,#email,#name,#tel,#birthday,#checkcode{
        width: 251px;
        height: 32px;
        border: 1px solid #A6A6A6 ;
        /*设置边框圆角*/
        border-radius: 5px;
        padding-left: 10px;
    }
    #checkcode{
        width: 110px;
    }

    #img_check{
        height: 32px;
        vertical-align: middle;
    }

    #btn_sub{
        width: 150px;
        height: 40px;
        background-color: #FFD026;
        border: 1px solid #FFD026 ;
    }
    .error{
        color:red;
    }
    #td_sub{
        padding-left: 150px;
    }

</style>
<script>

    /*
        分析：
            1.给表单绑定onsubmit事件。监听器中判断每一个方法校验的结果。
                如果都为true，则监听器方法返回true
                如果有一个为false，则监听器方法返回false

            2.定义一些方法分别校验各个表单项。
            3.给各个表单项绑定onblur事件。



     */

    window.onload = function(){
        //1.给表单绑定onsubmit事件
        document.getElementById("form").onsubmit = function(){
            //调用用户校验方法   chekUsername();
            //调用密码校验方法   chekPassword();
            //return checkUsername() && checkPassword();

            return checkUsername() && checkPassword();
        }

        //给用户名和密码框分别绑定离焦事件
        document.getElementById("username").onblur = checkUsername;
        document.getElementById("password").onblur = checkPassword;
    }

    //校验用户名
    function checkUsername(){
        //1.获取用户名的值
        var username = document.getElementById("username").value;
        //2.定义正则表达式
        var reg_username = /^\w{6,12}$/;
        //3.判断值是否符合正则的规则
        var flag = reg_username.test(username);
        //4.提示信息
        var s_username = document.getElementById("s_username");

        if(flag){
            //提示绿色对勾
            s_username.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
        }else{
            //提示红色用户名有误
            s_username.innerHTML = "用户名格式有误";
        }
        return flag;
    }

    //校验密码
    function checkPassword(){
        //1.获取用户名的值
        var password = document.getElementById("password").value;
        //2.定义正则表达式
        var reg_password = /^\w{6,12}$/;
        //3.判断值是否符合正则的规则
        var flag = reg_password.test(password);
        //4.提示信息
        var s_password = document.getElementById("s_password");

        if(flag){
            //提示绿色对勾
            s_password.innerHTML = "<img width='35' height='25' src='img/gou.png'/>";
        }else{
            //提示红色用户名有误
            s_password.innerHTML = "密码格式有误";
        }
        return flag;
    }



</script>
</head>
<body>

<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>

    </div>

    <div class="rg_center">
        <div class="rg_form">
            <!--定义表单 form-->
            <form action="#" id="form" method="get">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right">
                            <input type="text" name="username" id="username" placeholder="请输入用户名">
                            <span id="s_username" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right">
                            <input type="password" name="password" id="password" placeholder="请输入密码">
                            <span id="s_password" class="error"></span>
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" id="email" placeholder="请输入邮箱"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="name">姓名</label></td>
                        <td class="td_right"><input type="text" name="name" id="name" placeholder="请输入姓名"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="tel">手机号</label></td>
                        <td class="td_right"><input type="text" name="tel" id="tel" placeholder="请输入手机号"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right">
                            <input type="radio" name="gender" value="male" checked> 男
                            <input type="radio" name="gender" value="female"> 女
                        </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="birthday" placeholder="请输入出生日期"></td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="checkcode" >验证码</label></td>
                        <td class="td_right"><input type="text" name="checkcode" id="checkcode" placeholder="请输入验证码">
                            <img id="img_check" src="img/verify_code.jpg">
                        </td>
                    </tr>


                    <tr>
                        <td colspan="2" id="td_sub"><input type="submit" id="btn_sub" value="注册"></td>
                    </tr>
                </table>

            </form>


        </div>

    </div>

    <div class="rg_right">
        <p>已有账号?<a href="#">立即登录</a></p>
    </div>


</div>


</body>
</html>
```

