/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.*;
import javax.swing.JOptionPane;


 /*
 * @uthor Jhonny Picado
 * @author Christopher Vindas
 */
public class Personaje {

    //Atributos del personaje
    private int vida;
    private int dinero;
    private String nombre;
    private int agilidad ;
    private int ataque ;   
    private List<Item> inventarioPersonaje;
    private int defensa;
    
    //Constructor por defeto
    Personaje() {
        
    }
    
    //Constructo que inicializa los atributos, recibe los items del inventario
    Personaje(List<Item> items){
    
        //Inicializo los atributos con valores randoms
        this.vida = (int)(Math.random()*50+25);
        this.dinero =(int)(Math.random()*18000+10000);
        this.agilidad =(int)(Math.random()*78+12);
        this.ataque = (int)(Math.random()*70+30);
        this.defensa = (int)(Math.random()*80+15);
        this.nombre = JOptionPane.showInputDialog("Introduce el nombre del personaje");
        
        inventarioPersonaje=items;
    }
    
    //Metodo comprar de articulos de la tienda, resta el dinero del item comprado
    //añade ese item al inventario
    public void ComprarPersonaje(Item item){
        dinero-=item.getPrecio();
        inventarioPersonaje.add(item);
    }
    
    //Metodo de vender un item de personaje, retorna el item vendido
    public Item VenderPersonaje(int i){
        Item itemTemporal=inventarioPersonaje.get(i);
        return itemTemporal;
    }
  
    //Metodo usado para modificar la vida del personaje
    public void setVida(int vida) {
        this.vida += vida;
        
        if (this.vida>100)
            this.vida = this.vida -(this.vida-100);
        
        if (this.vida<0)
            this.vida=0;
    }
    
   
    //Metodo usado para mostrar la defensa del personaje
    public int getDefensa() {
        return defensa;
    }
   
    //Metodo usado para mostrar el nombre del personaje
    public String getnombre() {
        return nombre;
    }
    
    //Metodo usado para mostrar la vida del personaje
    public int getVida() {
        return vida;
    }

    //Metodo usado para mostrar el dinero del personaje
    public int getDinero() {
        return dinero;
    }

    //Metodo usado para mostrar la agilidad del personaje
    public int getAgilidad() {
        return agilidad;
    }

    //Metodo usado para mostrar el ataque del personaje
    public int getAtaque() {
        return ataque;
    }
    
    //Metodo usado para devolver un objeto, se usa cuando se vende un item
    public Object get(int i) {
        return inventarioPersonaje.get(i);
    }
    
    //Metodo que devuelve cuantos items tiene el personaje
    public int Size() {
        return inventarioPersonaje.size();
    }
    
    //Metoto usado para borrar un item, en que caso de que haya sido vendido
    public void remove(int i){
        inventarioPersonaje.remove(i);
    }
    
    //metodo usado para modificar el dinero del personaje
    public void setDinero(int precio){
        dinero+=precio;
    }
}