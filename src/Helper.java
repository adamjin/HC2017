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
	
	public static Output output(Set<Request> rqs, List<Video> vs){
		List<CachedServer> cachedServrs = new ArrayList<>();
		for(Request req:rqs){
		//	if(cachedServrs.stream().filter(x -> x.getExistVideo().contains(vs.get(req.getVideoId()))) ;
		}
		return null;
	}
}
