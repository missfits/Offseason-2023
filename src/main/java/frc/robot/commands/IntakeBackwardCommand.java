package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.IntakeConstants;


public class IntakeBackwardCommand extends Command {
    private Intake m_intake;

    public IntakeBackwardCommand(Intake intake){
        m_intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        System.out.println("INTAKE SPIT COMMAND STARTED");
    }  

    @Override
    public void execute() {
        m_intake.runIntakeMotor(IntakeConstants.INTAKE_MOTOR_SPEED_BACKWARD);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.intakeOff();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
