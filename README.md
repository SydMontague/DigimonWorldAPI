# Digimon World API

An in-memory API for Digimon World, run on emulator.

The current code isn't exactly nice and more or less a prototype/proof of concept. Refactoring will eventually take care of that. ;)

## Goal of the Project
By creating an abstraction layer on top of the emulated game, this project shall enable developers to create plugins and mods for the PS1 game "Digimon World".

The initial idea was to create a randomiser that can be used by speedrunners and casual players alike to create new experiences and challenges, 
by making knowledge of certain values useless and enabling the player to explore the game a bit like when they played it the first time.
And this idea will continue to be the leading focus of this project.

## Why an in-memory API/Tool?
The alternative would be an asset based (actually modifying the ROM) modding tool, but for me there is one reason against it:
Romsstar and Ze0nx (https://digimonworldre.wordpress.com/) are already working on such a tool and it would be quite a waste of time to develop 2 such tools in parallel.

So this project rather goes with another approach and tries to make things possible that are not possible with their tool.

## How does it work?
As any software, the game has to store it's stuff somewhere in the memory. As it happens it doesn't do so randomly but in a structured way,
allowing this tool to read, interpret and even modify them, effectively changing certain aspect of the game.
By closely observing the changes within the memory it's even possible to conclude what is happening in-game, allowing plugins/mods to react to it.


## Compatibility
To run the tool you need: 
* Windows
* Java 8
* ePSXe 1.9.0 (no other emulator or version will work!)

Support for more platforms is planned, but as of now I only support my local setup.
