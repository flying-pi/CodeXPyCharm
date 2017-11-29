package com.rg.fpi.codex.models;


import com.intellij.openapi.components.PersistentStateComponent;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthInfo implements PersistentStateComponent<AuthInfo> {
    private final String url;
    private final String userID;

    public AuthInfo(String jsonString) throws JSONException {
        JSONObject obj = new JSONObject(jsonString);
        this.url = obj.getString("url");
        this.userID = obj.getString("user_id");
    }

    @Override
    public String toString() {
        return new StringBuilder().append("url:\t").append(url).append("\nid:\t\t").append(userID).toString();
    }

    @Nullable
    @Override
    public AuthInfo getState() {
        return this;
    }

    @Override
    public void loadState(AuthInfo authInfo) {

    }
}
