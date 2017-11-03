
package Game;
/* 
    used as tank factory to call different type of tank

Author : Md.Faruk Hoaasin

*/
import static Game.UserTank.getInstance;


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
