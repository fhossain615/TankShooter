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
public class EnemyBullet implements Bullet{
    public static int bulletType = 111;
    BattleField field = new BattleField();
    public void moveBullet(int X, int Y)
    {
        field.blockArray[X][Y]=bulletType;
    }
}
