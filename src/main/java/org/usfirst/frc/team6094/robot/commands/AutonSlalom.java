/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6094.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonSlalom extends CommandGroup {
  // Creates A To Do List Sequentially Or In Parallel
  // Always Have A Stop At the Start And End for Safety
  public AutonSlalom() {
  // EncoderCrab(+ GSpeed for right, - GSpeed for left);
  // PiToAngle(Inverted false for CCW, Inverted true for CW)
   addSequential(new YawResetCommand(), 0.5);
  
   //Turns should be correct ;)
   //Start
   addSequential(new EncoderDrive(1.0, .6), 3);
   addSequential(new PiToAngle(90, false), 3);

   addSequential(new EncoderDrive(1.0, .6), 3);
   addSequential(new PiToAngle(0, true), 3);

   //Long Drive
   addSequential(new EncoderDrive(4.0, .6), 5);
   addSequential(new PiToAngle(90, true), 3);

   //Square Left Side
   addSequential(new EncoderDrive(1.2, .6), 3);
   addSequential(new PiToAngle(0, false), 3);

   //Square Bottom Side
   addSequential(new EncoderDrive(1.0, .6), 3);
   addSequential(new PiToAngle(90, false), 3);

   //Square Right Side
   addSequential(new YawResetCommand(), 0.5);
   addSequential(new EncoderDrive(1.0, .6), 3);
   addSequential(new PiToAngle(90, false), 3);
  
   //Square Top Side
   addSequential(new YawResetCommand(), 0.5);
   addSequential(new EncoderDrive(1.2, .6), 3);
   addSequential(new PiToAngle(90, false), 3);



   //Square Left and Turn for Long Path 2
   addSequential(new EncoderDrive(1.2, .6), 3);
   addSequential(new PiToAngle(0, true), 3);


   //Long Drive 2
   addSequential(new EncoderDrive(4.4, .6), 5);
   addSequential(new PiToAngle(90, true), 3);

   //Ending
   addSequential(new EncoderDrive(1.4, .6), 3);
   addSequential(new PiToAngle(0, false), 3);
   addSequential(new EncoderDrive(.6, .6), 3);

   addSequential(new StopCommand(), 300000);
 }
}