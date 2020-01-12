/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.subsystems.SwerveSubsystem;

/**
 * An example command. You can replace me with your own command.
 */
public class SwerveDriveCommand extends CommandBase {
    private final SwerveSubsystem m_subsystem;
  private final BooleanSupplier m_fieldRelative;

  private final DoubleSupplier translationX;
  private final DoubleSupplier translationY;
  private final DoubleSupplier rotation;

  public SwerveDriveCommand(SubsystemBase sub, final BooleanSupplier fieldRelative,
      final DoubleSupplier translationX, final DoubleSupplier translationY, final DoubleSupplier rotation) {
    System.out.println(Robot.getInstance().swerveSubsystem == null);

    addRequirements(sub);
    this.m_subsystem = (SwerveSubsystem) sub;

    this.m_fieldRelative = fieldRelative;
    this.translationX = translationX;
    this.translationY = translationY;
    this.rotation = rotation;

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    m_subsystem.getPidController().reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (this.m_fieldRelative.getAsBoolean()) {
      // Gyro coords are continous so this restricts it to 360 degrees
      final double robotAngle = ((this.m_subsystem.getGyro().pidGet() % 360) + 360) % 360;
      // Temporary save of x and y pre-translation
      final double tempX = translationX.getAsDouble();
      final double tempY = translationY.getAsDouble();

      // Overwriting x and y
      final double leftStickX = (tempX * Math.cos(Math.toRadians(robotAngle)))
          - (tempY * Math.sin(Math.toRadians(robotAngle)));
      final double leftStickY = (tempX * Math.sin(Math.toRadians(robotAngle)))
          + (tempY * Math.cos(Math.toRadians(robotAngle)));
      m_subsystem.setTranslationVector(leftStickX, leftStickY);
      m_subsystem.setRotationVector(rotation.getAsDouble());
    } else {
      m_subsystem.setTranslationVector(translationX.getAsDouble(), translationY.getAsDouble());
      m_subsystem.setRotationVector(rotation.getAsDouble());
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // @Override
  // public void end() {
  //   //   m_subsystem.getPidController().disable();
  //     m_subsystem.setTranslationVector(0, 0);
  //     m_subsystem.setRotationVector(0);
  // }

  // // Called when another command which requires one or more of the same
  // // subsystems is scheduled to run
  // @Override
  // protected void interrupted() {
  //     end();
  // }
}