package se.ATM;

import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        User user = new User();
        user.read();
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的账号:");//相当于读取账号
        String userName = input.next();
        System.out.print("请输入您的密码:");
        input.close();
        String passWord = input.next();
        ATMSystem atmSystem = new ATMSystem(userName, passWord);
        atmSystem.Exit();
    }
}
