package businessLogicLayer.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dataAccessLayer.models.Collection;

public class CollectionGenerator {
	
public static void generate() {
		
		try {
			URL url = new URL("http://localhost:8080/imseGenerator/imseGen/insertCollections");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json");
			
			Gson gson = new Gson();
			List<Collection> list = new ArrayList<Collection>();
			
			Random rand =new Random();
			int collectionId = 0;
	    	for(int i= 0; i< 50; i++) {
	    		Collection collection = new Collection();
	    		collectionId++;
	    		collection.setTitle(TestData.CollectionTitle[new Random().nextInt(TestData.CollectionTitle.length)]);
	    		collection.setDescription(TestData.CollectionDescription[new Random().nextInt(TestData.CollectionDescription.length)]);
	    		int userId3 = rand.nextInt((99-2)+1)+1;
	    		collection.setUserId(userId3);
	    		list.add(collection);
	    	}
			
			Type listOfUser = new TypeToken<List<Collection>>(){}.getType();
			String input = gson.toJson(list,listOfUser);

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
			
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseMessage());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String output;
			System.out.println("Output from Server ...");
			while((output = br.readLine()) != null) {
				System.out.println("Status: " + output);
			}
			
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}
}
