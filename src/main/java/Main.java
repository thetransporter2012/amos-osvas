

/*
 * Copyright (c) 2013 by The AMOS project, Group 3, 
 * http://osr.cs.fau.de/2013/04/17/the-2013-amos-projects-start-today/
 *
 * This file is part of the AMOS OSVAS application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */


import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class Main {
		
	public static void main (String[] args) {
		//
	}
	
	public static String[] getTitles (String path) throws Exception{
		
		String xmlFromCsv = WriteXMLFile.getXML(path);
		String [] titles = XMLReaderByTitle(xmlFromCsv);		//TODO: change the moethod!!
		return titles;
	}
	
	/**
	 * generate an array of strings, which represent the titles being browsed
	 * 
	 * @return a string of titles being browsed
	 * @param directory The path where the XML file is stored 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static String[] XMLReaderByTitle (String xml) throws ParserConfigurationException, SAXException, IOException{
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
		
		Document doc = builder.parse(is);
		NodeList nList = doc.getElementsByTagName("URLString");
		int len = 0;
		for (int i = 0; i < nList.getLength(); i++){
			len++;
		}
		String[] s = new String[len];
		for (int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			s[i] = eElement.getElementsByTagName("title").item(0).getTextContent();
		} 
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public static String inputPathCSV = "/Users/Radi/Desktop/CSVInput.csv";
	public static String inputPathXML = "/Users/Radi/Desktop/XMLQuery.xml";
	public static String outputPathXML = "/Users/Radi/Desktop/src";		//the place to store search results
	public static String APIKey = "";
	public static String answer;
	
	
	/*
	@SuppressWarnings("static-access")
	public static void main(String args[]) throws Exception {
	
		if (args.length != 3 ){
			//nothing changed
		} else {
			inputPathCSV = args[0];
			inputPathXML = args[1];
			outputPathXML = args[2];
		}
		

		boolean problems = false;
		
		WriteXMLFile fileWriter =  new WriteXMLFile();
		fileWriter.setInputPath(inputPathCSV);
		fileWriter.setOutputPath(inputPathXML);
		XMLReader reader = new XMLReader();
		reader.setInputPathXML(inputPathXML);
		
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
		String[] s = reader.URLGen();
		System.out.println("Search criteria read");
		File f = new File(outputPathXML);
		clearDir(f);
		XMLWriter.fillFiles(s, outputPathXML);
		
		
		
		//WriteXMLFile.main(null);
		
		answer = "/XMLOutputDatabase";
	}
	*/
	


	
	/**
	 * The existing functionality at the moment involves a file system.
	 * This method simulates the output of the search query for the first
	 * line in the dummy csv file, that would normally be filled in a file.
	 */
	
	/*
	public static String[] main (String args[]) throws Exception {
		
		String s = "http://www.osvdb.org/search/search?search%5Bvuln_title%5D=Apache+Ant&search%5Btext_type%5D=alltext&search%5Bs_date%5D=&search%5Be_date%5D=&search%5Brefid%5D=&search%5Breferencetypes%5D=&search%5Bvendors%5D=&search%5Bcvss_score_from%5D=&search%5Bcvss_score_to%5D=&search%5Bcvss_av%5D=*&search%5Bcvss_ac%5D=*&search%5Bcvss_a%5D=*&search%5Bcvss_ci%5D=*&search%5Bcvss_ii%5D=*&search%5Bcvss_ai%5D=*&kthx=search";
		String[] r = XMLReader.OutputString(s);
		return r;
	}
	*/
	
	/**
	 * @param vendorName The name of the vendor, whose ID is to be returned
	 * @param APIKey The API key
	 * @return an array of IDs correspondent to that name 
	 * @throws IOException 
	 */	
	 
	/*
	public static void clearDir (File directory) {
	      
		for (File file : directory.listFiles()) {
	        if (file.isFile()) {
	            file.delete();
	        }
	    }
	}
	*/
}
