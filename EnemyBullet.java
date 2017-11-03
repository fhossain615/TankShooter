
package Game;

/* 
    set the position of enemy bullet
Author : Md.Faruk Hoaasin

*/
public class EnemyBullet implements Bullet{
    public static int bulletType = 15;
     
    public void moveBullet(int x, int y)
    {
        Game.blockArray[x][y]=bulletType;
        System.out.println("move");
    }
}
