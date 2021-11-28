package com.company;

public class Account {
    //ska innehålla saldo, kontotyp(debitcard) och kontonummer (unika)

    //state
    private int Saldo;
    private long Kontonummer;
    private String Kontotyp;

    //constructor
    public Account(String kontotyp, long kontonummer, int saldo) {
        this.Kontotyp = kontotyp;
        this.Kontonummer = kontonummer;
        this.Saldo = saldo;
    }

    public Account(String kontotyp) {
        this.Kontotyp = kontotyp;
    }


    public void createAccount(long kontonummer) {
        this.Kontonummer = kontonummer;
    }

    //behaviour
    public long getKontonummer() {
        return Kontonummer;
    }

    public String getKontotyp() {
        return Kontotyp;
    }
    public int getSaldo(){
        return Saldo;
    }
    public void setSaldo(int saldo){
        Saldo = saldo;
    }

    public void deposit(int amount) {
        this.Saldo = this.Saldo + amount;
    }

    public void withdraw(int amount) {
        this.Saldo = this.Saldo - amount;
    }


}
