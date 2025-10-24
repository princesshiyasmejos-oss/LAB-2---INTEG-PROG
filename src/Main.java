public class Main {
    public static void main(String[] args) {
        Renderer hardware = new HardwareRenderer();
        Renderer software = new SoftwareRenderer();

        MediaPlayer player = new MediaPlayer();
        player.setRenderer(hardware);

        MediaSource local = new LocalFileSource("song.mp3");
        player.play(local);

        System.out.println();

        player.setRenderer(software);
        player.play(local);

        System.out.println();

        MediaPlayer decoratedPlayer = new WatermarkDecorator(player);
        decoratedPlayer.play(local);

        System.out.println();

        MediaSource remote = new ProxyStream(new RemoteApiSource("https://example.com/stream"));
        decoratedPlayer.play(remote);

        System.out.println();

        Playlist playlist = new Playlist("My Favorites");
        playlist.add(local);
        playlist.add(remote);
        player.play(playlist);
    }
}