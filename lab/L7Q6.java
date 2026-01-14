/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.*;
import java.util.*;

public class L7Q6 {
    public static void main(String[] args) {
        Map<String, String[]> products = new HashMap<>();

        try {
            // Load products into a Map: Key = ProductID, Value = {Name, Price}
            Scanner prodFile = new Scanner(new FileInputStream("product.txt"));
            while (prodFile.hasNextLine()) {
                String[] parts = prodFile.nextLine().split(",");
                products.put(parts[0].trim(), new String[]{parts[1].trim(), parts[2].trim()});
            }
            prodFile.close();

            // Process orders
            Scanner orderFile = new Scanner(new FileInputStream("order.txt"));
            System.out.printf("%-10s %-20s %-10s %-15s %-10s\n", "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");
            
            while (orderFile.hasNextLine()) {
                String[] parts = orderFile.nextLine().split(",");
                String pid = parts[1].trim();
                int qty = Integer.parseInt(parts[2].trim());
                
                if (products.containsKey(pid)) {
                    String name = products.get(pid)[0];
                    double price = Double.parseDouble(products.get(pid)[1]);
                    double total = qty * price;
                    System.out.printf("%-10s %-20s %-10d %-15.2f %-10.2f\n", pid, name, qty, price, total);
                }
            }
            orderFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Required files not found.");
        }
    }
}
