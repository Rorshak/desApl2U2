package utng.model;

import java.io.Serializable;

public class Incident implements Serializable{
	/**
	 * 
	 */
	
	private String incidentId;
	private String parentId;
	private String searchId;
	private String name;
	private int year;
	
	public Incident(String incidentId, String parentId, String searchId, String name, int year) {
		super();
		this.incidentId = incidentId;
		this.parentId = parentId;
		this.searchId = searchId;
		this.name = name;
		this.year = year;
	}

	public Incident() {
		this("","","","",0);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the incidentID
	 */
	public String getIncidentId() {
		return incidentId;
	}

	/**
	 * @param incidentID the incidentID to set
	 */
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the searchId
	 */
	public String getSearchId() {
		return searchId;
	}

	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the serialversionuid
	 */
	
	
	
	
	
	
	
	
	
	
}
