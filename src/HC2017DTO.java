import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this is the object to which the input file should be rendered
 * */
public class HC2017DTO {

	private int numV;
	private int numEP;
	private  int numRequestD;
	private int numCachedServers;
	private int cachedServersCapacity;
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
		curser++;
		String line1[] = strList.get(curser).split(" ");
		List<Video> videos = new ArrayList<>();
		for(int i=0; i< line1.length; i++){
			Video v = new Video();
			v.setId(i);
			v.setSize(Integer.parseInt(line1[i]));
			videos.add(v);
			System.out.println("Video " + v.getId() + " has size: " + v.getSize());
		}

		curser++;
		List<Endpoint> endpopints = new ArrayList<>();
		//the outer loop populates the End points
		for(int i = 0 ; i < numEP; i++){
			String [] a = strList.get(curser).split(" ");
			
			Endpoint endpoint = new Endpoint();
			endpoint.setId(i);
			endpoint.setDataCenterLatency(Integer.parseInt(a[0]));
			endpoint.setNumberOfCaches(Integer.parseInt(a[1]));
			
			curser++;
			//the inner loop populates the map in each end point
			for(int j= 0; j<endpoint.getNumberOfCaches(); j++){
				String [] b = strList.get(curser).split(" ");
				Map<Integer, Integer> cacheEndpointLatencyMap = new HashMap<Integer, Integer>();
				cacheEndpointLatencyMap.put(Integer.parseInt(b[0]), Integer.parseInt(b[1]));
				endpoint.setCacheEndpointLatencyMap(cacheEndpointLatencyMap);
				curser++;
			}
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
