/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mattressapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */

public class ProductCalculationsTest {
    //Testimg the methods using the data from the sample 

    // Tests if GetVat calculates the correct VAT amount (15% of 3500)
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        assertEquals(525.0, calc.GetVat(), 0.001);
    }

    // Tests if GetTotal calculates the correct total sale amount, which it must be (Price + VAT + Commission)
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500.0);
        // 3500 + 525 (VAT) + 175 (Commission) = 4200.0
        assertEquals(4200.0, calc.GetTotal(), 0.001);
    }
}