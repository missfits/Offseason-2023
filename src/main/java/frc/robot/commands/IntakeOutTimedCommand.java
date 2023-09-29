package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.Constants.IntakeConstants;

import edu.wpi.first.wpilibj.Timer;


public class IntakeOutTimedCommand extends Command {
    private Intake m_intake;
    private Timer m_timer = new Timer();

    public IntakeOutTimedCommand(Intake intake){
        m_intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        System.out.println("INTAKE SPIT OUT COMMAND STARTED");
        m_timer.start();
    }  

    @Override
    public void execute() {
        m_intake.runIntakeMotor(IntakeConstants.INTAKE_MOTOR_SPEED_OUT);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.intakeOff();
        m_timer.stop();
        m_timer.reset();
    }

    @Override
    public boolean isFinished() {
        return m_timer.get() >= 5.0;
    }
}
