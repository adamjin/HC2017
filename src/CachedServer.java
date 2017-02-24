import java.util.List;
import java.util.Map;

public class CachedServer {
	private int id;
	private int capacity;
	private List<Integer> existVideo;
//	private Map<Integer, Integer> cacheLatencyMap; //<endpointId, latency>
	public CachedServer(List<Integer> existVideo, int id, int capacity) {
		this.existVideo = existVideo;
		this.id = id;
		this.capacity = capacity;
//		this.cacheLatencyMap = map;
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


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
