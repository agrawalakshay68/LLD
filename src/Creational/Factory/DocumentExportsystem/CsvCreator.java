package Creational.Factory.DocumentExportsystem;

public class CsvCreator extends ExportCreator {
    @Override
    public Document createDocument() {
        return new CsvDocument();
    }
}
