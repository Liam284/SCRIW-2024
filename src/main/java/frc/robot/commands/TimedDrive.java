package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

//this file is the problem child!! 
public class TimedDrive extends Command {
  private static DriveSystem driveSystem;
  private double Y;

  private double Z;


  /**
   * Creates a new AutoMove.
   */
  public TimedDrive(double y) {
    Y = y;
    driveSystem = DriveSystem(); //The method DriveSystem() is undefined for the type TimedDriveJava(67108964)
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveSystem.drive(0,1,0); //Cannot make a static reference to the non-static method drive(double, double, double) from the type DriveSystemJava(603979977)
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSystem.stopDrive(); //Cannot make a static reference to the non-static method stopDrive() from the type DriveSystemJava(603979977)
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}