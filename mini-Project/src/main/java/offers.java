/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Draxtoss
 */
public class offers {
    private Float Prix;  

  private final membres memb;
  private final encheres ench;
  private final float prix;
  public offers(membres mem,encheres ench, float prix) {
    this.memb = mem;
    this.prix = prix;
    this.ench=ench;
  }
  public membres getmem() {return memb;}

  public float getPrix() {return prix;}
  public encheres getench() {return ench;}
  
  public boolean isFromUser(membres memb) {return this.memb.equals(memb);}

}
