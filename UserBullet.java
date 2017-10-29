
package game;


public class UserBullet implements Bullet{
    public static int bulletType = 222;
    Game game =new Game();
  
    public void moveBullet(int x, int y)
    {
        game.blockArray[x][y]=bulletType;
    }
}
