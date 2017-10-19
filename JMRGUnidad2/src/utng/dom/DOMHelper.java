package utng.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class DOMHelper {
	public static Document getDocument(String pathFile) {
		Document document = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// Creador de documentos, se hace uso de la fabrica de documentos.
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(pathFile);
		} catch (Exception e) {
			document = null;
			e.printStackTrace();
		}
		return document;
	}

	// obtener el contenido xml en ese archivo
	public static String saveXMLContent(Document document, String pathFile) {
		String result = "";
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(pathFile);
			// Transformar el archivo que usa domsource con
			transformer.transform(domSource, streamResult);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
