package businessLogicLayer.service.rest;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import dataAccessLayer.models.Playlist;
import dataAccessLayer.models.Track;
import dataAccessLayer.models.User;
import dataAccessLayer.models.Collection;

public final class MongoDbManager {
	
	public static void createMongoDb(List<User> users, List<Playlist> playlists, List<Track> tracks, List<Collection> collections)
	{
	
		MongoDatabase database = getDatabase();
		
		createCollections(database);
		
		MongoCollection<Document> collection = database.getCollection("users");
		
		for(User user : users)
		{
			Document document = new Document();
			document.append("username", user.getUsername());
			document.append("password", user.getPassword());
			document.append("joinDate", user.getJoinDate());
			document.append("profilePicture", user.getProfilePicture());
			collection.insertOne(document);
		}
	}
	
	private static MongoDatabase getDatabase()
	{
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		return mongoClient.getDatabase("local");
	}
	
	private static void createCollections(MongoDatabase database)
	{
		database.createCollection("users");
	}
	
}
