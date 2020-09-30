/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.*;
import org.json.simple.*;
/**
 * @author Christopher Vindas
 * @author Jhonny Picado Vega
 */
public class Controlador {
    
    public static List<Item> items = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        
        String [] vColor={"Azul", "Rosa", "Morado", "Purpura", "Cafe", "Negro", "Celeste", "Terracota", "Negro","Negro","Negro"};
        String [] vNombre={"Maria", "Juan", "Saul", "Isaac", "Manuel", "Lucas", "Lewandowski", "Capdevila", "Hola", "Hola", "Hola"};
        int [] vPrecio={12, 5, 7, 9, 2, 2, 45, 90, 12, 12, 12};
        int    [] vNivel={1,2,3,4,5,6,7,8, 10,10,10};
        int    [] vPoder={14,15,13,12,12,234,54,56,50,50,50};
        String [] vTipo ={"Cuchillo", "Pistola", "Pistola", "Flechas", "Pipolin", "Fuego", "Agua", "Tierra", "Bebida", "Comida", "Bebida"};
        int [] vPeso={12,1,11,17,12,2,4,6};
        
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
        //Parte del API
        
        OkHttpClient client = new OkHttpClient();
    
        Request request = new Request.Builder()
	.url("https://walmart.p.rapidapi.com/products/get-details?usItemId=55885487")
	.get()
	.addHeader("x-rapidapi-host", "walmart.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "8ac4177326mshd5244b602b18176p145d17jsn505c099c181c")
	.build();

        Response response = client.newCall(request).execute();
        //System.out.println(response.body().string());
        
        JSONObject object = new JSONObject();
        object.put("Hola",response.body().string());
        System.out.println("\n"+"\n"+object.values());
        
        
        System.out.println("\n"+"\n"+object.get("data"));//Acá debería agarrar los contenidos de la etiqueta data del JSON, pero no lo hace, más o menos va por ahí 
        
        
        
    }
}