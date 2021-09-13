package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LoadCommand extends Command {
	// Refer To Stop Command About Implementation
	public LoadCommand() {
		requires(Robot.iscs);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.iscs.ShootAuton();
		Robot.iscs.EverythingElse();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.iscs.ISCSStop();
	}

	protected void interrupted() {
		end();
	}
}