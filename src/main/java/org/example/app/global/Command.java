package org.example.app.global;

public class Command {

    String actionName;
    String paramKey;
    String paramValue;


    public Command(String cmd) {
        // 이름 = 차태진(key-value)
        String[] cmdBits = cmd.split("\\?"); // ["삭제", "id=1"]
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            paramValue = "";
            return;
        }

        String param = cmdBits[1];
        String[] paramBits = param.split("=");
        paramKey = paramBits[0];
        paramValue = paramBits[1];
    }

    public String getActionName() {
        return actionName;
    }

    public int getParam() {
        return Integer.parseInt(paramValue);
    }
}
