import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {

	/**
	 * Fills a file with the XML code from the web page called
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String[] text = XMLReader.OutputString();
		File output = new File(outputPath);
		if (output.exists() == false) {
			output.createNewFile();
		}
		FileWriter fWriter = new FileWriter(output.getAbsoluteFile());
		BufferedWriter bWriter = new BufferedWriter(fWriter);
		for (int i = 0; i < text.length; i++){
			if (text[i] != null){
				bWriter.write(text[i]);
			}
			bWriter.newLine();
		}
		bWriter.close();
		System.out.println("Finished");
	}
	
	public static final String outputPath = "/users/Radi/Desktop/XMLOutput.xml";

}
