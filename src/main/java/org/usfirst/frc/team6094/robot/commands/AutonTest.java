/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6094.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonTest extends CommandGroup {
  // Creates A To Do List Sequentially Or In Parallel
  // Always Have A Stop At the Start And End for Safety
  public AutonTest() {
    
   addSequential(new YawResetCommand(), 0.5);
    addSequential(new PiToAngle(90, false), 5);
    addSequential(new StopCommand(), 300000);
  }
}