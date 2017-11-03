
package Game;

/* 
    set the position of user bullet

Author : Md.Faruk Hoaasin

*/
public class UserBullet implements Bullet{
    public static int bulletType = 13;
    Game Game =new Game();
  
    public void moveBullet(int x, int y)
    {

        Game.blockArray[x][y]=bulletType;
        System.out.println(Game.blockArray[x][y]);
    }
}
