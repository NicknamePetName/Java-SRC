# 开闭原则
· **开闭原则（Open-Closed Principle，OCP）是面向对象设计中的一个重要原则，它指导着我们如何设计出具有高度可维护性和可扩展性的软件系统。**  

· **开闭原则的核心思想是：一个软件实体（类、模块、函数等）应该对扩展开放，对修改关闭。换句话说，我们应该允许系统的行为可以通过扩展来改变，而不是通过修改已有的代码来实现。**  

· **这个原则的优点在于，当我们需要对系统进行改动时，通过扩展已有的代码，而不是修改代码，可以减少系统的风险和不稳定性，同时也不会影响到系统的其他部分。这样，我们可以更加容易地实现系统的功能扩展和维护，而不需要担心对已有的代码产生不必要的影响。** 
 
· **为了遵守开闭原则，我们可以采用一些具体的实践方法，如使用接口和抽象类来实现多态性，采用设计模式等等。同时，也需要时刻关注系统的设计和代码的结构，确保它们能够满足开闭原则的要求。**  

### *假设我们要设计一个简单的图形绘制程序，可以绘制圆形、矩形、三角形等不同形状的图形。我们可以利用开闭原则来设计该程序，使得它能够具有高度的可扩展性和可维护性。以下是一个简单的UML类图，展示了如何使用接口和抽象类来实现开闭原则。*  

· `UML图`
```
           +--------------+
           |     Shape    |
           +--------------+
           | + getArea()  |
           | + draw()     |
           | + getPerimeter() |
           +--------------+
                    /\
                    |
            +---------------+
            |   AbstractShape |
            +---------------+
            | - color:String |
            | - filled:boolean |
            +---------------+
                    /\
                    |
          +------------------+
          |     Circle       |
          +------------------+
          | - radius:double  |
          +------------------+
          | + Circle(radius:double) |
          | + getArea():double |
          | + getPerimeter():double |
          | + draw():void |
          +------------------+
                    /\
                    |
          +------------------+
          |     Rectangle    |
          +------------------+
          | - width:double   |
          | - length:double  |
          +------------------+
          | + Rectangle(width:double, length:double) |
          | + getArea():double |
          | + getPerimeter():double |
          | + draw():void |
          +------------------+
                    /\
                    |
          +------------------+
          |     Triangle     |
          +------------------+
          | - sideA:double   |
          | - sideB:double   |
          | - sideC:double   |
          +------------------+
          | + Triangle(sideA:double, sideB:double, sideC:double) |
          | + getArea():double |
          | + getPerimeter():double |
          | + draw():void |
          +------------------+
                    /\
                    |
          +------------------+
          |     Drawing      |
          +------------------+
          | - shapes:List<Shape> |
          +------------------+
          | + addShape(shape:Shape):void |
          | + drawAll():void |
          +------------------+
```  

```
    在这个类图中，我们定义了一个 Shape 接口和一个抽象类 AbstractShape。Shape 接口包含了所有图形共有的方法，而 AbstractShape 则实现了这些方法的默认实现，并定义了一个抽象方法 draw()，用于表示具体的图形如何绘制。
    
    接着，我们定义了三个具体的图形类：Circle、Rectangle 和 Triangle。这些类都继承了 AbstractShape 抽象类，并实现了其中的 draw() 方法。

    最后，我们定义了一个 Drawing 类，用于表示绘图程序的核心逻辑。Drawing 类包含了一个 shapes 字段，用于存储所有需要绘制的图形。它提供了 addShape() 方法和 drawAll() 方法，分别用于向 shapes 中添加图形和绘制所有的图形。
```  
