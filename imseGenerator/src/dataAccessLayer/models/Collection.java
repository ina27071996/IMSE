package dataAccessLayer.models;

public class Collection {
	private String title ;
	private String description;
	private Integer userId;
	private Integer playlistId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPlaylistId() {
		return playlistId;
	}
	public void setPlaylistId(Integer playlistId) {
		this.playlistId = playlistId;
	}

}
