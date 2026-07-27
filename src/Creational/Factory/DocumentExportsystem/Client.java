package Creational.Factory.DocumentExportsystem;

public class Client {
    static void main(String[] args) {
        String[][] reportData = {
                {"Name", "Department", "Salary"},
                {"Alice", "Engineering", "120000"},
                {"Bob", "Marketing", "95000"},
                {"Charlie", "Design", "105000"}
        };

        ExportCreator pdfExporter = new PdfCreator();
        pdfExporter.export(reportData);

        ExportCreator htmlExporter = new HtmlCreator();
        htmlExporter.export(reportData);

        ExportCreator csvExporter = new CsvCreator();
        csvExporter.export(reportData);
    }
}
