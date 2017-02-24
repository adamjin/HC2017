import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class Helper {

//	public static Set<Request> calculate(Set<Request> rqs, List<Endpoint> eps){
//
//		for(Request rq : rqs){
//			Endpoint ep = eps.get(rq.getEndpointId());
//			rq.setBandwidth(ep.getDataCenterLatency()*rq.getNumRequest());
//		}
//		return rqs;
//	}
	
	public static Output process(List<Request> rqs, List<Video> vs, List<Endpoint> endpoints){

		Map<Integer, List<Integer>> cachedServersVideoMap = new HashMap<>();
		Set<CachedServer> caches = new HashSet<>();
		for(Request rq : rqs){
			Endpoint ep = endpoints.get(rq.getEndpointId());
			rq.setBandwidth(ep.getDataCenterLatency()*rq.getNumRequest());
		}
		
		List<Integer> existingVideioIds = new ArrayList<>();

		for(Request req:rqs){
			Endpoint ep = endpoints.get(req.getEndpointId());
//			System.out.format("- Processing endpoint %d req bandwitch %d \n", ep.getId(), req.getBandwidth());
			Stream<Map.Entry<CachedServer, Integer>> sorted =
				ep.getCacheEndpointLatencyMap().entrySet().stream()
				       .sorted(Map.Entry.comparingByValue());
			
			for (Iterator<Entry<CachedServer, Integer>> i = sorted.iterator(); i.hasNext();){
				Entry<CachedServer, Integer> entry = i.next();
					if(!existingVideioIds.contains(req.getVideoId()) &&
							!(entry.getKey().getCapacity() < vs.get(req.getVideoId()).getSize())){
						
						
						entry.getKey().getExistVideo().add(req.getVideoId());
						existingVideioIds.add(req.getVideoId());
						//	cachedServersVideoMap.get(entry.getKey())?null:cachedServersVideoMap.put(entry.getKey(), value)

//						System.out.format("-- Video %d has been added into cache server %d \n", req.getVideoId(), entry.getKey().getId());
					}
			    }
			caches.addAll(ep.getCacheEndpointLatencyMap().keySet());//there is a problem here -> adding same cache several times!!!
		}
		
		for(CachedServer cache: caches){
			if(cachedServersVideoMap.isEmpty()){
				cachedServersVideoMap.put(cache.getId(), cache.getExistVideo());
			}
			else{
				for(Integer c : cachedServersVideoMap.keySet()){
					if(c !=cache.getId()){
						cachedServersVideoMap.put(c, cache.getExistVideo());
					}
					else{
					//	cache.getExistVideo().addAll(cachedServersVideoMap.get(cache));
						List<Integer> list1 = cachedServersVideoMap.get(cache);
						list1.addAll(cache.getExistVideo());
						cachedServersVideoMap.put(c, list1);
					}
				}
			}
			
			

		}
		
		for(Integer cache : cachedServersVideoMap.keySet()){
			System.out.println("cache server" + cache + " has video ");
			cachedServersVideoMap.get(cache).forEach(System.out::println);
		}
	//	Output output = new Output(dto.numbrOfCacheServers, cachedVideos);
		return null;
	}
	
}
