# Architecture

`lore` separates TRANSFORMERS and NEXUS data.

`transformer` contains Cybertronian character and transformation state models.

`faction` manages Autobots, Decepticons, Verticons and future custom factions.

`kairos` is a dedicated service layer for the Nexus overseer.

`data` persists custom characters to YAML.

`command` exposes admin-facing controls.

Future modules can add Energon, abilities, quests, story events, ranks, player assignment, SQLite/MySQL and optional model/resource-pack integrations without replacing the core.
