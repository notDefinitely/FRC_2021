/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6094.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonBarrel extends CommandGroup {
  // Creates A To Do List Sequentially Or In Parallel
  // Always Have A Stop At the Start And End for Safety
  public AutonBarrel() {
    // EncoderCrab(- GSpeed for right, + GSpeed for left);
    addSequential(new YawResetCommand(), .5);

    addSequential(new EncoderDrive(3.3, .6), 4);
    addSequential(new PiToAngle(0, false), 1.5);
    addSequential(new EncoderCrab(3.0, -0.6), 3);
    addSequential(new PiToAngle(0, false), 1.5);

    addSequential(new EncoderDrive(1.5, -.6), 3);
    addSequential(new PiToAngle(0, false), 1.5);
    addSequential(new EncoderCrab(2.7, 0.6), 3.5);
    addSequential(new PiToAngle(0, false), 1.5);

    addSequential(new EncoderDrive(6.0, .6), 4);
    addSequential(new PiToAngle(0, false), 1.5);
    addSequential(new EncoderCrab(2.4, 0.6), 3);
    addSequential(new PiToAngle(0, false), 1.5);

    addSequential(new EncoderDrive(1.9, -.6), 3);
    addSequential(new PiToAngle(0, false), 1);
    addSequential(new EncoderCrab(7.6, -0.6), 7);
    addSequential(new PiToAngle(0, false), 1.5);

    addSequential(new EncoderDrive(2.8, .6), 3);
    addSequential(new PiToAngle(0, false), 1.0);
    addSequential(new EncoderCrab(3.0, 0.6), 3);
    addSequential(new PiToAngle(0, false), 1.5);

    addSequential(new EncoderDrive(11.0, -.6), 10);

    addSequential(new StopCommand(), 300000);
  }
}