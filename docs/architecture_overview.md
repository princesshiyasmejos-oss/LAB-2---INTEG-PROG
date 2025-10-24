# Architecture Overview

The Modular Media Player is organized using several structural design patterns.

- **Facade Pattern** provides a unified interface (`MediaPlayer`) to different media subsystems.
- **Adapter Pattern** converts different media sources (local, HLS, remote API) into a common interface.
- **Composite Pattern** allows playlists to contain both media files and other playlists.
- **Decorator Pattern** enables adding features like subtitles, equalizers, and watermarking dynamically.
- **Strategy Pattern** allows runtime switching between hardware and software rendering.
- **Proxy Pattern** caches remote streams to improve performance.