
package game;


public class DisplaySubject extends Game{
    
    Display displayObject;

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
