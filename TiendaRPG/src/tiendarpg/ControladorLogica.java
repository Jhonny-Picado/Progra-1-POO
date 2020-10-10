/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.io.IOException;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class ControladorLogica {
    public static void main(String[] args) throws IOException{
        List<Item> items;
        List<Item> itemsTienda;
        List<Item> itemsPersonaje;      
        
        
        ControladorInicial inicializador = new ControladorInicial();
        
        items = inicializador.Controlador();

        itemsTienda = inicializador.ProductosTienda(items); 
        Tienda inventarioTienda=new Tienda(itemsTienda); 
        
        itemsPersonaje = inicializador.ItemsPersonaje(items);
        Personaje inventarioJugador= new Personaje(itemsPersonaje);

        
        
        
        
        
        
        
        
    }
}
