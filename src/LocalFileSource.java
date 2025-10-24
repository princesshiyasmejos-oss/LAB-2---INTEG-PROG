public class LocalFileSource implements MediaSource {
    private String name;
    public LocalFileSource(String name) { this.name = name; }
    @Override public String getName() { return name; }
    @Override public String getStream() { return "local-stream:" + name; }
}

