interface Parser {
    String parse(String input);
    static Parser of(String format) {
        switch (format.toLowerCase()) {
            case "json":
                return new JsonParser();
            case "xml":
                return new XmlParser();
            default:
                throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}
class JsonParser implements Parser {
    @Override
    public String parse(String input) {
        return "Parsing JSON: " + input;
    }
}
class XmlParser implements Parser {
    @Override
    public String parse(String input) {
        return "Parsing XML: " + input;
    }
}
public class ParserStaticMethod {
    public static void main(String[] args) {
        Parser jsonParser = Parser.of("json");
        System.out.println(jsonParser.parse("{\"name\":\"Shashi\"}"));
        Parser xmlParser = Parser.of("xml");
        System.out.println(xmlParser.parse("<name>Shashi</name>"));
    }
}
