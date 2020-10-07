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
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Christopher Vindas
 * @author Jhonny Picado Vega
 */
public class Controlador {
    

    
    public static void main(String[] args) throws IOException{
        Tienda prueba = null;
        
        OkHttpClient client = new OkHttpClient();
   
        Request request = new Request.Builder()
	.url("https://walmart.p.rapidapi.com/departments/list")
	.get()
	.addHeader("x-rapidapi-host", "walmart.p.rapidapi.com")
	.addHeader("x-rapidapi-key", "8ac4177326mshd5244b602b18176p145d17jsn505c099c181c")
	.build();

        ResponseBody responseBody = client.newCall(request).execute().body();        
        //System.out.println(responseBody.string());
        
        JSONObject json=new JSONObject(responseBody.string());

        /*
        JSONArray myArray = new JSONArray();
        myArray.add(json.get("departments"));
        JSONArray myArray2 = new JSONArray();
        myArray2.add(myArray.get(0));
        System.out.println(myArray);
        System.out.println(json);
        */
        JSONArray arr = json.getJSONArray("departments");
        
            String post_id = arr.getJSONObject(4).getString("name");
            //prueba.algo(post_id);
           // prueba.retorno();
            System.out.println(post_id);

        
    }
}