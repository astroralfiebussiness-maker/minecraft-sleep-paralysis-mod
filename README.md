# Sleep Paralysis Mod

A terrifying Minecraft mod for Forge 1.21.1 that adds a horror element to sleeping.

## Features

- **Nightly Paralysis**: Every time you wake up from sleep, you are paralyzed and unable to move
- **Progressive Duration**: The first night you're paralyzed for 5 seconds, each subsequent night adds 1 second
- **Distorted Audio**: Hear creepy cave sounds with distortion while paralyzed
- **No Escape**: There is no way to break free from the paralysis - you must wait it out

## Installation

1. Download the latest JAR file from the releases
2. Place it in your Minecraft `mods` folder
3. Ensure you have Forge 52.0.0+ installed for Minecraft 1.21.1
4. Launch Minecraft and enjoy the nightmare

## How It Works

When you sleep and wake up:
1. You immediately become paralyzed
2. You cannot move or interact with the world
3. Distorted cave sounds play around you
4. After the duration expires, you regain control
5. The next night, the paralysis will last 1 second longer

### Duration Chart
- Night 1: 5 seconds
- Night 2: 6 seconds
- Night 3: 7 seconds
- And so on...

## Building

```bash
./gradlew build
```

The built JAR will be in `build/libs/`

## License

MIT License

## Author

astroralfiebussiness-maker
