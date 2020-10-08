/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;


/**
 * Super clase de la categorías de Items 
 * @author Jhonny Picado Vega
 */
public class Item {

    /**
     * 
     */
    protected  String color;
    protected  String nombre;
    protected  int precio;
    protected  int nivel;
    protected  int poder;
    
    //
    public Item(String nombre,String color,int precio,int nivel, int poder){
        this.nombre=nombre;
        this.color=color;
        this.precio=precio;
        this.nivel=nivel;
        this.poder=poder;
    }  
    
    //Get que muestra los atributos comunes de los items
    public String getDatos(){
        
        return "Color: "+ color +", Nombre: "+ nombre+ ", Precio: "
        +precio+ ", Nivel: "+nivel+", Poder: "+poder;
    }
    
    public void setnombre(String name){
        
        this.nombre=name;
        
    }
}
