package org.usfirst.frc.team6094.robot.commands;

import org.usfirst.frc.team6094.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PiToAngle extends Command {
	private Integer GAngle;
	private boolean autonRunning;
	private boolean Inverted;

	public PiToAngle(Integer Angle, boolean Reversed) {
		Inverted = Reversed;
		GAngle = -Angle;

		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Robot.drivetrain.init();
	}

	protected void execute() {
		// This fixs the problems with double prints,
		// not properly closing auton programs
		// and make sure we dont move while reseting yaw
		autonRunning = true;
	/*	
		if (autonRunning == true && Robot.ahrs.isCalibrating() == false) {
		System.out.printf("Angle, " + Robot.ahrs.getYaw());
		if (Robot.ahrs.getYaw() > GAngle + 2) {
			Robot.drivetrain.tCounterClockwise();
			System.out.println("Counterclosewise");
		} else if (Robot.ahrs.getYaw() < GAngle - 2 || Robot.ahrs.getYaw() > 1) {
			Robot.drivetrain.tClockwise();
			System.out.println("Clockwise");
		} else {
			System.out.println("Stop");
			Robot.drivetrain.driveTrainStop();
		}
*/
		// Its something with PiToAngle in this turn correction
		if (autonRunning == true && Robot.ahrs.isCalibrating() == false) {
			if (Inverted == false) {
				System.out.printf("Angle, " + Robot.ahrs.getYaw());
				if (Robot.ahrs.getYaw() > GAngle + 2) {
					Robot.drivetrain.tCounterClockwise();
					System.out.println("Counterclosewise");
				} else if (Robot.ahrs.getYaw() < GAngle - 2 || Robot.ahrs.getYaw() > 1) {
					Robot.drivetrain.tClockwise();
					System.out.println("Clockwise");
				} else {
					System.out.println("Stop");
					Robot.drivetrain.driveTrainStop();
				}
			} else {
				System.out.printf("Angle, " + Robot.ahrs.getYaw());
				if (Robot.ahrs.getYaw() < -GAngle - 2) {
					Robot.drivetrain.tClockwise();
					System.out.println("Closewise");
				} else if (Robot.ahrs.getYaw() > GAngle + 2 || Robot.ahrs.getYaw() < -1) {
					Robot.drivetrain.tCounterClockwise();
					System.out.println("CounterClockwise");
				} else {
					System.out.println("Stop");
					Robot.drivetrain.driveTrainStop();
				}
			}
			
			
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		autonRunning = false;
		Robot.encoderBR.reset();
		Robot.encoderFR.reset();
		Robot.encoderBL.reset();
		Robot.encoderFL.reset();
	}

	protected void interrupted() {
		end();
	}

}