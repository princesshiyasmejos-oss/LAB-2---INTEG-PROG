public class RemoteApiSource implements MediaSource {
    private String url;
    public RemoteApiSource(String url) { this.url = url; }
    @Override public String getName() { return url; }
    @Override public String getStream() { return "remote-stream:" + url; }
}

