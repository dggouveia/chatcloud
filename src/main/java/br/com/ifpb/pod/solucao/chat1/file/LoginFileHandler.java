package br.com.ifpb.pod.solucao.chat1.file;

import br.com.ifpb.pod.solucao.chat1.properties.PropertiesHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DouglasGabriel
 */
public class LoginFileHandler {

    public boolean login(String userName) throws IOException {
        String users = recuperarUsuarios();
        if (isNameValid(userName, users)) {
            escreverUserName(userName);
            return true;
        }
        return false;
    }

    public boolean logout(String userName) {
        try {
            String users = recuperarUsuarios();
            users = apagarUserName(users, userName);
            zerarAquivo();
            escreverUsersNames(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String recuperarUsuarios() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(PropertiesHandler.getInstance().getProperty("loginfile"));
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                sb.append(br.readLine() + "\n");
            }
            br.close();
            return sb.toString();
        }
        return null;
    }

    private boolean isNameValid(String userName, String users) {
        for (String s : users.split("\n")) {
            if (s.equals(userName)) {
                return false;
            }
        }
        return true;
    }

    private void escreverUserName(String userName) throws IOException {
        File file = new File(PropertiesHandler.getInstance().getProperty("loginfile"));
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.append(userName + "\n");
        bw.close();
    }

    private String apagarUserName(String users, String userName) {
        return users.replace(userName + "\n", "");
    }

    private void zerarAquivo() throws IOException {
        File file = new File(PropertiesHandler.getInstance().getProperty("loginfile"));
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    private void escreverUsersNames(String users) throws IOException {
        for (String user : users.split("\n")) {
            escreverUserName(user);
        }
    }

}
