package infrastructure.xmlGenerator;

import org.junit.Test;

public class MPERSXMLGeneratorTest {

    @Test
    public void generate_xml() {
        XMLGenerator xmlGenerator = new MPERSXMLGenerator();
        xmlGenerator.generateXML();
    }
}