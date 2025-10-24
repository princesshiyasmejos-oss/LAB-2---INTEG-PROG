public class HardwareRenderer implements Renderer {
    @Override
    public void render(String stream) {
        System.out.println("[HardwareRenderer] rendering: " + stream);
    }
}