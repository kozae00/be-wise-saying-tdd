package org.example.app.global;

import java.util.HashMap;
import java.util.Map;

public class Command {

    String actionName;
    Map<String, String> paramMap;


    public Command(String cmd) {

        paramMap = new HashMap<>();
        // 이름 = 차태진(key-value)
        String[] cmdBits = cmd.split("\\?"); // ["삭제", "id=1"]
        actionName = cmdBits[0];

        if(cmdBits.length < 2) {
            return;
        }

        // key1=val1&key2=val2
        String queryString = cmdBits[1];

        // ["key1=val1", "key2=val2"]
        String[] params = queryString.split("&");

        for(String param : params) {
            String[] paramBits = param.split("=", 2);

            if(paramBits.length < 2) {
                continue;
            }
            paramMap.put(paramBits[0], paramBits[1]);
        }
        // "=" 기준으로 key value가 나뉘기 때문에,
        // "&" 기준으로 나눌 수 있도록 설계.

    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key) {
        return paramMap.get(key);
    }

    public int getParamAsInt(String key) {
        try {
            String pram = paramMap.get(key);
            return Integer.parseInt(pram);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
