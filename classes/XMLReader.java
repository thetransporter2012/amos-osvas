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
	 

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class XMLReader {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
	//	String[] s = URLGen();
		String[] s = OutputString();
		
	//	/*
		for (int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
	//	*/

		/*
		//examplary url. The ones generated from URLGen() return HTTP response code 403!
		URL url = new URL("http://en.wikipedia.org/wiki/Hidden_variable_theory");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
		            System.out.println(inputLine);
		in.close();
		*/
	
		
		/*
		 * real code to be executed, at the moment throws IOException
		URL url = new URL(s[0]);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
		            System.out.println(inputLine);
		in.close();
		*/
	}

	public static final String directory = "/Users/Radi/Desktop/XMLInput.xml";
	
	public static String[] OutputString() throws IOException{

		//examplary url. The ones generated from URLGen() return HTTP response code 403!
		URL url = new URL("http://en.wikipedia.org/wiki/Hidden_variable_theory");
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        int lines = 0;
        while ((inputLine = in.readLine()) != null){
		    lines++;
        }
        String[] s = new String[lines];
        in = new BufferedReader(new InputStreamReader(url.openStream()));
        int i = 0;
        while ((inputLine = in.readLine()) != null){
            s[i] = inputLine;
            i++;
        }
        in.close();
		
		return s;
	}
	
	
	/**
	 * generate an array of URL addresses to be visited 
	 * 
	 * @return a string of URLs
	 * @param none 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static String[] URLGen() throws ParserConfigurationException, SAXException, IOException{
		
		String[] s = XMLReaderByTitle(directory);
		for (int i = 0; i < s.length; i++){
			String[] cString = new String[1];
			cString[0] = s[i];
			s[i] = getUrlByTitle(cString);
		}
		return s;
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
	public static String[] XMLReaderByTitle (String directory) throws ParserConfigurationException, SAXException, IOException{
		
		File source = new File(directory);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(source);
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
	
	
	/**
	 * get a string that can be put in a browser, leading to a 
	 * specific search of a certain vendor
	 * 
	 * @param args The title or titles being browsed
	 * @return a string ready to be written in a browser
	 */
	public static String getUrlByTitle (String[] args){
		String title = "";
		String textType = "";
		String bsDate = "";
		String beDate = "";
		String refId = "";
		String refTypes = "";
		String vendors = "";
		String cvssScoreFrom = "";
		String cvssScoreTo = "";
		String cvssAv = "";
		String cvssAc = "";
		String cvssA = "";
		String cvssCi = "";
		String cvssIi = "";
		String cvssAi = "";
		String additionalCriteria = "";
		
		if (args.length == 0){
			title = "";
		} else if (args.length == 1){
			title += args[0];
		} else {
			for (int i = 0; i < args.length-1; i++){
				title += args[0];
				title += "+";
			}
			title += args[args.length-1];
		}
		
		String s = "http://www.osvdb.org/search/search?search%5Bvuln_title%5D="
				+title+							//string (blanks are filled with "+")
				"&search%5Btext_type%5D="
				+textType+						//"titles" or "alltext"
				"&search%5Bs_date%5D="
				+bsDate+						//"May+8%2C+2013"	"Month" + "+(int)day" + "%2C+" + "(int)year"
				"&search%5Be_date%5D="
				+beDate+						//"May+8%2C+2013"	"Month" + "+(int)day" + "%2C+" + "(int)year"
				"&search%5Brefid%5D="
				+refId+							//string (blanks are filled with "+")
				"&search%5Breferencetypes%5D="
				+refTypes+						//enum refTypes or %21refTypes (NOT REF_TYPE)
				"&search%5Bvendors%5D="
				+vendors+						//string (blanks are filled with "+")
				"&search%5Bcvss_score_from%5D="
				+cvssScoreFrom+					//float
				"&search%5Bcvss_score_to%5D="
				+cvssScoreTo+					//float
				"&search%5Bcvss_av%5D="
				+cvssAv+						//enum AV
				"&search%5Bcvss_ac%5D="
				+cvssAc+						//enum AC
				"&search%5Bcvss_a%5D="
				+cvssA+							//enum A
				"&search%5Bcvss_ci%5D="
				+cvssCi+						//enum CI
				"&search%5Bcvss_ii%5D="
				+cvssIi+						//enum II
				"&search%5Bcvss_ai%5D="
				+cvssAi							//enum AI
				+additionalCriteria+			//string of: "&" + toString(classification enum) + "=1"
				"&kthx=search";
		
		return s;
	}

	 /**
	  * The necessary enumerators are listed below
	  * 
	  */
	//Reference Types
	enum REF_TYPES {
		NESSUS,
		SNORT,
		CVEID,
		BID,
		MSSB,
		RELOSVDBID,
		ISS,
		CERT,
		CERTVU,
		SECUNIA,
		CIAC,
		//US CERT = CERT
		SECURITYTRACKER,
		OVAL,
		VUPEN,
		NIKTO,
		MILW0RM,
		METASPLOIT,
		EXPLOITDB,
		SCIPID,
		TENPVS,
		//unavailable
		//unavailable
		//unavailable
		//unavailable
		//unavailable
	}

	//Access Vector
	enum AV {
		L,	//local
		A, 	//adjacent network
		N 	//remote network
	}

	//Access Complexity
	enum AC {
		H,	//high
		M,	//medium
		L	//low
	}

	//Authentication
	enum A {
		M,	//multiple
		S,	//single
		N	//none
	}

	//Confidentialilty
	enum CI {
		N,	//none
		P,	//partial
		C	//complete
	}

	//Integrity
	enum II {
		N,	//none
		P,	//partial
		C	//complete
	}

	//Availability
	enum AI {
		N,	//none
		P,	//partial
		C	//complete
	}

	//Classification - Location
	enum LOCATION {
		location_physical,
		location_local,
		location_remote,
		location_local_remote,
		location_context,
		location_dialup,
		location_wireless,
		location_mobile,
		location_unknown
	}

	//Classification - Attack Type
	enum ATTACK_TYPE {
		attack_type_auth_manage,
		attack_type_crypt,
		attack_type_dos,
		attack_type_info_disclose,
		attack_type_infrastruct,
		attack_type_input_manip,
		attack_type_miss_config,
		attack_type_race,
		attack_type_other,
		attack_type_unknown
	}

	//Classification - Impact
	enum IMPACT {
		impact_confidential,
		impact_integrity,
		impact_available,
		impact_unknown
	}

	//Classification - Solution
	enum SOLUTION {
		solution_workaround,
		solution_patch,
		solution_upgrade,
		solution_change_default,
		solution_third_party,
		solution_discontinued,
		solution_unknown,
		solution_none
	}

	//Classification - Exploit
	enum EXPLOIT {
		exploit_poc_public,
		exploit_public,
		exploit_private,
		exploit_commercial,
		exploit_unknown,
		exploit_virus_malware,
		exploit_wormified
	}

	//Classification - Disclosure
	enum DISCLOSURE {
		disclosure_rbs_confirmed,
		disclosure_verified,
		disclosure_disputed,
		disclosure_third_party_verified,
		disclosure_third_party_disputed,
		disclosure_coordinated_disclosure,
		disclosure_uncoordinated_disclosure,
		disclosure_in_wild,
		disclosure_no_vendor_response,
		disclosure_no_vendor_action
	}

	//Classification - OSVDB
	enum OSVDB {
		vuln_authentication_required,
		vuln_vuln_dependent,
		vuln_web_check,
		vuln_concern,
		vuln_myth_fake,
		not_a_vuln,
		vuln_backdoor,
		vuln_scada,
		vuln_voice_over_ip
	}

	
}
