import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class  Serverrr{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5757);
        Socket socket = serverSocket.accept();
        Scanner scanner = new Scanner(socket.getInputStream());
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
            if(scanner.hasNextLine()){
                System.out.println(("Wait a little bit..."));
                printWriter.println("Your number to calc: " + scanner.nextLine());
                String input = bufferedReader.readLine();
                System.out.println("dsafdsf");
                System.out.println(input);
                Integer value = Integer.valueOf(input);
                printWriter.println("Your fibonachi number is: " + fibonachi(value));
            }
        }

    public static int fibonachi(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonachi(n - 1) + fibonachi(n - 2); }
    }
}
