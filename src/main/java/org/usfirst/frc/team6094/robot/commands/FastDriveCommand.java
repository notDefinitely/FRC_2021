package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FastDriveCommand extends Command {
	// Refer To Stop Command About Implementation
	public FastDriveCommand() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
	}

	protected void execute() {
		//Refer to DriveTrain.java
		Robot.drivetrain.fastAutonDrive();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.driveTrainStop();
	}

	protected void interrupted() {
		end();
	}
}