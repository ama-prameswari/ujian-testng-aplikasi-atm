package com.juaracoding;

public class Main {
    public static void main(String[] args) {
        try {
            ATM atm = new ATM(1000);  // Membuat objek ATM dengan saldo awal 1000
            System.out.println("Saldo awal: " + atm.lihatSaldo());

            atm.setorUang(1500);  // Menyetor 1500
            System.out.println("Saldo setelah setor: " + atm.lihatSaldo());

            atm.tarikUang(500);  // Menarik 500
            System.out.println("Saldo setelah tarik: " + atm.lihatSaldo());

            atm.tarikUang(2500);  // Mencoba tarik lebih dari saldo
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
