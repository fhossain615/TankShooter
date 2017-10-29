
package game;


public class EnemyBullet implements Bullet{
    public static int bulletType = 111;
    Game game =new Game();
    
    public void moveBullet(int x, int y)
    {
        game.blockArray[x][y]=bulletType;
    }
}
