import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Output {

	private int numbrOfCacheServers;
	private Map<Integer, List<Video>> cachedVideos;
	
	
	public Output(int numbrOfCacheServers, Map<Integer, List<Video>> cachedVideos) {
		this.numbrOfCacheServers = numbrOfCacheServers;
		this.cachedVideos = cachedVideos;
	}
	public int getNumbrOfCacheServers() {
		return numbrOfCacheServers;
	}
	public void setNumbrOfCacheServers(int numbrOfCacheServers) {
		this.numbrOfCacheServers = numbrOfCacheServers;
	}
	public Map<Integer, List<Video>> getCachedVideos() {
		return cachedVideos;
	}
	public void setCachedVideos(Map<Integer, List<Video>> cachedVideos) {
		this.cachedVideos = cachedVideos;
	}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(this.numbrOfCacheServers).append("\\n");
		for (Entry<Integer, List<Video>> entry : cachedVideos.entrySet())
		{
		    str.append(entry.getKey() + " ");
		    for(Video video : entry.getValue()){
		    	
		    }
		}
		return str.toString();
	}
}
