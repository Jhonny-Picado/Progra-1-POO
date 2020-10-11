/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

/**
 *
 * @author cva
 */
public class Armadura extends Item{
    
    //Atributos propios de la clase arma 
    
    private String tamaño;
    private String material;
    //Constructor que modifica los atributos de Arma
    public Armadura(String nombre, String color, int precio, int nivel, int poder,String tamaño, String material){
        
        
        
        super(nombre,color,precio,nivel,poder);
        this.tamaño= tamaño;
        this.material=material;
    }
    
    //toString, muestra el contenido de los atributos de Arma
    @Override
    public String toString  (){ //Getter
        return super.getDatos()+" tamaño: "+ tamaño+ ",  material: "+material;
    }
}