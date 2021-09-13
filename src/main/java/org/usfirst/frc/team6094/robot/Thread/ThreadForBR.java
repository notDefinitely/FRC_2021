package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForBR extends Thread {
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
      System.out.println("BR: " + Robot.encoderBR.get());
      if (Math.abs(Robot.encoderBR.get()) < Math.abs(counts)) {
         Robot.drivetrain.backRightMotor(Speed);
      } else if (Math.abs(Robot.encoderBR.get()) > Math.abs(counts)+100) {
         Robot.drivetrain.backRightMotor(-Speed);
      } else {
         Robot.drivetrain.backRightMotor(0.0);
      }
   }
}