class Bank {
    long [] bal;
    int n ;
    public Bank(long[] balance) {
        this.bal = balance;
        this.n = balance.length;
    }
    
    public boolean transfer(int acc1, int acc2, long money) {
        if(!valid(acc1) || !valid(acc2) || bal[acc1 -1] < money)return false;
        bal[acc1 - 1] -= money;
        bal[acc2 - 1] += money;
        return true;

    }
    
    public boolean deposit(int acc, long money) {
        if(!valid(acc))return false;
        bal[acc -1] += money;
        return true;
    }
    
    public boolean withdraw(int acc, long money) {
        if (!valid(acc) || bal[acc - 1] < money) return false;
        bal[acc - 1] -= money;
        return true;
    }
    public boolean valid(int acc){
        return acc > 0 && acc <= n;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */