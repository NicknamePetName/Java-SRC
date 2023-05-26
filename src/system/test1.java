package system;

import java.sql.*;
import java.util.Scanner;
class ManageSystemOne
{
    //驱动名
    private String driver="com.mysql.cj.jdbc.Driver";
    //数据库用户名
    private String user="1013238728";
    //数据库密码
    private String password="cannian.zn.c0m";
    //要使用的数据库
    private String database="Nickname_zt";
    //数据库路径
    private String url=null;
    public ManageSystemOne(){
        //初始化数据库路径
        url="jdbc:mysql://localhost:3306/"+database+"?useSSL=false&serverTimezone=UTC";
    }
    public void Menu(){
        boolean flag=true;
        Scanner input=new Scanner(System.in);
        while(flag)
        {
            System.out.println("----------------------------------");
            System.out.println("|                                |");
            System.out.println("|-------------1.添加学生-----------");
            System.out.println("|                                |");
            System.out.println("|-------------2.修改学生-----------");
            System.out.println("|                                |");
            System.out.println("|-------------3.删除学生-----------");
            System.out.println("|                                |");
            System.out.println("|-------------4.查找学生-----------");
            System.out.println("|                                |");
            System.out.println("|-------------5.显示学生-----------");
            System.out.println("|                                |");
            System.out.println("|-------------6.退出系统-----------");
            System.out.println("|                                |");
            System.out.println("|---------------------------------");
            System.out.print("请输入您的选择：");
            //输入选择
            int choice=input.nextInt();
            switch(choice)
            {
                case 1:
                    this.AddStudent();
                    break;
                case 2:
                    this.ModifyStudent();
                    break;
                case 3:
                    this.DeleteStudent();
                    break;
                case 4:
                    this.SearchStudent();
                    break;
                case 5:
                    this.ShowStudent();
                    break;
                case 6:
                    flag=false;
                    break;
                default:
                    break;
            }
        }
        input.close();
        System.out.println("欢迎下次使用");
    }
    //添加学生
    public void AddStudent(){
        Scanner input=new Scanner(System.in);
        try{
            //加载驱动
            Class.forName(driver);
            //连接到数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
            //设置容器
            Statement stmt=conn.createStatement();
            boolean flag=true;
            while(flag)
            {
                System.out.print("请输入学生id：");
                int id=input.nextInt();
                input=new Scanner(System.in);
                System.out.print("请输入学生姓名：");
                String name=input.nextLine();
                System.out.print("请输入学生年龄：");
                int age=input.nextInt();
                //SQL语句
                String execute="INSERT INTO Student VALUES";
                //在Mysql的添加语句中，若添加id=202004,name=刘六，age=20，添加语句为INSERT INTO Student VALUES('202004','刘六',20);
                //即字符需要用"'"包起来
                execute+=("("+"'"+id+"'"+","+"'"+name+"'"+","+age+");");
                //将SQL语句上传到数据库执行
                stmt.executeUpdate(execute);
                System.out.println("插入成功");
                System.out.println("是否继续插入数据？");
                System.out.println("1.是");
                System.out.println("2.否");
                System.out.print("请输入您的选择：");
                int choice=input.nextInt();
                if(choice!=1)
                {
                    flag=false;
                }
            }
            //关闭容器和通道
            stmt.close();
            conn.close();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //停顿1秒，方便用户查看结果
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        input.close();
    }
    //修改学生
    public void ModifyStudent(){
        Scanner input=new Scanner(System.in);
        System.out.print("请输入要修改的学生姓名：");
        String name=input.nextLine();
        System.out.println("请输入要修改的内容：");
        System.out.println("1.id");
        System.out.println("2.name");
        System.out.println("3.age");
        System.out.println("4.all");
        System.out.print("请输入您的选择：");
        int choice=input.nextInt();
        //SQL语句
        String execute="";
        boolean flag=true;
        while(flag){
            if(choice<1||choice>4)
            {
                System.out.println("输入有误，请重新输入");
            }
            else
            {
                flag=false;
                if(choice==1){
                    System.out.print("请输入新id：");
                    int newid=input.nextInt();
                    execute="UPDATE Student SET stu_id="+"'"+newid+"'";
                }
                else if(choice==2){
                    input=new Scanner(System.in);
                    System.out.print("请输入新姓名：");
                    String newname=input.nextLine();
                    execute="UPDATE Student SET stu_name="+"'"+newname+"'";
                }
                else if(choice==3){
                    System.out.print("请输入新年龄：");
                    int newage=input.nextInt();
                    execute="UPDATE Student SET stu_age="+"'"+newage+"'";
                }
                else
                {
                    System.out.print("请输入新id：");
                    int newid=input.nextInt();
                    input=new Scanner(System.in);
                    System.out.print("请输入新姓名：");
                    String newname=input.nextLine();
                    System.out.print("请输入新年龄：");
                    int newage=input.nextInt();
                    execute="UPDATE Student SET stu_id="+"'"+newid+"'";
                    execute+=",stu_name="+"'"+newname+"'";
                    execute+=",stu_age="+"'"+newage+"'";
                }
            }
            input.close();
        }
        execute+=" WHERE stu_name="+"'"+name+"'"+";";
        try{
            //设置驱动
            Class.forName(driver);
            //连接数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            //设置容器
            Statement stmt=conn.createStatement();
            //执行SQL语句
            stmt.executeUpdate(execute);
            System.out.println("修改成功");
            //关闭容器和数据库
            stmt.close();
            conn.close();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //停顿1秒，方便用户观察结果
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //删除学生
    public void DeleteStudent(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要删除的学生姓名：");
        String name=input.nextLine();
        try{
            //加载驱动
            Class.forName(driver);
            //连接数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            //设置容器
            Statement stmt=conn.createStatement();
            //SQL语句
            String exceute="DELETE FROM Student WHERE ";
            exceute+="stu_name="+"'"+name+"'"+";";
            //执行SQL语句
            stmt.executeUpdate(exceute);
            System.out.println("删除成功");
            //关闭容器和数据库
            stmt.close();
            conn.close();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //停顿1秒，方便用户观察
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        input.close();
    }
    //查找学生
    public void SearchStudent(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入查询条件");
        System.out.println("1.id");
        System.out.println("2.name");
        System.out.println("3.age");
        System.out.print("请输入您的选择:");
        String execute="";
        boolean flag=true;
        while(flag){
            int choice=input.nextInt();
            if(choice<1||choice>3)
            {
                System.out.println("输入有误，请重新输入");
            }
            else if(choice==1){
                System.out.print("请输入要查询的id：");
                int id=input.nextInt();
                execute="SELECT * FROM Student WHERE stu_id="+"'"+id+"'"+";";
                flag=false;
            }
            else if(choice==2){
                input=new Scanner(System.in);
                System.out.print("请输入要查询的姓名：");
                String name=input.nextLine();
                execute="SELECT * FROM Student WHERE stu_name="+"'"+name+"'"+";";
                flag=false;
            }
            else
            {
                System.out.print("请输入要查询的年龄：");
                int age=input.nextInt();
                execute="SELECT * FROM Student WHERE stu_age="+age+";";
                flag=false;
            }
        }
        try{
            //加载驱动
            Class.forName(driver);
            //连接数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            //设置容器
            Statement stmt=conn.createStatement();
            //获得集合
            ResultSet rs=stmt.executeQuery(execute);
            int num=0;
            //遍历
            while(rs.next())
            {
                int id=Integer.parseInt(rs.getString("stu_id"));
                String name=rs.getString("stu_name");
                int age=Integer.parseInt(rs.getString("stu_age"));
                System.out.println(String.format("id:%-10d name:%-20s age:%-5d",id,name,age));
                num++;
            }
            if(num!=0)
                System.out.println("查询成功");
            else
                System.out.println("查无此人");
            //关闭集合，容器和数据库
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //停顿1秒，方便用户观察
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        input.close();
    }
    //显示学生
    public void ShowStudent(){
        try{
            //加载驱动
            Class.forName(driver);
            //连接数据库
            Connection conn=DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
            //设置容器
            Statement stmt=conn.createStatement();
            //SQL语句
            String execute="SELECT * FROM Student";
            //获得集合
            ResultSet rs= stmt.executeQuery(execute);
            System.out.println("查询成功");
            while(rs.next()){
                int id=Integer.parseInt(rs.getString("stu_id"));
                String name=rs.getString("stu_name");
                int age=Integer.parseInt(rs.getString("stu_age"));
                System.out.println(String.format("id:%-10d name:%-20s age:%-5d",id,name,age));
            }
            //关闭集合，容器和数据库
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        //停顿1秒，方便用户观察
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class test1{
    public static void main(String[]args){
      ManageSystemOne manageSystemOne=new ManageSystemOne();
      manageSystemOne.Menu();
    }
}