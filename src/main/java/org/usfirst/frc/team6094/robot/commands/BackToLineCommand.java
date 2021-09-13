package org.usfirst.frc.team6094.robot.commands;

import com.revrobotics.ColorMatch;
//import com.revrobotics.ColorMatchResult;
import org.usfirst.frc.team6094.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.util.Color;

public class BackToLineCommand extends Command {
	// Refer To Stop Command About Implementation.
	// All commands are structured in a similar manner.
	private final ColorMatch colorMatcher = new ColorMatch();
	private final Color White = ColorMatch.makeColor(0.35, 0.45, 0.19);
	private final Color NotWhite = ColorMatch.makeColor(.5, .5, .0);
	Boolean Trigger = false;

	public BackToLineCommand() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		colorMatcher.addColorMatch(White);
		colorMatcher.addColorMatch(NotWhite);
	}

	protected void execute() {
		/*
		// String initalizing Color
		Color detectedColor = Robot.colorSensor.getColor();
		String colorString;
		String SWhite = "White";

		ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);

		// If the color is white, set colorString = to White
		// If it is not white, set colorString = to Not White
		// In any other possible case, set colorString = to Unknown
		if (match.color == White) {
			colorString = "White";
		} else if (match.color == NotWhite) {
			colorString = "NotWhite";
		} else {
			colorString = "Unknown";
		}

		if (Trigger == false) {
			if (colorString.equals(SWhite)) {
				Robot.drivetrain.driveTrainStop();
				System.out.println("Red " + detectedColor.red);
				System.out.println("Green " + detectedColor.green);
				System.out.println("Blue " + detectedColor.blue);
				System.out.println(colorString);
				Trigger = true;
			} else {
				Robot.drivetrain.backAutonDrive();
				System.out.println(colorString);
			}
		} else {
			Robot.drivetrain.driveTrainStop();
		}
		*/
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