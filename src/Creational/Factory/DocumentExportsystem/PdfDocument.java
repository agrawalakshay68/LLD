package Creational.Factory.DocumentExportsystem;

public class PdfDocument implements Document{
    @Override
    public String getHeader() {
        return "---PDF Start---";
    }

    @Override
    public String getFooter() {
        return "---PDF End---";
    }

    @Override
    public String formatRow(String[] data) {
        return "| " + String.join(" | ", data) + " |";
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}
