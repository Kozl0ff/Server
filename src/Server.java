import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static PrintWriter printWriter;

    public static void main(String[] args) throws IOException {

        System.out.println("The server started, waiting client actions...");

        serverSocket = new ServerSocket(5757);
        socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        OutputStream outputStream = socket.getOutputStream();
        printWriter = new PrintWriter(outputStream, true);

        while (true) {
            if(bufferedReader.readLine().equals("1")) {
                System.out.println(("Wait a little bit..."));
                String input = bufferedReader.readLine();
                System.out.println("Number to calculate Fib: " + input);
                Integer value = Integer.valueOf(input);
                printWriter.println("Your fibonacci number is: " + Metods.fibonachi(value));
            }
            else {
                System.out.println(("Wait a little bit..."));
                String input = bufferedReader.readLine();
                System.out.println("Number to calculate Fib: " + input);
                Integer value = Integer.valueOf(input);
                printWriter.println("Your factorial number is: " + Metods.calculateFactorial(value));
            }
        }
    }

}
