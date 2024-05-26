package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        ComputeEngine engine = new ComputeEngine();
        engine.start();
        System.out.println(System.lineSeparator() + "Hit enter to stop.");

        boolean doJob = true;
        Scanner scanner = new Scanner(System.in);
        while (doJob) {
            String inputString = scanner.nextLine();
            if (inputString.equals("")) {
                doJob = false;
                engine.finish();
            }
        }
    }
}
