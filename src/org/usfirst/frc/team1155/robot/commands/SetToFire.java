package org.usfirst.frc.team1155.robot.commands;

import org.usfirst.frc.team1155.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetToFire extends Command {

	private final double speed = 0.5;
	
    public SetToFire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.springSubsystem);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	springSubsystem.leftTalon.set(1);
    	springSubsystem.rightTalon.set(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(leftTalon.getDistance() >= springSubsystem.encMax){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	for (int i = leftTalon.getDistance(); i > springSubsystem.encMin; i++ ){
    		springSubsystem.leftTalon.set(-1);
    		springSubsystem.rightTalon.set(1);
    	}
    springSubsystem.leftTalon.set(0);
	springSubsystem.rightTalon.set(0);


    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
