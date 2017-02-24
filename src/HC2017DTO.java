import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * this is the object to which the input file should be rendered
 * */
public class HC2017DTO {

	private int numV;
	private int numEP;
	private  int numRequestD;
	private int numCachedServers;
	private int cachedServersCapacity;
	private List<Video> videos; //the list is in order as video 1, 2, 3, 4...
	private List<Endpoint> endpopints; //the list is in order as endpoint 1, 2, 3, 4...
	private List<Request> requests; // this should be in order of bandwidth
	private List<CachedServer> cachedServers;



	//constructor which is initialized by the input string info
	public HC2017DTO(List<String> strList){
		int curser = 0; //the curser which points to the current line
		String line0[] = strList.get(curser).split(" ");
		this.numV = Integer.parseInt(line0[0]); 
		this.numEP = Integer.parseInt(line0[1]);
		this.numRequestD = Integer.parseInt(line0[2]);
		this.numCachedServers = Integer.parseInt(line0[3]);
		this.cachedServersCapacity = Integer.parseInt(line0[4]);
		this.cachedServers = new ArrayList<>();
		
		curser++;
		String line1[] = strList.get(curser).split(" ");
		this.videos = new ArrayList<>();
		this.requests = new ArrayList<>();
		for(int i=0; i< line1.length; i++){
			Video v = new Video();
			v.setId(i);
			v.setSize(Integer.parseInt(line1[i]));
			videos.add(v);
			System.out.println("Video " + v.getId() + " has size: " + v.getSize());
		}

		curser++;
		this.endpopints = new ArrayList<>();
		//the outer loop populates the End points
		for(int i = 0 ; i < numEP; i++){
			String [] a = strList.get(curser).split(" ");
			
			Endpoint endpoint = new Endpoint();
			endpoint.setId(i);
			endpoint.setDataCenterLatency(Integer.parseInt(a[0]));
			endpoint.setNumberOfCaches(Integer.parseInt(a[1]));
			System.out.println("Endpoint " + endpoint.getId() + " has " + endpoint.getDataCenterLatency() 
			+ " ms latency and is connected to " + endpoint.getNumberOfCaches() + " cache servers");
			curser++;
			//the inner loop populates the map in each end point

			for(int j= 0; j<endpoint.getNumberOfCaches(); j++){
				String [] b = strList.get(curser).split(" ");
				//populate the caches
				Map<CachedServer, Integer> map = new HashMap<>();
				CachedServer cache = new CachedServer(new ArrayList<Integer>(), Integer.parseInt(b[0]), cachedServersCapacity);
				map.put(cache, Integer.parseInt(b[1]));
				endpoint.setCacheEndpointLatencyMap(map);
				curser++;
			}			
			endpopints.add(endpoint);
		}

		//populates the map of <endpointId, numRequest> in video 
		for(int m = 0; m<numRequestD; m++){
			String [] c = strList.get(curser).split(" ");
			Map<Integer , Integer> requestEndpointMap = new HashMap<Integer, Integer>();
			requestEndpointMap.put(Integer.parseInt(c[1]), Integer.parseInt(c[2]));
			videos.get(Integer.parseInt(c[0])).setRequestEndpointMap(requestEndpointMap);
			Request request = new Request(Integer.parseInt(c[2]),Integer.parseInt(c[0]),Integer.parseInt(c[1]));
			this.requests.add(request);
			curser++;
		}

	}
	
	//the default constructor
	public HC2017DTO(){
		
	}
	
	public void print(){
		System.out.println("numV: " + this.numV);
		System.out.println("numEP: " + this.numEP);
		System.out.println("numRequestD: " + this.numRequestD);
		System.out.println("numCachedServers: " + this.numCachedServers);
		System.out.println("cachedServersCapacity: " + this.cachedServersCapacity);
	}

	public int getNumV() {
		return numV;
	}

	public void setNumV(int numV) {
		this.numV = numV;
	}

	public int getNumEP() {
		return numEP;
	}

	public void setNumEP(int numEP) {
		this.numEP = numEP;
	}

	public int getNumRequestD() {
		return numRequestD;
	}

	public void setNumRequestD(int numRequestD) {
		this.numRequestD = numRequestD;
	}

	public int getNumCachedServers() {
		return numCachedServers;
	}

	public void setNumCachedServers(int numCachedServers) {
		this.numCachedServers = numCachedServers;
	}

	public int getCachedServersCapacity() {
		return cachedServersCapacity;
	}

	public void setCachedServersCapacity(int cachedServersCapacity) {
		this.cachedServersCapacity = cachedServersCapacity;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Endpoint> getEndpopints() {
		return endpopints;
	}

	public void setEndpopints(List<Endpoint> endpopints) {
		this.endpopints = endpopints;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<CachedServer> getCachedServers() {
		return cachedServers;
	}

	public void setCachedServers(List<CachedServer> cachedServers) {
		this.cachedServers = cachedServers;
	}
}
