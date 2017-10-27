
package game;

import static game.Game.blockArray;

/**
 *
 * @author Admin
 */
public class DisplaySubject extends Game{
    
    Display displayObject;
    public void getUpdate()
    {
        
    }
    public void notifyAllObservers()
    {
        displayObject.updateData(score,lives,name);
        displayObject.updateBattleField(blockArray);
        
    }
    public void show()
    {
        displayObject.showUpdate();
    }
    
}
