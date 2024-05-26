package server;

import compute.Compute;
import compute.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine extends Thread implements Compute {

    Compute engine;
    Compute stub;
    Registry registry;

    public ComputeEngine() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }

    @Override
    public void run() {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        engine = new ComputeEngine();

        try {
            stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            registry = LocateRegistry.getRegistry();

            registry.rebind("Compute", stub);
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    }

    public void finish() throws RemoteException, NotBoundException {
        registry.unbind("Compute");
        UnicastRemoteObject.unexportObject(engine, true);
    }
}
