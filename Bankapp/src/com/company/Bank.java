package com.company;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    //state
    private List<Customer> Customers;
    private String bankName;


    //constructor
    public Bank() {
        Customers = new ArrayList<>();
    }

    //behaviour


    //findcustomer

    public int findCustomer(long Personnr) {
        var c = -1;
        for (int i = 0; i < Customers.size(); i++) {
            if (Customers.get(i).getPersonnr() == Personnr) {
                c = i;
            }
        }
        return c;
    }

/*    public List<String> getCustomer(long Personnr) {
        List<String> CustomerInfo = new ArrayList<>();
        for (var s : Customers) {
            s.getPersonnr();
            if (Personnr == s.getPersonnr()) {
                CustomerInfo.add(s.getName());
                CustomerInfo.add(Long.toString(s.getPersonnr()));
                CustomerInfo.add(Integer.toString(s.getAccounts().size()));

            } else {
                return null;
            }
        }
        return CustomerInfo;
    }*/

    //returns Customer
    public List<String> getCustomers() {
        List<String> temp = new ArrayList<>();
        for (var customer : Customers) {
            temp.add(
                    '\n' + "{" +
                            "Customer Name= '" + customer.getName() + '\'' +
                            ", Personnr=" + customer.getPersonnr() +
                            ", Accounts=" + customer.getAccounts() +
                            '}'
            );
        }
        return temp;

    }

    public String getCustomer(long Personnr) {
        String temp = "";
        for (var customer : Customers) {
            if (customer.getPersonnr() == Personnr) {
                temp = customer.toString();
            }
        }
        return temp;
    }

    //adds customer
    public boolean addCustomer(String CustomerName, long Personnr) {
        Customer c1 = new Customer(CustomerName, Personnr);
        Customers.add(c1);
        return true;
    }

    //changecustomername
    public boolean changeCustomerName(String CustomerName, long Personnr) {
        var c = findCustomer(Personnr);
        Customers.get(c).setCustomerName(CustomerName);
        return true;
    }
    //removecustomer

    //add account
    public long addAccount(long Personnr) {
        var a = findCustomer(Personnr);
        if (a == -1) {
            return -1;
        }
        return Customers.get(a).addAccount("Debitcard");
    }


    //deposit & withdraw
    public boolean deposit(long personnr, int accountnr, int balance) {
        for (var customer : Customers) {
            if (personnr == customer.getPersonnr()) {
                customer.deposit(accountnr, balance);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(long personnr, int accountnr, int balance) {
        for (var customer : Customers) {
            if (personnr == customer.getPersonnr()) {
                customer.withdraw(accountnr, balance);
                return true;
            }
        }
        return false;
    }

    public List<String> removeCustomer(long personnr) {
        List<String> temp = new ArrayList<>();
        for (var customer : Customers) {
            if (personnr == customer.getPersonnr()) {
                temp.add("Customer: " + customer.getName() + "is now removed");
                temp.add(customer.removeAccounts());
                Customers.remove(customer);
            }
        }return temp;
    }


}
