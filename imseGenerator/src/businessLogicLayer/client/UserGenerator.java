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

import dataAccessLayer.models.User;

public class UserGenerator {

	public static void generate() {
		
		try {
			URL url = new URL("http://localhost:8080/imseGenerator/imseGen/insertUsers");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json");
			
			Gson gson = new Gson();
			List<User> list = new ArrayList<User>();
			
			Random rand =new Random();
	    	for(int i= 0; i< 100; i++) {
	    		User user = new User();
	    		user.setUsername(TestData.username[new Random().nextInt(TestData.username.length)]);
	    		user.setPassword(TestData.password[new Random().nextInt(TestData.password.length)]);
	    		user.setProfilePicture(TestData.profilePicture[new Random().nextInt(TestData.profilePicture.length)]);
	    		list.add(user);
	    	}
			
			Type listOfUser = new TypeToken<List<User>>(){}.getType();
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
