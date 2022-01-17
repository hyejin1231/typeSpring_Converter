package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ipPort {

    private String ip;
    private int port;

    public ipPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
