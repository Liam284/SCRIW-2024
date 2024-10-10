// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Flipper;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import static frc.robot.Constants.AngleConstants.AMP_ANGLE;
import static frc.robot.Constants.AngleConstants.STARTING_ANGLE;
import static frc.robot.Constants.DriveConstants.*;

public class MoveFlipperToPosition extends Command {

  private PIDController pidController; 
  Flipper flipper;

  private double start; 
  private double end; 
  
  private double angle;
  private double current;

  private boolean movingToAmp;

  /** Creates a new RotateToAngle. */

  public MoveFlipperToPosition(double angle, Flipper flipper ) {
    // Use addRequirements() here to declare subsystem dependencies.

    this.angle = angle;
    this.flipper = flipper; 

    pidController = new PIDController(0.045,0 ,0.005);

    addRequirements(flipper);

    pidController.reset();
    pidController.setTolerance(2);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  pidController.enableContinuousInput(0, 360);
   
  start = STARTING_ANGLE;

  end = start + angle;
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double currentPosition = flipper.getthroughBore().getAbsolutePosition();
    double speed = pidController.calculate(currentPosition, angle);

    //speed = MathUtil.clamp(speed, -1, 1);

    movingToAmp = currentPosition < angle;

    pidController.setSetpoint(end);
    double rotationSpeed = pidController.calculate(currentPosition, end);

    //flipper.flip(rotationSpeed);

    //inspect??????
    movingToAmp = currentPosition >= angle;
    
    //make the angle a constant
    if (movingToAmp && currentPosition > angle){ 
      flipper.flip(speed);
      System.out.println(speed);
    }

    else if (!movingToAmp && currentPosition < angle){
      flipper.flip(speed);
      System.out.println(speed);
    }
    }

    

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  
    
  }

  // Returns true when the command should end
  @Override
  public boolean isFinished() {
    return (flipper.getthroughBore().getAbsolutePosition() >= angle - 0.01) && (flipper.getthroughBore().getAbsolutePosition() <= angle +0.01);
  }
}
