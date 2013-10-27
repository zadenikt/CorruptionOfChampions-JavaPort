package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.actors.Player;

public interface Scene {
	void displayText(Player me, Actor enemy); // me and enemy are null if not applicable
	Scene action(int button);
	// | 1 | 2 | 3 | 4 | 5 |
	// | 6 | 7 | 8 | 9 | 10|
}
