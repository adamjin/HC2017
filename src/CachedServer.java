import java.util.List;

public class CachedServer {
	private List<Video> existVideo;
	public CachedServer(List<Video> existVideo, int id) {
		this.existVideo = existVideo;
		this.id = id;
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
