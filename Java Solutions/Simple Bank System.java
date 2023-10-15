// https://leetcode.com/problems/simple-bank-system/submissions/

class Bank {
    long[] accounts;
    int size;

    public Bank(long[] balance) {
        this.accounts = balance;
        this.size = balance.length;
    }

    private boolean validAccount(int account){
        return account <= size;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(validAccount(account1) && validAccount(account2) && accounts[account1 - 1] >= money){
            accounts[account1 - 1] -= money;
            accounts[account2 - 1] += money;
            return true;
        }

        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(validAccount(account)){
            accounts[account - 1] += money;
            return true;
        } 

        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(validAccount(account) && accounts[account - 1] >= money){
            accounts[account - 1] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
