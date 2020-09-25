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
public class Armas {
    
    private String color;
    private String nombre;
   // private int cantidad;
    private double precio;
    private int nivel;
    private int poder;
    private String tipo;
    private double peso;
    
    public Armas(String color, String nombre, double precio,int nivel, int poder, String tipo, double peso){
        
        this.color=color;
        this.nombre=nombre;
        this.precio=precio;
        this.nivel=nivel;
        this.poder=poder;
        this.tipo= tipo;
        this.peso=peso;
        
    }

    public String dimeCar(){
        String msj;
        
        msj="El color del arma es: "+color+"\n"+"El nombre del arma es: "+nombre+
            "\n"+ "El precio del arma es: "+precio+"\n"+ "El nivel del arma es: "+ nivel+
            "\n"+ "El poder del arma es: "+ poder+ "\n"+ "El tipo de arma es: "+tipo+
            "\n"+"El peso del arma es: "+ peso;
        return msj;
    }
    
}
