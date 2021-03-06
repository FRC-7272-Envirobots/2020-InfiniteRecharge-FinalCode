// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.DropLift;
import frc.robot.commands.FalconPowerDown;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftUp;
import frc.robot.commands.LimeLightDrive;
import frc.robot.commands.FalconTest;
import frc.robot.commands.TestLimeLight;
import frc.robot.commands.TestRevEncoder;
import frc.robot.commands.ToggleLift;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Encoders;
import frc.robot.subsystems.Falcon500Test;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  Joystick joystick = new Joystick(0);
  
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain;
  private final Lift lift;
  private final LimeLight limeLight;
  private final Falcon500Test falconTest;
  private final Encoders encoders;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Might not need this?
    //Compressor compressor = new Compressor(0);

    lift = new Lift();
    drivetrain = new Drivetrain();
    limeLight = new LimeLight();
    falconTest = new Falcon500Test();
    encoders = new Encoders(Robot.Encoder);
    DefaultDrive defaultDrive = new DefaultDrive(drivetrain, joystick);

    // Configure the button bindings
    drivetrain.setDefaultCommand(defaultDrive);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton button1 = new JoystickButton(joystick, 1);
    JoystickButton button2 = new JoystickButton(joystick, 2);
    JoystickButton button7 = new JoystickButton(joystick, 7);
    JoystickButton button8 = new JoystickButton(joystick, 8);
    JoystickButton button9 = new JoystickButton(joystick, 9);
    JoystickButton button10 = new JoystickButton(joystick, 10);
    JoystickButton button11 = new JoystickButton(joystick, 11);
    JoystickButton button12 = new JoystickButton(joystick, 12);

    button1.whenPressed(new DropLift(lift).withTimeout(15));
    button2.whenPressed(new ToggleLift(lift));
    button7.whenHeld(new LimeLightDrive(drivetrain, limeLight));
    button8.whenHeld(new TestLimeLight(limeLight));
    button9.whenHeld(new FalconTest(falconTest)).whenReleased(new FalconPowerDown(falconTest));
    button10.whenPressed(new TestRevEncoder(encoders));
    button11.whenHeld(new LiftDown(lift));
    button12.whenHeld(new LiftUp(lift));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    return null;
  }
}
