/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  PWMVictorSPX m_rearRight= new PWMVictorSPX(0);  
  PWMVictorSPX m_rearLeft =new PWMVictorSPX(1);
  PWMVictorSPX m_frontRight= new PWMVictorSPX(2);
  PWMVictorSPX m_frontLeft =new PWMVictorSPX(3);
  PWMVictorSPX shootmotor = new PWMVictorSPX(4);

  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  DifferentialDrive tank = new DifferentialDrive(m_right, m_left);

  private final Joystick m_stick = new Joystick(0);


  private final Timer m_timer = new Timer();

  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
  }
  @Override
  public void autonomousInit() 
  {
    m_timer.reset();
    m_timer.start();
  }
/**
   * This function is called periodically during autonomous.
   * Uses the timer function- this particular code should set autonomous 
   * mode for 3 seconds and then the robot should drive forward. 
   */
  @Override
  public void autonomousPeriodic() 
  {/*
    // Drive for 3 seconds
    if (m_timer.get() < 3.0) 
    {
    
    tank.tankDrive(0.25, 0.25); // drive forwards half speed
    } 
    else 
    {
      m_drive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
*/}
@Override
  public void teleopInit() 
  {
    
  }
  /**
   * This function is called periodically during teleoperated mode.
   */
  @Override
  public void teleopPeriodic() 
  {
    tank.setSafetyEnabled(true);
    tank.tankDrive(m_stick.getRawAxis(1), m_stick.getRawAxis(5));

    DoubleSolenoid ee2 = new DoubleSolenoid(4,5);
    DoubleSolenoid eeShoot = new DoubleSolenoid(6,7);
    DoubleSolenoid led = new DoubleSolenoid(2,3);
    if(m_stick.getRawButton(3))
    {
      shootmotor.set(-.7);
    }
    else if(m_stick.getRawButton(4))
    {
      shootmotor.set(7);
    }
    else
    {
      shootmotor.set(0);
    }
    if(m_stick.getRawButton(5))
    {
      ee2.set(DoubleSolenoid.Value.kForward);
    }
    else if (m_stick.getRawButton(6)) 
    {
      ee2.set(DoubleSolenoid.Value.kReverse);
    }
    else
    {
      ee2.set(DoubleSolenoid.Value.kOff);
    }
    if(m_stick.getRawButton(1))
    {
      eeShoot.set(DoubleSolenoid.Value.kForward);
    }
    else if (m_stick.getRawButton(2))
    {
      eeShoot.set(DoubleSolenoid.Value.kReverse);
    }
    else
    {
      eeShoot.set(DoubleSolenoid.Value.kOff);
    }
    if(m_stick.getRawButton(10))
    {
      led.set(DoubleSolenoid.Value.kForward);
    }
  
    ee2.close();
    eeShoot.close();
    led.close();
  }

  /**
   * This function is called periodically during test mode.Test mode will be activated for 7 seconds.
   * The ball launcher should activate and spin for 1 second. The robot should then drive forward at half speed.
   * The elevator should rise (removed due to a problem with the air compressor), and then thr robot should drive forward again.
*/
@Override
  public void testPeriodic() 
  {/*
    if (m_timer.get() < 7.0) 
    {
      if(m_timer.get() >0.0 && m_timer.get() <1.0)
      {
        if(m_timer.get() <0.99)
        {
        shootmotor.set(0.2);
        }
        else{
        shootmotor.set(0);
        }
      }
      if(m_timer.get() >2.0 && m_timer.get() <3.0)
      {
      m_drive.arcadeDrive(0.5, 0.0); // drive forward half speed
      }
      if(m_timer.get() > 3.0 && m_timer.get() < 4.0)
      {
        //Removed Double Solenoid test
      }
      if(m_timer.get() >4.0 && m_timer.get() <7.0)
      {
      m_drive.arcadeDrive(0.5, 0.0); // drive forward half speed
      }
    } 
    else 
    {
      m_drive.stopMotor(); // stop robot
    }
  }*/
}
}
