import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class FileProcessTest {

	@Test
	public void readInputFileTest() throws IOException{
			FileProcess process = new FileProcess();
			List<String> inputString = process.readInputFile("dataset/example.in");
			System.out.print(inputString.get(0)+"\n");
			System.out.print(inputString.get(1)+"\n");
			System.out.print(inputString.get(2)+"\n");
			System.out.print(inputString.get(3)+"\n");
			
	}
}
