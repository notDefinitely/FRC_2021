package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CrabRightCommand extends Command {
	// Refer To Stop Command About Implementation
	public CrabRightCommand() {
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.drivetrain.crabRight();
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