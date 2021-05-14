package jackson;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonTask {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        Employee employee = createStaff();

       /* try {

            // Java objects to JSON file
            mapper.writeValue(new File("D:/hw14052021/employees.xml"), employee);

            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(employee);

            System.out.println(jsonString);

            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);

            System.out.println(jsonInString2);

        } catch (IOException | JsonMappingException ex) {
            ex.printStackTrace();
        }*/

    }

    private static Employee createStaff() {
        Employee employee = new Employee();

        employee.setName("Pavel");
        employee.setPosition("Urolog");
        employee.setBranch("4");
        employee.setExperience("12");
        
        return employee;
    }
}
