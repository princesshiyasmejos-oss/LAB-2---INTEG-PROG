import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final String name;
    private final List<MediaSource> items = new ArrayList<>();
    public Playlist(String name) { this.name = name; }
    public String getName() { return name; }
    public void add(MediaSource m) { items.add(m); }
    public List<MediaSource> getItems() { return items; }
}
