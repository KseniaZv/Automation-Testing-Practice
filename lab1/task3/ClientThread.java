package task3;

import java.io.*;
import java.net.Socket;

class ClientThread extends Thread {

    private String clientName = null;
    private DataInputStream is = null;
    private PrintStream os = null;
    private Socket clientSocket = null;
    private final ClientThread[] threads;
    private int maxClientsCount;

    private static final String FILENAME = "C:\\Users\\zveri\\IdeaProjects\\task3\\src\\task3\\clients.txt";

    public ClientThread(Socket clientSocket, ClientThread[] threads) {
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClientsCount = threads.length;
    }

    public void run() {
        int maxClientsCount = this.maxClientsCount;
        ClientThread[] threads = this.threads;

        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintStream(clientSocket.getOutputStream());
            String name;
            while (true) {
                os.println("Enter your name.");
                name = is.readLine().trim();
                if (name.indexOf('@') == -1) {
                    break;
                } else {
                    os.println("The name should not contain '@' character.");
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
                bw.write(name+"\n");
            }

            BufferedReader in = new BufferedReader(new FileReader(FILENAME));

            String clients;
            while((clients = in.readLine()) != null)
            {
                os.println(clients);
            }
            in.close();

            os.println("\nEnter a message. All online clients will receive it!\nTo leave enter /quit in a new line.");


            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i] == this) {
                        clientName = "@" + name;
                        break;
                    }
                }
            }

            while (true) {
                String line = is.readLine();
                if (line.startsWith("/quit")) {
                    break;
                }

                    synchronized (this) {
                        for (int i = 0; i < maxClientsCount; i++) {
                            if (threads[i] != null && threads[i].clientName != null) {
                                threads[i].os.println("<" + name + "> " + line);
                            }
                        }
                    }
            }

            try {
                File inFile = new File(FILENAME);
                if (!inFile.isFile()) {
                    System.out.println("Parameter is not an existing file");
                    return;
                }
                //Construct the new file that will later be renamed to the original filename.
                File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
                BufferedReader br = new BufferedReader(new FileReader(FILENAME));
                PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
                String line ;
                //Read from the original file and write to the new
                //unless content matches data to be removed.
                while ((line = br.readLine()) != null) {
                    if (!line.trim().equals(name)) {
                        pw.println(line);
                        pw.flush();
                    }
                }
                pw.close();
                br.close();

                //Delete the original file
                if (!inFile.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }
                //Rename the new file to the filename the original file had.
                if (!tempFile.renameTo(inFile))
                    System.out.println("Could not rename file");

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            os.println("Bye " + name);

            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] != null && threads[i] != this
                            && threads[i].clientName != null) {
                        BufferedReader in1 = new BufferedReader(new FileReader(FILENAME));

                        String newClients;
                        while((newClients = in1.readLine()) != null)
                        {
                            threads[i].os.println(newClients);
                        }
                        in1.close();
                    }
                }
            }

            synchronized (this) {
                for (int i = 0; i < maxClientsCount; i++) {
                    if (threads[i] == this) {
                        threads[i] = null;
                    }
                }
            }

            is.close();
            os.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}