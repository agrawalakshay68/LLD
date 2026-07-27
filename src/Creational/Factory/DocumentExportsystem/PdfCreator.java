package Creational.Factory.DocumentExportsystem;

public class PdfCreator extends ExportCreator {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
