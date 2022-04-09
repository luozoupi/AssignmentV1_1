package com.example.assignmentv1_1;

import javax.net.ServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static String Filepath="E:\\courses\\Melb\\Distributed system\\assignments\\A1\\AssignmentV1_1\\src\\dict.txt";
    // Declare the port number
    private static int port = 3005;

    // Identifies the user number connected
    private static int counter = 0;

    public static void main(String[] args)
    {
        ServerSocketFactory factory = ServerSocketFactory.getDefault();

        try(ServerSocket server = factory.createServerSocket(port))
        {
            System.out.println("Waiting for client connection-");

            // Wait for connections.
            while(true)
            {
                Socket client = server.accept();
                counter++;
                System.out.println("Client "+counter+": Applying for connection!");

                // Start a new thread for a connection
                Thread t = new Thread(() -> serveClient(client));
                t.start();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void serveClient(Socket client)
    {
        try(Socket clientSocket = client)
        {
            // Input stream
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            // Output Stream
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
            String outcome=null;
            String Operation = input.readUTF();
            System.out.println("CLIENT: "+Operation);
            char OP=Operation.charAt(Operation.indexOf("OP")+2);
            System.out.println("Client's operation: "+OP);


            if(OP=='0'){//Search operation requested

                String ToSearch = Operation.substring(Operation.indexOf("OP")+5);
                //SearchWord s1= new SearchWord();
                System.out.println("You are now searching for: "+ToSearch);
                outcome = SearchWord.LookItUp(ToSearch);

            }else if(OP=='1'){//Remove operation requested

                String ToRemove = Operation.substring(Operation.indexOf("OP")+5);
                SearchWord.RemoveAWord(ToRemove);
                outcome = SearchWord.RemoveAWord(ToRemove);

            }else if(OP=='2'){//Operation Update requested

                char div=Operation.charAt(Operation.indexOf("-")+2);
                String ToUpdate=Operation.substring(Operation.indexOf("OP")+5,div); //Sample: OP2: Cat-meow meow meow
                String NewMeaning=Operation.substring(div+1);
                outcome = SearchWord.UpdateAWord(ToUpdate,NewMeaning);

            }else if(OP=='3'){//Add operation requested

                char div=Operation.charAt(Operation.indexOf("-")+2);
                String ToAdd=Operation.substring(Operation.indexOf("OP")+5,div);//Sample: OP3: Poop-Number2
                String NewMeaning=Operation.substring(div+1);
                outcome = SearchWord.AddAWord(ToAdd,NewMeaning);
            }

            //output.writeUTF("Server: Hi Client "+counter+" !!!");
            output.writeUTF(outcome);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
