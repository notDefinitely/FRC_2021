package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBR;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFR;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderCrab extends Command {
	// Refer To Stop Command About Implementation
	// encoderResetRight and encoderResetLeft will either return True or False
	private Double GDistance;
	private Double GSpeed;
	private boolean encoderResetRight = false;
	private boolean encoderResetLeft = false;
	private ThreadForFL threadFL = new ThreadForFL();
	private ThreadForFR threadFR = new ThreadForFR();
	private ThreadForBL threadBL = new ThreadForBL();
	private ThreadForBR threadBR = new ThreadForBR();

	public EncoderCrab(Double Distance, Double Speed) {
		GDistance = Distance;
		// Distance is 2 to 1
		GSpeed = Speed;
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Robot.drivetrain.init();
		// set encoderReset to false and start the threads
		encoderResetRight = false;
		encoderResetLeft = false;
	
		Robot.encoderBR.reset();
		Robot.encoderFR.reset();
		Robot.encoderBL.reset();
		Robot.encoderFL.reset();

		Robot.encoderBR.setDistancePerPulse(1);
		Robot.encoderBL.setDistancePerPulse(1);

		// Sets the Thread in to a runnable state
		threadFL.start();
		threadFR.start();
		threadBL.start();
		threadBR.start();

	}

	protected void execute() {
		if (encoderResetRight == false) {
			Robot.encoderBR.reset();
			Robot.encoderFR.reset();
			encoderResetRight = true;
		}

		if (encoderResetLeft == false) {
			Robot.encoderBL.reset();
			Robot.encoderFL.reset();
			encoderResetLeft = true;
		}
		
		// Sets up the thread is gonna do
		// GSpeed: + for right, - for left
		threadBL.setSpeed(-GSpeed);
		threadBL.setDistance(GDistance);

		threadFL.setSpeed(GSpeed);
		threadFL.setDistance(GDistance);

		threadBR.setSpeed(GSpeed);
		threadBR.setDistance(GDistance);

		threadFR.setSpeed(-GSpeed);
		threadFR.setDistance(GDistance);

		threadFL.run();
		threadFR.run();
		threadBL.run();
		threadBR.run();

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		encoderResetRight = false;
		encoderResetLeft = false;

		Robot.encoderBR.reset();
		Robot.encoderFR.reset();
		Robot.encoderBL.reset();
		Robot.encoderFL.reset();

		threadFL.interrupt();
		threadFR.interrupt();
		threadBL.interrupt();
		threadBR.interrupt();
	}

	protected void interrupted() {
		end();
	}
}