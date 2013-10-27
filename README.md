CorruptionOfChampions
=====================

Fenoxo's Corruption Of Champions, ported to Java.

Authors
-------

 * Original game created by [Fenoxo](www.fenoxo.com)
 * Port written by [zadenikt](https://github.com/zadenikt)
 * UI Code written by [fagtron](https://github.com/fagtron)

If you want to help with code, make a fork and send a pull request.  
If you want to help with design decisions, [the GitHub wiki has a page for that](https://github.com/zadenikt/CorruptionOfChampions/wiki/Design-Decisions-Discussion).

TODOs
-----

 * Piercings.
 * Add an `InventoryFullScene.java` file for when you try to pick up an item, while also having a full inventory.
 * Followers.

### Actor.java ###

 * `raceScore()` functions:
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
