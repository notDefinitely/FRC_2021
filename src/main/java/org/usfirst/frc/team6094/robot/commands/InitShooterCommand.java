package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class InitShooterCommand extends Command {
	// Refer To Stop Command About Implementation
	public InitShooterCommand() {
		requires(Robot.iscs);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.iscs.ShootAuton();
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