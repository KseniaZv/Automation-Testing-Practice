package task2;

import java.io.*;
import java.net.Socket;

public class ChatServerThread extends Thread {
    private Socket socket;
    private ChatServer server;
    private int ID;
    private Socket pickedPartner = null;
    private DataInputStream streamIn = null;
    private DataOutputStream streamOut = null;

    public ChatServerThread(ChatServer server, Socket socket) {
        this.server = server;
        this.socket = socket;
        ID = socket.getPort();
    }

    public void run() {
        System.out.println("Server Thread " + ID + " running.");
        while (true) {
            try {
                String input = streamIn.readUTF();
                switch (input.toLowerCase()) {
                    case ("switch client"):
                    case ("show list of clients"):
                        streamOut.writeUTF(server.getConnectedClients().toString());
                        streamOut.flush();
                        pickedPartner = server.getSocket(Integer.parseInt(streamIn.readUTF()));
                        streamOut.writeUTF("picked port:" + pickedPartner.getPort());
                        streamOut.flush();
                        break;
                    default:
                        if (pickedPartner != null) {
                            server.sendTo(pickedPartner, input);
                        }
                        break;
                }
            } catch (IOException ioe) {
                System.out.println("Unexpected exception: " + ioe.getMessage());
            }
        }
    }

    public void sendTo(String message) {
        try {
            streamOut.writeUTF(message);
            streamOut.flush();
        } catch (IOException ioe) {
            System.out.println("Unexpected exception while forwarding message: " + ioe.getMessage());
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
