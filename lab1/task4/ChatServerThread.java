package task4;

import java.io.*;
import java.net.Socket;

@SuppressWarnings("Duplicates")
public class ChatServerThread extends Thread {
    private Socket socket;
    private ChatServer server;
    private int ID;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;

    public ChatServerThread(ChatServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        ID = socket.getPort();
    }

    public void run() {
        System.out.println("Server Thread " + ID + " running.");
        SonnetGetter sonnetGetter = new SonnetGetter();
        while (true) {
            try {
                if (streamIn.readUTF().toLowerCase().equals("sonnet")) {
                    streamOut.writeUTF(sonnetGetter.getRandomSonnet().toString());
                    streamOut.flush();
                }
            } catch (IOException ioe) {
                System.out.println("Unexpected exception: " + ioe.getMessage());
            }
        }
    }

    public void open() throws IOException {
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        streamOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void close() throws IOException {
        if (socket != null) socket.close();
        if (streamIn != null) streamIn.close();
    }
}
