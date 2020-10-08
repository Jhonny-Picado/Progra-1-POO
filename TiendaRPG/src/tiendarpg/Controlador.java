/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendarpg;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Christopher Vindas
 * @author Jhonny Picado Vega
 */
public class Controlador {
    
    public static List<Item> items = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        
        //Listas que contendrán los datos de la api convertidos
        String nombres[] = new String[21];
        String colores[] = {"Amarillo", "Morado", "Azul", "Rojo", "Verde","Cafe","Negro", "Blanco", "Celeste", "Gris", "Turquesa", "Naranja", "Violeta", "Dorado","Rosado","Fucsia","Salmon","Marron","Beige","Lila","Cian"};
        String tipos[] = new String [21];
        int precios[] = new int[21];
        int niveles[] = new int [21];
        int poderes[] =new int[21];
        double pesos[] = new double [21];
        String materiales[] = new String [21];
        String tamaños[] = new String [21];
        int temporal = 0;   //Variable utilizada para la conversion de enteros del JSON
        
        
        //Codigo del API y JSON
        OkHttpClient client = new OkHttpClient();
   
        Request request = new Request.Builder()
	.url("https://walmart.p.rapidapi.com/products/list?sort=best_seller&zipcode=94066&page=1&cat_id=0&pref_store=2648%252C5434%252C2031%252C2280%252C5426")
	.get()
	.addHeader("x-rapidapi-host", "walmart.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "8ac4177326mshd5244b602b18176p145d17jsn505c099c181c")
	.build();

        ResponseBody responseBody = client.newCall(request).execute().body();        
        //System.out.println(responseBody.string());
       
        JSONObject json=new JSONObject(responseBody.string());
        JSONArray arr = json.getJSONArray("items");
        
        for (int i=0; i<nombres.length; i++){
            nombres[i]= arr.getJSONObject(i).getString("seeAllName");
        }
        
        for (int i=0; i<precios.length; i++){
            
            temporal= arr.getJSONObject(i).getInt("numReviews");
            precios[i]=temporal*(i+1);
        }
        
        
        for (int i=0; i<niveles.length; i++){
            
            temporal = arr.getJSONObject(i).getInt("quantity");
            
            while (temporal>9){
                temporal/=10;
            }    
            niveles[i]=temporal;        
        }
        
        
        for (int i=0; i<poderes.length; i++){
            
            temporal=0;
            int tempaux;
            tempaux= arr.getJSONObject(i).getInt("usItemId");
            
            while (tempaux>0){
                temporal += (tempaux % 10);
                tempaux /= 10;
            }    
            poderes[i]=temporal;
        }

        for (int i=0; i<pesos.length; i++){
            pesos[i] = arr.getJSONObject(i).getDouble("customerRating");
        }
        for (int i=0; i<tipos.length; i++){
            tipos[i] = arr.getJSONObject(i).getString("department");
        }
        
        for (int i=0; i<tamaños.length; i++){
            
            String aux;
            String [] tamaño = {"S", "M", "L", "XL", "XXL"};
            
            aux = arr.getJSONObject(i).getString("title");
            
            int j = 0;
            
            while (true){
                
                if (aux.charAt(j)=='a'){
                    temporal=0;
                    break;
                }
                if (aux.charAt(j)=='e'){
                    temporal=1;
                    break;
                }
                else if (aux.charAt(j)=='i'){
                    temporal=2;
                    break;
                }
                else if (aux.charAt(j)=='o'){
                    temporal=3;
                    break;
                }
                else if (aux.charAt(j)=='u'){
                    temporal=4;
                    break;
                }

                j++;    
            }
            
            tamaños[i]=tamaño[temporal];
        }
        
    
        for (int i=0; i<materiales.length; i++){
            
            String [] materialesaux = {"cuero", "madera", "acero", "hueso", "algodón", "fibras"};
            temporal = (arr.getJSONObject(i).getString("title")).length();
            
            if ( temporal<20 ){
                materiales[i]=materialesaux[0];
                
            }
            else if (temporal>19 && temporal <40){
                materiales[i]=materialesaux[1];
            }
            else if (temporal>39 && temporal <60){
                materiales[i]=materialesaux[2];
            }
            else if (temporal>59 && temporal<80){
                materiales[i]=materialesaux[3];
            }
            else if (temporal>79 && temporal<100){
                materiales[i]=materialesaux[4];
            }
            else {
                materiales[i]=materialesaux[5];
            }
            
        }
        

        for (int i=0; i<21; i++){
            
            if ( i<7 ){
                Item arma= new Arma(nombres[i], colores[i], precios[i], niveles[i], poderes[i], tipos[i], pesos[i]);
                items.add(arma);
            }
            else if( i>7 && i<14 ){
                
                Item consumible= new Consumible(nombres[i], colores[i], precios[i], niveles[i],poderes[i], tipos[i]);
                items.add(consumible);    
            }
            else{
                Item armadura= new Armadura(nombres[i], colores[i], precios[i], niveles[i], poderes[i], tipos[i], tamaños[i], materiales[i]);
                items.add(armadura);
            }
        }
        
        Tienda inventarioTienda=new Tienda(items);
        inventarioTienda.dimeInventario();

//        System.out.println(Arrays.toString(tamaños));

    }
}