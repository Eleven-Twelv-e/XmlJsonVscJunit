import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class JsonParserTestHamcrest {

    static String sp = File.separator;
    static String path = "D:"+sp+"Java Web Projects"+sp+"XmlJsonVscJunit";

    @Test
    void readString() throws IOException {
        String filePath = path+sp+"data2.json";

        String checkJsonParser = JsonParser.readString(filePath);
        assertThat(checkJsonParser, containsString("id"));
        assertThat(checkJsonParser, containsString("firstName"));
        assertThat(checkJsonParser, containsString("lastName"));
        assertThat(checkJsonParser, containsString("country"));
        assertThat(checkJsonParser, containsString("age"));

    }

    @Test
    void jsonToList() throws ParseException {
        String json = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        List<Employee> list = JsonParser.jsonToList(json);
        Employee john = new Employee(1,"John", "Smith","USA",23);
        Employee ivan = new Employee(2,"Ivan", "Petrov","RU",25);
        assertThat(list,hasSize(2));
        assertThat(list,hasItems(john,ivan));


    }
}