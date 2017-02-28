import java.util.List;
import java.util.Map;

public class Endpoint {
	private int id;
	private int dataCenterLatency;
	private int numberOfCaches;
	private List< Integer> cacheServerIds;
	
	public List<Integer> getCacheServerIds() {
		return cacheServerIds;
	}

	public void setCacheServerIds(List<Integer> cacheServerIds) {
		this.cacheServerIds = cacheServerIds;
	}

	public Endpoint(int id, int dataCenterLatency,int numberOfCaches, List<Integer> cacheServerIds) {
		this.id = id;
		this.dataCenterLatency = dataCenterLatency;
		this.numberOfCaches = numberOfCaches;
		this.cacheServerIds = cacheServerIds;
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
