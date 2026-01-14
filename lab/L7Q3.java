/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.*;
import java.util.Scanner;

public class L7Q3 {
    public static void main(String[] args) {
        // You must have a source file to read from. 
        // For testing, create a file named "original.txt" with some text.
        String inputFile = "original.txt"; 
        String outputFile = "reverse.txt";

        try (Scanner in = new Scanner(new FileInputStream(inputFile));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputFile))) {

            while (in.hasNextLine()) {
                String line = in.nextLine();
                // Reverse the string
                String reversed = new StringBuilder(line).reverse().toString();
                // Write to new file
                out.println(reversed);
            }
            System.out.println("Content reversed and saved to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}