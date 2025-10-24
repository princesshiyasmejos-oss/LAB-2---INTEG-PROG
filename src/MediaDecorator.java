public abstract class MediaDecorator extends MediaPlayer {
    protected final MediaPlayer inner;
    public MediaDecorator(MediaPlayer inner) { this.inner = inner; }
    @Override public void setRenderer(Renderer r) { inner.setRenderer(r); }
}
