package br.com.ifpb.pod.solucao.chat1.loader;

import br.com.ifpb.pod.solucao.chat1.file.LoginFileHandler;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author DouglasGabriel
 */
public class Loader {

    public static void main(String[] args) throws IOException {
        LoginFileHandler loginFile = new LoginFileHandler();
        while (!loginFile.logout(JOptionPane.showInputDialog(null, "Digite seu nome:")));
    }
    
}
