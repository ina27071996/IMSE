package create;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Playlist;

/**
 * <h1>PlaylistRestService</h1> Restful Web Service which performs the previous modeled
 * operations
 * <p>
 *
 * @author Damaris Dumitru
 */
@Path("/imseGen")
public class PlaylistRestService
{
	public static String database = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
	public static String user = "sql11214736";
	public static String pass = "AUtSLeFRPX";
	
	@POST
	@Path("/insertPlaylists")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean insertUsers(List<Playlist> list)
	{
		try {
	      Connection con = DriverManager.getConnection(database, user, pass);
	      String sql ="INSERT INTO Playlists (Name,Hashtag,Description,Views,) VALUES (?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(Playlist item : list)
	      {
	    	  exec.setString(1,item.getName());
	    	  exec.setString(2,item.getHashtag());
			  exec.setString(3,item.getDescription());
	    	  exec.setInt(4, item.getViews());
        	  exec.executeUpdate();
	      }
	      return true;
		} catch (SQLException e) {
			return false;
		}

	}
}
