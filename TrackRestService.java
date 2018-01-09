package businessLogicLayer.service.rest;

import dataAccessLayer.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>PersonRestService</h1> Restful Web Service which performs the previous modeled
 * operations
 * <p>
 *
 * @author Cvijanovic Bojana
 * 
 */
@Path("/imseGen")
public class ImseGenRestService
{
	public static String database = "jdbc:mysql://sql11.freesqldatabase.com:3306/";
	public static String user = "sql11214736";
	public static String pass = "AUtSLeFRPX";
	
	@POST
	@Path("/insertTrack")
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean insertTrack(List<Track> list)
	{
		try {
	      Connection con = DriverManager.getConnection(database, user, pass);
	      String sql ="INSERT INTO Track (track_title,artist,year,album, duration) VALUES (?,?,?,?)";
	      PreparedStatement exec = con.prepareStatement(sql);
	      
	      for(User item : list)
	      {
	    	  exec.setString(1,item.gettrack_title());
	    	  exec.setString(2,item.getartist());
	    	  exec.setYear(3, null);
	    	  exec.setString(4,item.getalbum());
		  exec.setString(4,item.getduration());
        	  exec.executeUpdate();
	      }
	      return true;
		} catch (SQLException e) {
			return false;
		}

	}
}
