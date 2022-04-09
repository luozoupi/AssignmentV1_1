package com.example.assignmentv1_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class STest {
    private JButton button1;
    private JComboBox<String> OperationList;
    private JPanel TestForm;
    private JPanel PanelForLabel;
    private JPanel PanelForTextIn;
    private JPanel ForButton;
    public int OpIndex=0;
    public STest() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Op= (String) OperationList.getSelectedItem();
                if(Op=="Search a word"){
                    OpIndex=0;
                    SearchOrRemoveDialog D1=new SearchOrRemoveDialog(OpIndex);

                } else if(Op=="Remove a word"){
                    OpIndex=1;
                    SearchOrRemoveDialog D2=new SearchOrRemoveDialog(OpIndex);

                }
                else if(Op=="Update a word"){
                    OpIndex=2;
                    UpdateOrAddDialog D3=new UpdateOrAddDialog(OpIndex);

                }
                else if(Op=="Add a word"){
                    OpIndex=3;
                    UpdateOrAddDialog D4=new UpdateOrAddDialog(OpIndex);

                }

            }
        });
    }



    private void createUIComponents() {
         // TODO: place custom component creation code here
        OperationList.addItem("Search a word");
        OperationList.addItem("Update a word");
        OperationList.addItem("Remove a word");
        OperationList.addItem("Add a word");
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("STest");
        frame.setContentPane(new STest().TestForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
