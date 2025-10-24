// Simple Media Player Demo using Structural Patterns

import java.util.ArrayList;
import java.util.List;

// Strategy Pattern: Renderer
interface Renderer {
    void render(String data);
}

class HardwareRenderer implements Renderer {
    public void render(String data) {
        System.out.println("[Hardware Renderer] Rendering: " + data);
    }
}

class SoftwareRenderer implements Renderer {
    public void render(String data) {
        System.out.println("[Software Renderer] Rendering: " + data);
    }
}

// Basic Media Source
interface MediaSource {
    String getSource();
}

// Different Media Types
class LocalFileSource implements MediaSource {
    private String filename;
    public LocalFileSource(String filename) {
        this.filename = filename;
    }
    public String getSource() {
        return "Local file: " + filename;
    }
}

class RemoteApiSource implements MediaSource {
    private String url;
    public RemoteApiSource(String url) {
        this.url = url;
    }
    public String getSource() {
        return "Remote stream: " + url;
    }
}

// Proxy Pattern (for caching)
class ProxyStream implements MediaSource {
    private RemoteApiSource remote;
    public ProxyStream(RemoteApiSource remote) {
        this.remote = remote;
    }
    public String getSource() {
        System.out.println("[Proxy Stream] Checking cache...");
        return remote.getSource() + " (cached)";
    }
}

// Base Media Player
class MediaPlayer {
    private Renderer renderer;

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void play(MediaSource source) {
        System.out.println("[MediaPlayer] Playing " + source.getSource());
        renderer.render(source.getSource());
    }
}

// Decorator Pattern (Watermark)
class MediaDecorator extends MediaPlayer {
    protected MediaPlayer player;
    public MediaDecorator(MediaPlayer player) {
        this.player = player;
    }
    public void play(MediaSource source) {
        player.play(source);
    }
}

class WatermarkDecorator extends MediaDecorator {
    public WatermarkDecorator(MediaPlayer player) {
        super(player);
    }
    public void play(MediaSource source) {
        System.out.println("[Decorator] Adding watermark...");
        super.play(source);
    }
}

// Composite Pattern (Playlist)
class Playlist implements MediaSource {
    private String name;
    private List<MediaSource> items = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public void add(MediaSource item) {
        items.add(item);
    }

    public String getSource() {
        return "Playlist: " + name;
    }

    public List<MediaSource> getItems() {
        return items;
    }
}

// ============================
// MAIN PROGRAM
// ============================
public class Main {
    public static void main(String[] args) {
        Renderer hardware = new HardwareRenderer();
        Renderer software = new SoftwareRenderer();

        MediaPlayer player = new MediaPlayer();
        player.setRenderer(hardware);

        MediaSource local = new LocalFileSource("song.mp3");
        player.play(local);

        player.setRenderer(software);
        player.play(local);

        MediaPlayer decorated = new WatermarkDecorator(player);
        decorated.play(local);

        MediaSource remote = new ProxyStream(new RemoteApiSource("https://example.com/stream"));
        decorated.play(remote);

        Playlist playlist = new Playlist("My Favorites");
        playlist.add(local);
        playlist.add(remote);
        decorated.play(playlist);
    }
}
