import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Output {

	private int numbrOfCacheServers;
	private Map<Integer, List<Integer>> cachedVideos;
	
	
	public Output() {
	}
	public Output(int numbrOfCacheServers, Map<Integer, List<Integer>> cachedVideos) {
		this.numbrOfCacheServers = numbrOfCacheServers;
		this.cachedVideos = cachedVideos;
	}
	public int getNumbrOfCacheServers() {
		return numbrOfCacheServers;
	}
	public void setNumbrOfCacheServers(int numbrOfCacheServers) {
		this.numbrOfCacheServers = numbrOfCacheServers;
	}
	public Map<Integer, List<Integer>> getCachedVideos() {
		return cachedVideos;
	}
	public void setCachedVideos(Map<Integer, List<Integer>> cachedVideos) {
		this.cachedVideos = cachedVideos;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(this.numbrOfCacheServers);
		for (Entry<Integer, List<Integer>> entry : cachedVideos.entrySet())
		{
			str.append("\n"+entry.getKey() + " ");
		    for(Integer video : entry.getValue()){
		    	str.append(video + " ");
		    } 
		}
		str.append("\n");
		return str.toString();
	}
}
