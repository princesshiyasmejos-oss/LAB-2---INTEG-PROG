public class SoftwareRenderer implements Renderer {
    @Override
    public void render(String stream) {
        System.out.println("[SoftwareRenderer] rendering: " + stream);
    }
}
