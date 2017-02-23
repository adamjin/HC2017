import java.util.ArrayList;
import java.util.List;

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
		String line0[] = strList.get(0).split(" ");
		this.numV = Integer.parseInt(line0[0]);
		this.numEP = Integer.parseInt(line0[1]);
		this.numRequestD = Integer.parseInt(line0[2]);
		this.numCachedServers = Integer.parseInt(line0[3]);
		this.cachedServersCapacity = Integer.parseInt(line0[4]);;

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
