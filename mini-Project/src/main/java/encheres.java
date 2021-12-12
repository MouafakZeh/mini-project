
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Draxtoss
 */
public class encheres{
    private int enId;
    private String Desc;
    private Float Prix;
    private Integer Heur;
    private Integer Etat;
    private List<membres> Members ;
    private static int IdCounter = 0;

    public encheres(String desc,Float prix , Integer heur,Integer etat,membres mem){
        this.enId= IdCounter++;
        this.Desc=desc;
        this.Prix=prix;
        this.Heur=heur;
        this.Etat=etat;
        Members.add(mem);
    }
        public String toString() {
    return String.format("{ id: %s,Titre(description): %s, prix: %d , Heur fin: %s, }", this.enId,this.Desc,this.Prix,this.Heur);
  }
    public int gettId(){
        return(this.enId);
    }
    public String getDesc(){
        return(this.Desc);
    }
        public void addmem(membres x){
        Members.add(x);
    }
    public float getPrix(){
        return(this.Prix);
    }
    public int getHeur(){
        return(this.Heur);
    }
    public int getEtat(){
        return(this.Etat);
    }
}
