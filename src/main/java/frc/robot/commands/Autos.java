// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(DriveSystem driveSystem) {
    return new RunCommand((() -> Flipper.flip(-.25)))
    .withTimeout(.1)
    .andThen(new RunCommand(() -> driveSystem.drive(Math.cos(Math.PI/4), Math.sin(Math.PI/4), 0)))
    .withTimeout(3);
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
