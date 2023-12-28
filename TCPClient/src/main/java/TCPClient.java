import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    @SneakyThrows
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 2555);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        byte[] bytes = readBytes("C:\\Users/Umid/Pictures/profilephoto.jpg");
        dos.writeInt(bytes.length);
        dos.write(bytes);
        socket.close();
    }
    @SneakyThrows
    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] bytesArray = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytesArray);
        return bytesArray;
    }
}
