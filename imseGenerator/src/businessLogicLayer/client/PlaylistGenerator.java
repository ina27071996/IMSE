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

import dataAccessLayer.models.Playlist;

public class PlaylistGenerator {

	public static void generate() {
		
		try {
			URL url = new URL("http://localhost:8080/imseGenerator/imseGen/insertPlaylists");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json");
			
			Gson gson = new Gson();
			List<Playlist> list = new ArrayList<Playlist>();
			
			Random rand =new Random();
	    	for(int i= 0; i< 100; i++) {
	    		Playlist playlist = new Playlist();
	    		playlist.setName(TestData.name[new Random().nextInt(TestData.name.length)]);
	    		playlist.setHashtag(TestData.hashtag[new Random().nextInt(TestData.hashtag.length)]);
	    		playlist.setDescription(TestData.description[new Random().nextInt(TestData.description.length)]);
	    		list.add(playlist);
	    	}
			
			Type listOfPlaylist = new TypeToken<List<Playlist>>(){}.getType();
			String input = gson.toJson(list,listOfPlaylist);

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
