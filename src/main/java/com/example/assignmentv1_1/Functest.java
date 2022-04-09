package com.example.assignmentv1_1;

public class Functest {
    static String Filepath="E:\\courses\\Melb\\Distributed system\\assignments\\A1\\AssignmentV1_1\\src\\dict.txt";
    public static void main(String[] args) {
        SearchWord s= new SearchWord();
        s.AddAWord("Shit","Poop");
        s.AddAWord("Nice","good");
        s.AddAWord("SB","Clever");
        s.RemoveAWord("Cat");
        s.UpdateAWord("Dog","WongWong");

        s.UpdateAWord("Dog","WongWong21212");
        s.UpdateAWord("Dog","WongWong333");
        s.UpdateAWord("Dog","WongWong131313");
        s.RemoveAWord("SB");
    }
}
