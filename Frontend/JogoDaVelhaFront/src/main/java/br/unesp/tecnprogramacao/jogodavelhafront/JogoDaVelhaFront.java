/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unesp.tecnprogramacao.jogodavelhafront;

import br.unesp.tecnprogramacao.jogodavelhafront.exceptions.ThemeException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author eteixeira
 */
public class JogoDaVelhaFront {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Não foi possível aplicar o FlatLaf");
            ThemeException(STR."Ocorreu um erro ao tentar iniciar o tema: \{e.getMessage(}");
        }
    }
}
