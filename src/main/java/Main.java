import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    static String sp = File.separator;
    static String path = "D:"+sp+"Java Web Projects"+sp+"XmlJsonVscJunit";
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException {
        File dataCsv = new File(path+sp+"data.csv");
        File jsonCsv = new File(path+sp+"data1.json");
        File dataXml = new File(path+sp+"data.xml");
        File jsonXml = new File(path+sp+"data2.json");
        File jsonParser = new File(path+sp+"data2.json");

        CsvJson.csvJson(dataCsv.getAbsolutePath(), jsonCsv.getAbsolutePath());
        XmlJson.xmlJson(dataXml.getAbsolutePath(),jsonXml.getAbsolutePath());
        JsonParser.jsonParser(jsonParser.getAbsolutePath());
    }
}