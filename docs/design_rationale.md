# Design Rationale

This refactoring applied several structural design patterns to create a flexible and modular media player.

1. **Adapter Pattern**
   - Used to unify different media sources (local file, HLS stream, API) into a single interface.
   - This removes duplicated adaptation code and simplifies adding new sources.

2. **Decorator Pattern**
   - Enables runtime feature plugins such as subtitles, equalizer, and watermark.
   - This avoids hard-coding extra features into the core player.

3. **Composite Pattern**
   - Used for playlists that can include both single media files and nested playlists.
   - Provides simple recursive play logic.

4. **Strategy Pattern**
   - Allows runtime switching between software and hardware rendering.
   - Makes the system more flexible for different devices.

5. **Proxy Pattern**
   - Used for remote caching to reduce streaming latency.
   - Adds transparency — client code doesn’t change.

6. **Facade Pattern**
   - Provides a simplified interface to complex subsystems.
   - Makes the system easier to use for end users and developers.

This modular design improves extensibility, readability, and maintainability.