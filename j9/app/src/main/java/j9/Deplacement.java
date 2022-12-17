package j9;

public class Deplacement {
    private char sens;
    private int valeur;
 public Deplacement(char sens , int valeur){
    this.sens = sens;
    this.valeur = valeur;
 }  

 public void setValeur(int valeur) {
     this.valeur = valeur;
 }
 public char getSens() {
     return sens;
 }
 public int getValeur() {
     return valeur;
 }
 public boolean estHaut (){
    return getSens() == 'U';
 }
 
 public boolean estBas (){
    return getSens() == 'D';
 }
 
 public boolean estDroite (){
    return getSens() == 'R';
 }
 
 public boolean estGauche (){
    return getSens() == 'L';
 }
}
