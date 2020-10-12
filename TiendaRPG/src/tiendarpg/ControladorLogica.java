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
import javax.swing.JOptionPane;



/**
 *
 * @author Jhonny Picado Vega
 */
public class ControladorLogica  implements ActionListener{
    
    public static TiendaGUI vista;
    public static Tienda inventarioTienda;
    public static Personaje inventarioJugador;
    
    
    public ControladorLogica(TiendaGUI interfaz,Tienda inventarioTienda, Personaje inventarioJugador){
  
    this.vista = interfaz;
    
    NombreTienda();
    NombrePersonaje();
    DineroTienda();
    MostrarTablaTienda();
    MostrarTablaPersonaje();
    ModificarStats();
    }
    
    
    public static void main(String[] args) throws IOException{
        List<Item> items;
        List<Item> itemsTienda;
        List<Item> itemsPersonaje;      
        
        ControladorInicial inicializador = new ControladorInicial();
        
        items = inicializador.Controlador();

        itemsTienda = inicializador.ProductosTienda(items); 
        inventarioTienda=new Tienda(itemsTienda); 

        itemsPersonaje = inicializador.ItemsPersonaje(items);
        inventarioJugador= new Personaje(itemsPersonaje);
        
        
        TiendaGUI vista = new TiendaGUI();
        
        ControladorLogica controladorGUI = new ControladorLogica(vista, inventarioTienda, inventarioJugador);
        
        
        controladorGUI.vista.setVisible(true);
        controladorGUI.vista.setLocationRelativeTo(null);
        

            //Mensajes de error :)
       // JOptionPane.showMessageDialog(vista, "La reserva ha sido registrada con "+ "exito");

    }
    
    
    public static void Comprar(){
        
        Item producto;
        
        producto=inventarioTienda.VenderTienda(0);
        inventarioJugador.ComprarPersonaje(producto);
        DineroTienda();
        MostrarTablaTienda();
        MostrarTablaPersonaje();
        ModificarStats();
    }
    

    public static void Vender(int i, Tienda invTienda, Personaje invPersonaje){
        
        Item producto;
        
        producto=invPersonaje.VenderPersonaje(i);
        invTienda.ComprarTienda(producto);
        
    }
   
   
    //Metodo que intoduce el nombre de la tienda en la GUI
    public static void NombreTienda(){
        vista.tituloTienda.setText(inventarioTienda.getnombre());
    } 
    
    //Metodo que intoduce el nombre de la tienda en la GUI
    public static void NombrePersonaje(){
        vista.nombreJugador.setText(inventarioJugador.getnombre());
    } 

    //Método para mostrar el dinero de la tienda en la GUI
    public static void DineroTienda(){
        int valor=inventarioTienda.getdinero();
        vista.dineroTienda.setText(Integer.toString(valor));
    }
    
    public static void MostrarTablaTienda(){
        
        
        for (int i=0; i<inventarioTienda.Size(); i++){

            Item products =(Item) inventarioTienda.get(i);
     
            vista.productoTienda[0]=products.getNombre();
            vista.productoTienda[1]=products.getTipo();
            vista.productoTienda[2]=products.getColor();
            vista.productoTienda[3]=products.getNivel();
            vista.productoTienda[4]=products.getPoder();
            vista.productoTienda[5]=products.getPeso();
            vista.productoTienda[6]=products.getMaterial();
            vista.productoTienda[7]=products.getTamaño();
            vista.productoTienda[8]=products.getPrecio();
            vista.tablaTienda.addRow(vista.productoTienda);
        }    
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String actionCommand = ae.getActionCommand();
        if(actionCommand.equals("Comprar")) {
            
            JOptionPane.showMessageDialog(vista, "La reserva ha sido registrada con "+ "exito");
        }
    }
    
    
    
    public static void MostrarTablaPersonaje(){
        
        for (int i=0; i<inventarioJugador.Size(); i++){

            Item products =(Item) inventarioJugador.get(i);
     
            vista.productoPersonaje[0]=products.getNombre();
            vista.productoPersonaje[1]=products.getTipo();
            vista.productoPersonaje[2]=products.getColor();
            vista.productoPersonaje[3]=products.getNivel();
            vista.productoPersonaje[4]=products.getPoder();
            vista.productoPersonaje[8]=products.getPeso();
            vista.productoPersonaje[6]=products.getMaterial();
            vista.productoPersonaje[7]=products.getTamaño();
            vista.productoPersonaje[8]=products.getPrecio();
            vista.tablaPersonaje.addRow(vista.productoPersonaje);
        }    
    }
    
    
    public static void ModificarStats(){
        
        vista.nombrePersonajeSt1.setText(inventarioJugador.getnombre());
        vista.vida.setText(Integer.toString(inventarioJugador.getVida()));
        vista.defensa.setText(Integer.toString(inventarioJugador.getDefensa()));
        vista.agilidad.setText(Integer.toString(inventarioJugador.getAgilidad()));
        vista.ataque.setText(Integer.toString(inventarioJugador.getAtaque()));
        vista.cantItems1.setText(Integer.toString(inventarioJugador.Size()));
        vista.dineroJugador.setText(Integer.toString(inventarioJugador.getDinero()));
    }
    
    
    
}