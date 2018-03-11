package task3;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class MultiThreadChatServerSync {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    private static final int maxClientsCount = 10;
    private static final ClientThread[] threads = new ClientThread[maxClientsCount];

    public static void main(String args[]) throws IOException {

        int portNumber = 2222;
        if (args.length < 1) {
            System.out.println("Usage: java MultiThreadChatServerSync <portNumber>\n"
                    + "Now using port number=" + portNumber);
        } else {
            portNumber = Integer.valueOf(args[0]).intValue();
        }

        File f = new File("C:\\Users\\zveri\\IdeaProjects\\task3\\src\\task3\\clients.txt");
        if(!f.exists()) {
            f.createNewFile();
            String str = "\nOnline Clients: \n";
            BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
            writer.append(str);
            writer.close();
        }
        else {
            PrintWriter writer = new PrintWriter(f);
            writer.print("\nOnline Clients: \n");
            writer.close();
        }

        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println(e);
        }

        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i = 0;
                for (i = 0; i < maxClientsCount; i++) {
                    if (threads[i] == null) {
                        (threads[i] = new ClientThread(clientSocket, threads)).start();
                        break;
                    }
                }
                if (i == maxClientsCount) {
                    PrintStream os = new PrintStream(clientSocket.getOutputStream());
                    os.println("Server too busy. Try later.");
                    os.close();
                    clientSocket.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}