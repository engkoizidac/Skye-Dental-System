/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.global.helper;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author EngkoiZidac
 */
public class TextFieldSelectAllFunction {

    public void Inject(final JFormattedTextField TxtField) {
        TxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        TxtField.selectAll();
                    }
                });
            }
        });
    }
    
    public void Inject2(final JTextField TxtField) {
        TxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        TxtField.selectAll();
                    }
                });
            }
        });
    }
}
