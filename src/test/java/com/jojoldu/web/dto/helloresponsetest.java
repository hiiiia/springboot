package com.jojoldu.web.dto;

import com.jojoldu.dto.helloresponse;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class helloresponsetest {

    @Test
    public void 롬복_테스트() {
        //given
        String name = "test";
        int amount = 1000;
        //when
        helloresponse dto = new helloresponse(name,amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);//
        assertThat((dto.getAmount())).isEqualTo(amount);
    }
}
