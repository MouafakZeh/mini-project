
import java.io.*;
import java.util.List;

class Commandes implements Runnable
{
  Server _Serv;
  BufferedReader _in;
  String _strCommande=""; 
  Thread _t; 
  List <offers> offe;
  List<encheres> ench;
  List<membres> membe;
  int x,bh;
  float y;
  int longeur;
  
  String nom;
   Commandes(Server Serv)
  {
    _Serv=Serv;
    _in = new BufferedReader(new InputStreamReader(System.in));
    _t = new Thread(this); 
    _t.start(); 
  }
  public void run() 
  {
    try
    {
        
      while ((_strCommande=_in.readLine())!=null){ 
      
          
          System.out.println("donner votre nom");
          nom = _strCommande=_in.readLine();
          membres memy= new membres(nom);
          membe.add(memy);
          
          if(_strCommande.equalsIgnoreCase("encheres")){
      longeur=ench.size();
          if (longeur !=0){
              for (int i = 0; i < longeur; i++)
              {System.out.println((ench.get(i)).toString()); }
          }
          else System.out.println("list de enchere est vide");
      }
      
      
      
      
      
          else if (_strCommande.equalsIgnoreCase("join")) {
          System.out.println("donner le id de enchere");
          x = Integer.parseInt(_strCommande=_in.readLine());
          longeur=ench.size();
          if (longeur !=0){
              for (int i = 0; i < longeur; i++) {
                  if (( (ench.get(i)).gettId() )== x )
                      (ench.get(i)).addmem(memy);
              }
          }
          else System.out.println("list de enchere est vide");
}
          
          
          
          
          
        else if(_strCommande.equalsIgnoreCase("offre")){
            
          System.out.println("donner le id de enchere");
          x = Integer.parseInt(_strCommande=_in.readLine());
          System.out.println("donner le prix");
          y = Float.parseFloat(_strCommande=_in.readLine());
          longeur=ench.size();
          if (longeur !=0){
              for (int i = 0; i < longeur; i++)
              {if (( (ench.get(i)).gettId() )== x )
                      if((ench.get(i)).getPrix()<y){
                      System.out.println("Offre acceptée");
                      offers xab = new offers(memy,ench.get(i),y);
                      offe.add(xab);   }
                      else System.out.println("Offre non valide");
              }
          }
          else System.out.println("list de enchere est vide");
          
        }
        
        
        
        
        
        else if (_strCommande.equalsIgnoreCase("list")){ 
            System.out.println("donner le id de enchere");
          x = Integer.parseInt(_strCommande=_in.readLine());
          longeur=ench.size();
          if (longeur !=0){
              for (int i = 0; i < longeur; i++) {
                  if (( (offe.get(i)).getench().gettId() )== x ){
                     System.out.println((offe.get(i)).getmem().getId());
                  bh=i;}
              }
          }
          else if (bh ==longeur) System.out.println("le id donner n'exist pas ");
          if(longeur==0) System.out.println("list de enchere est vide");
        }
        
        
        
        
        else if (_strCommande.equalsIgnoreCase("quitter")) 
          System.exit(0);
        else
        {
          System.out.println("Cette commande n'est pas supportee");
          System.out.println("pour lister tous les encheres : \"encheres\"");
          System.out.println("join : \"join\"");
          System.out.println("pour offre : \"offre\"");
          System.out.println("pour lister tous les offre sur un encheres  : \"list\"");
          System.out.println("--------");
          System.out.println("pour Quitter  : \"quitter\"");
          System.out.println("--------");
        }
        System.out.flush();
      }
    }
    catch (IOException e) {}
  }
}
