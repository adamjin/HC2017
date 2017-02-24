import java.util.List;

public class CachedServer {
	private int capacity;
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	private List<Video> existVideo;
	public CachedServer(List<Video> existVideo, int id, int capacity) {
		this.existVideo = existVideo;
		this.id = id;
		this.capacity = capacity;
	}
	public List<Video> getExistVideo() {
		return existVideo;
	}
	public void setExistVideo(List<Video> existVideo) {
		this.existVideo = existVideo;
	}
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
