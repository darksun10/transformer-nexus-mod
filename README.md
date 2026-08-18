# Nexus Universe — Transformers / Kairos / Verticon

GitHub-ready Paper plugin foundation for Nexus Universe.

The architecture separates:
- TRANSFORMERS: Cybertronians, Autobots, Decepticons, Primes, Energon and transformation hooks.
- NEXUS: Kairos, Verticons, custom characters, custom factions and story events.

Requirements: Paper 1.21.x, Java 21, Gradle 8.x.

Build with `gradle build`; copy the resulting JAR from `build/libs/` to the server `plugins/` folder.

Commands:
`/kairos`
`/transformer create <name>`
`/transformer info <name>`
`/transformer transform <name>`
`/faction list`
`/verticon create <name>`
`/verticon list`
`/verticon info <name>`

High-fidelity Transformer models/animations require client assets, so this project provides server-side transformation hooks first and leaves clean integration points for future resource-pack/model systems.
