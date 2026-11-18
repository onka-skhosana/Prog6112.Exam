/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattresssalesreport;

/**
 *
 * @author Student
 */
//The class that prints the report 
public class PrintProduct {
    private Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
