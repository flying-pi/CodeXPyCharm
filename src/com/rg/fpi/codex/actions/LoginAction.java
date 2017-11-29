package com.rg.fpi.codex.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class LoginAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        System.out.println("hello");
    }
    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setEnabledAndVisible(true);
    }

}
