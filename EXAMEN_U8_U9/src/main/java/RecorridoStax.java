import org.w3c.dom.Text;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class RecorridoStax {
    public static void main(String[] args) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        int numPlatos = 0;
        int m=0;
        String tagActual = "";

        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("restaurante.xml"));

            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();

                if (event.isStartElement()){

                    StartElement start = event.asStartElement();
                    tagActual=start.getName().getLocalPart();

                    if (tagActual.equals("plato")){
                       numPlatos++;
                    }

                } else if (event.isAttribute()){


                }
            }


            System.out.println("La cantidad total de platos en el XML es: " + numPlatos);


        } catch (Exception e) {

        }
    }
}
