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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class QueryIDGenerator {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String apiKey = "XXXXXXXXXXXXXXXXXXXXXXXXXX";
		String param = "";
		
		if (args.length == 0){
			param = "Microsoft";
			int[] IDs = getVendorID(param, apiKey);
			System.out.println("IDs associated with " + param + ": (no other arguments)");
			for (int i = 0; i < IDs.length; i++){
				System.out.println(IDs[i]);
			}
		} else {
			param = args[0];
			int[] IDs = getVendorID(param, apiKey);
			System.out.println("IDs associated with " + param + ":");
			for (int i = 0; i < IDs.length; i++){
				System.out.println(IDs[i]);
			}
		}
	}
	
	/**
	 * @param vendorName The name of the vendor, whose ID is to be returned
	 * @param APIKey The API key
	 * @return an array of IDs correspondent to that name 
	 * @throws IOException 
	 */
	public static int[] getVendorID (String vendorName, String APIKey) throws IOException{

		if(vendorName == null || APIKey == null){
			return null;
		}
		if(vendorName == "" || APIKey == ""){
			return null;
		}

		String s = "http://www.osvdb.org/api/vendor_by_name/" + APIKey + "?name=" + vendorName;
		
		int maxXMLlen = 200;		//TODO update the actual number of xml lines
		
		URL url = new URL(s);
		URLConnection uc = url.openConnection();
		uc.setRequestProperty("Accept", "*/*");
		uc.setRequestProperty("Connection", "Keep-Alive");
		uc.setRequestProperty("User-Agent", "Wget/1.13.4 (linux-gnu)"); 
		uc.connect();
		InputStream is = uc.getInputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
       
        String[] output = new String[maxXMLlen];
        in = new BufferedReader(new InputStreamReader(is));
        int len = 0;
        while ((inputLine = in.readLine()) != null){
            output[len] = inputLine;
            len++;
            
        }
        in.close();
        
        int IDs = 0;
        for (int i = 0; i < output.length; i++){
        	if (checkLine(output[i]) == true){
        		IDs++;
        	}
        }
        
        int[] IDArray = new int[IDs];
        int c = 0;
        for(int i = 0; i < maxXMLlen; i++){
        	if (checkLine(output[i]) == true){
        		IDArray[c] = getID(output[i]);
        		c++;
        	}
        }
        
		return IDArray;
	}

	/**
	 * @param vendorID The ID of the vendor
	 * @param productName The name of the product, which ID is to be returned
	 * @param APIKey The API key
	 * @return an array of product IDs correspondent to the product name and the vendor ID 
	 * @throws IOException 
	 */
	public static int[] getProductID (int vendorID, String productName, String APIKey) throws IOException{
		
		if(vendorID == -1 || productName == null || APIKey == null){
			return null;
		}
		if(productName == "" || APIKey == ""){
			return null;
		}
		
		String s = "http://osvdb.org/api/products_by_name_through_vendor_id/" 
					+ APIKey + "/" + vendorID + "?name=" + productName;

		int maxXMLlen = 200;		//TODO update the actual number of xml lines
		
		URL url = new URL(s);
		URLConnection uc = url.openConnection();
		uc.setRequestProperty("Accept", "*/*");
		uc.setRequestProperty("Connection", "Keep-Alive");
		uc.setRequestProperty("User-Agent", "Wget/1.13.4 (linux-gnu)"); 
		uc.connect();
		InputStream is = uc.getInputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
       
        String[] output = new String[maxXMLlen];
        in = new BufferedReader(new InputStreamReader(is));
        int len = 0;
        while ((inputLine = in.readLine()) != null){
            output[len] = inputLine;
            len++;
            
        }
        in.close();
        
        int IDs = 0;
        for (int i = 0; i < output.length; i++){
        	if (checkLine(output[i]) == true){
        		IDs++;
        	}
        }
        
        int[] IDArray = new int[IDs];
        int c = 0;
        for(int i = 0; i < maxXMLlen; i++){
        	if (checkLine(output[i]) == true){
        		IDArray[c] = getID(output[i]);
        		c++;
        	}
        }
        
		return IDArray;
	}
	
	/**
	 * @param vendorID The ID of the vendor
	 * @param productID The ID of the relevant product
	 * @param APIKey The API key
	 * @return an array of version IDs correspondent to the vendor ID and the product ID 
	 * @throws IOException 
	 */
	public static int[] getVersionID (int vendorID, int productID, String APIKey) throws IOException{
		
		if(vendorID == -1 || productID == -1 || APIKey == null){
			return null;
		}
		if(APIKey == ""){
			return null;
		}
		
		String s = "http://osvdb.org/api/versions_by_vendor_id_and_product_id/" 
				+ APIKey + "/" + vendorID + "?product=" + productID;
		
		int maxXMLlen = 200;		//TODO update the actual number of xml lines
		
		URL url = new URL(s);
		URLConnection uc = url.openConnection();
		uc.setRequestProperty("Accept", "*/*");
		uc.setRequestProperty("Connection", "Keep-Alive");
		uc.setRequestProperty("User-Agent", "Wget/1.13.4 (linux-gnu)"); 
		uc.connect();
		InputStream is = uc.getInputStream();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String inputLine;
       
        String[] output = new String[maxXMLlen];
        in = new BufferedReader(new InputStreamReader(is));
        int len = 0;
        while ((inputLine = in.readLine()) != null){
            output[len] = inputLine;
            len++;
            
        }
        in.close();
        
        int IDs = 0;
        for (int i = 0; i < output.length; i++){
        	if (checkLine(output[i]) == true){
        		IDs++;
        	}
        }
        
        int[] IDArray = new int[IDs];
        int c = 0;
        for(int i = 0; i < maxXMLlen; i++){
        	if (checkLine(output[i]) == true){
        		IDArray[c] = getID(output[i]);
        		c++;
        	}
        }
        
		return IDArray;	}
	

	/**
	 * check whether the current XML line contains an ID
	 * 
	 * @param line The line to check
	 * @return true if the line contains an ID, false if it does not 
	 */
	public static boolean checkLine(String line){
		if (line == null){
			return false;
		}
		String s = "<id";
		int beg = -1;

		for (int i = 0; i < line.length(); i++){
			if(line.charAt(i) == '<'){
				beg = i;
				break;
			}
		}
		if (beg == -1){
			return false;
		} else {
			for (int i = beg; i < beg + 3; i++){
				if (line.charAt(i) != s.charAt(i-beg)){
					return false;
				}
			}
			return true;
		}
	}
	
	
	/**
	 * extract the ID from a line containing the ID
	 * 
	 * @param the line containing the ID
	 * @return -1 if no ID could be extracted, otherwise the extracted ID 
	 */
	public static int getID (String line){
		if (line == null){
			return -1;
		} else {
			@SuppressWarnings("resource")
			Scanner s = new Scanner(line).useDelimiter("[^0-9]+");
			return s.nextInt();
		}
	}
}
