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
    protected  double precio;
    protected  int nivel;
    protected  int poder;
    
    //
    public Item(String nombre,String color,double precio,int nivel, int poder){
        this.nombre=nombre;
        this.color=color;
        this.precio=precio;
        this.nivel=nivel;
        this.poder=poder;
    }  
    
    //Get que muestra los atributos comunes de los items
    public String getDatos(){
        
        return "El color del arma es: "+ color +", Nombre: "+ nombre+ ", Precio: "
        +precio+ ", Nivel: "+nivel+", Poder: "+poder;
    }
}
