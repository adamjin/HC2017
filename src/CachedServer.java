import java.util.List;
import java.util.Map;

public class CachedServer {
	private int capacity;
	private List<Integer> existVideo;
	private Map<Integer, Integer> cacheLatencyMap;
	public CachedServer(List<Integer> existVideo, int id, int capacity, Map<Integer, Integer> map) {
		this.existVideo = existVideo;
		this.id = id;
		this.capacity = capacity;
		this.cacheLatencyMap = map;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public List<Integer> getExistVideo() {
		return existVideo;
	}
	public void setExistVideo(List<Integer> existVideo) {
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
