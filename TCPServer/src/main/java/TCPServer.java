import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocket outFirstServerSocket = new ServerSocket(2555);
        while (true) {
            Socket connection = outFirstServerSocket.accept();
            InputStream is = connection.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            byte[] bytes = new byte[dis.readInt()];
            dis.readFully(bytes);
            writeBytes("C:\\Users/Umid/Desktop/salama.jpg", bytes);
        }
    }

    @SneakyThrows
    public static void writeBytes(String fileName, byte[] data) {
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(data);
        fos.flush();
        fos.close();
    }
}
