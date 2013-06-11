package amos;
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
public class XMLWriter {

	/**
	 * Fills a file with the XML code from the web page called
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	/*
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		final String outputXMLPath = "/users/Radi/Desktop/src/";
		String[] s = XMLReader.URLGen();
		String url = s[0];
		fillFile(url, outputXMLPath);
	}
	*/
	public static void fillFile(String url, String outputXMLPath) throws IOException{
		String[] text = XMLReader.OutputString(url);
		File output = new File(outputXMLPath);
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
	
	
	public static void fillFiles(String[] url, String outputXMLPath) throws IOException{
		
		
		for (int k = 0; k < url.length; k++){
			
			
			String[] text = XMLReader.OutputString(url[k]);
			
			String name = outputXMLPath + "/XMLOutput_" + k + ".xml";
			
			File output = new File(name);
			
			
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
			int l = k+1;
			System.out.println("File " + l + " of " + url.length + " filled");
		}
		System.out.println("Finished");
	}
}
