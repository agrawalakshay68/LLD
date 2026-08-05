package Structural.Adapter;

public class Mp4Player implements AdvancedPlayer{
    @Override
    public void playAdvanced(String filename) {
        System.out.println("Playing..." + filename);
    }
}
