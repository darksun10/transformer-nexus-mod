# Nexus Universe — Transformers / Kairos / Verticon Framework

A GitHub-ready Paper plugin starter for the Nexus Universe server.

## What this project is

A server-side framework designed to let a Transformers-inspired setting coexist with original Nexus Universe lore.

### Transformers layer
The architecture has dedicated support for:
- Cybertronian characters
- Autobots
- Decepticons
- Primes
- Energon
- Transformer factions
- Transformation states
- Future canonical-character integration

### Nexus Universe layer
Dedicated support for:
- Kairos
- Verticons
- Custom characters
- Custom factions
- Ranks
- Story events
- Kairos/Verticon relationships

## No client mod required for the framework

The first version is designed as a Paper server plugin. Players do not need to install a Forge/NeoForge mod just to use the basic framework.

Visual Transformer models and true client-side transformation animations are a later optional layer. The plugin can provide the server-side state, abilities and gameplay logic first.

## Requirements

- Paper 1.21.x
- Java 21
- Gradle 8.x

## Build

Run:

    gradle build

The resulting plugin JAR will be in:

    build/libs/

## Commands

- `/kairos`
- `/verticon create <name>`
- `/verticon list`
- `/verticon info <name>`
- `/verticon assign <player> <name>`

## Repository structure

    src/main/java/com/nexusuniverse/kairos/
    ├── abilities/
    ├── commands/
    ├── data/
    ├── events/
    ├── kairos/
    ├── lore/
    ├── transformations/
    └── transformers/

    src/main/resources/
    ├── plugin.yml
    ├── lore.yml
    └── factions.yml

    docs/
    ├── ARCHITECTURE.md
    ├── DEVELOPMENT_ROADMAP.md
    └── LORE_MODEL.md

## Important lore/IP note

This repository provides architecture for integrating Transformers concepts and your original Nexus Universe material. Do not redistribute copyrighted Transformers source text, artwork, models or proprietary assets without the appropriate rights.

The Nexus Universe-specific characters and lore can be authored independently.
