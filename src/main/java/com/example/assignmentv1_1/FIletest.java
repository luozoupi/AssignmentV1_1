package com.example.assignmentv1_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class FIletest {
    public static void main(String[] args) {
        String Filepath="E:\\courses\\Melb\\Distributed system\\assignments\\A1\\AssignmentV1_1\\src\\dict.txt";
        File dict=new File("E:\\courses\\Melb\\Distributed system\\assignments\\A1\\AssignmentV1_1\\src\\dict.txt");
        //Create a file in the src folder of the project
        String encoding = "UTF-8"; //Default coding
        try {
            dict.createNewFile();
            System.out.println("The dictionary is created.\n");
        } catch (Exception e){
            e.printStackTrace();
        }
        if(dict.exists()){
           try {
               FileWriter output = new FileWriter(dict);
               String str1="Cat 1.An animal. 2.It meows.\n";
               String str2="Dog 1.An animal. 2.It barks.\n";
               String content=str1+str2;
               output.write(content);
               output.close();

           } catch(Exception e){
               e.printStackTrace();
           }

        }
    }
}
