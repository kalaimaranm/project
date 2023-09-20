/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package iopackages;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOPackages {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int i;
        // BufferedInputStream bis = new BufferedInputStream(new FileInputStream("fas"));
        try (FileInputStream fis = new FileInputStream("/home/bas200193/Desktop/textFiles/Download/sample-2mb-text-file.txt"); 
             FileInputStream fiss = new FileInputStream("/home/bas200193/Desktop/textFiles/Download/small");) {
            String fileString = "";
            int characterCount = 0;
            int sentenceCount = 0;
            int specialCharacter = 0;
            while ((i = fiss.read()) != -1) {
                //System.out.print((char)i);
                fileString = fileString + (char) i;

            }
            for (int j = 0; j < fileString.length(); j++) {
                if ((int) fileString.charAt(j) != (int) '\n') {
                    ++characterCount;
                }
                if ((int) fileString.charAt(j) > 31 && (int) fileString.charAt(j) < 48 || (int) fileString.charAt(j) > 57 && (int) fileString.charAt(j) < 65 || (int) fileString.charAt(j) > 90 && (int) fileString.charAt(j) < 97 || (int) fileString.charAt(j) > 122 && (int) fileString.charAt(j) < 127) {
                    ++specialCharacter;
                }
                if ((int) fileString.charAt(j) == (int) '.') {
                    ++sentenceCount;
                }

            }
            System.out.println("Number of Character in File: " + characterCount + "\n" + "Number of Sentence in File: " + sentenceCount);
            System.out.println("Special Character: " + specialCharacter);
            System.out.println(fileString);
        }

    }

}
