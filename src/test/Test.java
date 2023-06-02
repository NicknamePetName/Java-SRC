package test;

import java.util.regex.*;
public class Test {
   public static void main(String args[ ]) { 
      String str = "忘记密码，不要惊慌失错，请登陆www.yy.cn或登陆www.tt.cc";              
      
//首先将"登陆"替换为"登录"
String regex = "登陆";
      Pattern pattern = Pattern.compile(regex);    //使用regex初试化模式对象pattern
      Matcher matcher = pattern.matcher(str);   //得到检索str的匹配对象matcher
      while(matcher.find()) {
         String s = matcher.group();
         System.out.print(matcher.start()+"位置出现:");
         System.out.println(s);
      } 
      System.out.println("将\"登陆\"替换为\"登录\"的字符串:");
      String result = matcher.replaceAll("登录");
      System.out.println(result);

//接着将"惊慌失错"替换为"惊慌失措"
      pattern= Pattern.compile("惊慌失错");  
      matcher = pattern.matcher(result);           
      System.out.println("将\"惊慌失错\"替换为\"惊慌失措\"的字符串:");
      result = matcher.replaceAll("惊慌失措");
      System.out.println(result);
   }
}
