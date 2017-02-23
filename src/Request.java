
public class Request implements Comparable<Request>{
	private int numRequest;
	private int videoId;
	private int endpointId;
	private int Endpoint;
	private int bandwidth;
	
	public int getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(int bandwidth) {
		this.bandwidth = bandwidth;
	}
	public Request() {
	}
	public Request(int numRequest, int videoId, int endpointId) {
		this.numRequest = numRequest;
		this.videoId = videoId;
		this.endpointId = endpointId;
	//	this.bandwidth = bandwidth;
	}
	public int getNumRequest() {
		return numRequest;
	}
	public void setNumRequest(int numRequest) {
		this.numRequest = numRequest;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getEndpointId() {
		return endpointId;
	}
	public void setEndpointId(int endpointId) {
		this.endpointId = endpointId;
	}
	@Override
	public int compareTo(Request o) {
		return o.bandwidth-this.bandwidth;
	}

}
