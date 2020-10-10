/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhonny Picado Vega
 */
public class Tienda {
    
    private String nombre;
    private int dinero;
    private static List<Item> inventarioTienda;
    private int indice;
    private int contador;
    public Item objecto;
    
    Tienda() {
    }
    
    
    public Tienda(List<Item> items) {
        nombre ="Sogeking Store";
        dinero = (int)(Math.random()*1000000+500000);
        inventarioTienda=items;
        contador=20;
    }


    
    public void ComprarTienda(Item item){
        contador++;
        dinero-=item.getPrecio();
        inventarioTienda.add(item);
    }
    
    public Item VenderTienda(int i){
        
        this.dinero += inventarioTienda.get(i).getPrecio();
        Item itemTemporal= inventarioTienda.get(i);
        inventarioTienda.remove(i);
        
        return itemTemporal;
    }

    public String dimeInventario(){
        System.out.println("El nombre de la tienda es:" + nombre+ "Dinero: "+dinero);
        for (Item i : inventarioTienda){
            System.out.println(i.toString());
        }
       return "El nombre de la tienda es:     " + nombre+ "    Dinero:    "+dinero;
    }
    
    public double dinero(){ 
        return dinero;
    }
    
    
}



