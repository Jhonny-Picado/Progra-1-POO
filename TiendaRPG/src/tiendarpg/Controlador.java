/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import java.util.*;
/**
 * @author Christopher Vindas
 * @author Jhonny Picado Vega
 */
public class Controlador {
    
    public static List<Item> items = new ArrayList<>();
    
    public static void main(String[] args) {
        String [] vColor={"Azul", "Rosa", "Morado", "Purpura", "Cafe", "Negro", "Celeste", "Terracota", "Negro","Negro","Negro"};
        String [] vNombre={"Maria", "Juan", "Saul", "Isaac", "Manuel", "Lucas", "Lewandowski", "Capdevila", "Hola", "Hola", "Hola"};
        double [] vPrecio={12.4, 5.6, 7.8, 9.0, 24.8, 23.3, 45.7, 90.87, 12.3, 12.3, 12.3};
        int    [] vNivel={1,2,3,4,5,6,7,8, 10,10,10};
        int    [] vPoder={14,15,13,12,12,234,54,56,50,50,50};
        String [] vTipo ={"Cuchillo", "Pistola", "Pistola", "Flechas", "Pipolin", "Fuego", "Agua", "Tierra", "Bebida", "Comida", "Bebida"};
        double [] vPeso={12.33,1.85,1.93,1.02,12.43,2.34,5.4,5.6};
        
        for (int i=0; i<8; i++){
            Item arma = new Arma(vNombre[i], vColor[i], vPrecio[i], vNivel[i], vPoder[i], vTipo[i], vPeso[i]);
            items.add(arma);
        }
        
        for (int i=8; i<11; i++){
            Item arma = new Consumible (vNombre[i], vColor[i], vPrecio[i], vNivel[i], vPoder[i], vTipo[i]);
            items.add(arma);
        }
        
        for(Item n:items) {
            System.out.println(n.toString());
        }
    }
}