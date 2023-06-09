# 接口分离原则  

· **接口分离原则（Interface Segregation Principle，简称ISP）是面向对象设计中的一个重要原则，它要求将一个接口拆分成多个独立的接口，客户端不应该依赖于它不需要的接口。**  

· **接口分离原则的核心思想是“不强迫用户依赖他们不需要的接口”，这样可以避免系统的臃肿和不必要的耦合，提高系统的灵活性、可维护性和可扩展性。具体来说，接口分离原则可以分为以下几个方面：**  

1. **客户端不应该依赖于它不需要的接口。**
2. **接口应该尽可能地小，但是要保证功能完整。**
3. **对于不同的用户，可以提供不同的接口实现。**  

· **在实际应用中，接口分离原则可以帮助我们设计出更加灵活、可扩展的系统，降低系统的维护成本和开发成本，提高系统的可重用性和可测试性。**  

### *假设有一个图形绘制程序，它支持绘制不同形状的图形，包括圆形、矩形、三角形等。我们可以用接口分离原则来对它进行重构，将一个绘图接口拆分成多个独立的接口，每个接口只负责一个形状的绘制。*  

· `UML图`  

```
       +--------------+
       |     Shape    |
       +--------------+
       | void draw(); |
       +--------------+
              /\
              |
   +----------------------+
   |          |           |
+--------+ +--------+ +--------+
| Circle | |Triangle| |Rectangle|
+--------+ +--------+ +--------+
|void drawCircle();      |void drawTriangle();    |void drawRectangle();
+-----------------------+-----------------------+-----------------------+
```  

