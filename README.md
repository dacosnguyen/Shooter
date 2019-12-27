# Shooter - a modified version of angry birds game.

## How to start a game
The main class is located here: /src/main/java/cz/fit/dpo/mvcshooter/Shooter.java

There are 2 modes available:
- Simple mode
- Realistic mode

The realistic mode has gravity included and missiles follows trajectory (flight path) based on the force and angle of the cannon.

For *simple mode* add an argument *-s* or add nothing since this mode is a default game mode.
For *realistic mode* add an argument *-r*

## How to play
Pigs are appearing on the canvas and you have to kill them with your angry bird missiles.


- F1: shows controls
- F2: toggle single/double shooting mode
- F11: save game snapshot
- F12: load game snapshot
- HOME / END: gravity up/down
- arrows UP/DOWN: cannon vertical movement
- arrows LEFT/RIGHT: cannon force
- PAGE UP / PAGE DOWN: cannon angle
- SPACE: shoot