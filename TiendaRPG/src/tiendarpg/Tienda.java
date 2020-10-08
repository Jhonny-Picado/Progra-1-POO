/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Tienda {
    
    private final String nombre;
    private int dinero;
    private List<Item> inventarioTienda;
    private  int j;
    private String casa;
    
    public Tienda(List<Item> items) {
        nombre ="Sogeking Store";
        dinero=54023821;
        inventarioTienda=items;
    }
    
    public void Eliminaritem(int j){
        this.j=j;
        dinero+=inventarioTienda.get(j).precio;
        inventarioTienda.remove(j);
        
    }

    public String dimeInventario(){
        System.out.println("El nombre de la tienda es:" + nombre+ "Dinero: "+dinero);
        int cont = 0;
        for (Item i : inventarioTienda){
            System.out.println(i);
            cont++;
        }
       return "El nombre de la tienda es:" + nombre+ "Dinero: "+dinero;
    }


    
}
