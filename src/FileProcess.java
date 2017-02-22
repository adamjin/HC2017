import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
/**
 * this is the file processing class
 * */
public class FileProcess {
	
	public static void main(String[] args) throws IOException {
		FileProcess process = new FileProcess();
		//read the file as a string
		String inputString = process.readInputFile("dataset/example.in");
		//do something with the inputString from here
		//e.g. to use the inputString to construct the dto, etc...
	}
	public String readInputFile(String path) throws IOException {
		File file = new File(path);
		String readLine = "";
		StringBuilder strBuilder = new StringBuilder();
	    String lineSeperator = System.getProperty("line.separator");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		try {

			while((readLine=reader.readLine())!=null){
				strBuilder.append(readLine);
				strBuilder.append(lineSeperator);
			}
			return strBuilder.toString();
		}  finally {
			reader.close();
		}
	}
	
	public void writeOutputFile(Result result){
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
