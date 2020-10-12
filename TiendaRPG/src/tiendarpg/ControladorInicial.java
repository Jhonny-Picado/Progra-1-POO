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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Christopher Vindas
 * @author Jhonny Picado Vega
 */

//Clase que inicializa los items, llama al API, transforma los datos del Json y demás.
public class ControladorInicial {
    
    public static List<Item> Controlador() throws IOException{
        
        //Listas que contendrán los datos de la api convertidos
        String nombres[];
        String colores[];
       
        int precios[];
        int niveles[];
        int poderes[];
        double pesos[];
        String materiales[];
        String tamaños[];
        
        //Lista de items que llenaran los inventarios de la tienda y personaje
        List<Item> items;

       
        //Se deja el JSONArray en la variable arreglo
        JSONArray arreglo = ApiJson();        
        
        //Se llaman a los metodos que hacen las conversiones de los datos del API 
        nombres = Nombres(arreglo);
        colores = Colores();
        precios = Precios(arreglo);
        niveles = Niveles(arreglo);
        poderes = Poderes(arreglo);
        pesos = Pesos(arreglo);
        tamaños = Tamaños(arreglo);
        materiales= Materiales(arreglo);
        
        //Se cre el arreglo de items de las tres categorias
        items = ArregloItems(nombres, colores, precios, niveles, poderes, pesos, tamaños, materiales);


        return items;
      
    }
    
    //Se da el request del API y se pasa a un Json
    //Codigo del API y JSON
    public static JSONArray ApiJson() throws IOException{
          
        OkHttpClient client = new OkHttpClient();
   
        Request request = new Request.Builder()
	.url("https://walmart.p.rapidapi.com/products/list?sort=best_seller&zipcode=94066&page=1&cat_id=0&pref_store=2648%252C5434%252C2031%252C2280%252C5426")
	.get()
	.addHeader("x-rapidapi-host", "walmart.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "2ca9a8d581msha6e26d4e637cf04p15e528jsna84bd3d46010")
	.build();

        ResponseBody responseBody = client.newCall(request).execute().body();        
       
        JSONObject json = new JSONObject(responseBody.string());
        
        JSONArray arregloJson = json.getJSONArray("items");
        
        return arregloJson;   
    }
    
    //Metodo que pasa los nombre del JSON al array de nuestros nombres de Items
    public static String[] Nombres(JSONArray arreglo){
        
        String nombres[] = new String[40];
        
        for (int i=0; i<nombres.length; i++){
            nombres[i]= arreglo.getJSONObject(i).getString("seeAllName");
        }
        return nombres;
    }
    
    //Metodo que pasa los colores al Array de nuestros items
    public static String[] Colores(){
        
        String coloresAuxiliar[]= new String[40];
        String colores[] = {"Amarillo", "Morado", "Azul", "Rojo", "Verde","Cafe","Negro", "Blanco", "Celeste", "Gris", 
                            "Turquesa", "Naranja", "Violeta", "Dorado","Rosado","Fucsia","Salmon","Marron","Beige","Lila"};
        int j;
        
        for (int i=0; i<coloresAuxiliar.length; i++){
            j=(int)(Math.random()*19+1);
            coloresAuxiliar[i]=colores[j];
        }
        return coloresAuxiliar;
    }
     
    //Metodo que pasa los precios del JSON al array de nuestros nombres de Items
    public static int[] Precios(JSONArray arreglo){
        
        int temporal;
        int precios[] = new int[40];
        
        
        for (int i=0; i<precios.length; i++){
        
            temporal= arreglo.getJSONObject(i).getInt("numReviews");
            
            while(temporal>500){
                temporal/=10;
            }
            precios[i]=temporal*(i+1);
        }
        return precios;
    }
    
    
    //Metodo que pasa los niveles del JSON al array de nuestros nombres de Items
    public static int[] Niveles(JSONArray arreglo){
        int niveles[] = new int[40];
        int temporal;
        
        for (int i=0; i<niveles.length; i++){
            
            temporal = arreglo.getJSONObject(i).getInt("quantity");
            
            while (temporal>9){
                temporal/=10;
            }    
            niveles[i]=temporal;        
        }
        
        return niveles;
    } 
    
    //Metodo que pasa los poderes del JSON al array de nuestros nombres de Items
    public static int[] Poderes(JSONArray arreglo){
        int poderes[] = new int[40];
        int temporal;
        
        for (int i=0; i<poderes.length; i++){
            
            temporal=0;
            int tempaux;
            tempaux= arreglo.getJSONObject(i).getInt("usItemId");
            
            while (tempaux>0){
                temporal += (tempaux % 10);
                tempaux /= 10;
            }    
            poderes[i]=temporal;
        }
        
        return poderes;
    }
    
    //Metodo que retorna los pesos de las armaduras
    public static double[] Pesos(JSONArray arreglo){
        double pesos[] = new double[40];

        for (int i=0; i<pesos.length; i++){
            pesos[i] = arreglo.getJSONObject(i).getDouble("customerRating");
        }    
        return pesos;
    }
    
    //Metodo que retorna los tamaños de las armaduras
    public static String[] Tamaños(JSONArray arreglo){
    
        String tamaños[]= new String[40];
        int temporal;
        
        for (int i=0; i<tamaños.length; i++){
            
            String aux;
            String [] tamaño = {"S", "M", "L", "XL", "XXL"};
            
            aux = arreglo.getJSONObject(i).getString("title");
            
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
        return tamaños;  
    }
    
    
    //Metodo que retorna los tamaños de las armaduras
    public static String[] Materiales(JSONArray arreglo){
    
        String materiales[]= new String[40];
        
        int temporal; 
    
            for (int i=0; i<materiales.length; i++){
            
                String [] materialesaux = {"Cuero", "Madera", "Acero", "Hueso", "Algodón", "Fibras"};
                temporal = (arreglo.getJSONObject(i).getString("title")).length();
            
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
        return materiales;
    } 
    
    //Metodo que se encarga de realizar el arreglo de items del programa
    public static List<Item> ArregloItems (String[] nombres, String[] colores, int[] precios, int[] niveles, int[] poderes, double[] pesos, String[] tamaños, String[] materiales){
         
        List<Item> items = new ArrayList<>();
        
        String tiposArmas[] = {"Espada","Pistola","Escopeta","Cuchillo","Bate"};
        String tiposConsumible []= {"Energizante","Posión","Comida","Adrenalina","Agua"};
        
        
        for (int i=0; i<40; i++){
            
            int index= (int)(Math.random()*4+0);
            int entrada= (int)(Math.random()*3+1);
            
            if ( entrada==1 ){
                Item arma= new Arma(nombres[i], colores[i], precios[i], niveles[i], poderes[i], tiposArmas[index], pesos[i]);
                items.add(arma);
            }
            else if( entrada==2 ){
                
                Item consumible= new Consumible(nombres[i], colores[i], precios[i], niveles[i],poderes[i], tiposConsumible[index]);
                items.add(consumible);    
            }
            else{
                Item armadura= new Armadura(nombres[i], colores[i], precios[i], niveles[i], poderes[i],tamaños[i], materiales[i]);
                items.add(armadura);
            }
        }
        return items;
    } 
    
    //Metodo que le brinda los productos iniciales de la tienda
    public static List<Item> ProductosTienda(List<Item> items){
           
        //Acá se le pasa los productos al inventario de la tienda y almaceno su direccion en inventarioTienda
        List<Item> itemsTienda = new ArrayList<>();
        
        for (int i=0; i<31; i++){
            itemsTienda.add(i, items.get(i));
        }
    return itemsTienda;
    }
    
    
    //Metodo que retorna los items iniciales del jugador
    public static List<Item> ItemsPersonaje(List<Item> items){
            
        List<Item> itemsPersonaje = new ArrayList<>();
        
        int j=0;
        for(int i=31; i<39; i++){
            itemsPersonaje.add(j, items.get(i));
            j++;
        }
    return itemsPersonaje;
    }

}    
