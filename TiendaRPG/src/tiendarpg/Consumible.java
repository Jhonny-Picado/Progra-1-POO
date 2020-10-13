/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

/**
 * Clase de la categoría consumible
 * @author Jhonny Picado Vega
 */
public class Consumible extends Item {
    
    //Constructor que modifica los atributos de Consumible
    public Consumible(String nombre, String color, int precio, int nivel, int poder, String tipo){
        
        super(nombre,color,precio,nivel,poder);
        
        //Atributo propio de consumible
        this.tipo= tipo;
    }
}
