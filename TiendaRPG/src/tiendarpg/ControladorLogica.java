/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
//Se importan las librerías necesarias
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
    
    //Atributos de la clase que se usan en su mayoría para referenciar los metodos de distintas clases
    public static TiendaGUI vista;  //Se usa para hacer evento en la GUI y modificación
    
    //Declara los inventarios como estaticos para usarlos en el main, sino daba error
    public static Tienda inventarioTienda;
    public static Personaje inventarioJugador;
    
    //Controlador por defecto, se usa en la gui para llamar los metodos de los botones que estan en esta clase
    public ControladorLogica(){  
    }
    
     /**
   * Método constructor de la clase
   * @param vista Objeto de tipo TiendaGUI que utiliza el objeto para realizar las peticiones del usuario
   */
    ControladorLogica(TiendaGUI interfaz){
  
    this.vista = interfaz;      //Vista es la variable para referirse a la GUI
    
    //Inicializo la gui con las tablas y nombres
    NombreTienda();
    NombrePersonaje();
    DineroTienda();
    MostrarTablaTienda();
    MostrarTablaPersonaje();
    ModificarStats();
    CantItemsTienda();
    }
    

    public static void main(String[] args) throws IOException{
        
        //Listas para dividir los items en ambos inventarios
        List<Item> items;
        List<Item> itemsTienda;
        List<Item> itemsPersonaje;      
        
        //Se declara un inicializador para dividir los items
        ControladorInicial inicializador = new ControladorInicial();
        
        //Guardo los items llamando al metodo del controlador inicial
        items = inicializador.ControladorInicial();

        //Divide los items en ambos inventarios
        itemsTienda = inicializador.ProductosTienda(items); 
        inventarioTienda=new Tienda(itemsTienda); 
        itemsPersonaje = inicializador.ItemsPersonaje(items);
        inventarioJugador= new Personaje(itemsPersonaje);
        
        //Inicializa la variable vista con el constructor por defecto de la interfaz
        vista = new TiendaGUI();
        
        //Pasa esta variable al controlador de esta clase para que se inicialice con la GUI
        ControladorLogica controladorGUI = new ControladorLogica(vista);
        
        //Hace visible la interfaz
        controladorGUI.vista.setVisible(true);
        controladorGUI.vista.setLocationRelativeTo(null);
    }
    
    /**
   * Método para invocar los métodos que ejecutan las operaciones indicadas por el usuario
   * dentro de la vista TiendaGUI
   * @param ae Objeto de tipo ActionEvent que indica la acción que el usuario ha seleccionado
   * dentro de la vista TiendaGUI (Administra los eventos)
   */
   @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()){
        case "Comprar":
            Comprar();
            break;
        case "Vender":
            Vender();
            break;
        case "Equipar":
            //Aquí tiene que llamar al método equipar
            break;
        default:
             break;
        }
    }
    
    
    //Metodo de compra, utilizado en la GUI
    public static void Comprar(){
        
        int index=vista.productosTienda.getSelectedRow();               //Pide el indice de la lista donde el usuario ingreso un clic
        int precio=inventarioTienda.VenderTienda(index).getPrecio();    //Obtiene el precio de del objeto que se ubica en ese indice
        
        //Verifica si la tiene dinero suficiente para la compra
        if (inventarioJugador.getDinero()>precio){                      
            Item producto;                                          //Inicializa un object tipo item
            producto=inventarioTienda.VenderTienda(index);         //recibe el objeto del metodo vender de la tienda
            inventarioTienda.setDinero(precio);                    //Llama el metodo set que modifica el dinero de la tienda
            inventarioTienda.remove(index);                        //Borra el object en la posicion index del inventario
            vista.tablaTienda.removeRow(index);                    //Elimina el row de la tabla también
            inventarioJugador.ComprarPersonaje(producto);          //Llama al metodo comprar del personaje
            AñadirRowPersonaje(producto);                          //añade este objeto al inventario del jugador en la GUI
            DineroTienda();                                        //Muestra el dinero
            ModificarStats();                                      //Muestra las stats
            CantItemsTienda();                                     //Muestra la cantidad de items de la tienda
        }
        //Envía un mensaje de error si no le alcanza el dinero
        else{
            JOptionPane.showMessageDialog(vista, "El Personaje no tiene dinero suficiente para hacer la compra");
        }
    }

     //Metodo de venta, utilizado en la GUI
    public static void Vender(){
        
        int index=vista.productosJugador.getSelectedRow();                  //Pide el indice de la lista donde el usuario ingreso un clic
        int precio=inventarioJugador.VenderPersonaje(index).getPrecio();    //Obtiene el precio de del objeto que se ubica en ese indice
        precio=(int)(precio*.45);                                           //Modifico el precio de venta
        
        //Dialogo que le indica al usuario el precio de venta y si queire proceder
        int decision = JOptionPane.showConfirmDialog (null, "El precio de venta del articulo es: "+Integer.toString(precio),"¿Desea Proceder?",JOptionPane.YES_NO_OPTION);
        if(decision == JOptionPane.YES_OPTION) {
    
        //Verifica si la tiene dinero suficiente para la compra
        //LLeva el mismo flujo que el metodo anterior
        if (inventarioTienda.getdinero()>precio){
            Item producto;
            producto=inventarioJugador.VenderPersonaje(index);
            JOptionPane.showMessageDialog(vista, "El precio de venta del articulo fue: "+ precio);
            inventarioJugador.setDinero(precio);
            inventarioJugador.remove(index);
            vista.tablaPersonaje.removeRow(index);
            inventarioTienda.ComprarTienda(producto,precio);
            AñadirRowTienda(producto);
            DineroTienda(); 
            ModificarStats();
            CantItemsTienda();
        }
        //Envía un mensaje de error si no le alcanza el dinero
        else{
            JOptionPane.showMessageDialog(vista, "La tienda no tiene dinero suficiente para hacer la compra");
        }
        }
        else{
            JOptionPane.showMessageDialog(vista, "La venta del producto no se realizo");
        }
    }
   
    //Metodo que intodruce el nombre de la tienda en la GUI
    public static void NombreTienda(){
        vista.tituloTienda.setText(inventarioTienda.getnombre());
    } 
    
    //Método que muestra la cantidad de items que tiene la tienda
    public static void CantItemsTienda(){
    vista.cantPrTienda.setText(Integer.toString(inventarioTienda.Size()));
    }
    
    //Metodo que intoduce el nombre del personaje en la GUI
    public static void NombrePersonaje(){
        vista.nombreJugador.setText(inventarioJugador.getnombre());
    } 

    //Método para mostrar el dinero de la tienda en la GUI
    public static void DineroTienda(){
        int valor=inventarioTienda.getdinero();
        vista.dineroTienda.setText(Integer.toString(valor));
    }
    
    //Metodo utilizado para mostrar la tabla del invenatrio de la tienda, al cargar la GUI
    public static void MostrarTablaTienda(){
        for (int i=0; i<inventarioTienda.Size(); i++){
            Item products =(Item) inventarioTienda.get(i);
            AñadirRowTienda(products);
        }    
    }

    //Metodo utilizado para mostrar la tabla del inventario del personaje, al cargar la GUI
    public static void MostrarTablaPersonaje(){
        for (int i=0; i<inventarioJugador.Size(); i++){
            Item products =(Item) inventarioJugador.get(i);
            AñadirRowPersonaje(products);
        }    
    }
    
    //Metodo utilizado para crea Row's y apartir de allí crear el objeto que se
    // pasa a la row de la tabla, es llamado por los metodos de Comprar y MostarTablaTienda
    public static void AñadirRowTienda(Item products){
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
    
    //Metodo utilizado para crea Row's y apartir de allí crear el objeto que se
    // pasa a la row de la tabla, es llamado por los metodos de Vender y MostarTablaPersonaje
    public static void AñadirRowPersonaje(Item products){
            vista.productoPersonaje[0]=products.getNombre();
            vista.productoPersonaje[1]=products.getTipo();
            vista.productoPersonaje[2]=products.getColor();
            vista.productoPersonaje[3]=products.getNivel();
            vista.productoPersonaje[4]=products.getPoder();
            vista.productoPersonaje[5]=products.getPeso();
            vista.productoPersonaje[6]=products.getMaterial();
            vista.productoPersonaje[7]=products.getTamaño();
            vista.productoPersonaje[8]=products.getPrecio();
            vista.tablaPersonaje.addRow(vista.productoPersonaje);
    }
    
    //Metodo utilizado para mostar las stats del jugador, son a base de labels
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