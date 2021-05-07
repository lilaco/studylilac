package com.studylilac.account;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureWebClient 또는 @AutoConfigureWebTestClient 를 Annotation 을 사용하여 View test 도 가능.

class AccountControllerTest {

    @Autowired private MockMvc mockMvc;

    @DisplayName("회원 가입 화면 보이는지 테스트")
    @Test
    void signUpForm() throws Exception {
        mockMvc.perform(get("/sign-up"))
                .andDo(print())
                //andDo(print()) 를 통하여 View 까지도 test 가능하다 (test message 에 HTML log 로 남는다.)
                .andExpect(status().isOk())
                .andExpect(view().name("account/sign-up"))
                .andExpect(model().attributeExists("signUpForm"));

        //MockMvc 를 이용하여 테스트를 실시
        //status() -> HTTP 상태 코드를 검증한다.
        //view() -> 컨트롤러가 반환한 뷰 이름을 검증한다.
    }

}