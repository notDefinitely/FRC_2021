package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForBL extends Thread {
   // variables for your Thread ...
   private Double Speed;
   private Double counts;

   /* 
    *NOTE: This functionality could have been acheived by using this.variable
    * then instead of then just calling Speed as a global variable
    * 
    * private Double Speed;
    * 
    * public void setSpeed(Double Speed){
    * this.Speed = Speed;
    * }
    */
   public void setSpeed(Double setSpeed){
      Speed = setSpeed;
   }

   public void setDistance(Double Meters) {
      // Should have added another *x to bring the distances to Meters since right
      // now its only that many rotations
      counts = Meters*2048;
   }

   // I used Math.abs for encoder counts since we are using > and <
   // Negative counts are still displayed in console.log
   // This fixes one of the main crabbing problems
   // The Speed variable will determine whether we want to go forward or backward
   @Override
   public void run() {
      System.out.println("BL: " + Robot.encoderBL.get());
      if (Math.abs(Robot.encoderBL.get()) < Math.abs(counts)) {
         Robot.drivetrain.backLeftMotor(-Speed);
      } else if (Math.abs(Robot.encoderBL.get()) > Math.abs(counts)+100) {
         Robot.drivetrain.backLeftMotor(Speed);
      } else {
         Robot.drivetrain.backLeftMotor(0.0);
      }
   }

}
