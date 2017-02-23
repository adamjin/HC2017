
public class Request {
	private int numRequest;
	private int videoId;
	private int endpointId;
	
	public Request() {
	}
	public Request(int numRequest, int videoId, int endpointId) {
		this.numRequest = numRequest;
		this.videoId = videoId;
		this.endpointId = endpointId;
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

}
