package com.jamescho.game.state;

import com.jamescho.game.main.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by cortman on 2/19/17.
 */
public class MenuState extends State {

    private Character[] correctLetters = new Character[] { 'D', 'O', 'G'};
    private int nextLetterIdx = 0;
    private int wrongGuesses = 0;

    private ArrayList<Character> enteredChars = new ArrayList<>();

    @Override
    public void init() {
        System.out.println("Entered MenuState");
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 44));

        if ( enteredChars.size() == 0) {
            g.drawImage(Resources.welcome, 0, 0, null);
        } else {
            String s = "";
            for(Character c : enteredChars) {
                s += c;
            }
            g.drawString(s, 10, 50);
        }

        int personStartX = 600;
        if ( wrongGuesses >= 1) {
            g.drawOval(personStartX, 75, 40, 40);
        }

        if (wrongGuesses >= 2) {
            g.drawLine(personStartX + 20, 75 + 40, personStartX + 20, 95 + 80);
        }

        if (wrongGuesses >= 3) {
            g.drawLine(personStartX + 20 - 50, 75 + 40 + 30, personStartX + 20 + 50, 75 + 40 + 30);
        }

        if (wrongGuesses >= 4) {
            g.drawLine(personStartX + 20, 95 + 80, personStartX + 20 - 30, 95 + 80 + 70);
        }

        if (wrongGuesses >= 5) {
            g.drawLine(personStartX + 20, 95 + 80, personStartX + 20 + 30, 95 + 80 + 70);
        }

    }

    @Override
    public void onClick(MouseEvent e) {

    }

    @Override
    public void onKeyPress(KeyEvent e) {
        if (wrongGuesses == 5) {
            return;
        }

        if (Character.isAlphabetic(e.getKeyChar())) {
            Character guess = Character.toUpperCase(e.getKeyChar());
            Character nextLetter = correctLetters[nextLetterIdx];

            if (Objects.equals(guess, nextLetter)) {
                nextLetterIdx++;

                if (nextLetterIdx > 2) {
                    setCurrentState(new WinState());
                }
            } else {
                wrongGuesses++;
            }

            enteredChars.add(guess);
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
