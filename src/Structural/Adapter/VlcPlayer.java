package Structural.Adapter;

public class VlcPlayer implements AdvancedPlayer{
    @Override
    public void playAdvanced(String filename) {
        System.out.println("Playing.." + filename);
    }
}
