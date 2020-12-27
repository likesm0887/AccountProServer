package XMLGenrator;

import XMLGenerator.XMLGenerator;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class XMLGeneratorTest {

    @Test
    public void generateXML() throws TransformerException, ParserConfigurationException {
        XMLGenerator xmlGenerator = new XMLGenerator();
        xmlGenerator.generateXML();
    }
}