package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBR;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFR;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {
	// Refer To Stop Command About Implementation
	// encoderResetRight and encoderResetLeft will either return True or False
	private Double GMeters;
	private Double GSpeed;
	private boolean encoderResetRight = false;
	private boolean encoderResetLeft = false;
	private ThreadForFL threadFL = new ThreadForFL();
	private ThreadForFR threadFR = new ThreadForFR();
	private ThreadForBL threadBL = new ThreadForBL();
	private ThreadForBR threadBR = new ThreadForBR();

	public EncoderDrive(Double Meters, Double Speed) {
		GMeters = Meters;
		GSpeed = -Speed;
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
		// .0254 x measurement in inches = measurement in m

		// Sets up the thread is gonna do
		System.out.println(GMeters);
		threadBL.setSpeed(GSpeed);
		threadBL.setDistance(GMeters*1.64);

		threadFL.setSpeed(GSpeed);
		threadFL.setDistance(GMeters*1.64);
		
		threadBR.setSpeed(GSpeed);
		threadBR.setDistance(GMeters*1.64);

		threadFR.setSpeed(GSpeed);
		threadFR.setDistance(GMeters*1.64);

		// Starts the threads
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