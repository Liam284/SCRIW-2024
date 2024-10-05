// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;

import static frc.robot.Constants.OperatorConstants.JOYSTICK_PORT;
// import frc.robot.subsystems.RobotContainer;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSystem.*;
import frc.robot.subsystems.DriveSystem;

public class DriveWithJoystick extends Command {

  DriveSystem drive;
  Joystick joy;
  
  private double x;
  private double y;
  private double z;
  /** Creates a new DriveWithJoystick. */
  public DriveWithJoystick(DriveSystem drive, Joystick joy) {
    addRequirements(drive);
    this.drive = drive;
    this.joy = joy;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    x = MathUtil.applyDeadband(joy.getX(), 0.18);
    y = MathUtil.applyDeadband(joy.getY(), 0.18);
    z = MathUtil.applyDeadband(joy.getZ(), 0.19);

    drive.drive(-x, y, -z);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    drive.drive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
