// ----- Adapter: different media sources -----
class LocalFile {
  play() { console.log("🎵 Playing from local file..."); }
}

class HLSStream {
  play() { console.log("🌐 Playing from HLS stream..."); }
}

class RemoteAPI {
  play() { console.log("☁️ Playing from remote API..."); }
}

// ----- Composite: playlists -----
class Playlist {
  constructor(name) { this.name = name; this.items = []; }
  add(item) { this.items.push(item); }
  play() {
    console.log(`▶️ Playlist: ${this.name}`);
    this.items.forEach(item => item.play());
  }
}

// ----- Decorator: add features like watermark -----
class WatermarkDecorator {
  constructor(player) { this.player = player; }
  play(media) {
    console.log("💧 Adding watermark...");
    this.player.play(media);
  }
}

// ----- Strategy: switch renderers -----
class SoftwareRenderer {
  render() { console.log("🧠 Rendering with Software Renderer..."); }
}

class HardwareRenderer {
  render() { console.log("⚙️ Rendering with Hardware Renderer..."); }
}

// ----- Proxy: cache remote streams -----
class ProxyStream {
  constructor(realStream) {
    this.realStream = realStream;
    this.cached = false;
  }
  play() {
    if (this.cached) {
      console.log("📀 Playing from cache...");
    } else {
      console.log("⬇️ Downloading and caching...");
      this.cached = true;
      this.realStream.play();
    }
  }
}

// ----- Facade: simple controller for everything -----
class PlayerFacade {
  constructor(renderer) { this.renderer = renderer; }
  setRenderer(renderer) { this.renderer = renderer; }
  play(media) {
    this.renderer.render();
    media.play();
  }
}

// ============================
// 🎬 DEMO STARTS HERE
// ============================

// Create sources
let song1 = new LocalFile();
let liveStream = new HLSStream();
let apiStream = new RemoteAPI();

// Use a Proxy for caching
let cachedAPI = new ProxyStream(apiStream);

// Create playlist (Composite)
let myPlaylist = new Playlist("My Favorites");
myPlaylist.add(song1);
myPlaylist.add(liveStream);
myPlaylist.add(cachedAPI);

// Choose a renderer (Strategy)
let software = new SoftwareRenderer();
let player = new PlayerFacade(software);

// Add decorator (extra feature)
let fancyPlayer = new WatermarkDecorator(player);

// Play!
fancyPlayer.play(myPlaylist);

// Try caching (second time)
console.log("\n🔁 Playing again (cache should work):");
fancyPlayer.play(myPlaylist);

// Switch renderer at runtime
console.log("\n🔄 Switching to hardware renderer...");
player.setRenderer(new HardwareRenderer());
fancyPlayer.play(myPlaylist);
