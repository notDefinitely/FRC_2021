package org.usfirst.frc.team6094.robot.Thread;

import org.usfirst.frc.team6094.robot.Robot;

public class ThreadForFL extends Thread {
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
      System.out.println("FL: " + Robot.encoderFL.get());
      if (Math.abs(Robot.encoderFL.get()) < Math.abs(counts)) {
         Robot.drivetrain.frontLeftMotor(Speed);
      } else if (Math.abs(Robot.encoderFL.get()) > Math.abs(counts)+100) {
         Robot.drivetrain.frontLeftMotor(-Speed);
      } else {
         Robot.drivetrain.frontLeftMotor(0.0);
      }
   }

}
