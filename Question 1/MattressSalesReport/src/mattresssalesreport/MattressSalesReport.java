/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mattresssalesreport;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class MattressSalesReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array for the 3 mattress products
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array for 3 products across 3 months
        int[][] sales = new int[3][3];

        // A for loop that capture user input matching the sample screenshot
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                sales[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        // It creates Product and PrintProduct objects
        Product productReport = new Product(products, sales);
        PrintProduct printer = new PrintProduct(productReport);

        // Display Results 
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("---------------------------------------------------");
        printer.printTotalSales();
        printer.printAverageSales();
        printer.printMostPopularProduct();
    }
}
