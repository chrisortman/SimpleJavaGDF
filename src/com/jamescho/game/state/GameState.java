package com.jamescho.game.state;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by k0808273 on 2/22/2017.
 */
public class GameState extends State {

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        Color bryantSaysThisAwesome = new Color(128,255,128);
        g.setColor(bryantSaysThisAwesome);
        g.setFont(new Font("Sans Serif",Font.PLAIN, 44));
        g.drawString("Awesome Game", 200,200);
    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {

    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
