import java.util.List;
import java.util.Map;

public class Endpoint {
	private int id;
	private int dataCenterLatency;
	private int numberOfCaches;
//	private List<CachedServer> caches;
	private Map<CachedServer, Integer> cacheEndpointLatencyMap;//key is cache id, value is latency
	
	public Endpoint(int id, int dataCenterLatency,int numberOfCaches, Map<CachedServer, Integer> cacheEndpointLatencyMap) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
		this.numberOfCaches = numberOfCaches;
		this.cacheEndpointLatencyMap = cacheEndpointLatencyMap;
	}
	


	public Map<CachedServer, Integer> getCacheEndpointLatencyMap() {
		return cacheEndpointLatencyMap;
	}



	public void setCacheEndpointLatencyMap(Map<CachedServer, Integer> cacheEndpointLatencyMap) {
		this.cacheEndpointLatencyMap = cacheEndpointLatencyMap;
	}



	public int getNumberOfCaches() {
		return numberOfCaches;
	}

	public void setNumberOfCaches(int numberOfCaches) {
		this.numberOfCaches = numberOfCaches;
	}

	public Endpoint(){
		
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

	
}
