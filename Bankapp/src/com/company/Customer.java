package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer {
    //customer name, personnr (unikt), list av konto

    //state
    private String CustomerName;
    private long Personnr;
    private List<Account> Accounts;

    //constructor

    public Customer(String customerName) {
        CustomerName = customerName;
    }

    public Customer(String customerName, long personnr) {
        CustomerName = customerName;
        Personnr = personnr;
        Accounts = new ArrayList<>();

    }
    //behaviour

    public long getPersonnr() {
        return Personnr;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerName='" + CustomerName + '\'' +
                ", Personnr=" + Personnr +
                ", Accounts=" + Accounts.size() +
                '}';
    }

    public String getName() {
        return CustomerName;
    }


    public List<String> getAccounts() {
        List<String> temp = new ArrayList<>();
        for (var acc : Accounts) {
            String accinfo = "\n" + "Account number: " + acc.getKontonummer() + "\n"
                    + "Account type: " + acc.getKontotyp() + "\n"
                    + "Account balance: " + acc.getSaldo();
            temp.add(accinfo);
        }
        return temp;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public long addAccount(String Kontotyp) {
        Account acc = new Account(Kontotyp);
        long accnr = 1000L;
        for (var account : Accounts) {
            if (accnr < account.getKontonummer()) {
                accnr = account.getKontonummer();
            }
        }
        accnr += 1;
        acc.createAccount(accnr);
        Accounts.add(acc);
        return accnr;
    }

    public long deposit(int accountnr, int saldo) {
        for (var acc : Accounts) {
            if (accountnr == acc.getKontonummer()) {
                int sal = acc.getSaldo();
                int nysaldo = sal + saldo;
                acc.setSaldo(nysaldo);
                return nysaldo;
            }
        }
        return accountnr;
    }

    public long withdraw(int accountnr, int saldo) {
        for (var acc : Accounts) {
            if (accountnr == acc.getKontonummer() && saldo <= acc.getSaldo()) {
                int sal = acc.getSaldo();
                int nysaldo = sal - saldo;
                acc.setSaldo(nysaldo);
                return nysaldo;
            }
        }
        return accountnr;
    }

    public String removeAccounts() {
        StringBuilder builder = new StringBuilder();
        for (var acc : Accounts) {
            builder.append(" Account number:  ").append(String.valueOf(acc.getKontonummer()))
                    .append(" Balance:  ").append(String.valueOf(acc.getSaldo()))
                    .append(" Kontotyp: ").append(acc.getKontotyp()).append("\n");
        }
        Accounts.removeAll(Accounts);
        String line = builder.toString();
        return line;
    }
}