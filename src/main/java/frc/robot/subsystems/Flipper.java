// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
//import com.revrobotics.RelativeEncoder;
//import com.revrobotics.SparkPIDController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.DriveConstants.*;
import frc.robot.commands.MoveFlipperToPosition;
import frc.robot.Constants.DriveConstants;

public class Flipper extends SubsystemBase {

  private DutyCycleEncoder throughBore;
  private WPI_TalonSRX flipperMotor;

  //private RelativeEncoder flipperEncoder;
  private PIDController flipperPID;

  /** Creates a new Flipper. */
  public Flipper() {
    flipperMotor = new WPI_TalonSRX(DriveConstants.FLIPPER_ID);
    flipperMotor.setInverted(false);
    flipperMotor.setNeutralMode(NeutralMode.Brake);
  
    //flipperEncoder = flipperMotor.getEncoder();

    //change numbers later when testing
    flipperPID = new PIDController(0.045, 0.005, 0.000);

    //flipperPID.setP(0.0001);
    //flipperPID.setFF(0.5);
    //flipperPID.setSmartMotionAllowedClosedLoopError(100, 0);
    //flipperPID.setOutputRange(0, 5000);
    throughBore = new DutyCycleEncoder(9);
    // throughBore.setConnectedFrequencyThreshold(50);

    

  }

  // public Command flip(){
    
  // }
  public void flip(double speed){
      flipperMotor.set(speed);
    }
  public int getChannel()
  {
    return throughBore.getSourceChannel();
  }
public DutyCycleEncoder getthroughBore(){
  return throughBore;
}


  public void stop(){
    flipperMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Throughbore angle", throughBore.getAbsolutePosition());
    System.out.println(throughBore.isConnected());
  }
}
