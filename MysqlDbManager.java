package businessLogicLayer.service.rest;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;

import dataAccessLayer.models.Collection;
import dataAccessLayer.models.Playlist;
import dataAccessLayer.models.Track;
import dataAccessLayer.models.User;

public final class MysqlDbManager {
	
	public static String user = "sql11217795";
	public static String pass = "qg4B76Shg2";
	
	public static List<User> GetUsers()
	{
		List<User> result = new ArrayList<User>();
	    String query = "SELECT * FROM Users";
	    try {
	    	Connection conn = DatabaseHandler.getConnection(user, pass);
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next())
	        {
	        	User item = new User();
	        	item.setId(rs.getInt("id"));
	        	item.setUsername(rs.getString("username"));
	        	item.setPassword(rs.getString("password"));
	        	item.setJoinDate(rs.getTimestamp("joinDate").toString());
	        	item.setProfilePicture(rs.getString("profilePicture"));
	        	result.add(item);
	        }
	        st.close();
		} catch (SQLException e) {
		}
		return result;
	}
	
	public static List<Collection> GetCollection()
	{
		List<Collection> result = new ArrayList<Collection>();
	    	String query = "SELECT * FROM Collection";
		try {
	    	Connection conn = DatabaseHandler.getConnection(user, pass);
	        Statement st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while (rs.next())
	        {
	        	Collection item = new Collection();
	        	item.setId(rs.getInt("id"));
	        	item.setTitle(rs.getString("title"));
	        	item.setDescription(rs.getString("description"));
	        	item.setUserId(rs.getInt("userId"));
			
	        	result.add(item);
	        }
	        st.close();
		} catch (SQLException e) {
		}
		return result;
	}
	
	public static List<Track> GetTrack()
	{
	    String query = "SELECT * FROM Track";
		return null;
		
	}
	
	public static List<Playlist> GetPlaylist()
	{
		List<Playlist> result = new ArrayList<Playlist>();
    	String query = "SELECT * FROM Playlist";
	try {
    	Connection conn = DatabaseHandler.getConnection(user, pass);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next())
        {
        	Playlist item = new Playlist();
        	item.setId(rs.getInt("id"));
        	item.setName(rs.getString("name"));
         item.setHashtag(rs.getString("hashtag"));
        	item.setDescription(rs.getString("description"));
        	item.setUserId(rs.getInt("userId"));
		
        	result.add(item);
        }
        st.close();
	} catch (SQLException e) {
	}
	return result;
		
	}
}
