# Modular Media Streaming Suite

### 👩‍💻 Author
Princess Hiyas Mejos

### 🧩 Overview
A refactored media player system that supports multiple media sources, decorators, playlists, and runtime rendering.

### 🏗️ Features
- Multiple media sources (local, HLS, API)
- Decorator support (subtitle, watermark, equalizer)
- Composite playlists (playlists within playlists)
- Renderer switching (hardware/software)
- Proxy caching for remote streams

### 🧠 Design Patterns Used
- **Adapter** – for handling different media sources  
- **Decorator** – for adding features like watermark or subtitles  
- **Composite** – for nested playlists  
- **Strategy** – for renderer switching  
- **Proxy** – for caching remote streams  

### ▶️ Run Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/princesshiyasmejos-oss/LAB-2---INTEG-PROG.git