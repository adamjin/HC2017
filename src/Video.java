import java.util.Map;

public class Video {
	private int id;
	private int size;
	private Map<Integer , Integer> requestEndpointMap;
	//key - end point id, value is number of requests
	
	public Video(){
		
	}
	public Video(int id, int size, Map<Integer, Integer> requestEndpointMap) {
		this.id = id;
		this.size = size;
		this.requestEndpointMap = requestEndpointMap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Map<Integer, Integer> getRequestEndpointMap() {
		return requestEndpointMap;
	}
	public void setRequestEndpointMap(Map<Integer, Integer> requestEndpointMap) {
		this.requestEndpointMap = requestEndpointMap;
	}
	
}
