/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mattressapp;

/**
 *
 * @author Student
 */

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductGUIApp extends JFrame {

    // Declaration of the GUI components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Constructor method: it sets up the window and components when the user enters the app
    public ProductGUIApp() {
        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponentsManually();
    }

    // Method that creats all the text boxes and other gui elements in the app
    private void initComponentsManually() {
        // Create Menu Bar
        JMenuBar menuBar = new JMenuBar();
        
        // File Menu
        JMenu menuFile = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");
        // For Closes app
        mnuExit.addActionListener(e -> System.exit(0)); 
        menuFile.add(mnuExit);
        
        // Tools Menu
        JMenu menuTools = new JMenu("Edit");
        JMenuItem mnuProcess = new JMenuItem("Process");
        //It Runs calculation
        mnuProcess.addActionListener(e -> processSalesData()); 
        
        JMenuItem mnuClear = new JMenuItem("Clear");
        // Clears form
        mnuClear.addActionListener(e -> clearForm()); 
        
        menuTools.add(mnuProcess);
        menuTools.add(mnuClear);
        
        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // Panel for form inputs
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Customer Name row
        panel.add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        panel.add(txtCustomerName);

        // Allows the user to Select Product row
        panel.add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        // Allows the user to Enter the Price row
        panel.add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        panel.add(txtPrice);

        // Process Button row
        // Empty label for clear space to make it look identicall to the sample one
        panel.add(new JLabel("")); 
        btnProcess = new JButton("PROCESS");
         // It runs the calculation after the user clicks ok
        btnProcess.addActionListener(e -> processSalesData());
        panel.add(btnProcess);

        add(panel);
    }

    // Method that proccesses data, show results and saves data to text file
    private void processSalesData() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = cmbProduct.getSelectedItem().toString();
            
            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter customer name.");
                return;
            }

            double price = Double.parseDouble(txtPrice.getText().trim());

            // Calls our calculation class to do the calculations
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Shows the calculated results in a message dialog box
            String message = String.format("Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                    customerName, productName, vat, commission, total);
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Creates and Saves the details into data.txt file
            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                writer.println("DATA LOG");
                writer.println("---------------------------------------------------");
                writer.println("Customer Name: " + customerName);
                writer.println("Product: " + productName);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("---------------------------------------------------");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.");
        }
    }

    // Clears all input fields back to empty
    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }
    // Main method to run the application directly
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductGUIApp().setVisible(true));
    }

}