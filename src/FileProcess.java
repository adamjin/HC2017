import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.nio.file.Paths;
/**
 * this is the file processing class
 * */
public class FileProcess {
	
	public static void main(String[] args) throws IOException {
		FileProcess process = new FileProcess();
		//read the file as a string
		List<String> inputString = process.readInputFile("dataset/videos_worth_spreading.in");
//		List<String> inputString = process.readInputFile("dataset/trending_today.in");
//		List<String> inputString = process.readInputFile("dataset/me_at_the_zoo.in");
//		List<String> inputString = process.readInputFile("dataset/kittens.in");

		//do something with the inputString from here
		//e.g. to use the inputString to construct the dto, etc...
		HC2017DTO dto = new HC2017DTO(inputString);
		//use helper class to process the dto in order to get the result
		Output output = Helper.process(dto.getRequests(), dto.getVideos(), dto.getEndpopints(), dto.getCachedServers());
		process.writeOutputFile(output);
//		dto.print();;
//		Map<Integer, List<Video>> cachedVideos = new HashMap<>();
//		List<Video> videos = new ArrayList<>();
//		Video video = new Video();
//		video.setId(2);
//		videos.add(video);
//		cachedVideos.put(0, videos);
//		List<Video> videos2 = new ArrayList<>();
//		Video video1 = new Video();
//		video1.setId(3);
//		videos2.add(video1);
//		Video video2 = new Video();
//		video2.setId(1);
//		videos2.add(video2);
//		cachedVideos.put(1, videos2);
//		List<Video> videos3 = new ArrayList<>();
//		Video video4 = new Video();
//		video4.setId(0);
//		videos3.add(video4);
//		videos3.add(video2);
//		cachedVideos.put(2, videos3);
//		
//		Output output = new Output(3, cachedVideos);
//		process.writeOutputFile(output);
	}
		
	public List<String> readInputFile(String path) throws IOException {
		File file = new File(path);
		String readLine = "";
		List<String> strBuilder = new ArrayList<>();
	    String lineSeperator = System.getProperty("line.separator");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {

			while((readLine=reader.readLine())!=null){
				strBuilder.add(readLine);
				
			}
			return strBuilder;
		}  finally {
			reader.close();
		}
	}
	
	public void writeOutputFile(Output result){
		writeStringIntoFile(result.toString());
	}
	
	public void writeOutputFile(String str){
		writeStringIntoFile(str);
	}
	
	private void writeStringIntoFile(String resultString){
		
		byte data[] = resultString.getBytes();
		Path file = Paths.get("./test.out");
		try{
			Files.write(file, data);
		} catch (IOException x) {
		      System.err.println(x);
	    }
	}
}
