package businessLogicLayer.client;

public class Client {

	public static void main(String[] args) {
		GenerateData();
		MigrateData();
	}
	
	private static void GenerateData()
	{
		UserGenerator userGenerator = new UserGenerator();
		userGenerator.generate();
		TrackGenerator trackGenerator = new TrackGenerator();
		trackGenerator.generate();
		PlaylistGenerator playlistGenerator = new PlaylistGenerator();
		playlistGenerator.generate();
		CollectionGenerator collectionGenerator = new CollectionGenerator();
		collectionGenerator.generate();
	}
	
	private static void MigrateData()
	{
		
	}
}
