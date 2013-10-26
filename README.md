CorruptionOfChampions
=====================

Fenoxo's Corruption Of Champions, ported to Java.

Authors
-------

 * Original game created by Fenoxo
 * Port written by Zadenikt

TODOs
-----

 * Piercings.
 * Add an `InventoryFullScene.java` file for when you try to pick up an item, while also having a full inventory.

### Actor.java ###

 * `raceScore()` functions:
  * `dragonScore()`
  * `goblinScore()`
  * `gooScore()`
  * `nagaScore()`
  * `rabbitScore()`
  * `harpyScore()`
  * `kangarooScore()`
  * `sharkScore()`
 * Make all currently `public` variables `protected`, and add getters/setters.
 * Look for Gills. They may or may not exist, and may or may not have an effect. There are references to them in the ActionScript, however.
 * Verify `getXPToLevelUpTease()` formula. It be gnarly.
### Perk.java ###

 * Add all the perks. Yeah, I'm too lazy. [Wiki](http://corruptionofchampions.wikispaces.com/Perks).

### ChampionsApplet.java ###

 * The part where stuff shows up. Yeah... I'm used to writing backends, so it'd likely be for the best if somebody else could help with the GUI.
