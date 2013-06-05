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

public class UploadList {
	
	public UploadListEntry[] uploadListEntry;

	public UploadList(UploadListEntry[] uploadListEntry){
		this.uploadListEntry = uploadListEntry;
	}
	
	/**
	 * transform the array of search entries into an array of search 
	 * objects
	 * 
	 * @param uploadListEntry The array of uploaded search entries
	 * @return an array of request classes
	 */
	public dbRequestOSVDB[] toRequests (UploadListEntry[] uploadListEntry){
		if (uploadListEntry == null){
			return null;
		}
		
		dbRequestOSVDB[] dbReq = new dbRequestOSVDB[uploadListEntry.length];
		for (int i = 0; i < uploadListEntry.length; i++){
			String name = uploadListEntry[i].productName;
			String version = uploadListEntry[i].productVersion;
			dbReq[i] = new dbRequestOSVDB(name, version);
		}
		
		return dbReq;
	}
}
