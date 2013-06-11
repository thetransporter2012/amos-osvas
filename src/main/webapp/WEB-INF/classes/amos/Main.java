package amos;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {
	
	public final static String inputPathCSV = "/Users/Radi/Desktop/CSVInput.csv";
	public final static String inputPathXML = "/Users/Radi/Desktop/XMLQuery.xml";
	public final static String outputPathXML = "/Users/Radi/Desktop/src";		//the place to store search results
	public final static String APIKey = "";
	public static String answer;

	public static void main(String args[]) throws Exception {
		
		boolean problems = false;

		WriteXMLFile fileWriter =  new WriteXMLFile();
		fileWriter.setInputPath(inputPathCSV);
		fileWriter.setOutputPath(inputPathXML);
		try {
			WriteXMLFile.main(null);
		} catch (ParserConfigurationException pce) {
			problems = true;
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			problems = true;
			tfe.printStackTrace();
		}		
		
		if (problems == true){
			return;
		}

		System.out.println("Input XML file created");
		String[] s = XMLReader.URLGen();
		System.out.println("Search criteria read");
		File f = new File(outputPathXML);
		clearDir(f);
		XMLWriter.fillFiles(s, outputPathXML);
		
		
		
		WriteXMLFile.main(null);
		
		answer = "/XMLOutputDatabase";
	}

	 
	
	/**
	 * @param vendorName The name of the vendor, whose ID is to be returned
	 * @param APIKey The API key
	 * @return an array of IDs correspondent to that name 
	 * @throws IOException 
	 */	
	 public static void clearDir (File directory) {
	      
		for (File file : directory.listFiles()) {
	        if (file.isFile()) {
	            file.delete();
	        }
	    }
	}
}
