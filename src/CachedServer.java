import java.util.List;
import java.util.Map;

public class CachedServer  implements Comparable<CachedServer>{
	private int id;
	private int capacity;
	private List<Integer> existVideo;
	private int latency;

	public CachedServer(List<Integer> existVideo, int id, int capacity, int latency) {
		this.existVideo = existVideo;
		this.id = id;
		this.capacity = capacity;
		this.latency = latency;
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

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	@Override
	public int compareTo(CachedServer o) {
		return this.latency-o.latency;
	}
	
	public void printLatency(){
		System.out.print(this.latency + " | ");
	}
	
}
