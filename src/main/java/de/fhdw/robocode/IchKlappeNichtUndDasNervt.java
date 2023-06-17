package de.fhdw.robocode;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class IchKlappeNichtUndDasNervt extends Robot {

	
	
	double radius = 100.0;
    double angle = 90.0;
    double aimTo;
    Boolean hasSeenEnemy =false;
    @Override
    public void run() {

        

        while (true) {
        	
        	if(!hasSeenEnemy) {
        		
        		ahead(radius);
        		turnLeft(angle);
        		//turnGunLeft(angle);
        		turnRadarLeft(angle);
        		//fireBullet(getEnergy());
        	}else {
        		turnGunLeft(90 - aimTo);
            	
            	
            	turnLeft(90 - aimTo);
            	ahead(radius);
        	}
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
    	
        hasSeenEnemy = true;
        aimTo = e.getBearing();
        fire(1);
        /*
    	turnGunLeft(90 - e.getBearing());
    	fire(0.1);
    	
    	turnLeft(90 - e.getBearing());
    	ahead(radius);
        */
    }

    public void onHitByBullet(HitByBulletEvent e) {
        turnLeft(90 - e.getBearing());
        
    }

}
