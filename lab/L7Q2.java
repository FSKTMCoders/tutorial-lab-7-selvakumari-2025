/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class L7Q2 {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL u = new URL("http://www.fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);
            
            // Create output file writer
            PrintWriter out = new PrintWriter(new FileWriter("index.htm"));

            // Read from web and write to file
            while (in.hasNextLine()) {
                String line = in.nextLine();
                out.println(line);
            }
            
            // Close resources
            in.close();
            out.close();
            System.out.println("Web page content written to index.htm");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}