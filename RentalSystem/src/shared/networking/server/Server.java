package shared.networking.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote
{
  ServerProduct getProductServer() throws RemoteException;
  ServerBasket getBasketServer() throws RemoteException;
  ServerReservation getReservationServer() throws RemoteException;
  ServerUser getUserServer() throws RemoteException;

}
