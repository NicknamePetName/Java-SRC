


# 第二章 基本数据类型与数组  
· 标识符：由字母、下画线、美元符号、数字组成。`第一个字符不能是数字字符`  
· byte: 1个字节，-128~127 可以把int型常量赋值给byte.因为补码，所以负数多一  
· long型：十进制(108L)、八进制(071232L)、十六进制(0x3ABCL)  
· float:精度8  
· double:精度16 
· java键盘输入 
```  
    Scanner scanner = new Scanner(System.in);  
        int x = scanner.nextInt();
        scanner.hasNextInt();  判断输入是否为整数
```
· 声明数组+分配空间
``` 
    float boy[];  float a[][];  
    char[] cat;   char[][]b;  
    boy = new float[2];  
    float boy[] = new float[2];  声明和分配空间同时完成  
    float a[][] = new float[3][2];  
    float boy[] = { 21.3f,23.89f,2.0f,23f,778.98f};
```
# 第三章 运算符、表达式、语句
· instanceof 运算符，判断对象是否是类的,true,false
``` 
    String s=new String("abc");  
    if(s instanceof  String)  
        System.out.println("s是String对象");  
```
# 第四章 类与对象
· boolean:默认值false  
· char:默认是'\\0'(空字符)  
· float/double:默认值 0.0  
· 对于"引用型"变量(数组、对象)：默认值null  
· 局部变量没有默认值，需要赋值，否则编译错误  
```
    class  A    {  
        int a=12; //声明成员变量并指定初始值12  
        int b; //声明成员变量默认初始值0  
        b=12;  //错误，这是语句  只能在方法中赋值
    }
```
· 可变参数,这些参数的类型必须相同  
`   public void f(double item, int … x)`  
`   public void g(int … x)`  
```  
    public int getSum(int... x) {//x可变参数的参数代表  可传数组为参数
        int sum=0,sun=0;  
        for(int i=0;i<x.length;i++) {  
            sum=sum+x[i];  
        }  
        for(int parm:x) {  
            sun +=x[i];  
        }  
        return sum;  
    }  
```
· 类变量也称static 变量、静态变量  
· 类变量与实例变量的区别  P86  
1. 不同对象的实例变量互不相同    
2. *所有对象共享类变量*    
3. 通过类名直接访问类变量    类的字节码加载到内存，该类没有创建对象，实例变量不分配内存，类变量分配内存(共享内存)，程序退出(结束)后才释放内存。
```
    class Dog {
        float x;            //实例变量
        static int y;       //类变量 
        
    }
```
· 实例方法(不加static),类方法加(static)  
· 实例方法和类方法的区别  P88  
1. 对象调用实例方法  创建对象才有(实例)方法入口地址，且被所有对象共享，所有对象都不存在时，(实例)方法入口才消失  
   实例方法可以操作：实例变量和类变量，可以调用：实例方法和类方法(不包括构造方法)  *不能通过类名调用*
2. 类名调用类方法  类加载到内存就分配了入口地址，可以被类创建的任何对象调用、执行，还可以直接通过*类名*调用，程序退出入口消失
3. 设计类方法的原则  不需要操作类中的任何实例变量和方法   即可  

· 方法重载与多态  
1. 两种多态：重载(Overload) 重写(Override),重写是与继承有关的多态  
2. 方法重载的意思是：一个类中可以有多个方法具有相同的名字，但这些方法的参数的个数不同，或者是参数的类型不同  
3. 构造方法也可以重载，但构造方法不参与和非构造方法之间的重载比较  

· 方法重载的语法规则
1. 参数的个数不同
2. 参数的个数相同，但参数列表中对应的某个参数的类型不同  
3. 注：方法的返回类型和参数的名字不参与比较

· 避免重载出现歧义  static void Dog(int a,double b);   static void Dog(double a,int b);   Dog(10,10)则出错  
· this关键字 this可以出现在实例方法和构造方法中，不可以出现在类方法中  
· 引入类库中的类  (import 语句)  
1. java.long 包含所有的基本语言类(见第8、12章)
2. javax.swing 包含抽象窗口工具集中的图形、文本、窗口GUI类(见第9章)
3. java.io 包含所有的输入、输出类(见第10章)
4. java.util 包含实用类(见第8章)
5. java.sql 包含操作数据库的类(见第11章)
6. java.net 包含所有实现网络功能的类(见第13章)
7. 如果要引入一个包中的所有类，则可以用通配符"\*"来代替如：import java.util.\*  

## 访问权限
`静态————>类名`   `非静态————>对象`  
` 类方法:只能访问——>类变量        实例方法:可以访问———>实例变量、类变量（所有成员变量） `  
`访问权限： public———>protected————>友好(默认)类————>private`  
`不能用protected,private修饰类（但可以修饰内部类）`  

· 私有变量和私有方法(private)  
1. 私有变量和私有方法  `不能`  在任何类中通过 `对象` 操纵和调用 自己的变量和方法  
2. 私有类变量(private静态成员变量)，私有类方法(~)，`不能`  在任何类中通过 `类名` 操纵和调用 自己的类变量和类方法  

· 公有变量和公有方法(public)  
1. 公有变量和公有方法  `可以`  在任何类中通过 `对象` 操纵和调用 自己的变量和方法  
2. 公有类变量(private静态成员变量)，公有类方法(~)，`可以`  在任何类中通过 `类名` 操纵和调用 自己的类变量和类方法  

· 友好变量和友好方法(默认的，不用private、protected、publicxiushid)  
1. 友好变量和友好方法，在 `相同包` 中,所有类 `可以` 通过 `对象`操纵和调用 自己的变量和方法  
2. 友好类变量和友好类方法，在 `相同包` 中,所有类 `可以` 通过 `类名`操纵和调用 自己的类变量和类方法  

· 受保护的变量和方法(protected)  
1. 受保护的变量和方法，在 `相同包` 中,所有类 `可以` 通过 `对象`操纵和调用 自己的变量和方法  
2. 受保护的类变量和类方法，在 `相同包` 中,所有类 `可以` 通过 `类名`操纵和调用 自己的类变量和类方法  

· public类和友好（默认）类
1. 在另一个类中使用友好类创建对象时要保证他们在同一个包中  
![访问权限级别](https://github.com/NicknamePetName/Photo/blob/main/java/JavaSyntaxPhoto/%E8%AE%BF%E9%97%AE%E6%9D%83%E9%99%90%E4%BC%98%E5%85%88%E7%BA%A7.png?raw=true)

· character类实现了对char基本型数据的类包装  P104  
· var局部变量: 必须显示指定初值(不可以为null),方法的参数和返回类型不可以用var声明  
  var是保留类型名称，不是Java关键字，var可以用作变量和方法，但不能作为类或接口的名称  

· jar文件 P106  
· 文档生成器 javadoc.exe 可以制作源文件中类的组成结构的html文档  

# 第五章 子类与继承
· 在同一包中，子类不能继承private成员变量 和 private方法   
· 不在同一包中，子类不能继承private,友好(默认)成员变量和方法   
· protect (对象的调用须在同一包中)  继承的进一步说明  P127   
· 子类的构造方法创建了一对象时，子类本身和父类成员变量都分配了内存空间  
· 子类、父类不在一个包中，子类不继承父类的友好(默认)成员变量，子类从父类继承的方法可以操作未来继承的成员变量  
· 子类继承的方法只能操作父类的成员变量，不能操作子类新增的成员变量  

· **instancdof运算符**：对象<——左，右——>类，左边是右边的类或子类创建的对象时，则instancdof运算结果是true,反之则false  

`**成员变量的隐藏**：子类声明的成员变量与其继承的成员变量名相同  *特点如下*：`  
1. 子类对象以及子类自己定义的方法操作与父类同名的成员变量是指子类重新声明的这个成员变量  
2. 子类对象可以调用继承的方法操作被子类隐藏的成员变量  
· 注:子类继承的方法可以操作子类继承和隐藏的成员变量，不可以操作子类新声明的的成员变量。子类新定义的方法可以操作子类继承和子类新声明的哦哦成员变量，但无法操作子类隐藏的成员变量（需使用super关键字操作隐藏的成员变量）  

· 方法重写：子类重写方法的名字、参数个数、参数类型、返回值类型必须和父类相同  
· 方法重写可以操作继承的成员变量和方法，新声明的成员变量、调用新定义的其他方法，隐藏的成员变量和方法需要用super关键字   
· 父类的方法是Object类型，子类重写的方法类型是Integer类型  
· 重写父类的方法时，只能提高访问权限  

· super操作被隐藏的成员变量和方法  
· 子类的构造方法创建一个子类对象时，子类的构造方法总是先调用父类的某个构造方法，子类没有显示指明使用父类的那个构造方法，则调用不带参的  
· 子类不继承构造方法，所以子类需要用super(arge1)调用父类的构造方法，并且super是子类构造方法的头一个语句  
· 注：为避免编译出错，父类应定义一个无参构造方法  

· final关键字：final类不能被继承，final方法不允许继承，不允许隐藏，成员、局部变量被fianl修饰则变为常量，所以声明时必须指定该常量的值   

· 对象的上转型对象：实体是子类创建的  
1. 上转型对象不能访问子类新增的成员变量，不能调用子类新增的方法   
2. 上转型对象可以访问子类继承和隐藏的成员变量，亦可以调用子类继承和重写的方法(调用重写的方法等同于子类对象的调用)  
· 注：可以将上转型对象在强制转换为子类对象，这是具备子类的所有属性与功能  
· 注：子类重写了父类静态方法，则子类对象的上转型对象不能调用子类重写的静态方法，只能调用父类的静态方法  
![上转型对象](https://github.com/NicknamePetName/Photo/blob/main/java/JavaSyntaxPhoto/%E4%B8%8A%E8%BD%AC%E5%9E%8B%E5%AF%B9%E8%B1%A1.png?raw=true)
                

· abstract方法：只允许声方法，不允许实现。不允许final和abstract同时修饰一个方法或类。不允许static,private修饰abstract方法  
· abstract类：abstract类中可以有abstract方法和非abstract方法。非abstract类中不可以有abstract方法  
· abstract类：不能用new创建对象，非抽象子类必须重写抽象父类的抽象方法   
· 一个abstract类是abstract类的子类，它可以重写父类的abstract方法，亦可以继承abstract类的方法  
· abstract类的对象做上转型对象：使用abstract类声明对象，不能用new创建对象，但该对象可以成为其子类的上转型对象，就可以调用子类重写的方法  
`对象可以赋值为null  (Test test = null;)`   


# 第六章 接口
· public abstract float getName();   <==等价==>    float getName();  
· public static final int r = 100;   <==等价==>    int r = 100;    //可省略  
```
    interface Com {
        public static final int MAX = 100;                 //等价写法: int MAX = 100;
        public abstract void add();                        //等价写法: void add();
        public abstract float sun(float x,float y)         //等价写法: float sun(float x,float y);
    }
```
· 接口体中的default实例方法：接口中具有方法体的实例方法，访问权限是public可以省略（不可以定义default的static方法）这些方法可以在实现接口的类中直接调用。  `有方法体`   
· 接口体中的static方法  `有方法体`   
```
    public interface Com {
        public static void f() {
            System.out.println("接口中的static方法")
        }
    }
```  
· 接口体中的pricate方法:接口中定义private方法(将某些算法封装在private方法中)，供default实例方法调用，实现算法的复用 `有方法体`    
· *重写接口中的方法*：
1. 一个类实现某个接口，也就拥有了接口中的常量、default方法(去掉default关键字)，该类也可以重写接口中的default方法(需去掉default关键字)。  
2. 一个非abstract类实现了某个接口，这个类必须重写该接口的abstract方法(去掉abstract，给出方法体) `非abstract类必须实现接口的abstract方法（程实现了这个接口）`    
3. 一个abstract类实现了某个接口，该类可以原则重写接口的abstract方法或直接拥有接口的abstract方法  
4. 注:类实现某接口，但并不拥有接口中的static方法和private方法。接口中除了private方法，其他的访问权限都是public,重写时不能省略public，否则是降低了访问权限    

· 接口中的常量和static方法: 可以用接口名直接调用。  、

· public接口可以在任何类中实现，友好(默认)接口只能在同一包实现。  
· 父类实现某接口，子类自然也实现。   
· 接口可以被继承,通过关键字extends声明一个接口是另一个接口的子接口，因为接口中的方法和常量都是public，所以子接口继承父接口中的全部实例方法和常量  
· java提供的接口都在包中，import不仅可以引入包中的类，也可以引入接口    

· 接口回调：  
```
    Com com;   //接口  
    ImpleCom impleCom = new ImpleCom();    //实现接口的类ImpleCom  
    com = impleCom;   //接口回调，用com. 调用类中实现的接口方法  
```
· 接口回调无法调用类中的其他非接口方法  

· 函数接口：一个接口中只有一个abstract方法，则称为 单接口(或函数接口)
· Lambda表达式：主要用在但接口（函数接口）   
```  
    (参数列表) -> {
        方法体
    }

例: 
    public interface SingleCom {
    public abstract int computeSum(int a,int b);
}
    SingleCom sm = (a,b) -> {
        return a+b;
    }
```  

· abstract类与接口比较：  
1. abstract类和接口都可以有abstract方法  
2. 接口中只可以有常量，不可以有变量。abstract类中都可以有  
3. abstract类中可以有非abstract方法，接口中abstract、default、static方法  


# 第七章 内部类与异常类  
### 内部类   
· 内部类可以是 final 类
· 内部类与外嵌类：  
1. 外嵌类的成员变量在内部类有效，内部类中的方法可以调用外嵌类的方法  
2. 内部类：不可以声明类变量和类方法，内部类声明的对象可以是外嵌类的成员  
3. 内部类只能外嵌类使用，其他类不可以用某个类的内部类声明对象。
4. 不能用proteccted和private修饰类，但可以修饰内部类  
5. 外嵌类的成员变量在内部类中有效，所以交互更加方便   
6. 非内部类不可以是static类，static内部类不可以操作外嵌类中的实例变量（程序就可以在其他类中使用static类创建对象）  
``` 
    RedCowFarm.RedCow redCow = new RedCowFarm.RedCow(180,119,6000);
    redCow.speak();
```  

##### 匿名类  
· 匿名类没有名字，但是编辑器会给匿名类一个名字 ，有构造方法，一定是 final 类   
```
    new Bank() {
        匿名类的类体
    }
    new Bank(100) {
        匿名类的类体
    }
```  
· 和子类有关的匿名类  
1. 匿名类可以继承和重写父类的方法  
2. 使用匿名类时，必然是在某个类中直接用匿名类创建对象，所以匿名类是内部类  
3. 匿名类可以访问外嵌类的成员变量和方法，匿名类的类体中不可以声明static成员变量和static方法  
4. 匿名类创建对象时要直接使用父类的构造方法  
```
    public abstract class Bank {
        int money;
        public Bank() {
            money = 100;
        }
        public Bank(int money) {
            this.money = money;
        }
        public abstract void output();
    }

    public class ShowBank {
        void showMess(Bank bank) {
            bank.output(); 
        } 
    }

    public class Example7_2 {
        public static void main(String args[]) {
            ShowBank showBank = new ShowBank();
            showBank.showMess(new Bank() { //向参数传递Bank的匿名子类对象
                                public void output() {
                                     money+=100;
                                    System.out.printf("中国银行资金：%3d\n",money); 
                                }  
                            }
                        );
            showBank.showMess(new Bank(500) { //向参数传递Bank的匿名子类对象
                                public void output() {
                                     money+=100;
                                    System.out.printf("建设银行资金：%3d\n",money); 
                                }  
                            }
                        );
       } 
    }
```  

· 和接口有关的匿名类    
· 非匿名内部类也可以实现接口   
```
    new ComImpl() {
        实现接口类的匿名类的类体
    }
```   
```  
    interface SpeakHello {
        void speak();
    }
    class HelloMachine {
        public void turnOn(SpeakHello hello) {
            hello.speak();
        }
    }
    public class Example7_3 {
        public static void main(String args[]) {
            HelloMachine machine = new HelloMachine();
            machine.turnOn( new SpeakHello() {
                                public void speak() {
                                    System.out.println("hello,you are welcome!");
                                }
                            } 
                        ); 
            machine.turnOn( new SpeakHello() {
                                public void speak() {
                                    System.out.println("你好，欢迎光临!");
                                }
                            } 
                        ); 
        } 
    }
```    

· 用Lambda表达式代替匿名类（函数接口，单接口）    
```  
    interface SpeakHello {
        void speak();
    }
    class HelloMachine {
        public void turnOn(SpeakHello hello) {
            hello.speak();
        }
    }
    public class Example7_4 {
        public static void main(String args[]) {
            HelloMachine machine = new HelloMachine();
            machine.turnOn( ()->{        //向形参传递Lambada表达式的值。
                                System.out.println("hello,you are welcome!");
                            }
                        ); 
            machine.turnOn( ()->{       //向形参传递Lambada表达式的值。
                                System.out.println("你好，欢迎光临!");
                            }
                        ); 
        } 
    }
```   

### 异常类  
· try-catch
· 异常对象可调用如下方法得到或输出有关异常的信息：  
```
    pubilc String getMessage();
    public void printStackTrace();  //打印堆栈信息
    public String toString();
```



```  
    try{
        包含可能发生异常的语句
        即可能throw关键字抛出了异常对象（抛出Exception子类对象）
    }
    catch(ExceptionSubClass1 e){
        ……
    }
    catch(ExceptionSubClass2 e){
        ……
    }
```   

· 各个catch参数中的异常类都是Exception的某个子类，表明try部分可能发生的异常，这些子类之间如果有父子关系，那么catch参数是子类在父类前面   

##### 自定义异常类  
· 一个方法在声明时可以使用 throws 关键字声明要产生的若干个异常，并在该方法的方法体中具体给出产生异常的操作，即用相应的异常类创建对象，并使用 throe 关键字抛出该异常对象，导致该方法结束执行。程序必须在 try-catch 块语句中调用可能发生异常的方法，其中 catch 的作用就是捕获 throw 关键字抛出的异常对象。  
· 注：throw是Java的关键字，该关键字的作用就是抛出异常。throw 和 throws 是两个不同的关键字   
```  
    public class Bank {
        private int money;

        public void income(int in, int out) throws BankException {
            if (in <= 0 || out >= 0 || in + out <= 0) {
                throw new BankException(in, out); // 方法抛出异常，导致方法结束
            }
            int netIncome = in + out;
            System.out.printf("本次计算出的纯收入是:%d元\n", netIncome);
            money = money + netIncome;
        }

        public int getMoney() {
            return money;
        }
    }

    public class BankException extends Exception {
        String message;

        public BankException(int m, int n) {
            message = "入账资金" + m + "是负数或支出" + n + "是正数，不符合系统要求.";
        }

        public String warnMess() {
            return message;
        }
    }

    public class Example7_6 {
        public static void main(String args[]) {
            Bank bank = new Bank();
            try {
                bank.income(200, -100);
                bank.income(300, -100);
                bank.income(400, -100);
                System.out.printf("银行目前有%d元\n", bank.getMoney());
                bank.income(200, 100);
                bank.income(99999, -100);
            } catch (BankException e) {
                System.out.println("计算收益的过程出现如下问题:");
                System.out.println(e.warnMess());
            }
            System.out.printf("银行目前有%d元\n", bank.getMoney());
        }
    }
```  

##### 断言
· 断言语句在调试代码阶段非常有用，断言语句一般用于程序不准备通过捕获异常来处理的错误（例如，当发生某个错误时要求程序必须立即停止执行）。在调试代码阶段让断言语句发挥作用，这样就可以发现一些致命的错误，当程序正式运行时就可以关闭断言语句，但仍把断言语句保留在源代码中，方便以后应用程序调试，则可以重新启用断言语句.  
· **断言语句的语法格式**：使用关键字 assert 声明一个断言语句，断言语句有两种格式：  
1. assert booleanExpression;  //booleanExpression必须是值为boolean型的表达式  
2. assert booleanExpression:messageExpression;   //messageExpression可以是值为字符串的表达式

· 使用 assert booleanExpression 形式的断言语句，booleanExpression的值为true时，程序从断言语句处继续执行；反之停止执行  
· 使用 assert booleanExpression:messageExpression 形式的断言语句，booleanExpression的值为true时，程序从断言语句处继续执行；当值为false时，程序从断言语句处停止执行，并输出messageExpression的值，提示用户出现了怎样的问题  

· **启用与关闭断言语句**：  
· 启用断言语句： 在调式程序可以使用 `-ea` 启用断言语句      (例：java -ea 类名)   
· 关闭断言语句：当使用Java解释器直接运行应用程序时，默认关闭断言语句   

· finally 子语句的 try-catch语句：无论 try 部分是否发生异常，finally 子语句都会被执行    
```
    try{}
    catch(ExceptionSubClass e) {}
    finally{}
```  
1. try-catch 语句中执行了 return 语句，finally 语句仍然被执行.  
2. try-catch 语句中执行了程序退出代码，即"System.exit(0)",则不执行 finally 语句  


# 第八章 常用实用类 P192  

## String类
1. Java 定义 String 为 final 类，用户不能扩展，即不可以有子类  
2. 常量对象： ` String str = "你好 12.97"; ` 常量池中的数据在程序运行期间不允许改变  
3. String 对象： ` String str = new String("Hello") ` （new 运算符构造出的对象都不在常量池中）  
```
    String address = System.out.println(str);  //得到 String 对象 str 的引用
    String com = new String(str);              //用参数 str 的实体构造 String 对象 com 的实体

    char a[] = {'j','a','v','a'};
    String str = String(a);                    //String(char a[]) :效果等同于String str = new String("java");

    String(char a[],int startIndex,int count):参数 startIndex 指在 a 中起始位置，count 指在起始位置后截取字符的个数
```  
4. 引用 String 常量:  
```
    String s1,s2;  //s1,s2的值是可以被改变的
    s1 = "你好";
    s2 = "你好";   // s1 == s2 结果是true;
    s2 = s1;      //  s1 == s2 结果是true;
```
#### String对象的并置
· String 可以用 "+" 进行并置运算得到一个新的 String 对象：
```
    String str = "你" + "好"; //结果还是常量，在常量池中

    String s1 = "你"
    String string1 = s1 + s2;
    String string2 = s1 + "好";  //string1,string2 右侧有变量参与了并置运算相当于"new String("你好")",在动态区产生新对象   
```  
· 两个常量并置运算，结果是常量，常量池没有就加入常量池，否则"引用"常量值的常量  

#### String类的常用方法  
· `public int length()`:获取一个 String 对象的字符序列长度    
  
· `public boolean equals(String s)`:比较两个字符序列是否相同(true)  s1.equals(s2);  
· `public boolean equalsIgnoreCase(String s)`:比较两个字符序列是否相同(true),忽略大小写   
  
· `public boolean startsWith(String s)`:判断 String 对象的字符前缀是(true)否为参数指定的 String 对象 s 的字符序列    
· `public boolean endsWith(String s)`:判断 String 对象的字符后缀是(true)否为参数指定的 String 对象 s 的字符序列    

· `public int compareTo(String s)`:按字典序与参数 s 字符序列比较大小，小于返回负数，等于返回0，大于返回正数   
· `public int compareToIgnoreCase(String s)`:按字典序与参数 s 字符序列比较大小，忽略大小写，小于返回负数，等于返回0，大于返回正数   

· `public boolean contains(String s)`:判断当前 String 对象的字符序列是(true)否包含参数 s 的字符序列  

· `public int indexOf(String s)`:从当前 String 对象的0位置索引，检索首次出现的 s 字符序列的位置并返回该位置，没有则返回-1    
· `public int lastIndexOf(String s)`:从当前 Strign 对象的0位置索引，检索最后一次出现的 s 字符序列的位置并返回该位置，没有则返回-1     
· `public int indexOf(String s,int startpoint)`和`public int lastIndexOf(String s,int startpoint)`:startpoint指定检索起始位置

· `public String substring(int startpoint)`:获得一个新对象，String 新对象是赋值 startponit 位置到结束的字符序列    
· `public String substring(int startpoint,int end)`:获得一个新对象，String 新对象是赋值 startponit 位置到 end-1 位置的字符序列    

· `public String trim()`:字符串去空格    

#### String对象基本数据的相互转换 P200    
· `public static int parseInt(String s) throws NumberFormatException`:将数字字符 s 转化为 int(或其他类型) 型数据 Integer.parseInt(s)    

· `public static String valueOf(int n)`:将 int(或其他) 型数据转换为 String 对象   

· 基本数据进制的表示：返回（）进制的 String 对象表示 P200    

· main()方法参数化：略    

· `public String toString()`:对象的 String 对象表示    

#### 正则表达式 略

#### StringTokenizer类 略  

#### Scanner类 略

#### Pattern类与Matcher类 略

#### StringBuffer类 lue

#### 日期与时间类 略

#### Match类、BigInteger类、Random类 略  

#### Class类与反射 略  

#### Arrays类、System类、Console类 略

# 第九章 组件及事件处理  P254  

# 第十章 输入和输出流 P303    

# 第十一章 JDBC与MySQL数据库 P347    

# 第十二章 Java多线程机制 P385  

# 第十三章 Java网络编程 P419  

# 第十四章 图形、图像与音频 P445  

# 第十五章 泛型与集合框架 P461














