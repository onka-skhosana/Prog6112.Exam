/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mattressapp;

/**
 *
 * @author Student
 */
//My Interface/Contruct that i must have
public interface IProductCalculations {
    // Gets the VAT amount (15% of price)
    double GetVat();
    
    // Gets the commission amount (5% of price)
    double GetCommission();
    
    // Gets the total sale amount (Price + VAT + Commission)
    double GetTotal();
}