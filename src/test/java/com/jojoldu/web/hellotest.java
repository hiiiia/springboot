package com.jojoldu.web;

import com.jojoldu.hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;///이거 들어가니까 ㅇㅋ


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = hello.class)

public class hellotest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
    @Test
    public void hellodto_리턴() throws Exception {
        String name = "test";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name",name)
                        .param("amount", String.valueOf(amount)))
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.name",is(name)))
                            .andExpect(jsonPath("$.amount",is(amount)));

    }
}
