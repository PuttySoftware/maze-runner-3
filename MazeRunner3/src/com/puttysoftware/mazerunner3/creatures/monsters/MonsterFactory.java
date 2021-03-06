/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.creatures.monsters;

public class MonsterFactory {
    private MonsterFactory() {
	// Do nothing
    }

    public static AbstractMonster getNewMonsterInstance(final boolean randomAppearance, final boolean randomFaith,
	    final boolean scales, final boolean dynamic) {
	if (randomAppearance) {
	    if (randomFaith) {
		if (scales) {
		    if (dynamic) {
			return new BothRandomScalingDynamicMonster();
		    } else {
			return new BothRandomScalingStaticMonster();
		    }
		} else {
		    if (dynamic) {
			return new BothRandomFixedDynamicMonster();
		    } else {
			return new BothRandomFixedStaticMonster();
		    }
		}
	    } else {
		if (scales) {
		    if (dynamic) {
			return new AppearanceRandomScalingDynamicMonster();
		    } else {
			return new AppearanceRandomScalingStaticMonster();
		    }
		} else {
		    if (dynamic) {
			return new AppearanceRandomFixedDynamicMonster();
		    } else {
			return new AppearanceRandomFixedStaticMonster();
		    }
		}
	    }
	} else {
	    if (randomFaith) {
		if (scales) {
		    if (dynamic) {
			return new FaithRandomScalingDynamicMonster();
		    } else {
			return new FaithRandomScalingStaticMonster();
		    }
		} else {
		    if (dynamic) {
			return new FaithRandomFixedDynamicMonster();
		    } else {
			return new FaithRandomFixedStaticMonster();
		    }
		}
	    } else {
		if (scales) {
		    if (dynamic) {
			return new DefiniteScalingDynamicMonster();
		    } else {
			return new DefiniteScalingStaticMonster();
		    }
		} else {
		    if (dynamic) {
			return new DefiniteFixedDynamicMonster();
		    } else {
			return new DefiniteFixedStaticMonster();
		    }
		}
	    }
	}
    }
}
