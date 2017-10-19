package utng.dom;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import utng.model.Incident;

/**
 * Servlet implementation class IncidentDOM
 */
@WebServlet("/IncidentDOM")
public class IncidentDOM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String pathFile="C:\\Users\\Home\\eclipse-workspace\\JMRGUnidad2\\src\\data\\incident.xml";
	//private String pathFile = "src/data/students.xml";

//	public void add(String strId, String strName, int intAge) {
	public void add(Incident data) {
		try {

			Document document = DOMHelper.getDocument(pathFile);
			Element incidents = document.getDocumentElement();
			// Create student tag
			Element incident = document.createElement("incident");
			// Create id tag
			Element id = document.createElement("incidentId");
			id.appendChild(document.createTextNode(data.getIncidentId()));
			incident.appendChild(id);
			// Create Search tag
			Element parent = document.createElement("parentId");
			parent.appendChild(document.createTextNode(data.getSearchId()));
			incident.appendChild(parent);
			Element search = document.createElement("searchId");
			search.appendChild(document.createTextNode(data.getSearchId()));
			incident.appendChild(search);
			// Create name tag
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(data.getName()));
			incident.appendChild(name);
			// Create age tag
			Element year = document.createElement("year");
			year.appendChild(document.createTextNode(String.valueOf(data.getYear())));
			incident.appendChild(year);
			incidents.appendChild(incident);
			// Write to File
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(String id) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("incident");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element incident = (Element) nodeList.item(i);
				if (incident.getElementsByTagName("incidentId").item(0).getTextContent().equals(id)) {
					incident.getParentNode().removeChild(incident);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Incident data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("incident");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element incident = (Element) nodeList.item(i);
				if (incident.getElementsByTagName("incidentId").item(0).getTextContent().equals(data.getIncidentId())) {
					incident.getElementsByTagName("parentId").item(0).setTextContent(data.getParentId());
					incident.getElementsByTagName("searchId").item(0).setTextContent(data.getSearchId());
					incident.getElementsByTagName("name").item(0).setTextContent(data.getName());
					incident.getElementsByTagName("year").item(0).setTextContent(String.valueOf(data.getYear()));
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Incident findById(String id) {
		Incident incident =null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("incident");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element s = (Element) nodeList.item(i);
				if (s.getElementsByTagName("incidentId").item(0).getTextContent().equals(id)) {
					incident = new Incident();
					incident.setIncidentId(id);
					incident.setParentId(s.getElementsByTagName("parentId").item(0).getTextContent());
					incident.setSearchId(s.getElementsByTagName("searchId").item(0).getTextContent());
					incident.setName(s.getElementsByTagName("name").item(0).getTextContent());
					
					incident.setYear(Integer.parseInt(s.getElementsByTagName("year").item(0).getTextContent()));
					
				}
				
			}
			DOMHelper.saveXMLContent(document, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return incident;
	}
	public List<Incident> getIncidents() {
		List<Incident> incidents = new ArrayList<Incident>();
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodeList = document.getElementsByTagName("incident");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Element s = (Element) nodeList.item(i);
				Incident incident = new Incident();
				incident.setIncidentId(s.getElementsByTagName("incidentId").item(0).getTextContent());
				incident.setParentId(s.getElementsByTagName("parentId").item(0).getTextContent());
				incident.setSearchId(s.getElementsByTagName("searchId").item(0).getTextContent());
				incident.setName(s.getElementsByTagName("name").item(0).getTextContent());
				incident.setYear(Integer.parseInt(s.getElementsByTagName("year").item(0).getTextContent()));
				incidents.add(incident);
				}
				return incidents;
			}

}
