
package Game;

/* 
    a observer for display but not been used

Author : Md.Faruk Hoaasin

*/
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
