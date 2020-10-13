/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

/**
 *Clase de la categoría Armadura
 * @author Christopher
 */
public class Armadura extends Item{
    
    //Constructor que modifica los atributos de Armadura
    Armadura(String nombre, String color, int precio, int nivel, int poder,String tamaño, String material){
       
        super(nombre,color,precio,nivel,poder);
        
        //Atributos propios de la clase Armadura 
        this.tamaño= tamaño;
        this.material=material;
    }
    
    //Metodo get para mostar el tamaño de la armadura
    public String getTamaño(){
       return this.tamaño;
    }
}