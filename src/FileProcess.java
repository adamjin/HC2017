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
	
	public static void main(String[] args) {
		FileProcess process = new FileProcess();
		process.readInputFile("dataset/example.in");
//		List<Integer[]> list = CutPizza.findFactors(6);
//		for(Integer[] in: list){
//			for(int i:in)
//				System.out.print(i + " ");
//			System.out.println();
//		}
	}
	public HC2017DTO readInputFile(String path){
		File file = new File(path);
		String readLine = "";
		int count = 0;
		HC2017DTO dto = null;
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while((readLine=reader.readLine())!=null){
				if(count==0){
					count++;
					String[] metaData = readLine.split(" ");
					dto = new HC2017DTO(metaData);
				}else{
					list.add(readLine);
				}
			}
//			char[][] cells = new char[list.size()][];
//			count=0;
//			for(String row:list){
//				cells[count++]= row.toCharArray();
//			}
//			pizza.setCell(cells);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Columns "+pizza.getColumn() +" Rows "+pizza.getRow()+" minSLiceLength "+pizza.getMinSliceLength()+ " maxSliceLength "+pizza.getMaxSliceLength() );
//		for(char[] ch: pizza.getCell()){
//			for(char c: ch)
//			System.out.print(""+c);
//			System.out.println();
//		}
		//pizza.setCell
		return dto;
	}
	
	public void writeOutputFile(Result result){
		//impl
		String resultString = result.toString();
		writeStringIntoFile(resultString);
	}
	
	public void writeOutputFile(String result){
		//impl
		String resultString = result;
		writeStringIntoFile(resultString);
	}
	
	private void writeStringIntoFile(String resultString){
		//impl
		byte data[] = resultString.getBytes();
		Path file = Paths.get("./test.out");
		try{
			Files.write(file, data);
		} catch (IOException x) {
		      System.err.println(x);
	    }
	}
}
