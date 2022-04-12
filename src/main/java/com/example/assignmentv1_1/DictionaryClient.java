package com.example.assignmentv1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DictionaryClient {
    private JButton button1;
    private JComboBox<String> OPlist;
    private JPanel TestForm;
    private JPanel PanelForLabel;
    private JPanel PanelForTextIn;
    private JPanel ForButton;
    private JLabel Label1;
    public static int Port=3005;
    static String Ip = "localhost" ;

    public int OpIndex=0;
    public DictionaryClient() {


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Op= (String) OPlist.getSelectedItem();
                if(Op=="Search"){
                    OpIndex=0;
                    System.out.println("Given OP = Search");
                    SearchOrRemoveDialog D1=new SearchOrRemoveDialog(OpIndex);
                    D1.setSize(400,250);
                    D1.setVisible(true);

                } else if(Op=="Remove"){
                    OpIndex=1;
                    System.out.println("Given OP = Remove");
                    SearchOrRemoveDialog D2=new SearchOrRemoveDialog(OpIndex);
                    D2.setSize(400,250);
                    D2.setVisible(true);

                }
                else if(Op=="Update"){
                    OpIndex=2;
                    System.out.println("Given OP = Update");
                    UpdateOrAddDialog D3=new UpdateOrAddDialog(OpIndex);
                    D3.setSize(400,250);
                    D3.setVisible(true);

                }
                else if(Op=="Add"){
                    OpIndex=3;
                    System.out.println("Given OP = Add");
                    UpdateOrAddDialog D4=new UpdateOrAddDialog(OpIndex);
                    D4.setSize(400,250);
                    D4.setVisible(true);
                }
            }
        });
    }



//    private void createUIComponents() {
//         // TODO: place custom component creation code here
//        OPlist.addItem("Search a word");
//        OPlist.addItem("Update a word");
//        OPlist.addItem("Remove a word");
//        OPlist.addItem("Add a word");
//    }

    public static void main(String[] args) {
        if(args.length==2){
            Ip = args[0];
            Port = Integer.parseInt(args[1]);
        }

        JFrame frame = new JFrame("DictionaryClient");
        frame.setContentPane(new DictionaryClient().TestForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
