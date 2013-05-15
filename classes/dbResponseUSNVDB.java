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

public class dbResponseUSNVDB extends dbResponse{

	class Reference {
		
	}
	//static variables
	public static long USNVDBResponses = 0;
	
	//instance variables - general variables
	private long responseID;
	private long time; 
	
	//instance variables - response vvariables
	Reference[] references;
	
	//explicit constructors
	public dbResponseUSNVDB() {
		USNVDBResponses++;
		responseID = USNVDBResponses;
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
