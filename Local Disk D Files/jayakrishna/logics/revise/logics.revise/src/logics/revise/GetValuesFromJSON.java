package logics.revise;

import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetValuesFromJSON {
    
    public static void main(String[] args) {
        
        String jsonString = "{\r\n"
                + "  \"employee\": {\r\n"
                + "    \"lastUpdatedTimestamp\": \"2022-04-18T21:30:15.600Z\",\r\n"
                + "    \"employeeNumber\": 1285493,\r\n"
                + "    \"username\": \"A1285493\",\r\n"
                + "    \"suffix\": \"II\",\r\n"
                + "    \"userPersonType\": \"Employee\",\r\n"
                + "    \"systemPersonType\": \"EMP\",\r\n"
                + "    \"workerType\": \"Regular\",\r\n"
                + "    \"employmentCategory\": \"full-time\",\r\n"
                + "    \"payType\": \"2\",\r\n"
                + "    \"employeeStatus\": \"Active\",\r\n"
                + "    \"isActive\": true,\r\n"
                + "    \"isTerminated\": false,\r\n"
                + "    \"location\": {\r\n"
                + "      \"locationName\": \"El Camino Real Store 000685\",\r\n"
                + "      \"locationId\": 685\r\n"
                + "    },\r\n"
                + "    \"jobCode\": 47841,\r\n"
                + "    \"jobTitle\": \"SPEC, SWAT PRODUCT FLOW\",\r\n"
                + "    \"leaveOfAbsenceType\": \"State_Only_Continuation\",\r\n"
                + "    \"glLocationOrganizationName\": \"El Camino Real CA\",\r\n"
                + "    \"organizationName\": \"Doral FL\",\r\n"
                + "    \"companyName\": \"Best Buy Stores, L.P.\",\r\n"
                + "    \"companyId\": 105,\r\n"
                + "    \"costCenter\": \"RET Store\",\r\n"
                + "    \"glLocationId\": \"GL_000685\",\r\n"
                + "    \"glLocationCodeSubType\": \"BBCC\",\r\n"
                + "    \"payGroup\": \"BiWeekly_1\",\r\n"
                + "    \"costCenterId\": 100100,\r\n"
                + "    \"isExempt\": false,\r\n"
                + "    \"gradeRateStructure\": \"4 Nonexempt\",\r\n"
                + "    \"emailAddress\": \"Workday@bestbuy.com\",\r\n"
                + "    \"homeAddress\": {\r\n"
                + "      \"state\": \"CA\",\r\n"
                + "      \"countryCode\": \"US\"\r\n"
                + "    },\r\n"
                + "    \"workAddress\": {\r\n"
                + "      \"state\": \"CA\",\r\n"
                + "      \"postalCode\": \"94087\",\r\n"
                + "      \"countryCode\": \"US\"\r\n"
                + "    },\r\n"
                + "    \"manager\": {\r\n"
                + "      \"employeeNumber\": 5675710,\r\n"
                + "      \"name\": \"Aaron\",\r\n"
                + "      \"username\": \"a567571\",\r\n"
                + "      \"preferredFirstName\": \"Aaron\"\r\n"
                + "    }\r\n"
                + "  }\r\n"
                + "}";
        
        String json = "{\"name\": \"John Doe\", \"age\": 30}";
        
        
        // Create an instance of ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        
        
        
        try {
            // Read JSON string and convert it to JsonNode
        	Person person = objectMapper.readValue(json, Person.class);
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            
            JsonNode path = jsonNode.path("employee").path("manager");
            
            Iterator<Entry<String, JsonNode>> fields = path.fields();
            
            while(fields.hasNext()) {
            	Entry<String, JsonNode> field = fields.next();
            	
            	System.out.println(field.getKey()+"->"+field.getValue());
            }
            
            // Extract the employeeNumber from the JsonNode
            int employeeNumber = jsonNode.path("employee").path("employeeNumber").asInt();
            
            // Print the extracted employeeNumber
            System.out.println(employeeNumber);
            System.err.println(person);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
        }
    }
}

class Person {
	  private String name;
	  private int age;

	  // Getters and setters (optional but recommended)
	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public int getAge() {
	    return age;
	  }

	  public void setAge(int age) {
	    this.age = age;
	  }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	  
	  
	}

