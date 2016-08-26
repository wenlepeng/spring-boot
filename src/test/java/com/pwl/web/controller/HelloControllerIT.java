package com.pwl.web.controller;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;

/**
 * User: hugo
 * Date: 16-8-25
 * Time: 下午4:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    @LocalServerPort
    private int port;

    private URL base;
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception{
        this.base = new URL("http://localhost:"+port+"/");
        template = new TestRestTemplate();
    }

    @Test
    public void getHello() throws Exception{
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        Assert.assertThat(response.getBody(), Matchers.equalTo("Greetings from Spring boot!"));
    }
}
