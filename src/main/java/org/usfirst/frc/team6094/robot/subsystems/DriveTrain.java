package org.usfirst.frc.team6094.robot.subsystems;

import java.lang.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.interfaces.Gyro;

import org.usfirst.frc.team6094.robot.Robot;
import org.usfirst.frc.team6094.robot.commands.Teleop;

//Here, we are creating the motors to be used in the code
@SuppressWarnings("unused")
public class DriveTrain extends Subsystem {

	//We are naming the motor plugged into port 0.
	//Since this motor is the front left motor, we name it frontLeft.
	//Same for other motors.
	//Will be different depending on the motor type. This one is using VictorSP motors.
	VictorSP frontLeft = new VictorSP(0);

	VictorSP frontRight = new VictorSP(1);

	VictorSP backLeft = new VictorSP(2);

	VictorSP backRight = new VictorSP(3);

	public Encoder encoderLift = new Encoder(0, 1, false, Encoder.EncodingType.k4X);

	public void initDefaultCommand() {
		setDefaultCommand(new Teleop());
	}

	//Macanum drive stuff
	public void init() {
		frontLeft.setInverted(false);
		frontRight.setInverted(false);
		backLeft.setInverted(false);
		backRight.setInverted(false);
	}

	// DriveTrain functions
	public void mecanumDrive(Joystick Joy) {
		frontLeft.setInverted(true);
		frontRight.setInverted(true);
		backLeft.setInverted(false);
		backRight.setInverted(true);

		double x = 0;
		double y = 0;
		double z = 0;

		//x is the joystick's horizontal position
		//y is the joystick's vertical position
		//z is the joystick's rotation.
		x = Joy.getRawAxis(0);
		y = -(Joy.getRawAxis(1));
		//small buffer so that the robot won't turn until you turn the joystick past this value
		if (java.lang.Math.abs(Joy.getRawAxis(2)) > .3) {
			z = Joy.getRawAxis(2);
		} else {
			z = 0;
		}

		//Depending on the values of x, y, and z determined by the joystick...
		//...the robot will move in a certain manner.
		//Otherwise, the robot will stay still.
		if (java.lang.Math.abs(x) > 0.2 || java.lang.Math.abs(y * .3) > 0.1 || java.lang.Math.abs(z) > 0.2) {
			frontLeft.set((x + y + z) * .8);
			frontRight.set((-x + y - z) * .8);
			backLeft.set((-x + y + z) * .8);
			backRight.set((x + y - z) * .8);
		} else {
			frontLeft.set(0);
			frontRight.set(0);
			backLeft.set(0);
			backRight.set(0);
		}
	}


	public void frontRightMotor(Double Power) {
		frontRight.set(Power);
	}

	public void backRightMotor(Double Power) {
		backRight.set(Power);
	}

	public void frontLeftMotor(Double Power) {
		frontLeft.set(Power);
	}

	public void backLeftMotor(Double Power) {
		backLeft.set(Power);
	}

	//Robot drives forward (fast)
	//changing the value in frontLeft.set(value); affects the speed
	//use Robot.drivetrain.driveTrainStop();
	//The same pattern applies to the other functions

	public void driveTrainStop() {
		frontLeft.set(0);
		frontRight.set(0);
		backLeft.set(0);
		backRight.set(0);
	}

	public void tCounterClockwise() {
		frontLeft.set(.3);
		frontRight.set(-.3);
		backLeft.set(-.3);
		backRight.set(-.3);
	}

	public void tClockwise() {
		frontLeft.set(-.3);
		frontRight.set(.3);
		backLeft.set(.3);
		backRight.set(.3);
	}
}