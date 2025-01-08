package alura.challenge.fer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumericTextField extends JTextField {
    public NumericTextField(){
        this.addKeyListener(new KeyAdapter(){

            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();

                if(!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != '.'){
                    e.consume();
                }
            }
        });
    }
}
