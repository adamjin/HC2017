import java.util.ArrayList;
import java.util.HashMap;
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

		for(Request rq : rqs){
			Endpoint ep = endpoints.get(rq.getEndpointId());
			rq.setBandwidth(ep.getDataCenterLatency()*rq.getNumRequest());
		}
		
		List<Integer> existingVideioIds = new ArrayList<>();
		
		for(Request req:rqs){
			Endpoint ep = endpoints.get(req.getEndpointId());
			
			Stream<Map.Entry<CachedServer, Integer>> sorted =
				ep.getCacheEndpointLatencyMap().entrySet().stream()
				       .sorted(Map.Entry.comparingByValue());
			
			for (Iterator<Entry<CachedServer, Integer>> i = sorted.iterator(); i.hasNext();){
				
					if(!existingVideioIds.contains(req.getVideoId()) &&
							!(i.next().getKey().getCapacity() < vs.get(req.getVideoId()).getSize())){
						i.next().getKey().getExistVideo().add(req.getVideoId());
						existingVideioIds.add(req.getVideoId());
						
					}
			    }
			
//			for(CachedServer cache : ep.getCaches()){
//				if(!existingVideioIds.contains(req.getVideoId()) &&
//						!(cache.getCapacity() < vs.get(req.getVideoId()).getSize())){
//					cache.getExistVideo().add(req.getVideoId());
//					existingVideioIds.add(req.getVideoId());
//					
//				}
//			}
			
		}
		return null;
	}
}
