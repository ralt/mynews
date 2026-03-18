# MyNews

A personal news aggregator Android app. Open it, skim titles from mixed sources, tap to read in the browser. That's it.

**This app is entirely vibe-coded** — built through conversational iteration with an AI, with zero manual code editing. It's very specific to my needs (a mix of tech, world, French, local south-of-France, and financial news). Your mileage may vary.

## Sources

| Tab | Sources |
|-----|---------|
| Tech | Hacker News, r/programming, Ars Technica, LWN.net |
| World | BBC World, r/worldnews, Reuters, Al Jazeera |
| Finance | Les Echos, CNBC, MarketWatch |
| France | Le Monde, France Info, France Bleu Vaucluse, Google News (Orange/Mornas) |

## Features

- Swipeable tabs per category
- Pull-to-refresh
- Round-robin sorting by source so no single feed dominates
- Room database cache for instant cold starts
- Tap any article to open in the browser
- Material3 with dynamic colors and dark mode support

## Building

Requires Android SDK and JDK 21.

```bash
export ANDROID_HOME=/path/to/Android/Sdk
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

## Suggestions welcome

Happy to take suggestions on news sources, UI tweaks, or whatever else. Open an issue or a PR.

## License

MIT
