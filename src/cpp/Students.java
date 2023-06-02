package cpp;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Students implements  Serializable{
    private int id;
    private String name;
    private int age;
    public Students(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        return id+" "+name+" "+age;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
}
class ManageSystem{
    private final static String filename="students.dat";
    private ArrayList<Students>arrayList=new ArrayList<>();
    //主界面
    JFrame jFrame=new JFrame("Student Manage System");
    //按钮
    JButton addButton=new JButton("添加学生");
    JButton modifyButton=new JButton("修改学生");
    JButton deleteButton=new JButton("删除学生");
    JButton searchButton=new JButton("查找学生");
    JButton showButton=new JButton("显示学生");
    JButton exitButton=new JButton("退出系统");
    public ManageSystem(){
        //设置界面的大小，位置，以及组件
        jFrame.setSize(800,700);
        jFrame.setLocation(600,200);
        jFrame.setLayout(null);
        addButton.setBounds(200,50,400,75);
        modifyButton.setBounds(200,150,400,75);
        deleteButton.setBounds(200,250,400,75);
        searchButton.setBounds(200,350,400,75);
        showButton.setBounds(200,450,400,75);
        exitButton.setBounds(200,550,400,75);
        jFrame.add(addButton);
        jFrame.add(modifyButton);
        jFrame.add(deleteButton);
        jFrame.add(searchButton);
        jFrame.add(showButton);
        jFrame.add(exitButton);
        addButton.setVisible(true);
        modifyButton.setVisible(true);
        deleteButton.setVisible(true);
        searchButton.setVisible(true);
        showButton.setVisible(true);
        exitButton.setVisible(true);
        //读取文件
        try{
            FileInputStream fileInputStream=new FileInputStream(filename);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            Students students=null;
            while((students=(Students)objectInputStream.readObject())!=null)
                arrayList.add(students);
            objectInputStream.close();
            fileInputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //添加学生
    public void AddStudent(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置新界面
                JDialog addDialog=new JDialog(jFrame);
                addDialog.setLayout(new FlowLayout());
                //界面标题
                addDialog.setTitle("添加学生");
                addDialog.setSize(800,700);
                addDialog.setLocation(600,200);
                //设置相关标签和文本框
                JLabel idLabel=new JLabel("学号:");
                JTextField idField=new JTextField("");
                idField.setPreferredSize(new Dimension(100,50));
                JLabel nameLabel=new JLabel("姓名：");
                JTextField nameField=new JTextField("");
                nameField.setPreferredSize(new Dimension(100,50));
                JLabel ageLabel=new JLabel("年龄：");
                JTextField ageField=new JTextField("");
                ageField.setPreferredSize(new Dimension(100,50));
                idLabel.setVisible(true);
                idField.setVisible(true);
                nameLabel.setVisible(true);
                nameField.setVisible(true);
                ageLabel.setVisible(true);
                ageField.setVisible(true);
                //将组件添加进入副界面addDialog
                addDialog.add(idLabel);
                addDialog.add(idField);
                addDialog.add(nameLabel);
                addDialog.add(nameField);
                addDialog.add(ageLabel);
                addDialog.add(ageField);
                addDialog.setVisible(true);
                //设置提交按钮
                JButton submitButton=new JButton("确定");
                submitButton.setBounds(300,400,200,75);
                submitButton.setVisible(true);
                addDialog.add(submitButton);
                submitButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //获取输入的内容
                        int id=Integer.parseInt(idField.getText());
                        String name=nameField.getText();
                        int age=Integer.parseInt(ageField.getText());
                        Students students=new Students(id,name,age);
                        arrayList.add(students);
                        //提交后返回主页面
                        addDialog.setVisible(false);
                    }
                });
                //设置返回按钮
                JButton returnbutton=new JButton("返回");
                returnbutton.setBounds(300,500,200,75);
                returnbutton.setLayout(null);
                returnbutton.setVisible(true);
                addDialog.add(returnbutton);
                returnbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //返回主页面
                        addDialog.setVisible(false);
                    }
                });
                jFrame.add(addDialog);
            }
        });
    }
    //修改学生信息
    public void ModifyStudent(){
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置新界面
                JDialog modifyDialog=new JDialog(jFrame);
                modifyDialog.setTitle("修改学生");
                modifyDialog.setSize(800,700);
                modifyDialog.setLocation(600,200);
                modifyDialog.setLayout(null);
                modifyDialog.setVisible(true);
                //搜索条件
                JLabel namelabel=new JLabel("姓名");
                JTextField namefield=new JTextField("");
                namelabel.setBounds(100,0,60,40);
                namefield.setBounds(160,0,200,40);
                namelabel.setLayout(null);
                namefield.setLayout(null);
                namelabel.setVisible(true);
                namefield.setVisible(true);
                modifyDialog.add(namelabel);
                modifyDialog.add(namefield);
                //设置查询按钮
                JButton searchbutton=new JButton("查询");
                searchbutton.setBounds(0,0,60,40);
                searchbutton.setLayout(null);
                searchbutton.setVisible(true);
                modifyDialog.add(searchbutton);
                searchbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //将符合条件的学生加入哈希表
                        Map<Integer,Students>map=new HashMap<>();
                        for(int i=0;i<arrayList.size();++i)
                        {
                            if(namefield.getText().equals(arrayList.get(i).getName())){
                                map.put(i,arrayList.get(i));
                            }
                        }
                        //显示结果
                        if(map.size()==0)
                        {
                            JButton resultbutton=new JButton("查无此人");
                            resultbutton.setBounds(300,200,200,50);
                            resultbutton.setLayout(null);
                            resultbutton.setVisible(true);
                            modifyDialog.add(resultbutton);
                        }
                        else
                        {
                            int num=0;
                            int height=40;
                            for(Map.Entry<Integer,Students>entry:map.entrySet()){
                                JLabel idlabel=new JLabel("学号");
                                JTextField idfield=new JTextField(entry.getValue().getId()+"");
                                JLabel nameLabel=new JLabel("姓名");
                                JTextField namefield=new JTextField(entry.getValue().getName());
                                JLabel ageLabel=new JLabel("年龄");
                                JTextField agefield=new JTextField(entry.getValue().getAge()+"");
                                idlabel.setBounds(60,40+height*num,60,height);
                                idfield.setBounds(120,40+height*num,180,height);
                                namelabel.setBounds(300,40+height*num,60,height);
                                namefield.setBounds(360,40+height*num,190,height);
                                ageLabel.setBounds(550,40+height*num,60,height);
                                agefield.setBounds(610,40+height*num,190,height);
                                idlabel.setLayout(null);
                                idfield.setLayout(null);
                                nameLabel.setLayout(null);
                                namefield.setLayout(null);
                                ageLabel.setLayout(null);
                                agefield.setLayout(null);
                                idlabel.setVisible(true);
                                idfield.setVisible(true);
                                namelabel.setVisible(true);
                                namefield.setVisible(true);
                                ageLabel.setVisible(true);
                                agefield.setVisible(true);
                                modifyDialog.add(idlabel);
                                modifyDialog.add(idfield);
                                modifyDialog.add(nameLabel);
                                modifyDialog.add(namefield);
                                modifyDialog.add(ageLabel);
                                modifyDialog.add(agefield);
                                //修改按钮
                                JButton yes=new JButton("修改");
                                yes.setBounds(0,40+num*height,60,height);
                                yes.setLayout(null);
                                yes.setVisible(true);
                                yes.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String tempname=namefield.getText();
                                        int tempid=Integer.parseInt(idfield.getText());
                                        int tempage=Integer.parseInt(agefield.getText());
                                        arrayList.get(entry.getKey()).setName(tempname);
                                        arrayList.get(entry.getKey()).setId(tempid);
                                        arrayList.get(entry.getKey()).setAge(tempage);
                                        //修改后返回主页面
                                        modifyDialog.setVisible(false);
                                    }
                                });
                                modifyDialog.add(yes);
                                ++num;
                            }
                        }
                    }
                });
                //设置返回按钮
                JButton returnbutton=new JButton("返回");
                returnbutton.setBounds(200,600,200,50);
                returnbutton.setLayout(null);
                returnbutton.setVisible(true);
                modifyDialog.add(returnbutton);
                returnbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        modifyDialog.setVisible(false);
                    }
                });
                jFrame.add(modifyDialog);
            }
        });
    }
    //删除学生
    public void DeleteStudent(){
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置新界面
                JDialog deleteDialog=new JDialog(jFrame);
                deleteDialog.setTitle("删除学生");
                deleteDialog.setSize(800,700);
                deleteDialog.setLocation(600,200);
                deleteDialog.setLayout(null);
                deleteDialog.setVisible(true);
                //搜索条件
                JLabel namelabel=new JLabel("姓名");
                JTextField namefield=new JTextField("");
                namelabel.setBounds(100,0,60,40);
                namefield.setBounds(160,0,200,40);
                namelabel.setLayout(null);
                namefield.setLayout(null);
                namelabel.setVisible(true);
                namefield.setVisible(true);
                deleteDialog.add(namelabel);
                deleteDialog.add(namefield);
                //设置查询按钮
                JButton searchbutton=new JButton("查询");
                searchbutton.setBounds(0,0,60,40);
                searchbutton.setLayout(null);
                searchbutton.setVisible(true);
                searchbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //筛选符合条件的学生
                        Map<Integer,Students>map=new HashMap<>();
                        for(int i=0;i<arrayList.size();++i)
                        {
                            if(namefield.getText().equals(arrayList.get(i).getName())){
                                map.put(i,arrayList.get(i));
                            }
                        }
                        if(map.size()==0)
                        {
                            JButton resultbutton=new JButton("查无此人");
                            resultbutton.setBounds(300,200,200,50);
                            resultbutton.setLayout(null);
                            resultbutton.setVisible(true);
                            deleteDialog.add(resultbutton);
                        }
                        else
                        {
                            int num=0;
                            int height=40;
                            for(Map.Entry<Integer,Students>entry:map.entrySet()){
                                JButton del=new JButton("删除");
                                del.setBounds(0,40+num*height,60,height);
                                del.setLayout(null);
                                del.setVisible(true);
                                del.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        arrayList.remove(entry.getValue());
                                        //删除后返回主页面
                                        deleteDialog.setVisible(false);
                                    }
                                });
                                deleteDialog.add(del);
                                JTextField resultfield=new JTextField(entry.getValue().toString());
                                resultfield.setBounds(60,40+height*num,740,height);
                                resultfield.setLayout(null);
                                resultfield.setVisible(true);
                                deleteDialog.add(resultfield);
                                ++num;
                            }
                        }
                    }
                });
                //设置返回按钮
                JButton returnbutton=new JButton("返回");
                returnbutton.setBounds(200,600,200,50);
                returnbutton.setLayout(null);
                returnbutton.setVisible(true);
                deleteDialog.add(returnbutton);
                returnbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteDialog.setVisible(false);
                    }
                });
                deleteDialog.add(searchbutton);
                jFrame.add(deleteDialog);
            }
        });
    }
    //查找学生
    public void SearchStudent(){
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置新界面
                JDialog searchDialog=new JDialog(jFrame);
                searchDialog.setTitle("查找学生");
                searchDialog.setSize(800,700);
                searchDialog.setLocation(600,200);
                searchDialog.setLayout(null);
                searchDialog.setVisible(true);
                //设置相关标签和文本框
                JLabel idLabel=new JLabel("学号:");
                JTextField idField=new JTextField("0");
                idField.setPreferredSize(new Dimension(100,50));
                JLabel nameLabel=new JLabel("姓名：");
                JTextField nameField=new JTextField("");
                nameField.setPreferredSize(new Dimension(100,50));
                JLabel ageLabel=new JLabel("年龄：");
                JTextField ageField=new JTextField("0");
                ageField.setPreferredSize(new Dimension(100,50));
                int width=250;
                int height=50;
                idLabel.setBounds(60,0,40,40);
                idField.setBounds(100,0,200,40);
                nameLabel.setBounds(300,0,50,40);
                nameField.setBounds(350,0,200,40);
                ageLabel.setBounds(550,0,50,40);
                ageField.setBounds(600,0,200,50);
                idLabel.setLayout(null);
                idField.setLayout(null);
                nameLabel.setLayout(null);
                nameField.setLayout(null);
                ageLabel.setLayout(null);
                ageField.setLayout(null);
                idLabel.setVisible(true);
                idField.setVisible(true);
                nameLabel.setVisible(true);
                nameField.setVisible(true);
                ageLabel.setVisible(true);
                ageField.setVisible(true);
                //将组件添加进入副界面searchDialog
                searchDialog.add(idLabel);
                searchDialog.add(idField);
                searchDialog.add(nameLabel);
                searchDialog.add(nameField);
                searchDialog.add(ageLabel);
                searchDialog.add(ageField);
                //设置查询按钮
                JButton searchbutton=new JButton("查询");
                searchbutton.setBounds(0,0,60,40);
                searchbutton.setLayout(null);
                searchbutton.setVisible(true);
                searchDialog.add(searchbutton);
                searchbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //根据查询条件进行筛选
                        int whichcase=0;
                        if(!nameField.getText().equals(""))
                            whichcase+=1;
                        if(!idField.getText().equals("0"))
                            whichcase+=2;
                        if(!ageField.getText().equals("0"))
                            whichcase+=4;
                        System.out.println(nameField.getText()+" "+idField.getText()+" "+ageField.getText());
                        //存储查询结果
                        Map<Integer,Students>map=new HashMap<>();
                        switch(whichcase){
                            case 0:
                            {
                                break;
                            }
                            case 1:
                            {
                               // System.out.println(tempname);
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(nameField.getText().equals(arrayList.get(i).getName()))
                                    {
                                        map.put(i,arrayList.get(i));
                                    }
                                }
                                break;
                            }
                            case 2:
                            {
                                int tempid=Integer.parseInt(idField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempid==arrayList.get(i).getId())
                                        map.put(i,arrayList.get(i));
                                }
                                break;
                            }
                            case 3:
                            {
                                String tempname=nameField.getText();
                                int tempid=Integer.parseInt(idField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempname.equals(arrayList.get(i).getName())&&tempid==arrayList.get(i).getId())
                                        map.put(i,arrayList.get(i));
                                }
                                break;
                            }
                            case 4:
                            {
                                int tempage=Integer.parseInt(ageField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempage==arrayList.get(i).getAge())
                                        map.put(i,arrayList.get(i));
                                }
                                break;
                            }
                            case 5:
                            {
                                String tempname=nameField.getText();
                                int tempage=Integer.parseInt(ageField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempname.equals(arrayList.get(i).getName())&&tempage==arrayList.get(i).getAge())
                                        map.put(i,arrayList.get(i));
                                }
                                break;
                            }
                            case 6:
                            {
                                int tempid=Integer.parseInt(idField.getText());
                                int tempage=Integer.parseInt(ageField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempid==arrayList.get(i).getId()&&tempage==arrayList.get(i).getAge()){
                                        map.put(i,arrayList.get(i));
                                    }
                                }
                                break;
                            }
                            case 7:
                            {
                                String tempname=nameField.getText();
                                int tempid=Integer.parseInt(idField.getText());
                                int tempage=Integer.parseInt(ageField.getText());
                                for(int i=0;i<arrayList.size();++i)
                                {
                                    if(tempname.equals(arrayList.get(i).getName())&&tempid==arrayList.get(i).getId()
                                    &&tempage==arrayList.get(i).getAge()){
                                        map.put(i,arrayList.get(i));
                                    }
                                }
                                break;
                            }
                        }
                        int num=0;
                        for(Map.Entry<Integer,Students>entry:map.entrySet()){
                            System.out.println(entry.getValue().toString());
                            JButton tempindexbutton=new JButton(entry.getKey()+"");
                            JButton tempidbutton=new JButton(entry.getValue().getId()+"");
                            JButton tempnamebutton=new JButton(entry.getValue().getName());
                            JButton tempagebutton=new JButton(entry.getValue().getAge()+"");
                            tempindexbutton.setBounds(0,40+height*num,50,height);
                            tempidbutton.setBounds(50,40+height*num,width,height);
                            tempnamebutton.setBounds(300,40+height*num,width,height);
                            tempagebutton.setBounds(550,40+height*num,width,height);
                            tempindexbutton.setLayout(null);
                            tempidbutton.setLayout(null);
                            tempnamebutton.setLayout(null);
                            tempagebutton.setLayout(null);
                            tempindexbutton.setVisible(true);
                            tempidbutton.setVisible(true);
                            tempnamebutton.setVisible(true);
                            tempagebutton.setVisible(true);
                            searchDialog.add(tempindexbutton);
                            searchDialog.add(tempidbutton);
                            searchDialog.add(tempnamebutton);
                            searchDialog.add(tempagebutton);
                            ++num;
                        }
                        if(map.size()==0)
                        {
                            System.out.println("查无此人");
                            JButton resultbutton=new JButton("查无此人");
                            resultbutton.setBounds(300,200,200,50);
                            resultbutton.setLayout(null);
                            resultbutton.setVisible(true);
                            searchDialog.add(resultbutton);
                        }
                    }
                });
                //设置返回按钮
                //设置返回按钮
                JButton returnbutton=new JButton("返回");
                returnbutton.setBounds(200,600,width,height);
                returnbutton.setLayout(null);
                returnbutton.setVisible(true);
                searchDialog.add(returnbutton);
                returnbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchDialog.setVisible(false);
                    }
                });
            }
        });
    }
    //显示学生
    public void ShowStudent(){
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //设置新界面
                JDialog showDialog=new JDialog(jFrame);
                showDialog.setTitle("显示学生");
                showDialog.setSize(800,700);
                showDialog.setLocation(600,200);
                showDialog.setLayout(null);
                showDialog.setVisible(true);
                JButton idbutton=new JButton("id");
                idbutton.setBounds(50,0,250,50);
                idbutton.setLayout(null);
                JButton namebutton=new JButton("name");
                namebutton.setBounds(300,0,250,50);
                namebutton.setLayout(null);
                JButton agebutton=new JButton("age");
                agebutton.setBounds(550,0,250,50);
                agebutton.setLayout(null);
                idbutton.setVisible(true);
                namebutton.setVisible(true);
                agebutton.setVisible(true);
                showDialog.add(idbutton);
                showDialog.add(namebutton);
                showDialog.add(agebutton);
                //数量
                int num=0;
                int height=40;
                int width=250;
                while(num<arrayList.size()){
                    //设置按钮来显示数据
                    JButton numbutton=new JButton(num+"");
                    JButton tempidbutton=new JButton(arrayList.get(num).getId()+"");
                    JButton tempnamebutton=new JButton(arrayList.get(num).getName());
                    JButton tempagebutton=new JButton(arrayList.get(num).getAge()+"");
                    numbutton.setBounds(0,50+height*num,50,height);
                    tempidbutton.setBounds(50,50+height*num,width,height);
                    tempnamebutton.setBounds(300,50+height*num,width,height);
                    tempagebutton.setBounds(550,50+height*num,width,height);
                    numbutton.setLayout(null);
                    tempidbutton.setLayout(null);
                    tempnamebutton.setLayout(null);
                    tempagebutton.setLayout(null);
                    numbutton.setVisible(true);
                    tempidbutton.setVisible(true);
                    tempnamebutton.setVisible(true);
                    tempagebutton.setVisible(true);
                    showDialog.add(numbutton);
                    showDialog.add(tempidbutton);
                    showDialog.add(tempnamebutton);
                    showDialog.add(tempagebutton);
                    ++num;
                }
                //设置返回按钮
                JButton returnbutton=new JButton("返回");
                returnbutton.setBounds(200,600,width,height);
                returnbutton.setLayout(null);
                returnbutton.setVisible(true);
                showDialog.add(returnbutton);
                returnbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        showDialog.setVisible(false);
                    }
                });
                jFrame.add(showDialog);
            }
        });
    }
    //退出系统
    public void ExitButton(){
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //前期的添加，删除，修改等工作，都只作用于ArrayList，最后退出系统时，再更新文件
                try{
                    FileOutputStream fileOutputStream=new FileOutputStream(filename);
                    ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
                    for(Students stu:arrayList)
                    {
                        objectOutputStream.writeObject(stu);
                    }
                    objectOutputStream.close();
                    fileOutputStream.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                jFrame.setVisible(false);
            }
        });
    }
    //菜单
    public void Menu(){
        //添加监听器
        this.AddStudent();
        this.ModifyStudent();
        this.DeleteStudent();
        this.SearchStudent();
        this.ShowStudent();
        this.ExitButton();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}

class ss {
    public static void main(String[] args) {
        ManageSystem manageSystem = new ManageSystem();
        manageSystem.Menu();
    }
}


