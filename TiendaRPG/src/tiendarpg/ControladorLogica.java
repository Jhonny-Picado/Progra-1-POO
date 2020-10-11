/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import GUI.TiendaGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class ControladorLogica  implements ActionListener{
    
    
    public static TiendaGUI inicializadorGUI;
    public TiendaGUI vista;
    
    
    public ControladorLogica(TiendaGUI interfaz){
    this.vista = interfaz;
    }
    
    
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
        
        
        TiendaGUI vista = new TiendaGUI();
        NombreTienda(inventarioTienda);
        ControladorLogica controladorGUI = new ControladorLogica(vista);
        
        
        controladorGUI.vista.setVisible(true);
        controladorGUI.vista.setLocationRelativeTo(null);

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

    public static void NombreTienda(Tienda inventarioTienda){
        inicializadorGUI.tituloTienda.setText(inventarioTienda.getnombre());
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }              

}