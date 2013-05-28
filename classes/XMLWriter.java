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

public class XMLWriter {

	/**
	 * Fills a file with the XML code from the web page called
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		String[] text = XMLReader.OutputString();
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
	
	public static final String outputXMLPath = "/users/Radi/Desktop/XMLOutput.xml";

}
