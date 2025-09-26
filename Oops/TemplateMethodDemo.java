abstract class DataImporter {
    public final void importData() {
        readData();
        parseData();
        validateData();
        saveData();
        postProcess();
    }
    protected abstract void readData();
    protected abstract void parseData();
    protected void validateData() {
        System.out.println("Validating data...");
    }
    protected void saveData() {
        System.out.println("Saving data...");
    }
    protected void postProcess() { }
}
class CSVImporter extends DataImporter {
    @Override
    protected void readData() {
        System.out.println("Reading CSV file...");
    }
    @Override
    protected void parseData() {
        System.out.println("Parsing CSV data...");
    }
    @Override
    protected void postProcess() {
        System.out.println("CSV-specific post processing...");
    }
}
class JSONImporter extends DataImporter {
    @Override
    protected void readData() {
        System.out.println("Reading JSON file...");
    }
    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data...");
    }
}
class XMLImporter extends DataImporter {
    @Override
    protected void readData() {
        System.out.println("Reading XML file...");
    }
    @Override
    protected void parseData() {
        System.out.println("Parsing XML data...");
    }
    @Override
    protected void validateData() {
        System.out.println("Validating XML schema...");
    }
}
public class TemplateMethodDemo {
    public static void main(String[] args) {
        DataImporter csv = new CSVImporter();
        DataImporter json = new JSONImporter();
        DataImporter xml = new XMLImporter();
        System.out.println("CSV Import:");
        csv.importData();
        System.out.println("\nJSON Import:");
        json.importData();
        System.out.println("\nXML Import:");
        xml.importData();
    }
}
