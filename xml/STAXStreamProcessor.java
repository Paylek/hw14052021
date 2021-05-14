package xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

public class STAXStreamProcessor implements AutoCloseable{
    private static final XMLInputFactory FACTORY = XMLInputFactory.newFactory();
    private final XMLStreamReader reader;

    public STAXStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

public boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT && parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT && element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
}

public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
}

    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    @Override
    public void close() throws Exception {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
