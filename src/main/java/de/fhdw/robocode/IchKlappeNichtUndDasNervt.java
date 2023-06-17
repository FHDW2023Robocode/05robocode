package de.fhdw.robocode;

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;
import static robocode.util.Utils.normalRelativeAngleDegrees;
//import robocode.getRadarHeading;
//import robocode.getHeading;
//import robocode.getBearing;
//import robocode.getDistance;

public class IchKlappeNichtUndDasNervt extends Robot {

	
	
	double radius = 100.0;
    double angle = 359.0;
    double aimTo;
    double turnTo;
    Boolean hasSeenEnemy =false;
    @Override
    public void run() {

        

        while (true) {
            ahead(radius);
        	turnGunLeft(angle);
            back(radius);
            /*
        	if(!hasSeenEnemy) {
        		
        		ahead(radius);
        		turnLeft(angle);

        	}else {
        		turnGunLeft(90 - aimTo);
            	
            	
            	turnLeft(90 - aimTo);
            	ahead(radius);
        	}
        	*/
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
    	
        hasSeenEnemy = true;
        aimTo = e.getBearing();
         double distance = e.getDistance(); //get the distance of the scanned robot

          if(distance > 800) //this conditions adjust the fire force according the distance of the scanned robot.

            fire(1);

          else if(distance > 600 && distance <= 800)

            fire(2);

          else if(distance > 400 && distance <= 600)

            fire(3);

          else if(distance > 200 && distance <= 400)

            fire(4);

          else if(distance < 200)

            fire(5);


        turnTo= normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
        turnRight(turnTo);
        //turnGunLeft(90 + aimTo);
        /*
    	turnGunLeft(90 - e.getBearing());
    	fire(0.1);
    	
    	turnLeft(90 - e.getBearing());
    	ahead(radius);
        */
    }

    public void onHitByBullet(HitByBulletEvent e) {
        //turnLeft(90 - e.getBearing());
        
    }

public void onWallHit(HitWallEvent e) {
        //turnLeft(180);
        ahead(radius);

    }

}
