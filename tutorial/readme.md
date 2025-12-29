# Tutorial 
## Question 1
Write statements for each of the following

a. Store ten random integers within 0 to 1000 to a text file name integer.txt.
```java
try {
    PrintWriter output = new PrintWriter(new FileOutputStream("integer.txt"));
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
        output.println(rand.nextInt(1001)); // 0 to 1000 inclusive
    }
    output.close();
} catch (IOException e) {
    System.out.println("Error writing to file.");
}
```

b. Read from the text file generated in a. Display all the integer and the largest
integer.
```java
try {
    Scanner input = new Scanner(new FileInputStream("integer.txt"));
    int max = Integer.MIN_VALUE;
    System.out.print("Integers: ");
    while (input.hasNextInt()) {
        int num = input.nextInt();
        System.out.print(num + " ");
        if (num > max) {
            max = num;
        }
    }
    input.close();
    System.out.println("\nLargest integer: " + max);
} catch (FileNotFoundException e) {
    System.out.println("File not found.");
}
```

c. Store ten random integers within 0 to 1000 to a binary file name integer.dat.
```java
try {
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("integer.dat"));
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
        output.writeInt(rand.nextInt(1001));
    }
    output.close();
} catch (IOException e) {
    System.out.println("Error writing to binary file.");
}
```
d. Read from the binary file generated in a c. Display the all the integer and the
average.
```java
try {
    ObjectInputStream input = new ObjectInputStream(new FileInputStream("integer.dat"));
    int sum = 0;
    int count = 0;
    System.out.print("Integers: ");
    try {
        while (true) {
            int num = input.readInt();
            System.out.print(num + " ");
            sum += num;
            count++;
        }
    } catch (EOFException e) {
        // End of file reached
    }
    input.close();
    if (count > 0) {
        System.out.println("\nAverage: " + (double) sum / count);
    }
} catch (IOException e) {
    System.out.println("Error reading binary file.");
}
```

## Question 2
Correct the error for the following statements.

a. 
```java
PrintWriter out = new PrintWriter(new FileOutputStream("d:\data\matrix.txt"));
```
Answer:
```java
try {
    PrintWriter out = new PrintWriter(new FileOutputStream("d:\\data\\matrix.txt"));
    out.close();
} catch (FileNotFoundException e) {
    System.out.println("File not found");
}
```
b.
```java
try {
 PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
 out.close();
} catch (FileNotFoundException e) {
 System.out.println("Problem with file output");
}
```
Answer:
```java
try {
 PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
 out.close();
} catch (IOException e) {
 System.out.println("Problem with file output");
}
```
c.
```java
int num;
Scanner a = new Scanner(new FileInputStream("data.dat"));
num = a.readInt();
a.close();
```
Answer:
```java
int num;
Scanner a = new Scanner(new FileInputStream("data.dat"));
num = a.nextInt();
a.close;
```
d.
```java
ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("data.dat"));
o.print('A');
o.close();
```
Answer:
```java
ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("data.dat"));
o.writeChar('A');
o.close();
```

## Question 3
Write a program that convert a sentence into binary number (ASCII code 8 bit) and store it in a text file named data.txt. Then, read from the text file and display the sentence.
```java
import java.io.*;
import java.util.Scanner;

public class T7Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String filename = "data.txt";
        
        System.out.println("Enter a Sentence: ");
        String sen = input.nextLine();
        System.out.println("Original sentence: " + sen);
        
        try (PrintWriter out = new PrintWriter (new FileOutputStream(filename))) {           
            for (char c : sen.toCharArray()) {
                // Convert char to binary string
                String binaryString = Integer.toBinaryString(c);
                
                // Pad with leading zeros to ensure 8 bits
                // Example: 'A' is 65 (1000001) -> 01000001
                while (binaryString.length() < 8) {
                    binaryString = "0" + binaryString;
                }
                out.print(binaryString); // Write raw bits continuously
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // 2. Read from text file and convert back to sentence
        try (Scanner in = new Scanner(new FileInputStream(filename))) {
            System.out.print("Read from file: ");
            
            // Read the entire line of binary data
            if (in.hasNext()) {
                String binaryData = in.next();
                
                // Process 8 bits at a time
                for (int i = 0; i < binaryData.length(); i += 8) {
                    if (i + 8 <= binaryData.length()) {
                        String byteStr = binaryData.substring(i, i + 8);
                        int charCode = Integer.parseInt(byteStr, 2); // Parse binary to int
                        System.out.print((char) charCode); // Cast to char
                    }
                }
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}
```
