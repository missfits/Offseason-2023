package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

import frc.robot.Constants.IntakeConstants;

public class PivotDownCommand extends Command{
    private Intake m_intake;

    public PivotDownCommand(Intake intake){
        m_intake = intake;
    }

    @Override
    public void initialize() {
        m_encoderStart = m_intake.getPivotEncoderPosition();
    }  

    @Override
    public void execute() {
        m_intake.runPivotIntakeMotor(IntakeConstants.PIVOT_MOTOR_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.pivotMotorOff();
    }

    @Override
    public boolean isFinished() {
        return m_intake.getPivotEncoderPosition() >= m_encoderStart + IntakeConstants.PIVOT_DELTA;
        // return m_intake.getPivotEncoderPosition() >= IntakeConstants.PIVOT_DOWN_POSITION;
    }
}
