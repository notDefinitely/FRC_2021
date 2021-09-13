package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootCommand extends Command {
	// Refer To Stop Command About Implementation
	public ShootCommand() {
		requires(Robot.iscs);
		requires(Robot.fml);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.iscs.ShootAuton();
		Robot.fml.finalMotorGo();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.fml.finalMotorStop();
		Robot.iscs.ISCSStop();
	}

	protected void interrupted() {
		end();
	}
}