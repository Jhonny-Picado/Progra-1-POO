/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;

import java.util.*;
/**
 *
 * @author Jhonny Picado Vega
 */
public class Items {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Armas arma = new Armas("Rosa", "Zenitsu", 78.23, 3, 12, "Espada", 2);
        //System.out.println(arma.dimeCar());
        //Armas arma1 = new Armas("Juana", "Mugiwara", 7.0, 8, 99, "Bate", 90);
        //System.out.println(arma1.dimeCar());
        String [] color={"Azul", "Rosa", "Morado", "Purpura", "Cafe", "Negro", "Celeste", "Terracota"};
        String [] nombre={"Maria", "Juan", "Saul", "Isaac", "Manuel", "Lucas", "Lewandowski", "Capdevila"};
       // String [] espadas={"Maria", "Juan", "Saul", "Isaac", "Manuel", "Lucas", "Lewandowski", "Capdevila"};
        double [] precio={12.4, 5.6, 7.8, 9.0, 24.8, 23.3, 45.7, 90.87};
        int    [] nivel={1,2,3,4,5,6,7,8};
        int    [] poder={14,15,13,12,12,234,54,56};
        String [] tipo ={"Cuchillo", "Pistola", "Pistola", "Flechas", "Pipolin", "Fuego", "Agua", "Tierra"};
        double [] peso={12.33,1.85,1.93,1.02,12.43,2.34,5.4,5.6};
        
        List<Armas> armas = new ArrayList<Armas>();
        
        for (int i=0; i<8; i++){
           
            Armas arma= new Armas(color[i], nombre[i], precio[i], nivel[i], poder[i], tipo[i], peso[i]);
            armas.add(arma);
            //System.out.println(arma.dimeCar()+"\n"+"\n");
        }
        
        for(Armas n: armas){
            System.out.println(n.dimeCar()+"\n"+"\n");
        }
    }
    
}
