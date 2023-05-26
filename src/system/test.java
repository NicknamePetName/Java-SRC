package system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//学生类，继承Serializeable接口，将其序列化写入文件
class Student implements Comparable<Student>,Serializable
{
    private int id;
    private String name;
    private int age;
    public Student(){
        id=0;
        name=null;
        age=0;
    }
    public Student(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    @Override
    public String toString(){
        return "id:"+id+" name:"+name+" age:"+age;
    }
    //重载equals和compareTo函数，分别后续比较
    @Override
    public boolean equals(Object obj){
        if(this==obj)
            return true;
        if(getClass()!=obj.getClass()){
            return false;
        }
        Student other=(Student)obj;
        if(other.name==null){
            if(this.name!=null)
                return false;
            else if(this.id==other.id&&this.age==other.age)
                return true;
            else
                return false;
        }
        if(this.name.equals(other.name)){
            if((this.age==other.age)&&(this.id==other.id))
                return true;
        }
        return false;
    }
    @Override
    public int compareTo(Student other){
        if(this.id>other.id)
            return 1;
        else if(this.id<other.id)
            return -1;
        else
        {
            if(this.age>other.age)
                return 1;
            else if(this.age<other.age)
                return -1;
            else
                return this.name.compareTo(other.name);
        }
    }
}
class Manage
{
    private ArrayList<Student>arrayList=new ArrayList<>();
    private final String filename="./src/system/student.dat";
    public Manage(){
        try{
            FileInputStream file=new FileInputStream(new File(filename));
            ObjectInputStream inputStream=new ObjectInputStream(file);
            while(true)
            {
                Student stu=(Student)inputStream.readObject();
                if(stu==null)
                    break;
                arrayList.add(stu);
            }
            //先关闭对象流，再关闭文件流
            inputStream.close();
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Menu(){
        boolean flag=true;
        Scanner input=new Scanner(System.in);
        while(flag)
        {
            System.out.println("-----------------------------------");
            System.out.println("|                                 |");
            System.out.println("|-------------1.添加学生-----------|");
            System.out.println("|                                 |");
            System.out.println("|-------------2.修改学生-----------|");
            System.out.println("|                                 |");
            System.out.println("|-------------3.删除学生-----------|");
            System.out.println("|                                 |");
            System.out.println("|-------------4.查找学生-----------|");
            System.out.println("|                                 |");
            System.out.println("|-------------5.显示学生-----------|");
            System.out.println("|                                 |");
            System.out.println("|-------------6.退出系统-----------|");
            System.out.println("|                                 |");
            System.out.println("-----------------------------------");
            System.out.print("请输入您的选择:");
            int choice=input.nextInt();
            switch(choice){
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
                    this.FindStudent();
                    break;
                case 5:
                    this.ShowStudent();
                    break;
                case 6:
                {
                    try{
                        FileOutputStream outputStream=new FileOutputStream(filename);
                        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                        for(Student stu:arrayList){
                            objectOutputStream.writeObject(stu);
                        }
                        objectOutputStream.close();
                        outputStream.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    flag=false;
                    break;
                }
                default:
                    break;
            }
            input.close();;
        }
        System.out.println("欢迎下次使用");
    }
    public void AddStudent(){
        Scanner input=new Scanner(System.in);
        try{
            FileOutputStream outputStream=new FileOutputStream(filename,true);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
            String name;
            int id,age;
            boolean flag=true;
            while(flag){
                System.out.print("请输入学号：");
                id=input.nextInt();
                //重新new Scanner，防止将换行符赋给name
                input=new Scanner(System.in);
                System.out.print("请输入姓名：");
                name=input.nextLine();
                System.out.print("请输入年龄：");
                age=input.nextInt();
                Student stu=new Student(id,name,age);
                objectOutputStream.writeObject(stu);
                arrayList.add(stu);
                System.out.println("是否继续添加？");
                System.out.println("1.Yes/2.No");
                int choice=input.nextInt();
                if(choice==2)
                    flag=false;
            }
            objectOutputStream.close();
            outputStream.close();
            System.out.println("添加成功");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        //等待1秒,方便实验者观察结果
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        input.close();
    }
    public void ModifyStudent(){
        Scanner input=new Scanner(System.in);
        System.out.print("请输入要修改的学生姓名：");
        String name=input.nextLine();
        boolean flag=false;
        for(int i=0;i<arrayList.size();++i)
        {
            if(name.equals(arrayList.get(i).getName()))
            {
                flag=true;
                System.out.println(i+" "+arrayList.get(i).toString());
            }
        }
        if(!flag)
        {
            System.out.println("修改失败");
        }
        else
        {
            System.out.print("请输入要修改的学生对应的序号：");
            int index=input.nextInt();
            System.out.print("请输入学生学号：");
            int id=input.nextInt();
            System.out.print("请输入学生姓名：");
            name=input.nextLine();
            System.out.print("请输入学生年龄：");
            int age=input.nextInt();
            arrayList.set(index,new Student(id,name,age));
            try{
                FileOutputStream outputStream=new FileOutputStream(filename);
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                for(Student stu:arrayList){
                    objectOutputStream.writeObject(stu);
                }
                objectOutputStream.close();
                outputStream.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("修改成功");
        }
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        input.close();
    }
    public void DeleteStudent(){
        Map<Integer,Student>map=new HashMap<>();
        Scanner input=new Scanner(System.in);
        System.out.print("请输入学生姓名：");
        String name=input.nextLine();
        boolean flag=false;
        for(int i=0;i<arrayList.size();++i)
        {
            if(name.equals(arrayList.get(i).getName()))
            {
                flag=true;
                System.out.println(i+":"+arrayList.get(i).toString());
                map.put(i,arrayList.get(i));
            }
        }
        if(!flag)
        {
            System.out.println("删除失败");
        }
        else
        {
            System.out.print("请输入要删除的学生序号：");
            int id=input.nextInt();
            if(map.containsKey(id)){
                arrayList.remove(map.get(id));
                try{
                    FileOutputStream outputStream=new FileOutputStream(filename);
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                    for(Student stu:arrayList){
                        objectOutputStream.writeObject(stu);
                    }
                    objectOutputStream.close();
                    outputStream.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else
            {
                System.out.println("删除失败");
            }
        }
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        input.close();
    }
    public void FindStudent(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入学生姓名：");
        String stuname=input.nextLine();
        input.close();
        if(arrayList.size()==0)
        {
            System.out.println("当前系统无学生信息");
            return;
        }
        else
        {
            boolean flag=false;
            for(Student stu:arrayList){
                if(stuname.equals(stu.getName()))
                {
                    flag=true;
                    System.out.println(stu.toString());
                }
            }
            if(!flag)
                System.out.println("查无此人");
        }
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public void ShowStudent(){
        if(arrayList.size()==0)
        {
            System.out.println("当前系统中无学生信息");
            return;
        }
        int num=0;
        for(Student stu:arrayList){
            System.out.println((num++)+":"+stu.toString());
        }
        try {
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class test{
    public static void main(String[]args){
        Manage manage=new Manage();
        manage.Menu();
    }
}