/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.*;
import java.util.*;

public class L7Q5 {
    public static void main(String[] args) {
        List<String[]> records = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream("person.dat"))) {
            int total = in.readInt();
            for (int i = 0; i < total; i++) {
                String name = in.readUTF();
                int age = in.readInt();
                char gender = in.readChar();
                records.add(new String[]{name, String.valueOf(age), String.valueOf(gender)});
            }
            
            records.sort(Comparator.comparing(r -> r[0])); // Sort by Name

            for (String[] r : records) {
                System.out.printf("Name: %-15s Age: %-3s Gender: %s\n", r[0], r[1], r[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading binary file.");
        }
    }
}