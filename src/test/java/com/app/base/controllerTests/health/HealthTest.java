package com.app.base.controllerTests.health;

import static org.assertj.core.api.Assertions.assertThat;

import com.app.base.controllers.health.Health;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthTest {

    @Value(value="${local.server.port}")
    private int port;
    @Autowired
    private Health health;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(health).isNotNull();
    }

    @Test
    public void healthChecks() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/healthInfo", String.class))
                .contains("All Good");
    }
}
