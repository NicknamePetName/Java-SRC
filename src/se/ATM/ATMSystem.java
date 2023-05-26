package se.ATM;

import java.util.Scanner;

public class ATMSystem {
    private CentralBank centralBank;

    public ATMSystem(String userName, String passWord) {
        System.out.println("请求验证账户");
        this.centralBank = new CentralBank(userName, passWord);
        objectType(centralBank.getBranchBank().getVerificationResult());
    }

    public void objectType(boolean verificationResult) {
        if (verificationResult) {
            System.out.print("请输入您要办理的业务：");
            Scanner input = new Scanner(System.in);
            int key = input.nextInt();

            switch (key) {
                case 1:
                    System.out.print("请输入取款额：");
                    int withdrawal = input.nextInt();
                    System.out.println("请求处理事务");
                    centralBank.withdrawalObject(withdrawal);
                    break;
                case 2:
                    System.out.print("请输入存款额:");
                    int deposit = input.nextInt();
                    System.out.println("请求处理事务");
                    centralBank.depositObject(deposit);
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
            System.out.println("打印账单");
            System.out.println("退卡，请拿走卡");
            System.out.println("显示主屏幕");
            input.close();

        } else {
            System.out.println("账号或密码错误!!!\n请重新输入。");
        }
    }

    public void Exit() {
        Exit();
    }
}
