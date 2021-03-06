package com.terrabats.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "TerraOp: Test")
public class TerraOp extends OpMode{
    //All RobotParts
    TerraBot robot = new TerraBot();

    @Override
    public void init() {

        robot.init(hardwareMap);

        telemetry.addData("", "Press Start");
        telemetry.update();
    }
    @Override
    public void init_loop(){
    }
    @Override
    public void start() {
    }
    @Override
    public void loop() {
        if(gamepad1.left_bumper){
            robot.out(0);
        }
        if(gamepad1.right_bumper) {
            robot.out(180);
        }

        robot.intakeLift(gamepad2.right_stick_y);
        robot.intake(gamepad2.left_stick_y);
        robot.move(gamepad1.right_stick_y, gamepad1.left_stick_x);

        if(gamepad1.left_trigger > 0) {
            robot.lift(0.5);
        }else if(gamepad1.right_trigger > 0) {
            robot.lift(-0.5);
        }else{
            robot.lift(0);
        }

    }
    @Override
    public void stop() {
    }

}
