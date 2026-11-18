/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattresssalesreport;

/**
 *
 * @author Student
 */
public class Product implements IProduct {
    // Single-dimensional array for product names
    private String[] products;
    // Two-dimensional array for monthly sales
    private int[][] sales;

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }
    //Override tha getTotalProductsSold method
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total = total + sales[i][j];
            }
        }
        return total;
    }
    //Overrides the getAverageProductSold method
    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count = count + sales[i].length;
        }
        return (double) total / count;
    }
    //Overrides the getMostPopularProduct method
    @Override
    public String GetMostPopularProduct() {
        int highestSale = sales[0][0];
        int productIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > highestSale) {
                    highestSale = sales[i][j];
                    productIndex = i;
                }
            }
        }
        return products[productIndex] + " (" + highestSale + ")";
    }
}
