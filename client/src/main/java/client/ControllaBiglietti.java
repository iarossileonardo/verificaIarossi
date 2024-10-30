package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ControllaBiglietti extends Thread{
    Socket s0;

    public ControllaBiglietti(Socket s0, Main padre) {
        this.s0 = s0;
    }

    @Override
    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));
            String mIn;
            do {
                mIn = in.readLine();
            } while (!mIn.equals("800"));
            System.out.println("Biglietti terminati");
            
            
        } catch (Exception e) {}
    }
}
