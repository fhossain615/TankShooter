
package game;

//import game.BattleField.blockArray;

/**
 *
 * @author Admin
 */
public class DisplaySubject extends Game{
    
    Display displayObject;
    
    //BattleField field = new BattleField();
    
    public void getUpdate()
    {
        
    }
    public void notifyAllObservers()
    {
        displayObject.updateData(score,lives,name);
        displayObject.updateBattleField(Game.blockArray);
        
    }
    public void show()
    {
        displayObject.showUpdate();
    }
    
}
