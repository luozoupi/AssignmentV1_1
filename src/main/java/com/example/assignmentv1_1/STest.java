package com.example.assignmentv1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STest {
    private JButton button1;
    private JComboBox<String> OPlist;
    private JPanel TestForm;
    private JPanel PanelForLabel;
    private JPanel PanelForTextIn;
    private JPanel ForButton;
    private JLabel Label1;
    public int OpIndex=0;
    public STest() {
//        button1.addActionListener(new ActionListener() {
//           @Override
//            public void actionPerformed(ActionEvent e) {
//                String Op= (String) OPlist.getSelectedItem();
//                if(Op=="Search a word"){
//                    OpIndex=0;
//                    SearchOrRemoveDialog D1=new SearchOrRemoveDialog(OpIndex);
//
//                } else if(Op=="Remove a word"){
//                    OpIndex=1;
//                    SearchOrRemoveDialog D2=new SearchOrRemoveDialog(OpIndex);
//
//                }
//                else if(Op=="Update a word"){
//                    OpIndex=2;
//                    UpdateOrAddDialog D3=new UpdateOrAddDialog(OpIndex);
//
//                }
//                else if(Op=="Add a word"){
//                    OpIndex=3;
//                    UpdateOrAddDialog D4=new UpdateOrAddDialog(OpIndex);
//
//                }
//
//            }
//        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Op= (String) OPlist.getSelectedItem();
                if(Op=="Search"){
                    OpIndex=0;
                    System.out.println("Given OP = Search");
                    SearchOrRemoveDialog D1=new SearchOrRemoveDialog(OpIndex);

                } else if(Op=="Remove"){
                    OpIndex=1;
                    System.out.println("Given OP = Remove");
                    SearchOrRemoveDialog D2=new SearchOrRemoveDialog(OpIndex);

                }
                else if(Op=="Update"){
                    OpIndex=2;
                    System.out.println("Given OP = Update");
                    UpdateOrAddDialog D3=new UpdateOrAddDialog(OpIndex);

                }
                else if(Op=="Add"){
                    OpIndex=3;
                    System.out.println("Given OP = Add");
                    UpdateOrAddDialog D4=new UpdateOrAddDialog(OpIndex);

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
        JFrame frame = new JFrame("STest");
        frame.setContentPane(new STest().TestForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
