/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1.Logic.States;

/**
 *
 * @author iness
 */
public interface IEstado {

    IEstado up();
    IEstado down();

    String getName();
    
    boolean canGoUp();
    boolean canGoDown();
    
    IEstado erro();
    IEstado safeKey(int code);
}
