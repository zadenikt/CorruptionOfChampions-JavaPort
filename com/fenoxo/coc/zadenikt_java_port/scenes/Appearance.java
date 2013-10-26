package com.fenoxo.coc.zadenikt_java_port.scenes;

import com.fenoxo.coc.zadenikt_java_port.Actor;
import com.fenoxo.coc.zadenikt_java_port.ChampionsApplet;
import com.fenoxo.coc.zadenikt_java_port.Game;
import com.fenoxo.coc.zadenikt_java_port.Player;
import com.fenoxo.coc.zadenikt_java_port.characteristics.Race;

public class Appearance implements Scene {
	public void displayText(Player me, Actor enemy) {
		Game.getUI().clear();
		//Race
		if(Race.getRace(me) != Race.HUMAN) Game.getUI().write("You began your journey as a human, but gave that up as you explored the dangers of this realm. ");
		//Height
		Game.getUI().write("You are a " + (me.height/12) + " foot " + (me.height%12) + " inch tall " + Race.get(me) + ", with " + me.describeBodyType() + ". ");
		//Equipment
		Game.getUI().write("<b>You are currently wearing your " + me.getArmour().name + " and using your " + me.getWeapon().name + " as a weapon.</b> ");
		//Faces
		switch(me.face) {
		case FOX:
			Game.getUI().write("You have a tapered, shrewd-looking vulpine face with a speckling of downward-curved whiskers just behind the nose. ");
			switch(me.skin.getType()) {
			case NORMAL:
			default:
				Game.getUI().write("Oddly enough, there's no fur on your animalistic muzzle, just " + me.skin.describe() + ". ");
				break;
			case FUR:
				Game.getUI().write("A coat of " + me.skin.describe() + " decorates your muzzle. ");
				break;
			case SCALES:
				Game.getUI().write("Strangely, " + me.skin.describe() + " adorn every inch of your animalistic visage. ");
				break;
			}
			break;
		}
		/*if(me.faceType == 0 || me.faceType == 4 || me.faceType == 8 || me.faceType == 10) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  Your face is human in shape and structure, with " + me.skin() + ".", false);
			if(me.skinType == 1) applet.write("  Under your " + me.skinFurScales() + " you have a human-shaped head with " + me.skin(true,false) + ".", false);
			if(me.skinType == 2) applet.write("  Your face is fairly human in shape, but is covered in " + me.skin() + ".", false);
			if(me.faceType == 4) applet.write("  A set of razor-sharp, retractable shark-teeth fill your mouth and gives your visage a slightly angular appearance.", false);
			else if(me.faceType == 8) applet.write("  The constant twitches of your nose and the length of your incisors gives your visage a hint of bunny-like cuteness.", false);
			else if(me.faceType == 10) applet.write("  A set of retractable, needle-like fangs sit in place of your canines and are ready to dispense their venom.", false);
		}
		//Naga
		if(me.faceType == 5) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  You have a fairly normal face, with " + me.skin() + ".  The only oddity is your pair of dripping fangs which often hang over your lower lip.", false);
			if(me.skinType == 1) applet.write("  Under your " + me.skinFurScales() + " you have a human-shaped head with " + me.skin(true,false) + ".  In addition, a pair of fangs hang over your lower lip, dripping with venom.", false);
			if(me.skinType == 2) applet.write("  Your face is fairly human in shape, but is covered in " + me.skinFurScales() + ".  In addition, a pair of fangs hang over your lower lip, dripping with venom.", false);
		}
		//horse-face
		if(me.faceType == 1) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  Your face is equine in shape and structure.  The odd visage is hairless and covered with " + me.skinFurScales() + ".", false);
			if(me.skinType == 1) applet.write("  Your face is almost entirely equine in appearance, even having " + me.skinFurScales() + ".  Underneath the fur, you believe you have " + me.skin(true,false) + ".", false);
			if(me.skinType == 2) applet.write("  You have the face and head structure of a horse, overlaid with glittering " + me.skinFurScales() + ".", false);
		}
		//dog-face
		if(me.faceType == 2) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  You have a dog-like face, complete with a wet nose.  The odd visage is hairless and covered with " + me.skinFurScales() + ".", false);
			if(me.skinType == 1) applet.write("  You have a dog's face, complete with wet nose and panting tongue.  You've got " + me.skinFurScales() + ", hiding your " + me.skin(true,false) + " underneath your furry visage.", false);
			if(me.skinType == 2) applet.write("  You have the facial structure of a dog, wet nose and all, but overlaid with glittering " + me.skinFurScales() + ".", false);
		}
		//cat-face
		if(me.faceType == 6) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  You have a cat-like face, complete with a cute, moist nose, whiskers, and slitted eyes.  The furry visage conceals what you assume to be " + me.skin() + ".", false);
			if(me.skinType == 1) applet.write("  You have a cat-like face, complete with moist nose, whiskers, and slitted eyes.  Your " + me.skinDesc + " is " + me.hairColor + ", hiding your " + me.skin(true,false) + " underneath.", false);
			if(me.skinType == 2) applet.write("  Your facial structure blends humanoid features with those of a cat.  A moist nose, whiskers, and slitted eyes are included, but overlaid with glittering " + me.skinFurScales() + ".", false);
		}
		//Minotaaaauuuur-face
		if(me.faceType == 3) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  You have a face resembling that of a minotaur, with cow-like features, particularly a squared off wet nose.  Despite your lack of fur elsewhere, your visage does have a short layer of " + me.hairColor + " fuzz.", false);
			if(me.skinType == 1) applet.write("  You have a face resembling that of a minotaur, with cow-like features, particularly a squared off wet nose.  Your " + me.skinFurScales() + " thickens noticably on your head, looking shaggy and more than a little monstrous once laid over your visage.", false);
			if(me.skinType == 2) applet.write("  Your face resembles a minotaur's, though strangely it is covered in shimmering scales, right up to the flat cow-like nose that protrudes from your face.", false);
		}
		//Lizard-face
		if(me.faceType == 7) {
			if(me.skinType == 0 || me.skinType == 3) applet.write("  You have a face resembling that of a lizard, and with your toothy maw, you have quite a fearsome visage.  The reptilian visage does look a little odd with just " + me.skin() + ".", false);
			if(me.skinType == 1) applet.write("  You have a face resembling that of a lizard.  Between the toothy maw, pointed snout, and the layer of " + me.skinFurScales() + " covering your face, you have quite the fearsome visage.", false);
			if(me.skinType == 2) applet.write("  Your face is that of a lizard, complete with a toothy maw and pointed snout.  Reflective " + me.skinFurScales() + " complete the look, making you look quite fearsome.", false);
		}
		if(me.faceType == 12) {
			applet.write("  Your face is a narrow, reptilian muzzle.  It looks like a predatory lizard's, at first glance, but with an unusual array of spikes along the under-jaw.  It gives you a regal but fierce visage.  Opening your mouth reveals several rows of dagger-like sharp teeth.  The fearsome visage is decorated by " + me.skinFurScales() + ".");
		}
		if(me.faceType == 9) {
			applet.write("  Your face is ", false);
			if(me.skinType == 0) applet.write("bald", false);
			else applet.write("covered with " + me.skinFurScales(), false);
			applet.write(" and shaped like that of a kangaroo, somewhat rabbit-like except for the extreme length of your odd visage.", false);
		}
		//M/F stuff!
		applet.write("  It has " + me.faceDesc() + ".", false);
		//Eyes
		if(me.eyeType == 1) applet.write("  In addition to your primary two eyes, you have a second, smaller pair on your forehead.", false);
		else if(me.eyeType == 2) applet.write("  Your eyes are solid spheres of inky, alien darkness.");

		//Hair
		//if bald
		if(me.hairLength == 0) {
			if(me.skinType == 1) applet.write("  You have no hair, only a thin layer of fur atop of your head.  ", false);
			else applet.write("  You are totally bald, showing only shiny " + me.skinTone + " " + me.skinDesc + " where your hair should be.", false);
			if(me.earType == 1) applet.write("  A pair of horse-like ears rise up from the top of your head.", false);
			else if(me.earType == 2) applet.write("  A pair of dog ears protrude from your skull, flopping down adorably.", false);
			else if(me.earType == 3) applet.write("  A pair of round, floppy cow ears protrude from the sides of your skull.", false);
			else if(me.earType == 4) applet.write("  A pair of large pointy ears stick out from your skull.", false);
			else if(me.earType == 5) applet.write("  A pair of cute, fuzzy cat ears have sprouted from the top of your head.", false);
			else if(me.earType == 6) applet.write("  A pair of rounded protrusions with small holes on the sides of your head serve as your ears.", false);
			else if(me.earType == 7) applet.write("  A pair of floppy rabbit ears stick up from the top of your head, flopping around as you walk.", false);
			else if(me.earType == 9) applet.write("  A pair of large, adept fox ears sit high on your head, always listening.");
			else if(me.earType == 10) applet.write("  A pair of rounded protrusions with small holes on the sides of your head serve as your ears.  Bony fins sprout behind them.", false);
			if(me.antennae == 2) applet.write("  Floppy antennae also appear on your skull, bouncing and swaying in the breeze.", false);
		}
		//not bald
		else {
			if(me.earType == 0) applet.write("  Your " + hairDescript() + " looks good on you, accentuating your features well.", false);
			else if(me.earType == 1) applet.write("  The " + hairDescript() + " on your head parts around a pair of very horse-like ears that grow up from your head.", false);
			else if(me.earType == 2) applet.write("  The " + hairDescript() + " on your head is overlapped by a pair of pointed dog ears.", false);
			else if(me.earType == 3) applet.write("  The " + hairDescript() + " on your head is parted by a pair of rounded cow ears that stick out sideways.", false);
			else if(me.earType == 4) applet.write("  The " + hairDescript() + " on your head is parted by a pair of cute pointed ears, bigger than your old human ones.", false);
			else if(me.earType == 5) applet.write("  The " + hairDescript() + " on your head is parted by a pair of cute, fuzzy cat ears, sprouting from atop your head and pivoting towards any sudden noises.", false);
			else if(me.earType == 6) applet.write("  The " + hairDescript() + " atop your head makes it nigh-impossible to notice the two small rounded openings that are your ears.", false);
			else if(me.earType == 7) applet.write("  A pair of floppy rabbit ears stick up out of your " + hairDescript() + ", bouncing around as you walk.", false);
			else if(me.earType == 8) applet.write("  The " + hairDescript() + " atop your head is parted by a pair of long, furred kangaroo ears that stick out at an angle.", false);
			else if(me.earType == 9) applet.write("  The " + hairDescript() + " atop your head is parted by a pair of large, adept fox ears that always seem to be listening.");
			else if(me.earType == 10) applet.write("  The " + hairDescript() + " atop your head is parted by a pair of rounded protrusions with small holes on the sides of your head serve as your ears.  Bony fins sprout behind them.", false);
			if(me.antennae == 2) {
				if(me.earType == 7) applet.write("  Limp antennae also grow from just behind your hairline, waving and swaying in the breeze with your ears.", false);
				else applet.write("  Floppy antennae also grow from just behind your hairline, bouncing and swaying in the breeze.", false);
			}
		}
		//Tongue
		if(me.tongueType == 1) applet.write("  A snake-like tongue occasionally flits between your lips, tasting the air.", false);
		else if(me.tongueType == 2) applet.write("  A slowly undulating tongue occasionally slips from between your lips.  It hangs nearly two feet long when you let the whole thing slide out, though you can retract it to appear normal.", false);
		else if(me.tongueType == 3) applet.write("  Your mouth contains a thick, fleshy tongue that, if you so desire, can telescope to a distance of about four feet.  It has sufficient manual dexterity that you can use it almost like a third arm.");

		//Horns
		//Demonic horns
		if(me.hornType == 1) {
			if(me.horns == 2) applet.write("  A small pair of pointed horns has broken through the " + me.skinDesc + " on your forehead, proclaiming some demonic taint to any who see them.", false);
			if(me.horns == 4) applet.write("  A quartet of prominent horns has broken through your " + me.skinDesc + ".  The back pair are longer, and curve back along your head.  The front pair protrude forward demonically.", false);
			if(me.horns == 6) applet.write("  Six horns have sprouted through your " + me.skinDesc + ", the back two pairs curve backwards over your head and down towards your neck, while the front two horns stand almost eight inches long upwards and a little forward.", false);
			if(me.horns >= 8) applet.write("  A large number of thick demonic horns sprout through your " + me.skinDesc + ", each pair sprouting behind the ones before.  The front jut forwards nearly ten inches while the rest curve back over your head, some of the points ending just below your ears.  You estimate you have a total of " + num2Text(me.horns) + " horns.", false);	
		}
		//Minotaur horns
		if(me.hornType == 2) {
			if(me.horns < 3) applet.write("  Two tiny horn-like nubs protrude from your forehead, resembling the horns of the young livestock kept by your village.", false);
			if(me.horns >= 3 && me.horns < 6) applet.write("  Two moderately sized horns grow from your forehead, similar in size to those on a young bovine.", false);
			if(me.horns >= 6 && me.horns < 12) applet.write("  Two large horns sprout from your forehead, curving forwards like those of a bull.", false);
			if(me.horns >= 12 && me.horns < 20) applet.write("  Two very large and dangerous looking horns sprout from your head, curving forward and over a foot long.  They have dangerous looking points.", false);
			if(me.horns >= 20) applet.write("  Two huge horns erupt from your forehead, curving outward at first, then forwards.  The weight of them is heavy, and they end in dangerous looking points.", false);
		}
		//Lizard horns
		if(me.hornType == 3) {
			applet.write("  A pair of " + num2Text(int(me.horns)) + " inch horns grow from the sides of your head, sweeping backwards and adding to your imposing visage.", false);
		}
		//Super lizard horns
		if(me.hornType == 4) applet.write("  Two pairs of horns, roughly a foot long, sprout from the sides of your head.  They sweep back and give you a fearsome look, almost like the dragons from your village's legends.", false);
		//Antlers!
		if(me.hornType == 5) {
			if(me.horns > 0) applet.write("  Two antlers, forking into " + num2Text(me.horns) + " points, have sprouted from the top of your head, forming a spiky, regal crown of bone.");
		}
		//BODY PG HERE
		applet.write("\n\nYou have a humanoid shape with the usual torso, arms, hands, and fingers.", false);
		//WINGS!
		if(me.wingType == 1) applet.write("  A pair of tiny-yet-beautiful bee-wings sprout from your back, too small to allow you to fly.", false);
		if(me.wingType == 2) applet.write("  A pair of large bee-wings sprout from your back, reflecting the light through their clear membranes beautifully.  They flap quickly, allowing you to easily hover in place or fly.", false);
		if(me.wingType == 6) applet.write("  A pair of tiny bat-like demon-wings sprout from your back, flapping cutely, but otherwise being of little use.", false);
		if(me.wingType == 7) applet.write("  A pair of large bat-like demon-wings fold behind your shoulders.  With a muscle-twitch, you can extend them, and use them to soar gracefully through the air.", false);
		if(me.wingType == 8) applet.write("  A large shark-like fin has sprouted between your shoulder blades.  With it you have far more control over swimming underwater.", false);
		if(me.wingType == 9) applet.write("  A pair of large, feathery wings sprout from your back.  Though you usually keep the " + me.hairColor + "-colored wings folded close, they can unfurl to allow you to soar as gracefully as a harpy.", false);
		if(me.wingType == 10) applet.write("  Small, vestigial wings sprout from your shoulders.  They might look like bat's wings, but the membranes are covered in fine, delicate scales.");
		else if(me.wingType == 11) applet.write("  Magnificent wings sprout from your shoulders.  When unfurled they stretch further than your arm span, and a single beat of them is all you need to set out toward the sky.  They look a bit like bat's wings, but the membranes are covered in fine, delicate scales and a wicked talon juts from the end of each bone.");
		else if(me.wingType == 12) applet.write("  Giant dragonfly wings hang from your shoulders.  At a whim, you could twist them into a whirring rhythm fast enough to lift you off the ground and allow you to fly.");

		//Wing arms
		if(me.armType == 1) applet.write("  Feathers hang off your arms from shoulder to wrist, giving them a slightly wing-like look.", false);
		else if(me.armType == 2) applet.write("  Shining black exoskeleton  covers your arms from the biceps down, resembling a pair of long black gloves from a distance.", false);	
		//Done with head bits. Move on to body stuff
		//Horse lowerbody, other lowerbody texts appear lower
		if(me.lowerBody == 11) applet.write("  From the waist down you have an incredibly cute and cartoonish parody of a horse's body, with all four legs ending in flat, rounded feet.", false);
		else if(me.isTaur()) applet.write("  From the waist down you have the body of a horse, with all four legs capped by hooves.", false);
		//Hip info only displays if you aren't a centaur. 
		if(!me.isTaur()) {
			if(me.thickness > 70) {
				applet.write("  You have " + hipDescript(), false);
				if(me.hipRating < 6) {
					if(me.tone < 65) applet.write(" buried under a noticeable muffin-top, and", false);
					else applet.write(" that blend into your pillar-like waist, and", false);
				}
				if(me.hipRating >= 6 && me.hipRating < 10) applet.write(" that blend into the rest of your thick form, and", false);
				if(me.hipRating >= 10 && me.hipRating < 15) applet.write(" that would be much more noticeable if you weren't so wide-bodied, and", false);
				if(me.hipRating >= 15 && me.hipRating < 20) applet.write(" that sway and emphasize your thick, curvy shape, and", false);
				if(me.hipRating >= 20) applet.write(" that sway hypnotically on your extra-curvy frame, and", false);
			}
			else if(me.thickness < 30) {
				applet.write("  You have " + hipDescript(), false);
				if(me.hipRating < 6) applet.write(" that match your trim, lithe body, and", false);
				if(me.hipRating >= 6 && me.hipRating < 10) applet.write(" that sway to and fro, emphasized by your trim body, and", false);
				if(me.hipRating >= 10 && me.hipRating < 15) applet.write(" that swell out under your trim waistline, and", false);
				if(me.hipRating >= 15 && me.hipRating < 20) applet.write(", emphasized by your narrow waist, and", false);
				if(me.hipRating >= 20) applet.write(" that swell disproportionately wide on your lithe frame, and", false);
			}
			//STANDARD
			else {
				applet.write("  You have " + hipDescript(), false);
				if(me.hipRating < 6) applet.write(", and", false);
				if(me.femininity > 50) {
					if(me.hipRating >= 6 && me.hipRating < 10) applet.write(" that draw the attention of those around you, and", false);
					if(me.hipRating >= 10 && me.hipRating < 15) applet.write(" that make you walk with a sexy, swinging gait, and", false);
					if(me.hipRating >= 15 && me.hipRating < 20) applet.write(" that make it look like you've birthed many children, and", false);
					if(me.hipRating >= 20) applet.write(" that make you look more like an animal waiting to be bred than any kind of human, and", false);
				}
				else {
					if(me.hipRating >= 6 && me.hipRating < 10) applet.write(" that give you a graceful stride, and", false);
					if(me.hipRating >= 10 && me.hipRating < 15) applet.write(" that add a little feminine swing to your gait, and", false);
					if(me.hipRating >= 15 && me.hipRating < 20) applet.write(" that force you to sway and wiggle as you move, and", false);
					if(me.hipRating >= 20) {
						applet.write(" that give your ", false);
						if(me.balls > 0) applet.write("balls plenty of room to breathe", false);
						else if(me.hasCock()) applet.write(multiCockDescript() + " plenty of room to swing", false);
						else if(me.hasVagina()) applet.write(vaginaDescript() + " a nice, wide berth", false);
						else applet.write("vacant groin plenty of room", false);
						applet.write(", and", false);
					}
				}
			}
		}
		//ASS
		//Horse version
		if(me.isTaur()) {
			//FATBUTT
			if(me.tone < 65) {
				applet.write("  Your " + buttDescript(), false);
				if(me.buttRating < 4) applet.write(" is lean, from what you can see of it.", false);
				if(me.buttRating >= 4 && me.buttRating < 6) applet.write(" looks fairly average.", false);
				if(me.buttRating >= 6 && me.buttRating <10) applet.write(" is fairly plump and healthy.", false);
				if(me.buttRating >= 10 && me.buttRating < 15) applet.write(" jiggles a bit as you trot around.", false);
				if(me.buttRating >= 15 && me.buttRating < 20) applet.write(" jiggles and wobbles as you trot about.", false);
				if(me.buttRating >= 20) applet.write(" is obscenely large, bordering freakish, even for a horse.", false);
			}
			//GIRL LOOK AT DAT BOOTY
			else {
				applet.write("  Your " + buttDescript(), false);
				if(me.buttRating < 4) applet.write(" is barely noticable, showing off the muscles of your haunches.", false);
				if(me.buttRating >= 4 && me.buttRating < 6) applet.write(" matches your toned equine frame quite well.", false);
				if(me.buttRating >= 6 && me.buttRating <10) applet.write(" gives hints of just how much muscle you could put into a kick.", false);
				if(me.buttRating >= 10 && me.buttRating < 15) applet.write(" surges with muscle whenever you trot about.", false);
				if(me.buttRating >= 15 && me.buttRating < 20) applet.write(" flexes its considerable mass as you move.", false);
				if(me.buttRating >= 20) applet.write(" is stacked with layers of muscle, huge even for a horse.", false);
			}
		}
		//Non-horse PCs
		else {
			//TUBBY ASS
			if(me.tone < 60) {
				applet.write(" your " + buttDescript(), false);
				if(me.buttRating < 4) applet.write(" looks great under your gear.", false);
				if(me.buttRating >= 4 && me.buttRating < 6) applet.write(" has the barest amount of sexy jiggle.", false);
				if(me.buttRating >= 6 && me.buttRating <10) applet.write(" fills out your clothing nicely.", false);
				if(me.buttRating >= 10 && me.buttRating < 15) applet.write(" wobbles enticingly with every step.", false);
				if(me.buttRating >= 15 && me.buttRating < 20) applet.write(" wobbles like a bowl full of jello as you walk.", false);
				if(me.buttRating >= 20) applet.write(" is obscenely large, bordering freakish, and makes it difficult to run.", false);
			}
			//FITBUTT
			else {
				applet.write(" your " + buttDescript(), false);
				if(me.buttRating < 4) applet.write(" molds closely against your form.", false);
				if(me.buttRating >= 4 && me.buttRating < 6) applet.write(" contracts with every motion, displaying the detailed curves of its lean musculature.", false);
				if(me.buttRating >= 6 && me.buttRating <10) applet.write(" fills out your clothing nicely.", false);
				if(me.buttRating >= 10 && me.buttRating < 15) applet.write(" stretches your gear, flexing it with each step.", false);
				if(me.buttRating >= 15 && me.buttRating < 20) applet.write(" threatens to bust out from under your kit each time you clench it.", false);
				if(me.buttRating >= 20) applet.write(" is marvelously large, but completely stacked with muscle.", false);
			}
		}
		//TAILS
		if(me.tailType == 1) applet.write("  A long " + me.hairColor + " horsetail hangs from your " + buttDescript() + ", smooth and shiny.", false);
		if(me.tailType == 2) applet.write("  A fuzzy " + me.hairColor + " dogtail sprouts just above your " + buttDescript() + ", wagging to and fro whenever you are happy.", false);
		if(me.tailType == 3) applet.write("  A narrow tail ending in a spaded tip curls down from your " + buttDescript() + ", wrapping around your " + me.leg() + " sensually at every opportunity.", false);
		if(me.tailType == 4) applet.write("  A long cowtail with a puffy tip swishes back and forth as if swatting at flies.", false);
		if(me.tailType == 5) {
			applet.write("  A large, spherical spider-abdomen has grown out from your backside, covered in shiny black chitin.  Though it's heavy and bobs with every motion, it doesn't seem to slow you down.", false);
			if(me.tailVenom > 50 && me.tailVenom < 80) applet.write("  Your bulging arachnid posterior feels fairly full of webbing.", false);
			if(me.tailVenom >= 80 && me.tailVenom < 100) applet.write("  Your arachnid rear bulges and feels very full of webbing.", false);
			if(me.tailVenom == 100) applet.write("  Your swollen spider-butt is distended with the sheer amount of webbing it's holding.", false);
		}
		if(me.tailType == 6) {
			applet.write("  A large insectile bee-abdomen dangles from just above your backside, bobbing with its own weight as you shift.  It is covered in hard chitin with black and yellow stripes, and tipped with a dagger-like stinger.", false);
			if(me.tailVenom > 50 && me.tailVenom < 80) applet.write("  A single drop of poison hangs from your exposed stinger.", false);
			if(me.tailVenom >= 80 && me.tailVenom < 100) applet.write("  Poisonous bee venom coats your stinger completely.", false);
			if(me.tailVenom == 100) applet.write("  Venom drips from your poisoned stinger regularly.", false);
		}
		if(me.tailType == 7) {
			applet.write("  A long shark-tail trails down from your backside, swaying to and fro while giving you a dangerous air.", false);
		}
		if(me.tailType == 8) {
			applet.write("  A soft " + me.hairColor + " cat-tail sprouts just above your " + buttDescript() + ", curling and twisting with every step to maintain perfect balance.", false);
		}
		if(me.tailType == 9) {
			applet.write("  A tapered tail hangs down from just above your " + assDescript() + ".  It sways back and forth, assisting you with keeping your balance.", false);
		}
		if(me.tailType == 10) applet.write("  A short, soft bunny tail sprouts just above your " + assDescript() + ", twitching constantly whenever you don't think about it.", false);
		else if(me.tailType == 11) applet.write("  A tail of feathers fans out from just above your " + assDescript() + ", twitching instinctively to help guide you if you were to take flight.", false);
		else if(me.tailType == 12) {
			applet.write("  A conical, ", false);
			if(me.skinType == 3) applet.write("gooey, " + me.skinTone, false);
			else applet.write("furry, " + me.hairColor, false);
			applet.write(", tail extends from your " + assDescript() + ", bouncing up and down as you move and helping to counterbalance you.", false);
		}
		else if(me.tailType == 13) {
			if(me.tailVenom == 1) applet.write("  A swishing, colorful fox's brush extends from your " + assDescript() + ", curling around your body - the soft fur feels lovely.");
			else applet.write("  " + Num2Text(me.tailVenom) + " swishing, colorful fox's tails extend from your " + assDescript() + ", curling around your body - the soft fur feels lovely.");
		}
		else if(me.tailType == 14) {
			applet.write("  A thin, scaly, prehensile reptilian tail, almost as long as you are tall, swings behind you like a living bullwhip.  Its tip menaces with spikes of bone, meant to deliver painful blows.");		
		}
		//LOWERBODY SPECIAL
		if(me.lowerBody == 0) applet.write("  Two normal human legs grow down from your waist, ending in normal human feet.", false);
		else if(me.lowerBody == 1) applet.write("  Your legs are muscled and jointed oddly, covered in fur, and end in a pair of bestial hooves.", false);
		else if(me.lowerBody == 2) applet.write("  Two digitigrade legs grow downwards from your waist, ending in dog-like hind-paws.", false);
		else if(me.lowerBody == 3) applet.write("  Below your waist your flesh is fused together into a very long snake-like tail.", false);
		//Horse body is placed higher for readability purposes
		else if(me.lowerBody == 5) applet.write("  Your perfect lissom legs end in mostly human feet, apart from the horn protruding straight down from the heel that forces you to walk with a sexy, swaying gait.", false);
		else if(me.lowerBody == 6) applet.write("  Your lithe legs are capped with flexible clawed feet.  Sharp black nails grow where once you had toe-nails, giving you fantastic grip.", false);
		else if(me.lowerBody == 7) applet.write("  Your legs are covered in a shimmering insectile carapace up to mid-thigh, looking more like a pair of 'fuck-me-boots' than exoskeleton.  A bit of downy yellow and black fur fuzzes your upper thighs, just like a bee.", false);
		else if(me.lowerBody == 8) applet.write("  In place of legs you have a shifting amorphous blob.  Thankfully it's quite easy to propel yourself around on.  The lowest portions of your " + me.armorName + " float around inside you, bringing you no discomfort.", false);
		else if(me.lowerBody == 9) applet.write("  Two digitigrade legs grow downwards from your waist, ending in soft, padded cat-paws.", false);
		else if(me.lowerBody == 10) applet.write("  Two digitigrade legs grow down from your " + hipDescript() + ", ending in clawed feet.  There are three long toes on the front, and a small hind-claw on the back.", false);
		else if(me.lowerBody == 12) applet.write("  Your legs thicken below the waist as they turn into soft-furred rabbit-like legs.  You even have large bunny feet that make hopping around a little easier than walking.", false);
		else if(me.lowerBody == 13) applet.write("  Your legs are covered with " + me.hairColor + " plumage.  Thankfully the thick, powerful thighs are perfect for launching you into the air, and your feet remain mostly human, even if they are two-toed and tipped with talons.", false);
		else if(me.lowerBody == 14) applet.write("  Your furry legs have short thighs and long calves, with even longer feet ending in prominently-nailed toes.", false);
		else if(me.lowerBody == 15) applet.write("  Your legs are covered in a reflective black, insectile carapace up to your mid-thigh, looking more like a pair of 'fuck-me-boots' than exoskeleton.", false);
		else if(me.lowerBody == 16) applet.write("  Where your legs would normally start you have grown the body of a spider, with eight spindly legs that sprout from its sides.", false);
		else if(me.lowerBody == 17) applet.write("  Your legs are crooked into high knees with hocks and long feet, like those of a fox; cute bulbous toes decorate the ends.");
		else if(me.lowerBody == 18) applet.write("  Two human-like legs grow down from your " + hipDescript() + ", sheathed in scales and ending in clawed feet.  There are three long toes on the front, and a small hind-claw on the back.", false);
		if(me.hasPerk("Incorporeality") >= 0) applet.write("  Of course, your " + me.legs() + " are partially transparent due to their ghostly nature.", false);
		
		applet.write("\n", false);
		//Pregnancy Shiiiiiitz
		if((me.buttPregnancyType == 19 && me.buttPregnancyType > 0) || (me.pregnancyType > 0 && me.pregnancyIncubation > 0)) {
			if(me.pregnancyType == 5) {
				applet.write("<b>", false);
				//Compute size
				temp = me.statusAffects[me.hasStatusAffect("eggs")].value3 + me.statusAffects[me.hasStatusAffect("eggs")].value2 * 10;
				if(me.pregnancyIncubation <= 50 && me.pregnancyIncubation > 20) {
					applet.write("Your swollen pregnant belly is as large as a ", false);
					if(temp < 10) applet.write("basketball.", false);
					if(temp >= 10 && temp < 20) applet.write("watermelon.", false);
					if(temp >= 20) applet.write("beach ball.", false);
				}
				if(me.pregnancyIncubation <= 20) {
					applet.write("Your swollen pregnant belly is as large as a ", false);
					if(temp < 10) applet.write("watermelon.", false);
					if(temp >= 10 && temp < 20) applet.write("beach ball.", false);
					if(temp >= 20) applet.write("large medicine ball.", false);
				}
				applet.write("</b>", false);
				temp = 0;
			}
			//Satur preggos - only shows if bigger than regular pregnancy or not pregnancy
			else if((me.buttPregnancyType == 19 && me.buttPregnancyType > 0) && (me.pregnancyIncubation == 0 || me.buttPregnancyIncubation < me.pregnancyIncubation)) {
				if(me.buttPregnancyIncubation < 125 && me.buttPregnancyIncubation >= 75) {
					applet.write("<b>You've got the begginings of a small pot-belly.</b>\n", false);
				}
				else if(me.buttPregnancyIncubation >= 50) {
					applet.write("<b>The unmistakable bulge of pregnancy is visible in your tummy, yet it feels odd inside you - wrong somehow.</b>\n", false);	
				}
				else if(me.buttPregnancyIncubation >= 30) {
					applet.write("<b>Your stomach is painfully distended by your pregnancy, making it difficult to walk normally.</b>\n", false);
				}
				else {
					if(me.pregnancyType == 12 || me.pregnancyType == 4 || me.pregnancyType == 11 || me.pregnancyType == 17 || me.pregnancyType == 21) applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging with the spawn of one of this land's natives.</b>\n", false);
					else if(me.pregnancyType != 8) applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging with the unclean spawn of some monster or beast.</b>\n", false);
					else applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging outwards with Marble's precious child.</b>\n", false);
				}
			}
			else {
				trace("Pregnancy detected, outputting descriptivez" + me.pregnancyIncubation);
				if(me.pregnancyIncubation <= 336 && me.pregnancyIncubation > 280) {
					applet.write("<b>Your belly is larger than it used to be.</b>\n", false);
				}
				if(me.pregnancyIncubation <= 280 && me.pregnancyIncubation > 216) {
					applet.write("<b>Your belly is more noticably distended.   You are probably pregnant.</b>", false);
				}
				if(me.pregnancyIncubation <= 216 && me.pregnancyIncubation > 180) {
					applet.write("<b>The unmistakable bulge of pregnancy is visible in your tummy.</b>\n", false);	
				}
				if(me.pregnancyIncubation <= 180 && me.pregnancyIncubation > 120) {
					applet.write("<b>Your belly is very obviously pregnant to anyone who looks at you.</b>\n", false);		
				}
				if(me.pregnancyIncubation <= 120 && me.pregnancyIncubation > 72) {
					applet.write("<b>It would be impossible to conceal your growing pregnancy from anyone who glanced your way.</b>\n", false);
				}
				if(me.pregnancyIncubation <= 72 && me.pregnancyIncubation > 48) {
					applet.write("<b>Your stomach is painfully distended by your pregnancy, making it difficult to walk normally.</b>\n", false);
				}
				if(me.pregnancyIncubation <= 48) {
					if(me.pregnancyType == 12 || me.pregnancyType == 4 || me.pregnancyType == 11 || me.pregnancyType == 17 || me.pregnancyType == 21) applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging with the spawn of one of this land's natives.</b>\n", false);
					else if(me.pregnancyType != 8) applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging with the unclean spawn of some monster or beast.</b>\n", false);
					else applet.write("\n<b>Your belly protrudes unnaturally far forward, bulging outwards with Marble's precious child.</b>\n", false);
				}
			}
			applet.write("\n", false);
		}
		applet.write("\n", false);
		if(me.gills) applet.write("A pair of feathery gills are growing out just below your neck, spreading out horizontally and draping down your chest.  They allow you to stay in the water for quite a long time.  ", false);
		//Chesticles..I mean bewbz.
		if(me.breastRows.length == 1) {
			applet.write("You have " + num2Text(me.breastRows[temp].breasts) + " " + breastDescript(temp) + ", each supporting ", false);
			if(me.breastRows[0].nipplesPerBreast == 1) applet.write(num2Text(me.breastRows[temp].nipplesPerBreast) + " " + int(me.nippleLength*10)/10 + "-inch " + nippleDescript(temp) + ".", false);
			else applet.write(num2Text(me.breastRows[temp].nipplesPerBreast) + " " + int(me.nippleLength*10)/10 + "-inch " + nippleDescript(temp) + "s.", false);
			if(me.breastRows[0].milkFullness > 75) applet.write("  Your " + breastDescript(temp) + " are painful and sensitive from being so stuffed with milk.  You should release the pressure soon.", false);
			if(me.breastRows[0].breastRating >= 1) applet.write("  You could easily fill a " + me.breastCup(temp) + " bra.", false);
			//Done with tits.  Move on.
			applet.write("\n", false);
		}
		//many rows
		else {
			applet.write("You have " + num2Text(me.breastRows.length) + " rows of breasts, the topmost pair starting at your chest.\n", false);
			while (temp < me.breastRows.length) {
				if(temp == 0) applet.write("--Your uppermost rack houses ", false);
				if(temp == 1) applet.write("\n--The second row holds ", false);
				if(temp == 2) applet.write("\n--Your third row of breasts contains ", false);
				if(temp == 3) applet.write("\n--Your fourth set of tits cradles ", false);
				if(temp == 4) applet.write("\n--Your fifth and final mammory grouping swells with ", false);
				applet.write(num2Text(me.breastRows[temp].breasts) + " " + breastDescript(temp) + " with ", false);
				if(me.breastRows[temp].nipplesPerBreast == 1) applet.write(num2Text(me.breastRows[temp].nipplesPerBreast) + " " + int(me.nippleLength*10)/10 + "-inch " + nippleDescript(temp) + " each.", false);
				else applet.write(num2Text(me.breastRows[temp].nipplesPerBreast) + " " + int(me.nippleLength*10)/10 + "-inch " + nippleDescript(temp) + "s each.", false);
				if(me.breastRows[temp].breastRating >= 1) applet.write("  They could easily fill a " + me.breastCup(temp) + " bra.", false);
				if(me.breastRows[temp].milkFullness > 75) applet.write("  Your " + breastDescript(temp) + " are painful and sensitive from being so stuffed with milk.  You should release the pressure soon.", false);
				temp++;
			}
			//Done with tits.  Move on.
			applet.write("\n", false);
		}	
		//Crotchial stuff - mention snake
		if(me.lowerBody == 3 && me.gender > 0) {
			applet.write("\nYour sex", false);
			if(me.gender == 3 || me.totalCocks() > 1) applet.write("es are ", false);
			else applet.write(" is ", false);
			applet.write("concealed within a cavity in your tail when not in use, though when the need arises, you can part your concealing slit and reveal your true self.\n", false);
		}
		//Cock stuff!
		temp = 0;
		if(me.cocks.length == 1) {
			if(me.lowerBody==4) applet.write("\nEver since becoming a centaur, your equipment has shifted to lie between your rear legs, like a horse.", false);
			applet.write("\nYour " + cockDescript(temp) + " is " + int(10*me.cocks[temp].cockLength)/10 + " inches long and ", false);
			if(Math.round(10*me.cocks[temp].cockThickness)/10 < 2) {
				if(Math.round(10*me.cocks[temp].cockThickness)/10 == 1) applet.write(int(10*me.cocks[temp].cockThickness)/10 + " inch thick.", false);
				else applet.write(Math.round(10*me.cocks[temp].cockThickness)/10 + " inches thick.", false);
			}
			else applet.write (num2Text(Math.round(10*me.cocks[temp].cockThickness)/10) + " inches wide.", false);
			//Horsecock flavor
			if(me.cocks[temp].cockType == 1) {
				applet.write("  It's mottled black and brown in a very animalistic pattern.  The 'head' of your shaft flares proudly, just like a horse's.", false);
			}
			//dog cock flavor
			if(me.cocks[temp].cockType == 2) {
				if(me.cocks[temp].knotMultiplier > 1 && me.cocks[temp].knotMultiplier < 1.4) applet.write("  A small knot of thicker flesh is near the base of your " + cockDescript(temp) + ", ready to expand to help you lodge it inside a female.", false);
				if(me.cocks[temp].knotMultiplier >= 1.4 && me.cocks[temp].knotMultiplier < 1.8) applet.write("  A large bulge of flesh nestles just above the bottom of your " + cockDescript(temp) + ", to ensure it stays where it belongs during mating.", false);
				if(me.cocks[temp].knotMultiplier >= 1.8) applet.write("  The obscenely swollen lump of flesh near the base of your " + cockDescript(temp) + " looks almost too big for your cock.", false);
				//List thickness
				applet.write("  The knot is " + Math.round(me.cocks[temp].cockThickness * me.cocks[temp].knotMultiplier * 10)/10 + " inches wide when at full size.", false);
			}
			//Demon cock flavor
			if(me.cocks[temp].cockType == 3) {
				applet.write("  The crown is ringed with a circle of rubbery protrusions that grow larger as you get more aroused.  The entire thing is shiny and covered with tiny, sensitive nodules that leave no doubt about its demonic origins.", false);
			}
			//Tentacle cock flavor
			if(me.cocks[temp].cockType == 4) {
				applet.write("  The entirety of its green surface is covered in perspiring beads of slick moisture.  It frequently shifts and moves of its own volition, the slightly oversized and mushroom-like head shifting in coloration to purplish-red whenever you become aroused.", false);
			}
			//Cat cock flavor
			if(me.cocks[temp].cockType == 5) {
				applet.write("  It ends in a single point, much like a spike, and is covered in small, fleshy barbs. The barbs are larger at the base and shrink in size as they get closer to the tip.  Each of the spines is soft and flexible, and shouldn't be painful for any of your partners.", false);
			}
			//Snake cock flavor
			if(me.cocks[temp].cockType == 6) {
				applet.write("  It's a deep, iridescent purple in color.  Unlike a human penis, the shaft is not smooth, and is instead patterned with multiple bulbous bumps.", false);
			}
			//Anemone cock flavor
			if(me.cocks[temp].cockType == 7) {
				applet.write("  The crown is surrounded by tiny tentacles with a venomous, aphrodisiac payload.  At its base a number of similar, longer tentacles have formed, guaranteeing that pleasure will be forced upon your partners.", false);
			}
			//Kangawang flavor
			if(me.cocks[temp].cockType == 8) {
				applet.write("  It usually lies coiled inside a sheath, but undulates gently and tapers to a point when erect, somewhat like a taproot.", false);
			}
			//Draconic Cawk Flava flav
			if(me.cocks[temp].cockType == 9) {
				applet.write("  With its tapered tip, there are few holes you wouldn't be able to get into.  It has a strange, knot-like bulb at its base, but doesn't usually flare during arousal as a dog's knot would.");
			}
			//Worm flavor
			if(me.hasStatusAffect("infested") >= 0) applet.write("  Every now and again a slimy worm coated in spunk slips partway out of your " + cockDescript(0) + ", tasting the air like a snake's tongue.", false);		
			//DONE WITH COCKS, moving on!
			applet.write("\n", false);
		}
		if(me.cocks.length > 1) 
		{
			temp = 0;
			rando = rand(4);
			if(me.lowerBody == 4) applet.write("\nWhere a horse's penis would usually be located, you have instead grown " + multiCockDescript() + "!\n", false);
			else applet.write("\nWhere a penis would normally be located, you have instead grown " + multiCockDescript() + "!\n", false);
			while(temp < me.cocks.length) 
			{
				
				//middle cock description
				if(rando == 0) {
					if(temp == 0)applet.write("-Your first ", false);
					else applet.write("-Your next ", false);
					applet.write(cockDescript(temp), false);
					applet.write(" is ", false);
					applet.write(int(10*me.cocks[temp].cockLength)/10 + " inches long and ", false)
					if(Math.floor(me.cocks[temp].cockThickness) >= 2) applet.write(num2Text(Math.round(me.cocks[temp].cockThickness * 10)/10) + " inches wide.", false);
					else {
						if(me.cocks[temp].cockThickness == 1) applet.write("one inch wide.", false);
						else applet.write(Math.round(me.cocks[temp].cockThickness*10)/10 + " inches wide.", false);
					}
				}
				if(rando == 1) {
					applet.write("-One of your ", false);
					applet.write(cockDescript(temp) + "s is " + Math.round(10*me.cocks[temp].cockLength)/10 + " inches long and ", false);
					if(Math.floor(me.cocks[temp].cockThickness) >= 2) applet.write(num2Text(Math.round(me.cocks[temp].cockThickness * 10)/10) + " inches thick.", false);
					else {
						if(me.cocks[temp].cockThickness == 1) applet.write("one inch thick.", false);
						else applet.write(Math.round(me.cocks[temp].cockThickness*10)/10 + " inches thick.", false);
					}
				}
				if(rando == 2) {
					if(temp > 0) applet.write("-Another of your ", false);
					else applet.write("-One of your ", false);
					applet.write(cockDescript(temp) + "s is " + Math.round(10*me.cocks[temp].cockLength)/10 + " inches long and ", false);
					if(Math.floor(me.cocks[temp].cockThickness) >= 2) applet.write(num2Text(Math.round(me.cocks[temp].cockThickness * 10)/10) + " inches thick.", false);
					else {
						if(me.cocks[temp].cockThickness == 1) applet.write("one inch thick.", false);
						else applet.write(Math.round(me.cocks[temp].cockThickness*10)/10 + " inches thick.", false);
					}
				}
				if(rando == 3) {
					if(temp > 0) applet.write("-Your next ", false);
					else applet.write("-Your first ", false);
					applet.write(cockDescript(temp) + " is " + Math.round(10*me.cocks[temp].cockLength)/10 + " inches long and ", false);
					if(Math.floor(me.cocks[temp].cockThickness) >= 2) applet.write(num2Text(Math.round(me.cocks[temp].cockThickness * 10)/10) + " inches in diameter.", false);
					else {
						if(Math.round(me.cocks[temp].cockThickness*10)/10 == 1) applet.write("one inch in diameter.", false);
						else applet.write(Math.round(me.cocks[temp].cockThickness*10)/10 + " inches in diameter.", false);
					}
				}
				//horse cock flavor
				if(me.cocks[temp].cockType == 1) {
					applet.write("  It's mottled black and brown in a very animalistic pattern.  The 'head' of your " + cockDescript(temp) + " flares proudly, just like a horse's.", false);
				}
				//dog cock flavor
				if(me.cocks[temp].cockType == 2) {
					applet.write("  It is shiny, pointed, and covered in veins, just like a large dog's cock.", false);
					if(me.cocks[temp].knotMultiplier > 1 && me.cocks[temp].knotMultiplier < 1.4) applet.write("  A small knot of thicker flesh is near the base of your " + cockDescript(temp) + ", ready to expand to help you lodge your " + cockDescript(temp) + " inside a female.", false);
					if(me.cocks[temp].knotMultiplier >= 1.4 && me.cocks[temp].knotMultiplier < 1.8) applet.write("  A large bulge of flesh nestles just above the bottom of your " + cockDescript(temp) + ", to ensure it stays where it belongs during mating.", false);
					if(me.cocks[temp].knotMultiplier >= 1.8) applet.write("  The obscenely swollen lump of flesh near the base of your " + cockDescript(temp) + " looks almost comically mismatched for your " + cockDescript(temp) + ".", false);
					//List knot thickness
					applet.write("  The knot is " + Math.floor(me.cocks[temp].cockThickness * me.cocks[temp].knotMultiplier * 10)/10 + " inches thick when at full size.", false);
				}
				//Demon cock flavor
				if(me.cocks[temp].cockType == 3) {
					applet.write("  The crown is ringed with a circle of rubbery protrusions that grow larger as you get more aroused.  The entire thing is shiny and covered with tiny, sensitive nodules that leave no doubt about its demonic origins.", false);
				}
				//Tentacle cock flavor
				if(me.cocks[temp].cockType == 4) {
					applet.write("  The entirety of its green surface is covered in perspiring beads of slick moisture.  It frequently shifts and moves of its own volition, the slightly oversized and mushroom-like head shifting in coloration to purplish-red whenever you become aroused.", false);
				}
				//Cat cock flavor
				if(me.cocks[temp].cockType == 5) {
					applet.write("  It ends in a single point, much like a spike, and is covered in small, fleshy barbs. The barbs are larger at the base and shrink in size as they get closer to the tip.  Each of the spines is soft and flexible, and shouldn't be painful for any of your partners.", false);
				}
				//Snake cock flavor
				if(me.cocks[temp].cockType == 6) {
					applet.write("  It's a deep, iridescent purple in color.  Unlike a human penis, the shaft is not smooth, and is instead patterned with multiple bulbous bumps.", false);
				}
				//Anemone cock flavor
				if(me.cocks[temp].cockType == 7) {
					applet.write("  The crown is surrounded by tiny tentacles with a venomous, aphrodisiac payload.  At its base a number of similar, longer tentacles have formed, guaranteeing that pleasure will be forced upon your partners.", false);
				}
				//Kangwang flavor
				if(me.cocks[temp].cockType == 8) {
					applet.write("  It usually lies coiled inside a sheath, but undulates gently and tapers to a point when erect, somewhat like a taproot.", false);
				}
				//Draconic Cawk Flava flav
				if(me.cocks[temp].cockType == 9) {
					applet.write("  With its tapered tip, there are few holes you wouldn't be able to get into.  It has a strange, knot-like bulb at its base, but doesn't usually flare during arousal as a dog's knot would.");
				}
				temp++;
				rando++
				applet.write("\n", false);
				if(rando > 3) rando = 0;
			}
			//Worm flavor
			if(me.hasStatusAffect("infested") >= 0) applet.write("Every now and again slimy worms coated in spunk slip partway out of your " + multiCockDescriptLight() + ", tasting the air like tongues of snakes.\n", false);
			//DONE WITH COCKS, moving on!
		}
		//Of Balls and Sacks!
		if(me.balls > 0) {
			if(me.hasStatusAffect("Uniball") >= 0) {
				if(me.skinType != 3) applet.write("Your [sack] clings tightly to your groin, holding " + ballsDescript() + " snugly against you.");
				else if(me.skinType == 3) applet.write("Your [sack] clings tightly to your groin, dripping and holding " + ballsDescript() + " snugly against you.");
			}
			else if(me.cockTotal() == 0) {
				if(me.skinType == 0) applet.write("A " + sackDescript() + " with " + ballsDescript() + " swings heavily under where a penis would normally grow.", false);
				if(me.skinType == 1) applet.write("A fuzzy " + sackDescript() + " filled with " + ballsDescript() + " swings low under where a penis would normally grow.", false);
				if(me.skinType == 2) applet.write("A scaley " + sackDescript() + " hugs your " + ballsDescript() + " tightly against your body.", false);
				if(me.skinType == 3) applet.write("An oozing, semi-solid sack with " + ballsDescript() + " swings heavily under where a penis would normally grow.", false);
			}
			else {
				if(me.skinType == 0) applet.write("A " + sackDescript() + " with " + ballsDescript() + " swings heavily beneath your " + multiCockDescriptLight() + ".", false);
				if(me.skinType == 1) applet.write("A fuzzy " + sackDescript() + " filled with " + ballsDescript() + " swings low under your " + multiCockDescriptLight() + ".", false);
				if(me.skinType == 2) applet.write("A scaley " + sackDescript() + " hugs your " + ballsDescript() + " tightly against your body.", false);
				if(me.skinType == 3) applet.write("An oozing, semi-solid sack with " + ballsDescript() + " swings heavily beneath your " + multiCockDescriptLight() + ".", false);
			}
			applet.write("  You estimate each of them to be about " + num2Text(Math.round(me.ballSize)) + " ", false);
			if(Math.round(me.ballSize) == 1) applet.write("inch", false);
			else applet.write("inches", false);
			applet.write(" across.\n", false);
		}	
		//VAGOOZ
		if(me.vaginas.length > 0) {
			if(me.gender == 2 && me.lowerBody == 4) applet.write("\nEver since becoming a centaur, your womanly parts have shifted to lie between your rear legs, in a rather equine fashion.", false);
			applet.write("\n", false);
			if(me.vaginas.length == 1) applet.write("You have a " + vaginaDescript(0) + ", with a " + int(me.clitLength*10)/10 + "-inch clit", false);
			if(me.vaginas[0].virgin) applet.write(" and an intact hymen", false);
			applet.write(".  ", false);
			if(me.vaginas.length > 1) applet.write("You have " + me.vaginas.length+ " " + vaginaDescript(0) + "s, with " + int(me.clitLength*10)/10 + "-inch clits each.  ", false);
			if(me.lib < 50 && me.lust < 50) //not particularly horny
			{
				//Wetness
				if(me.vaginas[0].vaginalWetness >= 2 && me.vaginas[0].vaginalWetness< 4) applet.write("Moisture gleams in ", false);
				if(me.vaginas[0].vaginalWetness>= 4) {
					applet.write("Occasional beads of ", false);
					applet.write("lubricant drip from ", false);
				}				
				//Different description based on vag looseness
				if(me.vaginas[0].vaginalWetness>= 2) {
					if(me.vaginas[0].vaginalLooseness< 2) applet.write("your " + vaginaDescript(0) + ". ", false);
					if(me.vaginas[0].vaginalLooseness>= 2 && me.vaginas[0].vaginalLooseness< 4) applet.write("your " + vaginaDescript(0) + ", its lips slightly parted. ", false);
					if(me.vaginas[0].vaginalLooseness>= 4) applet.write("the massive hole that is your " + vaginaDescript(0) + ".  ", false);
				}
			}
			if((me.lib>=50 || me.lust >=50) && (me.lib< 80 && me.lust < 80)) //kinda horny
			{
				//Wetness
				if(me.vaginas[0].vaginalWetness< 2) applet.write("Moisture gleams in ", false);
				if(me.vaginas[0].vaginalWetness>= 2 && me.vaginas[0].vaginalWetness< 4) {
					applet.write("Occasional beads of ", false);
					applet.write("lubricant drip from ", false);
				}
				if(me.vaginas[0].vaginalWetness>= 4) {
					applet.write("Thin streams of ", false);
					applet.write("lubricant occasionally dribble from ", false);
				}				
				//Different description based on vag looseness
				if(me.vaginas[0].vaginalLooseness< 2) applet.write("your " + vaginaDescript(0) + ". ", false);
				if(me.vaginas[0].vaginalLooseness>= 2 && me.vaginas[0].vaginalLooseness< 4) applet.write("your " + vaginaDescript(0) + ", its lips slightly parted. ", false);
				if(me.vaginas[0].vaginalLooseness>= 4) applet.write("the massive hole that is your " + vaginaDescript(0) + ".  ", false);
			}
			if((me.lib> 80 || me.lust > 80)) //WTF horny!
			{
				//Wetness
				if(me.vaginas[0].vaginalWetness< 2) 
				{
					applet.write("Occasional beads of ", false);
					applet.write("lubricant drip from ", false);
				}
				if(me.vaginas[0].vaginalWetness>= 2 && me.vaginas[0].vaginalWetness< 4)
				{
					applet.write("Thin streams of ", false);
					applet.write("lubricant occasionally dribble from ", false);
				}
				if(me.vaginas[0].vaginalWetness>= 4) 
				{
					applet.write("Thick streams of ", false);
					applet.write("lubricant drool constantly from ", false);
				}				
				//Different description based on vag looseness
				if(me.vaginas[0].vaginalLooseness< 2) applet.write("your " + vaginaDescript(0) + ". ", false);
				if(me.vaginas[0].vaginalLooseness>= 2 && me.vaginas[0].vaginalLooseness< 4) applet.write("your " + vaginaDescript(0) + ", its lips slightly parted. ", false);
				if(me.vaginas[0].vaginalLooseness>= 4) applet.write("the massive hole that is your cunt.  ", false);
			}
			//Line Drop for next descript!
			applet.write("\n", false);
		}
		//Genderless lovun'
		if(me.cockTotal() == 0 && me.vaginas.length == 0) applet.write("\nYou have a curious lack of any sexual endowments.\n", false);
		
		
		//BUNGHOLIO
		if(me.ass != undefined) {
			applet.write("\n", false);
			applet.write("You have one " + assholeDescript() + ", placed between your " + buttDescript() + "-cheeks where it belongs.\n", false);
		}
		//Piercings!
		if(me.eyebrowPierced > 0) applet.write("\nA solitary " + me.eyebrowPShort + " adorns your eyebrow, looking very stylish.", false);
		if(me.earsPierced > 0) applet.write("\nYour ears are pierced with " + me.earsPShort + ".", false);
		if(me.nosePierced > 0) applet.write("\nA " + me.nosePShort + " dangles from your nose.", false);
		if(me.lipPierced > 0) applet.write("\nShining on your lip, a " + me.lipPShort + " is plainly visible.", false);
		if(me.tonguePierced > 0) applet.write("\nThough not visible, you can plainly feel your " + me.tonguePShort + " secured in your tongue.", false);
		if(me.nipplesPierced == 3) applet.write("\nYour " + nippleDescript(0) + "s ache and tingle with every step, as your heavy " + me.nipplesPShort + " swings back and forth.", false);
		else if(me.nipplesPierced > 0) applet.write("\nYour " + nippleDescript(0) + "s are pierced with " + me.nipplesPShort + ".", false);
		if(me.totalCocks() > 0) {
			if(me.cocks[0].pierced > 0) applet.write("\nLooking positively perverse, a " + me.cocks[0].pShort + " adorns your " + cockDescript(0) + ".", false);
		}
		if(flags[286] == 1) applet.write("\nA magical, ruby-studded bar pierces your belly button, allowing you to summon Ceraph on a whim.", false);
		if(me.hasVagina()) {
			if(me.vaginas[0].labiaPierced > 0) applet.write("\nYour " + vaginaDescript(0) + " glitters with the " + me.vaginas[0].labiaPShort + " hanging from your lips.", false);
			if(me.vaginas[0].clitPierced > 0) applet.write("\nImpossible to ignore, your " + clitDescript() + " glitters with its " + me.vaginas[0].clitPShort + ".", false);
		}
		//MONEY!
		 * */
		if(me.gems == 0) Game.getUI().write("\n\n<b>Your money-purse is devoid of any currency.");
		if(me.gems > 1) Game.getUI().write("\n\n<b>You have " + me.gems + " shining gems, collected in your travels.");
		if(me.gems == 1) Game.getUI().write("\n\n<b>You have " + me.gems + " shining gem, collected in your travels.");
	}
}
