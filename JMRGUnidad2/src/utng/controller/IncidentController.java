package utng.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utng.dom.IncidentDOM;
import utng.model.Incident;

/**
 * Servlet implementation class IncidentController
 */
@WebServlet("/IncidentController")
public class IncidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Incident incident;
	private List<Incident> incidents;
	private IncidentDOM IncidentDOM;
	//varialbe de instancia
	private List<String> ids = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
	// Inicializacion de objetos
		public IncidentController() {
			super();
			incident = new Incident();
			incidents = new ArrayList<Incident>();
			IncidentDOM = new IncidentDOM();
			// TODO Auto-generated constructor stub
		}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btn_save") != null) {
			// se trae el parametro nombre del formulario
			
			incident.setParentId(request.getParameter("parentId"));
			incident.setSearchId(request.getParameter("searchId"));
			incident.setName(request.getParameter("name"));
			// se hace el try catch porque hay un tipo de elemento llamado year que se
			// almacenara			
			try {
				incident.setYear(Integer.parseInt(request.getParameter("year")));
			} catch (NumberFormatException e) {
				incident.setYear(2017);
			}
			// Se genera una forma de hacer ids automaticas, se checa que el incident
			// tenga un id vacio
			// se le dara un formato para que le añada una abreviatura de 4 cifras.
			if (incident.getIncidentId() == "") {
				System.out.println("entro");
				String newId = "idt"+String.format("%04d", 1);
				incident.setIncidentId(newId);
				if(incidents.size()>0) {
					ids.clear();
					for(Incident s: incidents) {
						ids.add(s.getIncidentId());
					}
					for(int i=0; i<=ids.size();i++) {
						newId = "idt"+String.format("%04d", i+1);
						if(!ids.contains(newId)) {
							incident.setIncidentId(newId);
							break;
						}
					}
				}
				
				// Al final de colocar los datos del incident, se insertaran los datos en
				// incident
				//pasa un registro y lo añade al archivo xml, si el id no esa vacio lo actualiza.
				IncidentDOM.add(incident);
				//students.add(student);
			} else {
				IncidentDOM.update(incident);
			}
			//se trae todos los datos del incident
			incidents = IncidentDOM.getIncidents();
			//coloca una variable que pueda ser accesible desde la vista
			
			request.setAttribute("incidents", incidents);
			request.getRequestDispatcher("incident_list.jsp").forward(request, response);
			//si el btn new no es nullo, se creara el nuevo registro
		} else if (request.getParameter("btn_new") != null) {
				incident = new Incident();
				request.getRequestDispatcher("incident_form.jsp").forward(request, response);
		}else if(request.getParameter("btn_edit")!=null) {
			try {
				System.out.println("Entroo");
				String id = request.getParameter("incidentId");
				incident = IncidentDOM.findById(id);
				
			}catch(Exception e) {
				incident = new Incident();
			}
			request.setAttribute("incident", incident);
			request.getRequestDispatcher("incident_form.jsp").forward(request, response);
			//busca el registro a partir del parametro id y si es asi lo borra, si no 
		}else if(request.getParameter("btn_delete")!=null) {
			try {
				String id = request.getParameter("incidentId");
				IncidentDOM.delete(id);
				incidents = IncidentDOM.getIncidents();
			}catch(Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("incidents", incidents);
			request.getRequestDispatcher("incident_list.jsp").forward(request, response);
		}else {
			incidents = IncidentDOM.getIncidents();
			request.setAttribute("incidents", incidents);
			request.getRequestDispatcher("incident_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}