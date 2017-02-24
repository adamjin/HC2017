import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Helper {

	public static Set<Request> calculate(Set<Request> rqs, List<Endpoint> eps){
		Map<Integer, Integer> map = new HashMap<>(); 
		for(Request rq : rqs){
			Endpoint ep = eps.get(rq.getEndpointId());
			rq.setBandwidth(ep.getDataCenterLatency()*rq.getNumRequest());
		}
		return rqs;
	}
	
	public static Output process(List<Request> rqs, List<Video> vs, List<Endpoint> endpoints){

		List<Integer> existingVideioIds = new ArrayList<>();
		
		for(Request req:rqs){
			Endpoint ep = endpoints.get(req.getEndpointId());
			for(CachedServer cache : ep.getCaches()){
				if(!existingVideioIds.contains(req.getVideoId()) &&
						!(cache.getCapacity() < vs.get(req.getVideoId()).getSize())){
					cache.getExistVideo().add(req.getVideoId());
					existingVideioIds.add(req.getVideoId());
					
				}
			}
		//	if(cachedServrs.stream().filter(x -> x.getExistVideo().contains(vs.get(req.getVideoId()))) ;
		
		}
		return null;
	}
}
