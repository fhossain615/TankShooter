/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Admin
 */
public class UserBullet implements Bullet{
    public static int bulletType = 222;
    Game gm = new Game();
    public void moveBullet(int X, int Y)
    {
        gm.blockArray[X][Y]=bulletType;
    }
}
