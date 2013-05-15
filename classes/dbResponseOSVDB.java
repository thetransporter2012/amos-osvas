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
 
/**
 * variables and method signatures need to be updated
 * 
 */
import java.util.Date;

public class dbResponseOSVDB extends dbResponse{

	class Reference {
		public int referenceID;
		public boolean fourOfFour;
		public boolean indirect;
		public String ref;
		
		public Reference(int referenceID, boolean fourOfFour
						, boolean indirect, String ref){
			this.referenceID = referenceID;
			this.fourOfFour = fourOfFour;
			this.indirect = indirect;
			this.ref = ref;
		}
	}
	//static variables
	public static long OSVDBResponses = 0;
	
	//instance variables - general variables
	private long responseID;
	private long time; 
	
	//instance variables - response vvariables
	int complete; //<complete type="integer">
	long createdOn; //<created-on type="datetime">
	String cveDescription; //<description>
	long disclosureDate; //<disclosure-date type="datetime">
	int disclosureSourceID; //<disclosure-source-id type="integer">
	long discoveryDate; //<discovery-date type="datetime">
	long exploitPublishDate; //<exploit-publish-date type="datetime">
	String[] keywords; //<keywords>
	String manualNotes; //<manual-notes>
	int osvdbID; //<osvdb-id type="integer">
	long promotedOn; //<promoted-on type="datetime">
	String shortDescription; //<short-description>
	String solution; //<solution>
	long solutionDate; //<solution-date type="datetime">
	String title; //<title>
	long updatedOn; //<updated-on type="datetime">
	int userID; //<user-id type="integer">
	Reference[] references;
	
	//explicit constructors
	public dbResponseOSVDB() {
		OSVDBResponses++;
		responseID = OSVDBResponses;
		//time = getTime();???
	}
	
	//methods
	/**
	 * Generates query and forwards it to the relevant database
	 * 
	 * @param - to be completed
	 */
	public void requestData (){
		
	}
}
