package com.chehejia.letcode;

class Bank {

    long[] balance;
    int len = 0;

    public Bank(long[] balance) {
        this.balance = balance;
        len = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > len || account2 > len) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > len) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > len) {
            return false;
        }
        if (balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}