package com.example.assignmentv1_1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;
import java.awt.event.*;

public class UpdateOrAddDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField TFWord;
    private JTextField TFMeaning;
    private JTextArea FromServer;
    private static String ip = "localhost";
    private static int port = 3005;

    public UpdateOrAddDialog(int OP) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onOK(OP);
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public UpdateOrAddDialog() {

    }

    private void onOK(int OP) {// 在此处添加您的代码
        // IP and port
        try(Socket socket = new Socket(ip, port);)
        {
            // Output and Input Stream
            DataInputStream input = new DataInputStream(socket.getInputStream());

            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String op=null;
            if(OP==2){
                op="OP2: ";
            }else if(OP==3){
                op="OP3: ";
            }//
            String wd=TFWord.getText();
            String mn="-"+TFMeaning.getText();
            String sendData =op+wd+mn;

            output.writeUTF(sendData);
            System.out.println("Data sent to Server--> " + sendData);
            output.flush();

            boolean flag=true;
            while(flag)
            {
                if(input.available()>0) {
                    String message = input.readUTF();
                    FromServer.setText(message);
                    System.out.println(message);
                    flag= false;;
                }
            }


            while(true)
            {
                if(input.available()>0) {
                    String message = input.readUTF();
                    FromServer.setText(message);
                    System.out.println(message);
                    break;
                }
            }

        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




        dispose();
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }

    public static void main(String[] args) {

        UpdateOrAddDialog dialog = new UpdateOrAddDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
