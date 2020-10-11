/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.*;


 /*
 *
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
    int contador;
    
    //Constructor por defeto
    Personaje() {
        
    }
    
    
    
    Personaje(List<Item> items){
    
        //Inicializo los atributos con valores randoms
        this.vida = (int)(Math.random()*100+1);
        this.dinero =(int)(Math.random()*20000+15000);
        this.agilidad =(int)(Math.random()*100+1);
        this.ataque = (int)(Math.random()*100+1);   
        this.nombre = "Sogeking";
        this.contador=7;
        
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
    

    public void imprimirInventario(){
        System.out.println("Personaje:     " + nombre+ "        Dinero:    "+dinero);
        for (Item i : inventarioPersonaje){
            System.out.println(i);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Metodo que selecciona el nombre del jugador
    public void SelNombre(String nombre){
        this.nombre=nombre;
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

    public void setDinero(double dinero) {
        this.dinero += dinero;
        if (this.dinero<0)
            this.dinero=0;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;  
    }


    public void setAgilidad(int agilidad) {
        this.agilidad += agilidad;
        if (this.agilidad<0)
            this.agilidad=0;
    }


    public void setAtaque(int ataque) {
        this.ataque += ataque;
        if (this.ataque<0)
            this.ataque=0;
    }

    
    


    /*
    public void guardar() {
        // TODO implement here
        return null;
    }

    
    public void reiniciarEstados() {
        // TODO implement here
        return null;
    }
     public double comprar() {
        // TODO implement here
        return 0.0d;
    }

    
    public double vender() {
        // TODO implement here
        return 0.0d;
    } a controlador// recibe id de personaje

    */
   
    //Metodo que muestra las stats del jugador
    public String mostrarStats() {
        
        String mensaje="";
        mensaje+="dinero: "+ dinero;
        mensaje+="\nNombre: "+  nombre;
        mensaje+="\n Vida : "+vida;
        mensaje+="\n Armadura : "+armadura;
        mensaje+="\n Agilidad : "+agilidad;

        return mensaje;
    
    
    }

}