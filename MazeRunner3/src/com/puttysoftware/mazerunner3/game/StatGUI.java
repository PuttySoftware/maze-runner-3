/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.game;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.puttysoftware.images.BufferedImageIcon;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.creatures.party.PartyMember;
import com.puttysoftware.mazerunner3.loader.EffectImageConstants;
import com.puttysoftware.mazerunner3.loader.EffectImageLoader;
import com.puttysoftware.mazerunner3.maze.Maze;

class StatGUI {
    // Fields
    private Container statsPane;
    private JLabel hpLabel;
    private JLabel mpLabel;
    private JLabel goldLabel;
    private JLabel attackLabel;
    private JLabel defenseLabel;
    private JLabel xpLabel;
    private JLabel poisonLabel;
    private JLabel timeLabel;

    // Constructors
    StatGUI() {
	this.setUpGUI();
    }

    // Methods
    Container getStatsPane() {
	return this.statsPane;
    }

    void updateStats() {
	final PartyMember pc = PartyManager.getParty().getLeader();
	final Maze m = Boot.getApplication().getMazeManager().getMaze();
	this.hpLabel.setText(pc.getHPString());
	this.mpLabel.setText(pc.getMPString());
	this.goldLabel.setText(Integer.toString(pc.getGold()));
	this.attackLabel.setText(Integer.toString(pc.getAttack()));
	this.defenseLabel.setText(Integer.toString(pc.getDefense()));
	this.xpLabel.setText(pc.getXPString());
	this.poisonLabel.setText(m.getPoisonString());
	this.timeLabel.setText(m.getTimeString());
    }

    private void setUpGUI() {
	this.statsPane = new Container();
	this.statsPane.setLayout(new GridLayout(8, 1));
	this.hpLabel = new JLabel("", null, SwingConstants.LEFT);
	this.mpLabel = new JLabel("", null, SwingConstants.LEFT);
	this.goldLabel = new JLabel("", null, SwingConstants.LEFT);
	this.attackLabel = new JLabel("", null, SwingConstants.LEFT);
	this.defenseLabel = new JLabel("", null, SwingConstants.LEFT);
	this.xpLabel = new JLabel("", null, SwingConstants.LEFT);
	this.poisonLabel = new JLabel("", null, SwingConstants.LEFT);
	this.timeLabel = new JLabel("", null, SwingConstants.LEFT);
	this.statsPane.add(this.hpLabel);
	this.statsPane.add(this.mpLabel);
	this.statsPane.add(this.goldLabel);
	this.statsPane.add(this.attackLabel);
	this.statsPane.add(this.defenseLabel);
	this.statsPane.add(this.xpLabel);
	this.statsPane.add(this.poisonLabel);
	this.statsPane.add(this.timeLabel);
    }

    void updateImages() {
	final BufferedImageIcon hpImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_HEALTH);
	this.hpLabel.setIcon(hpImage);
	final BufferedImageIcon mpImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_MAGIC);
	this.mpLabel.setIcon(mpImage);
	final BufferedImageIcon goldImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_GOLD);
	this.goldLabel.setIcon(goldImage);
	final BufferedImageIcon attackImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_ATTACK);
	this.attackLabel.setIcon(attackImage);
	final BufferedImageIcon defenseImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_DEFENSE);
	this.defenseLabel.setIcon(defenseImage);
	final BufferedImageIcon xpImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_XP);
	this.xpLabel.setIcon(xpImage);
	final BufferedImageIcon poisonImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_POISON);
	this.poisonLabel.setIcon(poisonImage);
	final BufferedImageIcon timeImage = EffectImageLoader.getImage(EffectImageConstants.STAT_IMAGE_TIME);
	this.timeLabel.setIcon(timeImage);
    }
}
