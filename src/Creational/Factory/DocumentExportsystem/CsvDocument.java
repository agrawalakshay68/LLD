package Creational.Factory.DocumentExportsystem;

public class CsvDocument implements Document{
    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public String getFooter() {
        return "";
    }

    @Override
    public String formatRow(String[] data) {
        return String.join(",", data);
    }

    @Override
    public String getFileExtension() {
        return ".csv";
    }
}
