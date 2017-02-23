import java.util.Map;

public class Endpoint {
	private int id;
	private int dataCenterLatency;
	private Map<Integer, Integer> cacheEndpointLatencyMap;
	
	public Endpoint(){
		
	}
	
	public Endpoint(int id, int dataCenterLatency, Map<Integer, Integer> cacheEndpointLatencyMap) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
		this.cacheEndpointLatencyMap = cacheEndpointLatencyMap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDataCenterLatency() {
		return dataCenterLatency;
	}
	public void setDataCenterLatency(int dataCenterLatency) {
		this.dataCenterLatency = dataCenterLatency;
	}
	public Map<Integer, Integer> getCacheEndpointLatencyMap() {
		return cacheEndpointLatencyMap;
	}
	public void setCacheEndpointLatencyMap(Map<Integer, Integer> cacheEndpointLatencyMap) {
		this.cacheEndpointLatencyMap = cacheEndpointLatencyMap;
	}
	
}
