import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CsvJsonTest {

    static String sp = File.separator;
    static String path = "D:"+sp+"Java Web Projects"+sp+"XmlJsonVscJunit";

    @Test
    void parseCSV_valid_test() throws IOException {
        final String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        final String fileName = path+sp+"data2.csv";

        List<Employee> list = CsvJson.parseCSV(columnMapping, fileName);

        Assertions.assertNotNull(list);
    }

    @Test
    void listToJson_valid_test() {
        Employee john = new Employee(1, "John", "Smith", "USA", 25);
        Employee ivan = new Employee(2, "Ivan", "Petrov", "RU", 23);
        List<Employee> listForCheck = new ArrayList<>();
        listForCheck.add(john);
        listForCheck.add(ivan);
        String checkJson = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

        String json = CsvJson.listToJson(listForCheck);

        Assertions.assertNotNull(json);
        Assertions.assertEquals(checkJson, json);

    }

}