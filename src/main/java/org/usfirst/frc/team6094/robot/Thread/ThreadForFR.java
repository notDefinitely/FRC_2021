package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForFR extends Thread {
   // variables for your Thread ...
   private Double Speed;
   private Double counts;

   public void setSpeed(Double setSpeed){
      Speed = setSpeed;
   }

   public void setDistance(Double gMeters) {
      counts = gMeters*2048;
   }

   @Override
   public void run() {
      System.out.println("FR: " + Robot.encoderFR.get());
      if (Math.abs(Robot.encoderFR.get()) < Math.abs(counts)) {
         Robot.drivetrain.frontRightMotor(Speed);
      } else if (Math.abs(Robot.encoderFR.get()) > Math.abs(counts)+100) {
         Robot.drivetrain.frontRightMotor(-Speed);
      } else {
         Robot.drivetrain.frontRightMotor(0.0);
      }
   }
}