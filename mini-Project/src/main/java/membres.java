
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Draxtoss
 */
public class membres{
    private final int Id;
    private final String Nom;
    private static int IdCounter = 0;

    public membres(String nom){
        this.Id= IdCounter++;
        this.Nom=nom;
    }
        public membres(){
        this.Id= IdCounter++;
        this.Nom="";
    }
    public String toString() {
    return String.format("{ id: %s, name: %s }", Id, Nom);
  }
    public int getId(){
        return(this.Id);
    }
    public String getNom(){
        return(this.Nom);
    }
    public void printId(){
        System.out.println(this.Id);
    }
    public void printNom(){
        System.out.println(this.Nom);
    }
    
}

