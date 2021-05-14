package xml;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SAXTask {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Employee> emp = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File("y.xml"), handler);

        for (Employee employee : employees) {
            System.out.println("Имя сотрудника: " + employee.getName() + ", его должность: "
                    + employee.getPosition() + ", отделение: " + employee.getBranch() +
                    ", стаж работы: " + employee.getExperience());
        }

        try(STAXStreamProcessor processor = new STAXStreamProcessor(Files.newInputStream(Paths.get("r.xml")))) {
            while (processor.startElement("position", "employee")) {
                System.out.println(processor.getAttribute("name") + ":" + processor.getText());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        DocumentBuilderFactory factory1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory1.newDocumentBuilder();
        Document document = builder.parse(new File("y.xml"));

        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
        for(int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            NamedNodeMap attributes = employee.getAttributes();
            emp.add(new Employee(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("position").getNodeValue(),
                    attributes.getNamedItem("branch").getNodeValue(), attributes.getNamedItem("experience").getNodeValue()));
        }

        for (Employee employee : emp) {
            System.out.println("Имя сотрудника: " + employee.getName() + ", его должность: "
                    + employee.getPosition() + ", отделение: " + employee.getBranch() +
                    ", стаж работы: " + employee.getExperience());
        }

      searchEmployee("Pavel");
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String position = attributes.getValue("position");
                String branch = attributes.getValue("branch");
                String experience = attributes.getValue("experience");
                employees.add(new Employee(name, position, branch, experience));
            }
        }

    }

    public static void searchEmployee(String fio) {
        ArrayList<Employee> empe = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("y.xml"));

            NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");
            for(int i = 0; i < employeeElements.getLength(); i++) {
                Node employee = employeeElements.item(i);
                NamedNodeMap attributes = employee.getAttributes();
                if (attributes.getNamedItem("name").getNodeValue().equals(fio))
                empe.add(new Employee(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("position").getNodeValue(),
                        attributes.getNamedItem("branch").getNodeValue(), attributes.getNamedItem("experience").getNodeValue()));
            }

            for (Employee employee : empe) {

                System.out.println("Имя сотрудника: " + employee.getName() + ", его должность: "
                        + employee.getPosition() + ", отделение: " + employee.getBranch() +
                        ", стаж работы: " + employee.getExperience());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
