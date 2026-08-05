package Structural.Adapter;

public class Main {
    static void main() {
        // legacy player
        MediaPlayer legacyPlayer = new LegacyPlayer();
        legacyPlayer.play("sample.mp3");

        // new advanced players
        AdvancedPlayer mp4Player = new Mp4Player();
        AdvancedPlayer vlcPlayer = new VlcPlayer();

        // we need adapters
        MediaPlayer mp4Adapter = new Adapter(mp4Player);
        MediaPlayer vlcAdapter = new Adapter(vlcPlayer);

        mp4Adapter.play("sample.mp4");
        vlcAdapter.play("sample.vlc");
    }
}
