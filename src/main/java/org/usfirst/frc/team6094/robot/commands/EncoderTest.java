package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForBR;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFL;
import org.usfirst.frc.team6094.robot.Thread.ThreadForFR;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderTest extends Command {
	// Refer To Stop Command About Implementation
	//encoderResetRight and encoderResetLeft will either return True or False
	boolean encoderResetRight = false;
	boolean encoderResetLeft = false;
	ThreadForFL threadFL = new ThreadForFL();
	ThreadForFR threadFR = new ThreadForFR();
	ThreadForBL threadBL = new ThreadForBL();
	ThreadForBR threadBR = new ThreadForBR();

	public EncoderTest() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		//set encoderReset to false and start the threads
		encoderResetRight = false;
		encoderResetLeft = false;

		threadBL.setSpeed(1.0);
		threadBL.setDistance(1);
		
		threadFL.setSpeed(1.0);
		threadFL.setDistance(1);

		threadBR.setSpeed(1.0);
		threadBR.setDistance(1);

		threadFR.setSpeed(1.0);
		threadFR.setDistance(1);

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
		// 2048 counts per rotation
		// Circumference of Wheel: .152pi m
		Robot.encoderBR.setDistancePerPulse(1);
		Robot.encoderBL.setDistancePerPulse(1);

		// https://stackoverflow.com/questions/8360099/how-to-run-two-for-loops-at-the-same-time
		// Possible we could math using .getRate() to adjust speed motors individually

		//Proceed to threadA and threadB
		//The threads allow us to run 2 different if/else statements at the same time
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
		Robot.drivetrain.driveTrainStop();
		encoderResetRight = false;
		encoderResetLeft = false;
		threadFL.interrupt();
		threadFR.interrupt();
		threadBL.interrupt();
		threadBR.interrupt();
	}

	protected void interrupted() {
		end();
	}
}