import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;

public class Client {

    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedReader bufferedReader1;
    private static BufferedReader bufferedReader2;
    private static PrintWriter printWriter;

    public static void main(String[] args) throws IOException {
        socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), 5757), 2000);

        OutputStream outputStream = socket.getOutputStream();
        printWriter = new PrintWriter(outputStream, true);


        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        System.out.println("Server is ready to work...");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, Charset.forName("cp1251")));
        String tmp = "";

        do {
            System.out.println("Choose operation Fibonacci, Factorial: (1),(2)");
            String question = reader.readLine();
            printWriter.println(question);
            {
                if (question.equals("1")) {
                    System.out.print("Write INTEGER to calculate Fibonacci: ");

                    bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
                    String s = bufferedReader1.readLine();
                    printWriter.println(s);

                    String calcResult = bufferedReader.readLine();
                    System.out.println(calcResult);
                }
                if (question.equals("2")) {
                    System.out.print("Write INTEGER to calculate Factorial: ");

                    bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
                    String s1 = bufferedReader2.readLine();
                    printWriter.println(s1);

                    String calcResult = bufferedReader.readLine();
                    System.out.println(calcResult);
                }
                System.out.println("New expression?: (Yes), (No)");
                tmp = reader.readLine();
            }

        }while (tmp.equals("Yes"));

    }
}
