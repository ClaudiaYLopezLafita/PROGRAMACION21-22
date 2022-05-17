import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.print.attribute.Attribute;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ModificacionDOM {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("restaurante.xml"));

            Element root = doc.getDocumentElement();

            //1. Añadimos una nueve etiqueta.
            NodeList nl = doc.getElementsByTagName("plato");

            for (int i = 0; i < nl.getLength(); i++) {

                Element disponible = doc.createElement("dispobible");
                disponible.setTextContent("Si");
                nl.item(i).appendChild(disponible);
            }

            //2. Insertarmos un nuevo plato

            Element plato = doc.createElement("plato");
            plato.setAttribute("calorias", String.valueOf(400));
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent("Plato de Examen");
            Element precio = doc.createElement("precio");
            precio.setTextContent("30.2");
            Element disponible = doc.createElement("disponible");
            disponible.setTextContent("Si");

            root.appendChild(plato);
            plato.appendChild(nombre);
            plato.appendChild(precio);
            plato.appendChild(disponible);


            // CONFIGURACIOND EL TRANNSFORMER

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty( OutputKeys.OMIT_XML_DECLARATION, "no" );
            transformer.setOutputProperty( OutputKeys.METHOD, "xml" );
            transformer.setOutputProperty("http://www.oracle.com/xml/is-standalone", "yes");

            DOMSource origen = new DOMSource(root);
            File nuevo = new File("examen2.xml");
            StreamResult destino = new StreamResult(nuevo);

            transformer.transform(origen,destino);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
