import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(InetAddress.getLocalHost(),5757), 2000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            Scanner scanner1 = new Scanner(System.in);
            System.out.print("Write INTEGER to calculate Fibonachi: ");
            String inform = scanner1.nextLine();
            printWriter.println(inform);
            String result = bufferedReader.readLine();
            System.out.println(result);
    }
}
