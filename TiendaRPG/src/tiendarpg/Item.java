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

    //Atributos de las 3 categorías categorías 
    protected  String color;
    protected  String nombre;
    protected  int precio;
    protected  int nivel;
    protected  int poder;
    protected String tipo;
    protected double peso;
    protected String material;
    protected String tamaño;
    
    //Constructor de la clase Item
    Item(String nombre,String color,int precio,int nivel, int poder){
        this.nombre=nombre;
        this.color=color;
        this.precio=precio;
        this.nivel=nivel;
        this.poder=poder;
    }  
    
    //Metodo para mostrar el precio del item
    public int getPrecio(){
        return this.precio;
    }
    
    //Metodo para mostrar el color del item
    public String getColor() {
        return this.color;
    }

    //Metodo para mostrar el nombre del item
    public String getNombre() {
        return this.nombre;
    }

    //Metodo para mostrar el nivel del item
    public int getNivel() {
        return this.nivel;
    }

    //Metodo para mostrar el poder del item
    public int getPoder() {
        return this.poder;
    }
    
    //Metodo para mostrar el tipo del item (Categoria consumible o espada, unicamente)
    public String getTipo() {
        return this.tipo;
    }
    
    //Metodo para mostrar el peso del item (Espada unicamente)
    public double getPeso() {
        return this.peso;
    }
    
    //Metodo para mostrar el material del item (Armadura unicamente)
    public String getMaterial() {
        return this.material;
    }
    
    //Metodo para mostrar el tamaño del item (Armadura)
    public String getTamaño() {       
        return tamaño;
    }
}
