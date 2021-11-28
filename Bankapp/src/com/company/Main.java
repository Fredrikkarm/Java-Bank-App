package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank NYbank = new Bank();
        NYbank.addCustomer("pelle", 199203042354L);
        NYbank.addCustomer("kalle", 197509235678L);
        NYbank.addAccount(199203042354L);
        NYbank.addAccount(199203042354L);
        NYbank.addAccount(197509235678L);
        NYbank.deposit(199203042354L, 1002, 5000);
        NYbank.withdraw(199203042354L, 1002, 2500);
        NYbank.changeCustomerName("Niklas", 199203042354L);

        System.out.println(NYbank.getCustomers());

        NYbank.removeCustomer(199203042354L);
        System.out.println(NYbank.getCustomers());
        NYbank.removeAcco


    }
}
