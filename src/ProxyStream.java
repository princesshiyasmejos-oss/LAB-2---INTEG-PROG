import java.util.HashMap;
import java.util.Map;

public class ProxyStream implements MediaSource {
    private final MediaSource upstream;
    private static final Map<String, String> cache = new HashMap<>();

    public ProxyStream(MediaSource upstream) { this.upstream = upstream; }

    @Override public String getName() { return upstream.getName(); }

    @Override public String getStream() {
        String key = upstream.getName();
        if (cache.containsKey(key)) {
            System.out.println("[ProxyStream] returning cached for " + key);
            return cache.get(key);
        } else {
            System.out.println("[ProxyStream] fetching and caching " + key);
            String s = upstream.getStream();
            cache.put(key, s);
            return s;
        }
    }
}

