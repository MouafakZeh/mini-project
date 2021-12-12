
import java.net.*;
import java.io.*;

class Clients implements Runnable
{
  private Thread _t; 
  private Socket _s; 
  private PrintWriter _out; 
  private BufferedReader _in; 
  private Server Serve; 
  private int _numClient=0; 

    Clients(Socket s, Server Serv)
  {
    Serve=Serv; 
    _s=s; 
    try
    {
           _out = new PrintWriter(_s.getOutputStream());
      _in = new BufferedReader(new InputStreamReader(_s.getInputStream()));
      _numClient = Serv.addClient(_out);
    }
    catch (IOException e){ }

    _t = new Thread(this);
    _t.start(); 
  }
  public void run()
  {
    String message = "";
    System.out.println("Un nouveau client s'est connecte, no "+_numClient);
    try
    {

      char charCur[] = new char[1];
      while(_in.read(charCur, 0, 1)!=-1) 
      {
        if (charCur[0] != '\u0000' && charCur[0] != '\n' && charCur[0] != '\r')
                message += charCur[0]; 
        else if(!message.equalsIgnoreCase(""))
        {
          if(charCur[0]=='\u0000') 
          	
            Serve.sendAll(message,""+charCur[0]);
          else Serve.sendAll(message,"");
          message = "";
        }
      }
    }
    catch (Exception e){ }
    finally 
    {
      try
      {
      
        System.out.println("Le client no "+_numClient+" s'est deconnecte");
        Serve.delClient(_numClient); 
        _s.close(); 
      }
      catch (IOException e){ }
    }
  }
}
