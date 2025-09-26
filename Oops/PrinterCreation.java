interface Printable {
    void print(String content);
}
interface Scannable {
    void scan(String content);
}
interface Faxable {
    void fax(String content);
}
class BasicPrinter implements Printable {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
}
class MultiFunctionPrinter implements Printable, Scannable {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }
}
class AllInOnePrinter implements Printable, Scannable, Faxable {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }
    @Override
    public void fax(String content) {
        System.out.println("Faxing: " + content);
    }
}
class PrinterFactory {
    static Printable createBasicPrinter() {
        return new BasicPrinter();
    }
    static MultiFunctionPrinter createMultiFunctionPrinter() {
        return new MultiFunctionPrinter();
    }
    static AllInOnePrinter createAllInOnePrinter() {
        return new AllInOnePrinter();
    }
}
public class PrinterCreation {
    public static void main(String[] args) {
        Printable basic = PrinterFactory.createBasicPrinter();
        basic.print("Hello ISP!");
        MultiFunctionPrinter multi = PrinterFactory.createMultiFunctionPrinter();
        multi.print("Report");
        multi.scan("Document");
        AllInOnePrinter aio = PrinterFactory.createAllInOnePrinter();
        aio.print("Contract");
        aio.scan("Passport");
        aio.fax("Agreement");
    }
}
