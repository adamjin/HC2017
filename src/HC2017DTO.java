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
//	private  List<CachedServer> cachedServers;


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
			List<CachedServer> caches = new ArrayList<>();
			for(int j= 0; j<endpoint.getNumberOfCaches(); j++){
				String [] b = strList.get(curser).split(" ");
//				Map<Integer, Integer> cacheEndpointLatencyMap = new HashMap<Integer, Integer>();
//				cacheEndpointLatencyMap.put(Integer.parseInt(b[0]), Integer.parseInt(b[1]));
//				endpoint.setCacheEndpointLatencyMap(cacheEndpointLatencyMap);
				//populate the caches
		//		CachedServer cache = new CachedServer(null, Integer.parseInt(b[0]), cachedServersCapacity);
		//		caches.add(cache);
				curser++;
			}
			endpoint.setCaches(caches);
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
}
