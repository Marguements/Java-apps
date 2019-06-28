//Mathew Argue
//MyDieRoll Class

import java.util.Random;

public class MyDieRoll implements IDieRoll {

    MyDieRoll()
    {}

    @Override
    public int getDieRoll(int diesize) {
        Random r = new Random();
        return r.nextInt((diesize + 1)-minDieSize) + minDieSize;
    }


}
