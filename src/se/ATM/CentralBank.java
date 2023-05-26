package se.ATM;

public class CentralBank {
    private BranchBank branchBank;
    public CentralBank(String userName,String passWord) {
        System.out.println("请求分行验证账户");
        this.branchBank = new BranchBank(userName,passWord);
        if(branchBank.getVerificationResult()) {
            System.out.println("总行账户有效");
        }
    }
    public BranchBank getBranchBank() {
        return branchBank;
    }
    public void withdrawalObject(int withdrawal) {
        System.out.println("请求处理分行事务！");
        branchBank.withdrawalObject(withdrawal);
        System.out.println("事务成功，吐出现金，请拿走现金，拿走现金");
    }

    public void depositObject(int deposit) {
        System.out.println("请求处理分行事务！");
        branchBank.depositObject(deposit);
        System.out.println("事务成功！");
    }
}
