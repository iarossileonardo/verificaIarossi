package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("Server in ascolto");
        ServerSocket sS0 = new ServerSocket(3000);
        ArrayList<String> nomi = new ArrayList<String>();
        Biglietti biglietti = new Biglietti();
        while (true) {
            Socket s0 = sS0.accept();
            GestioneServizio gS = new GestioneServizio(s0, nomi, biglietti);
            gS.start();
        }
    }
}