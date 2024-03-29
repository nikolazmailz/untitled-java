package ru.thinking_in_java.chapter21.page948.closeResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import ru.thinking_in_java.chapter21.page948.IOBlocked;

public class CloseResource {

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));

        TimeUnit.MILLISECONDS.sleep(100);

        System.out.println("Shutting down all threads");

        exec.shutdownNow();

        TimeUnit.SECONDS.sleep(2);

        System.out.println("Closing " + socketInput.getClass().getName());
        socketInput.close();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("Closing " + System.in.getClass().getName());
        System.in.close();

    }

}
