package XMLGenerator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NodeGenerator {
    private final Document document;
    private Element root;

    public NodeGenerator(Document document) {
        this.document = document;
    }

    public NodeGenerator createRoot() {
        root = document.createElement("xbrli:xbrl");
        root.setAttribute("xmlns:xbrli", "http://www.xbrl.org/2003/instance");
        root.setAttribute("xmlns:link", "http://www.xbrl.org/2003/linkbase");
        root.setAttribute("xmlns:link", "http://www.w3.org/1999/xlink");
        root.setAttribute("xmlns:iso4217", "http://www.xbrl.org/2003/iso4217");
        root.setAttribute("xmlns:xbrldi", "http://xbrl.org/2006/xbrldi");
        root.setAttribute("xmlns:ssmt-dei", "http://xbrl.ssm.com.my/taxonomy/2017-12-31/ssmt-dei-core");
        root.setAttribute("xmlns:ssmt-dei-ee-mfrs", "http://xbrl.ssm.com.my/taxonomy/2017-12-31/ssmt-dei-ee-mfrs");
        root.setAttribute("xmlns:ifrs-full", "http://xbrl.ifrs.org/taxonomy/2017-03-09/ifrs-full");
        root.setAttribute("xmlns:ssmt", "http://xbrl.ssm.com.my/taxonomy/2017-12-31/ssmt-cor");
        root.setAttribute("xmlns:ssmt-mfrs", "http://xbrl.ssm.com.my/taxonomy/2017-12-31/ssmt-mfrs-cor");
        root.setAttribute("id", "MBRS_Preparation_Tool_1.0.38");
        document.appendChild(root);
        return this;
    }

    public NodeGenerator createElementWithUnitRefDecimal(String tag, String contextRefValue, String unitRefValue, String decimalValue, String nodeValue) {
        Element element = document.createElement(tag);
        element.setAttribute("contextRef", contextRefValue);
        element.setAttribute("unitRef", unitRefValue);
        element.setAttribute("decimals", decimalValue);
        element.appendChild(document.createTextNode(nodeValue));
        root.appendChild(element);
        return this;
    }

    public NodeGenerator createElementWithContextRef(String tag, String attributeValue, String nodeValue) {
        Element element = document.createElement(tag);
        element.setAttribute("contextRef", attributeValue);
        element.appendChild(document.createTextNode(nodeValue));
        root.appendChild(element);
        return this;
    }

    public NodeGenerator createElementWithAttribute(String tag, String attributeName, String attributeValue, String nodeValue) {
        Element element = document.createElement(tag);
        element.setAttribute(attributeName, attributeValue);
        element.appendChild(document.createTextNode(nodeValue));
        root.appendChild(element);
        return this;
    }

    public Document build() {
        return document;
    }
}
