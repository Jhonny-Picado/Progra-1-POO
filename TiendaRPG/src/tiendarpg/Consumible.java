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
        this.tipo= tipo;
    }

    //toString, muestra el contenido de los atributos de Consumible
    @Override
    public String toString  (){ //Getter
        return super.getDatos()+" tipo: "+ tipo;
    }
}
