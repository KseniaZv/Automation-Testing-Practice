package task9;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

class ChatClient implements Runnable {
    private Socket socket = null;
    private Thread thread = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private ChatClientThread client = null;

    private ChatClient(String serverName, int serverPort) {
        System.out.println("Establishing connection. Please wait ...");
        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Connected: " + socket);
            start();
        } catch (UnknownHostException uhe) {
            System.out.println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Unexpected exception: " + ioe.getMessage());
        }
    }

    public static void main(String args[]) {
        ChatClient client = null;
        client = new ChatClient("localhost", 1488);
    }

    public void run() {
        while (thread != null) {
            try {
                String input = console.readLine();
                if (!input.toLowerCase().equals("send image")) {
                    streamOut.writeUTF(input);
                    streamOut.flush();
                } else {
                    streamOut.writeUTF("send image");
                    streamOut.flush();
                    System.out.println("enter filename");
                    String filename = console.readLine();
                    BufferedImage image = ImageIO.read(new File(filename));
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ImageIO.write(image, "jpg", byteArrayOutputStream);
                    byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
                    streamOut.write(size);
                    streamOut.write(byteArrayOutputStream.toByteArray());
                    streamOut.flush();
                    System.out.println("image sent");
                    this.stop();
                }
            } catch (IOException ioe) {
                System.out.println("Sending error: " + ioe.getMessage());
                stop();

            }
        }
    }

    public void handle(String msg) {
        System.out.println(msg);
    }
    public void handleImage(BufferedImage image) throws IOException {
        System.out.println("image received");
        ImageIO.write(image, "jpg", new File ("C:\\Users\\zveri\\IdeaProjects\\task9\\imagereceived.jpg"));
    }

    private void start() throws IOException {
        console = new DataInputStream(System.in);
        streamOut = new DataOutputStream(socket.getOutputStream());
        if (thread == null) {
            client = new ChatClientThread(this, socket);
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
        try {
            if (console != null) console.close();
            if (streamOut != null) streamOut.close();
            if (socket != null) socket.close();
        } catch (IOException ioe) {
            System.out.println("Error closing ...");
        }
        client.close();
        client.stop();
    }
}