package Creational.Factory.DocumentExportsystem;

public class HtmlCreator extends ExportCreator {
    @Override
    public Document createDocument() {
        return new HtmlDocument();
    }
}
