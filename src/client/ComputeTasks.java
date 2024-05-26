package client;

import compute.Compute;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputeTasks {

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup("Compute");

            Pi task1 = new Pi(Integer.parseInt(args[1]));
            BigDecimal pi = comp.executeTask(task1);
            System.out.println("Machine-like formula PI = " + pi);

            ConstantE task2 = new ConstantE(Integer.parseInt(args[1]));
            Double constantE = comp.executeTask(task2);
            System.out.println("Constant E = " + constantE);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
