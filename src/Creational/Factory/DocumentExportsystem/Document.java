package Creational.Factory.DocumentExportsystem;

public interface Document {
    String getHeader();
    String getFooter();
    String formatRow(String[] data);
    String getFileExtension();
}
