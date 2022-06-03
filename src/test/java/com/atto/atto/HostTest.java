package com.atto.atto;


import com.atto.atto.domain.host.dto.request.HostNameAndIpDto;
import com.atto.atto.domain.host.entity.Host;
import com.atto.atto.domain.host.repository.HostRepositorySupport;
import com.mysema.commons.lang.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HostTest {

    @Autowired
    private HostRepositorySupport hostRepositorySupport;

    @Test
    @DisplayName("호스트 카운트 테스트")
    void HostCountTest(){
        assertNotEquals(100,hostRepositorySupport.checkCount());
    }

    @Test
    @DisplayName("호스트 ip 중복 체크")
    void ipDuplicate(){

        String ip = "172.30.1.53";
        assertEquals(0,hostRepositorySupport.countByIp(ip));
    }

    @Test
    @DisplayName("호스트 name 중복 체크")
    void nameDuplicate(){
        String name = "host";
        assertEquals(0,hostRepositorySupport.countByName(name));
    }

    @Test
    @DisplayName("호스트 save")
    void saveHost(){
        HostNameAndIpDto dto = new HostNameAndIpDto("host","172.30.1.53");
        Host host = Host.create(dto);
        assertNotNull(host);
    }
}
