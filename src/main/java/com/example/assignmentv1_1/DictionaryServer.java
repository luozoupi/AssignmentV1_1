package com.example.assignmentv1_1;

import javax.net.ServerSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DictionaryServer {
    static String Filepath=".\\src\\dict.txt";
    // Declare the port number
    private static int port = 3005;

    // Identifies the user number connected
    private static int counter = 0;

    public static void main(String[] args)
    {

        if(args.length==2) {
        port = Integer.parseInt(args[0]);
        Filepath = args[1];
        }
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
                System.out.println("You are now searching for: "+ToSearch);
                outcome = SearchWord.LookItUp(ToSearch);

            }else if(OP=='1'){//Remove operation requested

                String ToRemove = Operation.substring(Operation.indexOf("OP")+5);
                System.out.println("You are now removing: "+ToRemove);
                outcome = SearchWord.RemoveAWord(ToRemove);

            }else if(OP=='2'){//Operation Update requested

                //char div=Operation.charAt(Operation.indexOf("-")+2);
                System.out.println("div at: "+Operation.indexOf("-"));
                String ToUpdate=Operation.substring(Operation.indexOf("OP")+5,Operation.indexOf("-")); //Sample: OP2: Cat-meow meow meow
                System.out.println("Toupdate: "+ToUpdate);
                String NewMeaning=Operation.substring(Operation.indexOf("-")+1);
                System.out.println("Newmeaning: "+NewMeaning);
                outcome = SearchWord.UpdateAWord(ToUpdate,NewMeaning);

            }else if(OP=='3'){//Add operation requested
                int div=Operation.indexOf("-");
                String ToAdd=Operation.substring(Operation.indexOf("OP")+5,div);//Sample: OP3: Poop-Number2
                String NewMeaning=Operation.substring(div+1);
                outcome = SearchWord.AddAWord(ToAdd,NewMeaning);
            }

            //output.writeUTF("DictionaryServer: Hi Client "+counter+" !!!");
            output.writeUTF(outcome);
            System.out.println("The outcome: "+outcome+" has been sent back to the client!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
