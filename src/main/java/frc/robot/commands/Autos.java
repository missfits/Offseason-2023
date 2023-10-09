// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.*;
import frc.robot.Constants.AutoConstants;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static Command taxiAuto(Drivetrain drivetrain) {
    return new DistanceDriveCommand(drivetrain, -AutoConstants.TAXI_AUTO_TARGET_DISTANCE);
  }

  public static Command shootTaxiAuto(Intake intake, Drivetrain drivetrain) {
    return Commands.sequence(new PivotDownCommand(intake), new IntakeOutTimedCommand(intake, AutoConstants.INTAKE_TIME), Commands.parallel(
        new PivotUpCommand(intake), new DistanceDriveCommand(drivetrain, -AutoConstants.TAXI_AUTO_TARGET_DISTANCE)));
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
