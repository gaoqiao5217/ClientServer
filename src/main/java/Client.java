import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            String greeting = in.readLine();
            System.out.print(greeting + " ");
            String name = scanner.nextLine();
            out.println(name);

            String question = in.readLine();
            System.out.println(question);
            String isChild = scanner.nextLine();
            out.println(isChild);

            String response = in.readLine();
            System.out.println(response);

        } catch (IOException e) {
            System.err.println("Ошибка при работе клиента: " + e.getMessage());
        }
    }
}