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
		List<String> inputString_1 = process.readInputFile("dataset/videos_worth_spreading.in");
		List<String> inputString_2 = process.readInputFile("dataset/trending_today.in");
		List<String> inputString_3 = process.readInputFile("dataset/me_at_the_zoo.in");
		List<String> inputString_4 = process.readInputFile("dataset/kittens.in");

		//do something with the inputString from here
		//e.g. to use the inputString to construct the dto, etc...
		HC2017DTO dto_1 = new HC2017DTO(inputString_1);
		HC2017DTO dto_2 = new HC2017DTO(inputString_2);
		HC2017DTO dto_3 = new HC2017DTO(inputString_3);
		HC2017DTO dto_4 = new HC2017DTO(inputString_4);
		//use helper class to process the dto in order to get the result
		Output output_1 = Helper.process(dto_1.getRequests(), dto_1.getVideos(), dto_1.getEndpopints(), dto_1.getCachedServers());
		process.writeOutputFile(output_1, "videos_worth_spreading");
		
		Output output_2 = Helper.process(dto_2.getRequests(), dto_2.getVideos(), dto_2.getEndpopints(), dto_2.getCachedServers());
		process.writeOutputFile(output_2, "trending_today");

		Output output_3 = Helper.process(dto_3.getRequests(), dto_3.getVideos(), dto_3.getEndpopints(), dto_3.getCachedServers());
		process.writeOutputFile(output_3, "me_at_the_zoo");

		Output output_4 = Helper.process(dto_4.getRequests(), dto_4.getVideos(), dto_4.getEndpopints(), dto_4.getCachedServers());
		process.writeOutputFile(output_4, "kittens");


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
	
	public void writeOutputFile(Output result, String outputFileName){
		writeStringIntoFile(result.toString(), outputFileName);
	}
	
	public void writeOutputFile(String str, String outputFileName){
		writeStringIntoFile(str, outputFileName);
	}
	
	private void writeStringIntoFile(String resultString, String outputFileName){
		String path = "./" + outputFileName + ".out";
		byte data[] = resultString.getBytes();
		Path file = Paths.get(path);
		try{
			Files.write(file, data);
		} catch (IOException x) {
		      System.err.println(x);
	    }
	}
}
