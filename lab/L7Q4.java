/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.*;
import java.util.Scanner;

public class L7Q4 {
    public static void main(String[] args) {
        int chars = 0, words = 0, lines = 0;
        try {
            Scanner sc = new Scanner(new FileInputStream("input.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines++;
                chars += line.length();
                String[] parts = line.split(" ");
                words += parts.length;
            }
            sc.close();
            System.out.println("Lines: " + lines + "\nWords: " + words + "\nCharacters: " + chars);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}