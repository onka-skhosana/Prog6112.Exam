/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattressapp;

/**
 *
 * @author Student
 */

public class ProductCalculations implements IProductCalculations {
    private double price;

    // My Constructor Method: saves the price passed from the form
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculates 15% VAT from the price
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Calculates 5% commission from the price
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Adds price, VAT, and commission for the final total
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}