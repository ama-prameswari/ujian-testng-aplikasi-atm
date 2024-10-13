package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {

    ATM atm;

    // Inisialisasi objek ATM dengan saldo awal 1000
    @BeforeMethod
    public void setUp(){
        atm = new ATM(1000);
    }

    // Testing lihatSaldo()
    @Test(priority = 1)
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000);
    }

    // Testing setorUang()
    // Positive Test
    @Test(priority = 2)
    public void testSetorUang() {
        atm.setorUang(1500);
        double actualSaldo = atm.lihatSaldo();
        double expectedSaldo = 2500; // Saldo awal + Jumlah (1000 + 1500 = 2500)
        Assert.assertEquals(actualSaldo, expectedSaldo);
    }

    // Negative Test
    @Test(priority = 3, expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-1500);
    }

    // Testing tarikUang()
    // Positive Test
    @Test(priority = 4)
    public void testTarikUang() {
        atm.tarikUang(500);
        double actualSaldo = atm.lihatSaldo();
        double expectedSaldo = 500; // Saldo setelah setor - Jumlah (2500 - 500 = 2000)
        Assert.assertEquals(actualSaldo, expectedSaldo);
    }

    // Negative Test (Tarik uang lebih dari saldo)
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(2500);
    }

    // Negative Test (Tarik uang negatif)
    @Test(priority = 6, expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-1500);
    }

}
