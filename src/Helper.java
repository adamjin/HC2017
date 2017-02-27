import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

public class Helper {
	
	public static Output process(List<Request> rqs, List<Video> vs, List<Endpoint> endpoints, List<CachedServer> cachedServerList){

//		System.out.println("Video size "+vs.size()+ " Request size "+rqs.size() + " endpoints size "+endpoints.size()  );
		for(Request rq : rqs){
			Endpoint ep = endpoints.get(rq.getEndpointId());
			rq.setBandwidth(ep.getDataCenterLatency()*rq.getNumRequest());
		}//Sort the requests
		Collections.sort(rqs);
		List<Integer> existingVideioIds = new ArrayList<>();
		Map<Integer, CachedServer> cachedServersStored = new HashMap<>();
		Collections.sort(cachedServerList);
		for(CachedServer cache : cachedServerList){
			cachedServersStored.put(cache.getId(), cache);
		}
		Map<Integer, CachedServer> servers = new HashMap<>();

		for(Request req:rqs){
				
			Endpoint ep = endpoints.get(req.getEndpointId());

			List<Integer> listOfCachedIds = ep.getCacheEndpointLatencyMap();
			if(listOfCachedIds!=null){
			List<CachedServer> cacheSever = new ArrayList<>();
				for(Integer i: listOfCachedIds){
					cacheSever.add(cachedServersStored.get(i));
				}
					
				Collections.sort(cacheSever, (a, b) -> b.compareTo(a));
				Collections.reverse(cacheSever);
				
				for (CachedServer cache : cacheSever) {
					if(!checkVideoAlreadyInAnyServer(cacheSever, req)){
						if (!checkVideoExists(cache, req) && cache.getCapacity() >= vs.get(req.getVideoId()).getSize()) {
							cache.getExistVideo().add(req.getVideoId());
							cache.setCapacity(cache.getCapacity()-vs.get(req.getVideoId()).getSize());
							if (servers.get(cache.getId())==null) {
								servers.put(cache.getId(), cache);
							}
						}
				}
				}
			}
		}
		
		Output output = new Output();
		Map<Integer, List<Integer>> map =  new HashMap<>();
			for(CachedServer  server: servers.values()){
				map.put(server.getId(), server.getExistVideo());
			}
			output.setNumbrOfCacheServers(servers.size());
			output.setCachedVideos(map);
		return output;
	}


private static boolean checkVideoAlreadyInAnyServer(List<CachedServer> cachedServerList, Request req) {
	for(CachedServer cacche: cachedServerList){
		if(cacche.getExistVideo().contains(req.getVideoId())){
			return true;
		}
		
	}
	return false;
}

private static boolean checkVideoExists(CachedServer server, Request req) {
    return server.getExistVideo().contains(req.getVideoId());
}
	
}
