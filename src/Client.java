import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    static Socket socket;
    static BufferedReader bufferedReader;
    static BufferedReader bufferedReader1;
    static PrintWriter printWriter;

    public static void main(String[] args) throws IOException{
            socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),5757), 2000);

            OutputStream outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream,true);

            InputStream inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Server is ready to work...");

            System.out.print("Write INTEGER to calculate Fibonachi: ");

            bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferedReader1.readLine();
            printWriter.println(s);

            String calcResult = bufferedReader.readLine();
            System.out.println(calcResult);

    }
}
