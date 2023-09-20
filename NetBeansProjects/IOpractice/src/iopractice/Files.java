/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iopractice;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author bas200193
 */
public class Files {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/bas200193/Desktop/New Folder/OuterFolder/InnerFolder/nebula.txt");//home/bas200193/Desktop/textFiles
        File txtFile = new File("/home/bas200193/Desktop/New Folder/OuterFolder/InnerFolder/nebula.txt/nebula.txt");
        File rename = new File("/home/bas200193/Desktop/New Folder/OuterFolder/InnerFolder/nebula.txt/nebula2022.txt");
        if (txtFile.createNewFile()) {
            System.out.println("nebula.txt File created Successfully...");
        }
        if (txtFile.renameTo(rename)) {
            System.out.println("nebula.txt is rename to nebula2022.txt Successfully....");
        }
        if (file.mkdirs()) {
            System.out.println("mkdir() created successfully...");
        }
//        if()
//        if(file.createNewFile()){
//            System.out.println("File Created Successfully...");
//        }
        File find = new File("/home/bas200193/Downloads");
        String[] listFile = find.list();
        System.out.println("Total list before counting " + listFile.length);
        int totalCount = 0;
        int fileCount = 0;
        int folderCount = 0;
        File[] totalFile = find.listFiles();
        for (File totalDirectory : totalFile) {
            if (totalDirectory.isDirectory()) {
                System.out.println(totalDirectory);
                ++folderCount;
            }
        }
        for (File f : totalFile) {
            if (f.isFile()) {
                System.out.println(f.getName());
                ++fileCount;
            }
        }
        System.out.println("TotalFile Count " + fileCount);
        System.out.println("TotalFolder Count " + folderCount);
        int temp = fileCount + folderCount;
        System.out.println("TotalFile After Count " + temp);
        int txtCount=0;
        int others=0;
        for (File f : totalFile) {
            if (f.isFile()) {
            String fileName = f.getName();
            int index = fileName.lastIndexOf(".");
            int end = index+5;
            String extension = fileName.substring(index+1);//,end);
            if(extension.equals("txt")){
                ++txtCount;
            }
            else{
                ++others;
            }
            }
        }
        
        System.out.println("Total txt File count is :"+txtCount);
        int confirm = txtCount+others;
        System.out.println("confirmation is :"+confirm);
//        if (find.isFile()) {
//            for (String fileName : listFile) {
//
//                System.out.println(fileName);
//
//            }
//        }
    }
}
