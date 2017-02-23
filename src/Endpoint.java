import java.util.Map;

public class Endpoint {
	private int id;
	private int dataCenterLatency;
	private int numberOfCaches;
	private Map<Integer, Integer> cacheEndpointLatencyMap;//key is cache id, value is latency
	
	public int getNumberOfCaches() {
		return numberOfCaches;
	}

	public void setNumberOfCaches(int numberOfCaches) {
		this.numberOfCaches = numberOfCaches;
	}

	public Endpoint(){
		
	}
	
	public Endpoint(int id, int dataCenterLatency,int numberOfCaches, Map<Integer, Integer> cacheEndpointLatencyMap) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
		this.numberOfCaches = numberOfCaches;
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
