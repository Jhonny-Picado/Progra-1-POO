/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

/**
 *
 * @author Jhonny Picado Vega
 */
public class Arma extends Item{
    
    //Atributos propios de la clase arma 
    //double peso;
    
    //Constructor que modifica los atributos de Arma
    Arma(String nombre, String color, int precio, int nivel, int poder, String tipo, double peso){
        
        super(nombre,color,precio,nivel,poder);
        this.tipo= tipo;    //Tipo atributo propio de Arma
        this.peso=peso;    //Peso atributo propio de Peso
    }  
}