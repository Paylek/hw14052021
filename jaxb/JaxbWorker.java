package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbWorker {
    public static void main(String[] args) {
        String fileName = "D:/hw14052021/employees.xml";

        Employee employee = new Employee();

        employee.setName("Pavel");
        employee.setPosition("physiotherapist");
        employee.setBranch("7");
        employee.setExperience("8");

        // сохраняем объект в XML файл
        convertObjectToXml(employee, fileName);

        // восстанавливаем объект из XML файла
        Employee unmarshStudent = fromXmlToObject(fileName);
        if (unmarshStudent != null) {
            System.out.println(unmarshStudent.toString());
        }
    }

        private static Employee fromXmlToObject(String filePath) {
            try {
                // создаем объект JAXBContext - точку входа для JAXB
                JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
                Unmarshaller un = jaxbContext.createUnmarshaller();

                return (Employee) un.unmarshal(new File(filePath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            return null;
        }

        // сохраняем объект в XML файл
        private static void convertObjectToXml(Employee student, String filePath) {
            try {
                JAXBContext context = JAXBContext.newInstance(Employee.class);
                Marshaller marshaller = context.createMarshaller();
                // устанавливаем флаг для читабельного вывода XML в JAXB
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                // маршаллинг объекта в файл
                marshaller.marshal(student, new File(filePath));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }
