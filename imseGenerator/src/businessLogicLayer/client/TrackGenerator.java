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

import dataAccessLayer.models.Track;

public class TrackGenerator {

	public static void generate() {
		
		try {
			URL url = new URL("http://localhost:8080/imseGenerator/imseGen/insertTracks");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json");
			
			Gson gson = new Gson();
			List<Track> list = new ArrayList<Track>();
			
			Random rand =new Random();
	    	for(int i= 0; i< 100; i++) {
	    		Track track = new Track();
	    		track.setTitle(TestData.title[new Random().nextInt(TestData.title.length)]);
	    		track.setArtist(TestData.artist[new Random().nextInt(TestData.artist.length)]);
	    		track.setAlbum(TestData.album[new Random().nextInt(TestData.album.length)]);
	    		track.setYear(new Random().nextInt(30)+1980);
	    		track.setDuration(new Random().nextInt(300)+90 + " seconds");
	    		list.add(track);
	    	}
			
			Type listOfTrack = new TypeToken<List<Track>>(){}.getType();
			String input = gson.toJson(list,listOfTrack);

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
