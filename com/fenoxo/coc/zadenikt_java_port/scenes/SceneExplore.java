package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.Game;
import com.fenoxo.coc.zadenikt_java_port.actors.Actor;
import com.fenoxo.coc.zadenikt_java_port.actors.Player;

public class SceneExplore implements Scene {
    public void displayText(Player me, Actor enemy) {
        Game.getUI().clear();
        if(me.getNumberOfTimesExplored() == 0) {
            Game.getUI().write("You tentatively step away from your campsite, alert and scanning the ground and sky for danger.  You walk for the better part of an hour, marking the rocks you pass for a return trip to your camp.  It worries you that the portal has an opening on this side, and it was totally unguarded...\n\n...Wait a second, why is your campsite in front of you? The portal's glow is clearly visible from inside the tall rock formation.   Looking carefully you see your footprints leaving the opposite side of your camp, then disappearing.  You look back the way you came and see your markings vanish before your eyes.  The implications boggle your mind as you do your best to mull over them.  Distance, direction, and geography seem to have little meaning here, yet your campsite remains exactly as you left it.  A few things click into place as you realize you found your way back just as you were mentally picturing the portal!  Perhaps memory influences travel here, just like time, distance, and speed would in the real world!\n\nThis won't help at all with finding new places, but at least you can get back to camp quickly.  You are determined to stay focused the next time you explore and learn how to traverse this gods-forsaken realm.");
            Game.getUI().setButton(1, "Next");
            me.increaseNumberOfTimesExplored();
        } else if(me.getNumberOfTimesExplored() == 1) {
            Game.getUI().write("You walk for quite some time, roaming the hard-packed and pink-tinged earth of the demon-realm.  Rust-red rocks speckle the wasteland, as barren and lifeless as anywhere else you've been.  A cool breeze suddenly brushes against your face, as if gracing you with its presence.  You turn towards it and are confronted by the lush foliage of a very old looking forest.  You smile as the plants look fairly familiar and non-threatening.  Unbidden, you remember your decision to test the properties of this place, and think of your campsite as you walk forward.  Reality seems to shift and blur, making you dizzy, but after a few minutes you're back, and sure you'll be able to return to the forest with similar speed.\n\n<b>You have discovered the Forest!</b>");
            Game.getUI().setButton(1, "Next");
            me.increaseNumberOfTimesExplored();
        } else {
            Game.getUI().write("You can continue to search for new locations, or explore your previously discovered locations.");
            Game.getUI().setButton(1, "Explore");
            if(me.canExplorePlace(Location.DESERT       )) Game.getUI().setButton(2, "Desert");
            if(me.canExplorePlace(Location.FOREST       )) Game.getUI().setButton(3, "Desert");
            if(me.canExplorePlace(Location.LAKE         )) Game.getUI().setButton(4, "Desert");
            if(me.canExplorePlace(Location.MOUNTAIN     )) Game.getUI().setButton(5, "Desert");
            if(me.canExplorePlace(Location.PLAINS       )) Game.getUI().setButton(6, "Desert");
            if(me.canExplorePlace(Location.SWAMP        )) Game.getUI().setButton(7, "Desert");
            if(me.canExplorePlace(Location.DEEP_WOODS   )) Game.getUI().setButton(8, "Desert");
            if(me.canExplorePlace(Location.HIGH_MOUNTAIN)) Game.getUI().setButton(9, "Desert");
            Game.getUI().setButton(10, "Back");
        }
    }
    public Scene action(Player me, Actor enemy, int button) {
        //TODO
        return null;
    }
}
