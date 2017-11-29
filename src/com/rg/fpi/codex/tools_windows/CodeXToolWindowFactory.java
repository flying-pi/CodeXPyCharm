package com.rg.fpi.codex.tools_windows;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.rg.fpi.codex.models.AuthInfo;
import org.json.JSONException;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

public class CodeXToolWindowFactory implements ToolWindowFactory {
    private JTextArea tokenTextArea;
    private JPanel content;
    private JLabel authLabel;
    private JButton authButton;
    private ToolWindow window;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        this.window = toolWindow;
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(this.content, "", false);
        toolWindow.getContentManager().addContent(content);
        this.authButton.addActionListener(e -> {
            this.auth();
        });
    }

    private void auth() {
        String token = tokenTextArea.getText();
        String decodeToken = new String(Base64.getDecoder().decode(token));
        try {
            AuthInfo authInfo = new AuthInfo(decodeToken);
            System.out.println(authInfo);
        } catch (JSONException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(content, "Invalid token");
        }

    }

    @Override
    public void init(ToolWindow window) {

    }

    @Override
    public boolean shouldBeAvailable(@NotNull Project project) {
        return false;
    }

    @Override
    public boolean isDoNotActivateOnStart() {
        return false;
    }
}
