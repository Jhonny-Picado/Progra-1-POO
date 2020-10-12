/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.*;


 /*
 * @uthor Jhonny Picado
 * @author Christopher
 */
public class Personaje {

    //Atributos del personaje
    private int vida;
    private String armadura;
    private int dinero;
    private String nombre;
    private int agilidad ;
    private int ataque ;   
    private List<Item> inventarioPersonaje;
    private int defensa;
    
    //Constructor por defeto
    Personaje() {
        
    }
    
    
    
    Personaje(List<Item> items){
    
        //Inicializo los atributos con valores randoms
        this.vida = (int)(Math.random()*50+25);
        this.dinero =(int)(Math.random()*18000+10000);
        this.agilidad =(int)(Math.random()*78+12);
        this.ataque = (int)(Math.random()*70+30);
        this.defensa = (int)(Math.random()*80+15);
        this.nombre = "Sogeking";
        
        inventarioPersonaje=items;
    }
    
    //Metodo comprar de la tienda
    public void ComprarPersonaje(Item item){
        
        if (item.getPrecio()>dinero){
            System.out.println("No hay suficiente dinero");
        }
        else{
        dinero-=item.getPrecio();
        inventarioPersonaje.add(item);
        }
    }
    
    //Metodo de vender un item de personaje
    public Item VenderPersonaje(int i){
        
        this.dinero += this.inventarioPersonaje.get(i).getPrecio();
        
        Item itemTemporal=inventarioPersonaje.get(i);
        
        inventarioPersonaje.remove(i);
        
        return itemTemporal;
    }
  
    public void setVida(int vida) {
        this.vida += vida;
        
        if (this.vida>100)
            this.vida = this.vida -(this.vida-100);
        
        if (this.vida<0)
            this.vida=0;
    }
    
    
    
    public String getArmadura() {
        return armadura;
    }
    
    

    public int getDefensa() {
        return defensa;
    }
   
    public String getnombre() {
        return nombre;
    }
    
    public int getVida() {
        return vida;
    }

    public int getDinero() {
        return dinero;
    }


    public int getAgilidad() {
        return agilidad;
    }

    public int getAtaque() {
        return ataque;
    }
    
    public Object get(int i) {
        return inventarioPersonaje.get(i);
    }
    
    public int Size() {
        return inventarioPersonaje.size();
    }

}