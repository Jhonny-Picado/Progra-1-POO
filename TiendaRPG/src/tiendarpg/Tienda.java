/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import java.util.List;

/**
 * Clase de la tiendaRPG
 * @author Jhonny Picado Vega
 */
public class Tienda {
    
    //Atributos propios de la tienda
    private String nombre;
    private int dinero;
    private List<Item> inventarioTienda;

    //Constuctor por defecto
    Tienda() {
    }
    
    //Constructor inicializador
    Tienda(List<Item> items) {
        
        nombre = "Sogeking Store";
        dinero = (int)(Math.random()*17000+15000);
        inventarioTienda=items;
    }

    //Metodo utilizado pra la compra de items por parte de la tienda, rebaja el
    //dinero y añade el item al inventario
    public void ComprarTienda(Item item, int precio){
        dinero-=precio;
        inventarioTienda.add(item); 
    }
    
    //Metodo utilizado pra la compra de items por parte de la tienda, retorna el item vendido
    public Item VenderTienda(int i){
        Item itemTemporal= inventarioTienda.get(i);
        return itemTemporal;
    }

    //Metodo que muestra el dinero de la tienda
    public int getdinero(){ 
        return dinero;
    }
    
    //Metodo que muestra el nombre de la tienda
    public String getnombre(){
        return nombre;
    }

    //Metodo que devuelve un objeto item
    public Object get(int i) {
        return inventarioTienda.get(i);
    }
    
    //Metodo que retorna la cantidad de items que tiene la tienda
    public int Size(){
        return inventarioTienda.size();
    }
    
    //Metodo que borra un item del inventario (se usa en vender)
    public void remove(int i){
        inventarioTienda.remove(i);
    }
    
    //Metodo utilizado para modificar el dinero de la tienda
    public void setDinero(int precio){    
        dinero+=precio;
    }
}



