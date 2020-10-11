/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import GUI.Interfaz;
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
        inventarioTienda.dimeInventario();
        System.out.println("\n"+"\n");
        itemsPersonaje = inicializador.ItemsPersonaje(items);
        Personaje inventarioJugador= new Personaje(itemsPersonaje);
        inventarioJugador.imprimirInventario();
        System.out.println("\n"+"\n");
  
            
           
        Vender(6, inventarioTienda, inventarioJugador);
        inventarioTienda.dimeInventario();
        System.out.println("\n"+"\n");
        inventarioJugador.imprimirInventario();

        
    }
    
    public static void Comprar(int i, Tienda invTienda, Personaje invPersonaje){
        
        Item producto;
        
        producto=invTienda.VenderTienda(i);
        invPersonaje.ComprarPersonaje(producto);
        
    }
    
   public static void Vender(int i, Tienda invTienda, Personaje invPersonaje){
        
        Item producto;
        
        producto=invPersonaje.VenderPersonaje(i);
        invTienda.ComprarTienda(producto);
        
    }



    public static void TitulosGUI(){
        
        public Interfaz 
        

    }
        
        
        
} 

            
            
                      
