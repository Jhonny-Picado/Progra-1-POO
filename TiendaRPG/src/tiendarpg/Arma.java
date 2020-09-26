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
    
    private String tipo;
    private double peso;
    
    public Arma(String nombre, String color, double precio, int nivel, int poder, String tipo, double peso){
        
        this.nombre=nombre;
        this.color=color;
        this.precio=precio;
        this.nivel=nivel;
        this.poder=poder;
        this.tipo= tipo;
        this.peso=peso;
    }

    //Getter
    public String dimeDatos(){
        return "El color del arma es: "+ color +", Nombre: "+ nombre+ ", Precio: "+precio+ ", Nivel: "+nivel+", Poder: "+poder+ ", Tipo:"+tipo+", Peso"+peso;
    }
}
