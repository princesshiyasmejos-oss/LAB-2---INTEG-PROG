public class MediaPlayer {
    private Renderer renderer;
    public void setRenderer(Renderer r) { this.renderer = r; }

    public void play(MediaSource source) {
        System.out.println("[MediaPlayer] play() called for " + source.getName());
        String stream = source.getStream();
        if (renderer == null) {
            System.out.println("[MediaPlayer] No renderer set. Use setRenderer().");
        } else {
            renderer.render(stream);
        }
    }

    // convenience to support Playlist
    public void play(Playlist playlist) {
        System.out.println("[MediaPlayer] Playing playlist: " + playlist.getName());
        for (MediaSource item : playlist.getItems()) {
            play(item);
        }
    }
}
