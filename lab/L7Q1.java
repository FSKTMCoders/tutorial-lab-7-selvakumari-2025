/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7;

import java.io.*;
import java.util.Scanner;

public class L7Q1 {
    public static void main(String[] args) {
        String binaryFile = "coursename.dat";

        // 1. Write the table to the binary file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binaryFile))) {
            // Arrays to hold the data
            String[] codes = {"WXES1116", "WXES1115", "WXES1110", "WXES1112"};
            String[] names = {"Programming I", "Data Structure", "Operating System", "Computing Mathematics I"};

            for (int i = 0; i < codes.length; i++) {
                out.writeUTF(codes[i]); // Write Code
                out.writeUTF(names[i]); // Write Name
            }
            System.out.println("Data saved to " + binaryFile);

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // 2. Ask user for course code and read from file
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a course code: ");
        String searchCode = sc.nextLine();
        boolean found = false;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(binaryFile))) {
            while (true) {
                String code = in.readUTF();
                String name = in.readUTF();

                if (code.equalsIgnoreCase(searchCode)) {
                    System.out.println("Course Name: " + name);
                    found = true;
                    break;
                }
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Course code not found.");
        }
    }
}