package se.ATM;

public class BranchBank {
    // 需要访问数据库，匹配账号密码来验证账户。账户不可更改,所以常量，密码可以修改，是变量
    private static final String userName = "110110";
    private double money = 072433;
    private String passWord = "011011";
    private boolean verificationResult = false;// 验证账号结果

    public BranchBank(String userName, String passWord) {
        if (userName.equals(BranchBank.userName) && passWord.equals(this.passWord)) {
            this.verificationResult = true;
            System.out.println("分行账户有效");
        }
    }

    public boolean getVerificationResult() {
        return verificationResult;
    }

    public static String getUsername() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void withdrawalObject(int withdrawal) {
        this.money = this.money - withdrawal;
        System.out.println("事务成功！");
    }

    public void depositObject(int deposit) {
        System.out.println("请放入现金!");
        this.money = this.money + deposit;
        System.out.println("事务成功！");
    }
}
