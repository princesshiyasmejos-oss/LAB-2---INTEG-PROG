public class WatermarkDecorator extends MediaDecorator {
    public WatermarkDecorator(MediaPlayer inner) { super(inner); }

    @Override
    public void play(MediaSource source) {
        System.out.println("[WatermarkDecorator] adding watermark to " + source.getName());
        inner.play(source);
    }

    @Override
    public void play(Playlist playlist) {
        System.out.println("[WatermarkDecorator] adding watermark to playlist " + playlist.getName());
        inner.play(playlist);
    }
}

