package logging;

import java.time.LocalDateTime;

public class MessageLogger {

    public void message(String msg){
        StringBuilder sb = new StringBuilder(LocalDateTime.now().toString()).append(" | ").append(msg);
        System.out.println(sb.toString());
    }

    public void message(Object msg){
        System.out.println(msg);
    }

}
