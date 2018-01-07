package com.yuan.ngu.springboot;

import com.alibaba.dubbo.config.annotation.Reference;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStudyWebApplication.class)
@WebAppConfiguration
@ComponentScan(basePackages={"com.yuan.ngu.springboot"})
public class RedisServiceTest {

    private TestRestTemplate template = new TestRestTemplate();

    @Reference
    private RedisService redisService;

    @Test
    public void setStr() {
        redisService.setStr("dashabi","大傻逼");
    }

    @Test
    public void testHttp(){
        String url = "http://localhost:"+8080+"/myspringboot/hello/info";
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("name", "Tom");
        map.add("name1", "Lily");
        String result = template.postForObject(url, map, String.class);
        System.out.println(result);
        assertNotNull(result);
        assertThat(result, Matchers.containsString("Tom"));
    }
}
