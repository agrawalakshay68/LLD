package Structural.Adapter;

public class LegacyPlayer implements MediaPlayer{
    @Override
    public void play(String filename) {
        System.out.println("Playing.." + filename);
    }
}
