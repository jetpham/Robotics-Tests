/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  private TalonSRX[] driveMotors ={
    new TalonSRX(Constants.leftFrontDriveMotor),
    new TalonSRX(Constants.leftRearDriveMotor),
    new TalonSRX(Constants.rightFrontDriveMotor),
    new TalonSRX(Constants.rightRearDriveMotor)
  };


  public DriveTrain(){
    for (TalonSRX motor : driveMotors){
      motor.configFactoryDefault();
      motor.setNeutralMode(NeutralMode.Coast);
    }
    driveMotors[3].set(ControlMode.Follower, driveMotors[2].getDeviceID());
    driveMotors[1].set(ControlMode.Follower, driveMotors[0].getDeviceID());

    driveMotors[0].setInverted(true);
    driveMotors[1].setInverted(true);
    driveMotors[3].setInverted(false);
    driveMotors[2].setInverted(false);
  }

  public void setDriveOutput(double leftoutput, double rightoutput){
    driveMotors[2].set(ControlMode.PercentOutput, rightoutput);
    driveMotors[0].set(ControlMode.PercentOutput, leftoutput);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
  }
}
