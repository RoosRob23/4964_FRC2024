package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LauncherSubsystem extends SubsystemBase {

  private CANSparkMax m_topMotor;
  private CANSparkMax m_bottomMotor;

  private double m_topPower;
  private double m_bottomPower;

  /** Creates a new LauncherSubsystem. */
  public LauncherSubsystem() {
    // create two new SPARK MAXs and configure them
    m_topMotor =
        new CANSparkMax(Constants.Launcher.kTopCanId, CANSparkLowLevel.MotorType.kBrushless);
    m_topMotor.setInverted(false);
    m_topMotor.setSmartCurrentLimit(Constants.Launcher.kCurrentLimit);
    m_topMotor.setIdleMode(IdleMode.kCoast);

    m_topMotor.burnFlash();

    m_bottomMotor =
        new CANSparkMax(Constants.Launcher.kBottomCanId, CANSparkLowLevel.MotorType.kBrushless);
    m_bottomMotor.setInverted(false);
    m_bottomMotor.setSmartCurrentLimit(Constants.Launcher.kCurrentLimit);
    m_bottomMotor.setIdleMode(IdleMode.kCoast);

    m_bottomMotor.burnFlash();

  }

  public void stopLauncher() {

    m_topMotor.set(0);
    m_bottomMotor.set(0);
  }

    /**
   * Set the power to spin the motor at. This only applies outside of position mode.
   *
   * @param _power The power to apply to the motor (from -1.0 to 1.0).
   */
  public void setPowerWithAmp(boolean isAmp) {
    if (isAmp) {
      m_topPower = Constants.Launcher.kTopAmpPower;
      m_bottomPower = Constants.Launcher.kBottomAmpPower;
    } else {
      m_topPower = Constants.Launcher.kTopPower;
      m_bottomPower = Constants.Launcher.kBottomPower;
    }
  }

  @Override
  public void periodic() { // this method will be called once per scheduler run
    // set the launcher motor powers based on whether the launcher is on or not

    // Code before the one above Incase it gives an error
    m_topMotor.set(m_topPower);
    m_bottomMotor.set(m_bottomPower);

  }
}
