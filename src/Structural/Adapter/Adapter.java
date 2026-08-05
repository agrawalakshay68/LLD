package Structural.Adapter;

public class Adapter implements MediaPlayer {
    AdvancedPlayer player;

    public Adapter(AdvancedPlayer player){
        this.player = player;
    }

    @Override
    public void play(String filename) {
        player.playAdvanced(filename);
    }
}
