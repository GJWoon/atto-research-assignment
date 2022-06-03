package com.atto.atto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import static org.junit.jupiter.api.Assertions.*;

public class AliveTest {

    @Test
    @DisplayName("ip alive 테스트")
     void ipAlive() throws IOException {
        InetAddress pingCheck = InetAddress.getByName("172.30.1.53");
        assertTrue(pingCheck.isReachable(1000));
    }

}
