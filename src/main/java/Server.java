import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен и ожидает подключения на порту " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение принято");

                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    out.println("Привет! Напишите, пожалуйста, ваше имя:");
                    String name = in.readLine();
                    System.out.println("Получено имя: " + name);

                    out.println("Вы ребенок? (yes/no)");
                    String isChild = in.readLine();
                    System.out.println("Получен ответ: " + isChild);

                    if (isChild.equalsIgnoreCase("yes")) {
                        out.println("Добро пожаловать в детскую зону, " + name + "! Давайте поиграем!");
                    } else if (isChild.equalsIgnoreCase("no")){
                        out.println("Добро пожаловать во взрослую зону, " + name + "! Желаю вам приятного отдыха или хорошего рабочего дня!");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при работе сервера: " + e.getMessage());
        }
    }
}