/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.util.PidConfig;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  public static PidConfig wheelPidConfig = new PidConfig(0.02, 0, 0, 2.5);
  public static PidConfig headingPidConfig = new PidConfig(0.0125, 0, 0, 2.0);

  public static double[] rightFrontLoc = { 12, 12 };
	public static double[] leftFrontLoc = { -12, 12 };
	public static double[] leftBackLoc = { -12, -12 };
	public static double[] rightBackLoc = { 12, -12 };
  public static double[] pivotLoc = {0,0};


  public static CANSparkMax rightFrontDrive = new CANSparkMax(7, MotorType.kBrushless);
  public static WPI_TalonSRX rightFrontTurn = new WPI_TalonSRX(5);
  // public static CANEncoder rightFrontDriveEncoder = ((CANSparkMax) rightFrontDrive).getEncoder();
  public static AnalogEncoder rightFrontTurnEncoder = new AnalogEncoder(new AnalogInput(0));

  public static CANSparkMax leftFrontDrive = new CANSparkMax(8, MotorType.kBrushless);
  public static WPI_TalonSRX leftFrontTurn = new WPI_TalonSRX(3);
  // public static CANEncoder leftFrontDriveEncoder = ((CANSparkMax) leftFrontDrive).getEncoder();
  public static AnalogEncoder leftFrontTurnEncoder = new AnalogEncoder(new AnalogInput(1));

  public static CANSparkMax leftBackDrive = new CANSparkMax(9, MotorType.kBrushless);
  public static WPI_TalonSRX leftBackTurn = new WPI_TalonSRX(1);
  // public static CANEncoder leftBackDriveEncoder = ((CANSparkMax) leftBackDrive).getEncoder();
  public static AnalogEncoder leftBackTurnEncoder = new AnalogEncoder(new AnalogInput(2));

  public static CANSparkMax rightBackDrive = new CANSparkMax(10, MotorType.kBrushless);
  public static WPI_TalonSRX rightBackTurn = new WPI_TalonSRX(2);
  // public static CANEncoder rightBackDriveEncoder = ((CANSparkMax) rightBackDrive).getEncoder();
  public static AnalogEncoder rightBackTurnEncoder = new AnalogEncoder(new AnalogInput(3));

  public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
