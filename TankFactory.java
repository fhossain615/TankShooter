
package game;

import static game.UserTank.getInstance;


public class TankFactory {
    Tank tk;
    public Tank getTank(int tankX, int tankY, String direction, String tankType)
    {
        if(tankType=="user")
        {
            tk=getInstance(tankX, tankY, direction);

        }
        else if(tankType=="enemy")
        {
            tk=new EnemyTank(tankX,tankY,direction);

        }
        else if(tankType=="boss")
        {
            tk=new BossTank(tankX,tankY,direction);

        }
        return tk;
    }
}
