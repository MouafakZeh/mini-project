
import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
  private Vector _tabClients = new Vector(); 
  private int _nbClients=0; 

  public static void main(String args[])
  {
    Server Serv = new Server(); 
    try
    {
      Integer port;
      if(args.length<=0) port=new Integer("18000");
      else port = new Integer(args[0]); 

      new Commandes(Serv);

      ServerSocket ss = new ServerSocket(port.intValue()); 
      printWelcome(port);
      while (true)
      {
        new Clients(ss.accept(),Serv); 
      }
    }
    catch (Exception e) { }
  }

  static private void printWelcome(Integer port)
  {
    System.out.println("--------");
    System.out.println("Mini-Projet : Mouafak Zehri");
    System.out.println("--------");
    System.out.println("Tappez ENCHERES pour lister tous les enchere");
    System.out.println("--------");
    System.out.println("Tappez join pour joindre un enchere");
    System.out.println("--------");
    System.out.println("Tappez offre pour fair un offre sur un enchere");
    System.out.println("--------");
    System.out.println("Tappez list pour litse pour lister tous les offre sur un enreche");
    System.out.println("--------");
  }



  synchronized public void sendAll(String message,String sLast)
  {
    PrintWriter out;
    for (int i = 0; i < _tabClients.size(); i++)
    {
      out = (PrintWriter) _tabClients.elementAt(i);
      if (out != null) 
      {
      	
        out.print(message+sLast);
        out.flush(); 
      }
    }
  }

   synchronized public void delClient(int i)
  {
    _nbClients--; 
    if (_tabClients.elementAt(i) != null)
    {
      _tabClients.removeElementAt(i);
    }
  }

  synchronized public int addClient(PrintWriter out)
  {
    _nbClients++; 
    _tabClients.addElement(out);
    return _tabClients.size()-1; 
  }

   synchronized public int getNbClients()
  {
    return _nbClients; 
  }

}
