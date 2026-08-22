# RRB (RandomRoleBot)

A Discord bot for the **Collectif** community, built to run random-role "predictions" for UHC-style game events (All Stars, Black Clover, Manhwa, One Piece, Naruto) and to track each player's drop history through a personal profile command.

## Features

- **`/prediction`** — Launches a random role prediction for a chosen game mode. Each game mode (All Stars UHC, Black Clover UHC, Manhwa UHC, One Piece UHC, Naruto UHC) has its own set of roles, emoji, and accent color.
- **`/profile`** — Lets a user view their personal profile: overall ranking, most-drawn role, and number of times that role has been drawn, rendered as a Discord Components V2 message.
- **Persistent drop tracking** — Every role drawn is recorded in a local SQLite database (`bot.db`) so rankings and stats persist across restarts.
- **Slash command framework** — Commands are registered per guild using [Cloud Command Framework](https://github.com/Incendo/cloud) with the JDA6 integration.

## Tech Stack

- **Language:** Java 21
- **Build tool:** Gradle (Kotlin DSL)
- **Discord API:** [JDA](https://github.com/discord-jda/JDA) 6.5.0
- **Command framework:** [cloud-jda6](https://github.com/Incendo/cloud) 1.0.0-beta.4
- **Database:** SQLite via `sqlite-jdbc`
- **Logging:** Logback

## Project Structure

```
src/main/java/fr/rrb/bot/
├── Main.java                     # Entry point, reads DISCORD_TOKEN and boots the bot
├── Bot.java                      # JDA setup, command manager, guild command registration
├── command/
│   ├── CommandBuilder.java       # Interface implemented by every slash command
│   └── defaults/
│       ├── prediction/           # /prediction command, game modes, per-mode roles
│       └── profile/               # /profil command
├── database/
│   └── Database.java             # SQLite connection and schema bootstrap
├── drop/
│   ├── DropRepository.java       # Queries for drop stats, rankings, and profiles
│   ├── DropRequest.java          # SQL statements
│   └── DropStats.java
├── profile/
│   └── ProfileStats.java
└── util/
    ├── Constant.java             # Guild IDs, logger
    └── Placeholder.java          # Message templating helper
```

## Prerequisites

- JDK 21+
- A Discord bot application and token (see the [Discord Developer Portal](https://discord.com/developers/applications))

## Setup

1. Clone the repository.
2. Set the required environment variables:
```bash
   export DISCORD_TOKEN=your-bot-token-here
   export SERVER_GUILD_ID=your-server-guild-id
   export DEBUG_GUILD_ID=1your-debug-server-guild-id
```
   All three are read at startup; a missing or non-numeric value fails fast with an explicit error.
3. Run the bot:
```bash
   ./gradlew run
```

On startup, the bot connects to Discord, opens (or creates) the local `bot.db` SQLite database, and registers its slash commands on the configured guilds.

## Configuration

| Variable           | Description                            | Required |
|--------------------|----------------------------------------|----------|
| `DISCORD_TOKEN`    | The bot's Discord authentication token | Yes      |
| `SERVER_GUILD_ID`  | Guild ID of the production server      | Yes      |
| `DEBUG_GUILD_ID`   | Guild ID of the test server            | Yes      |

## Author

- [@Fayzeen](https://github.com/Fayzeen) on GitHub / `thefayz` on Discord
