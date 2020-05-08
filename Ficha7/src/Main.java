import Logic.Data.Ball;
import Logic.Data.BlackBall;
import Logic.Data.WhiteBall;
import Logic.StateMac;
import UI.UIStateMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StateMac mach = new StateMac();
        /*mach.start();
        mach.bet();
        mach.bet(1);
        mach.bet();
        mach.bet();
        mach.bet(1);
        mach.exit();*/

        UIStateMachine ui = new UIStateMachine(mach);
        ui.waitStart();
    }
}
