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
   
    public static void main(String[] args) {

        String [] vColor={"Azul", "Rosa", "Morado", "Purpura", "Cafe", "Negro", "Celeste", "Terracota"};
        String [] vNombre={"Maria", "Juan", "Saul", "Isaac", "Manuel", "Lucas", "Lewandowski", "Capdevila"};
        double [] vPrecio={12.4, 5.6, 7.8, 9.0, 24.8, 23.3, 45.7, 90.87};
        int    [] vNivel={1,2,3,4,5,6,7,8};
        int    [] vPoder={14,15,13,12,12,234,54,56};
        String [] vTipo ={"Cuchillo", "Pistola", "Pistola", "Flechas", "Pipolin", "Fuego", "Agua", "Tierra"};
        double [] vPeso={12.33,1.85,1.93,1.02,12.43,2.34,5.4,5.6};
        
        List<Arma> armas = new ArrayList<>();
        
        for (int i=0; i<8; i++){
            
           
            Arma arma= new Arma(vNombre[i], vColor[i], vPrecio[i], vNivel[i], vPoder[i], vTipo[i], vPeso[i]);
            armas.add(arma);
            //System.out.println(arma.dimeCar()+"\n"+"\n");
        }
        
        armas.forEach((n) -> {
            System.out.println(n.dimeDatos());
        });
}
}