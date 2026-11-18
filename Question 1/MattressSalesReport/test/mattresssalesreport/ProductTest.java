/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package mattresssalesreport;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Student
 */
public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);
        int expected = 153;
        int actual = product.GetTotalProductsSold();

        assertEquals(expected, actual);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
        };

        Product product = new Product(products, sales);
        double expected = 17.0;
        double actual = product.GetAverageProductSold();

        assertEquals(expected, actual, 0.01);
    }
}