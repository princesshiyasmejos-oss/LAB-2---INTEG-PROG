**Design Rationales**

Overview
This project changes a simple media player into a modular media streaming app. The goal is to make it support different media sources, add features like subtitles or watermark, and switch between different renderers. I used different structural design patterns to make the code easier to understand, reuse, and update.

1. **Adapter Pattern – For Media Sources**
The adapter pattern lets the media player work with many kinds of media sources (like local files, live streams, or online APIs).
Each source has its own way of working, so I made separate adapters for each.
The player talks to all of them through one common interface called ***MediaSourceAdapter***.

WHY: So I can add new types of media sources in the future without changing the main code

2. **Composite Pattern – For Playlists**
The composite pattern allows the app to treat both single media files and playlists in the same way.
I made a base interface called ***MediaComponent***.
Then, ***MediaFile*** is a single file, and ***Playlist*** can hold many media files or even other playlists.
sb
WHY: So the player can just call ***play()*** on anything — file or playlist — and it works the same way.

3. **Decorator Pattern – For Extra Features**
The decorator pattern is used for adding features while the app is running, like subtitles, watermark, or an equalizer.
Each feature is a “decorator” that wraps around the media file and adds new behavior.

WHY: So users can turn features on or off without changing the main player’s code.

4. **Strategy Pattern – For Renderer Switching**
The strategy pattern lets the app switch between different rendering methods — like hardware or software rendering.
There’s a ***RendererStrategy*** interface, and two classes implement it: ***HardwareRenderer*** and SoftwareRenderer.
The player can switch between them anytime.

WHY: So the app can run smoothly on different devices or situations.

5. **Proxy Pattern – For Stream Caching**
The proxy pattern helps improve loading speed.
It uses a ***ProxyStream*** class that checks if a stream is already saved (cached).
If yes, it loads from the cache instead of downloading again.

WHY: To save data and make playback 

6. **Facade Pattern – For Simpler Control**
The main ***MediaPlayer*** acts as a facade that hides the complex parts of the system.
Instead of calling many classes, the user only needs to use the MediaPlayer to control playback, decorators, playlists, and renderers.

WHY: So the system is easier to use and understand.

7. **Trade-offs and Future Plans**
Using many design patterns makes the project flexible but also adds more classes.
This means the program uses more memory and might be a little slower.
If I had more time, I would add background loading for smoother playback and better testing for each pattern.

**Conclusion**
Using structural design patterns helped make the media player modular and flexible.
It is now easier to add new features, fix bugs, or change how the player works without breaking other parts of the code.