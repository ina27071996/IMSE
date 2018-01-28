package businessLogicLayer.service.rest;

import dataAccessLayer.models.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * <h1>ImseGenRestService</h1> Restful Web Service which performs the previous modeled
 * operations
 * <p>
 *
 * @author Debora Eveline Nuta
 * @since 2018-01-09
 */
@Path("/imseGen")
public class ImseGenRestService
{
	public static String user = "sql11217795";
	public static String pass = "qg4B76Shg2";
	
	@POST
	@Path("/insertUsers")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertUsers(List<User> list)
	{
		try {
	      Connection con = DatabaseHandler.getConnection(user, pass);
	      String sql ="INSERT INTO Users (Username,Password,JoinDate,ProfilePicture) VALUES (?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(User item : list)
	      {
	    	  exec.setString(1,item.getUsername());
	    	  exec.setString(2,item.getPassword());
	    	  exec.setTimestamp(3, null);
	    	  exec.setString(4,item.getProfilePicture());
        	  exec.executeUpdate();
	      }
	      return "Users inserted. Success: added " + list.size() + " items.";
		} catch (SQLException e) {
			return "Failed";
		}

	}
	
	@POST
	@Path("/insertPlaylists")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertPlaylists(List<Playlist> list)
	{
		try {
	      Connection con = DatabaseHandler.getConnection(user, pass);
	      String sql ="INSERT INTO Playlist (Id,Name,Hashtag,Description,UserId) VALUES (?,?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(Playlist item : list)
	      {
	    	  exec.setInt(1,item.getId());
	    	  exec.setString(1,item.getName());
	    	  exec.setString(2,item.getHashtag());
			  exec.setString(3,item.getDescription());
			  exec.setInt(1,item.getUserId());
        	  exec.executeUpdate();
	      }
	      return "Playlists inserted. Success: added " + list.size() + " items.";
		} catch (SQLException e) {
			return e.toString();
		}
	}
	
	@POST
	@Path("/insertTracks")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertTracks(List<Track> list)
	{
		try {
	      Connection con = DatabaseHandler.getConnection(user, pass);
	      String sql ="INSERT INTO Track (track_title,artist,year,album,duration) VALUES (?,?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(Track item : list)
	      {
	    	  exec.setString(1,item.getTitle());
	    	  exec.setString(2,item.getArtist());
	    	  exec.setInt(3, item.getYear());
	    	  exec.setString(4,item.getAlbum());
	    	  exec.setString(5,item.getDuration());
	    	  exec.executeUpdate();
	      }
	      return "Tracks inserted. Success: added " + list.size() + " items.";
		} catch (SQLException e) {
			return e.toString();
		}

	}
	
	@POST
	@Path("/insertCollections")
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertCollections(List<Collection> list)
	{
		try {
	      Connection con = DatabaseHandler.getConnection(user, pass);
	      String sql ="INSERT INTO Collection (Id,Title,Description,UserId) VALUES (?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(Collection item : list)
	      {
	    	  exec.setString(1,item.getId());
	    	  exec.setString(1,item.getTitle());
	    	  exec.setString(2,item.getDescription());
	    	  exec.setInt(3, item.getUserId());	    	  
	    	 
        	  exec.executeUpdate();
	      }
	      return "Collections inserted. Success: added " + list.size() + " items.";
		} catch (SQLException e) {
			return e.toString();
		}
	}
	
	@GET
	@Path("/migrateDatabase")
	public String migrateDatabase()
	{
		/*MongoDbManager.createMongoDb(MysqlDbManager.GetUsers(), 
									 MysqlDbManager.GetPlaylist(),
									 MysqlDbManager.GetTrack(),
		
									MysqlDbManager.GetCollection());
									*/
		return "Success";
	}
	
}
