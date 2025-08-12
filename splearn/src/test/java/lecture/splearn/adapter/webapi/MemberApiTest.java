package lecture.splearn.adapter.webapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lecture.splearn.adapter.webapi.dto.MemberRegisterResponse;
import lecture.splearn.application.member.provided.MemberRegister;
import lecture.splearn.application.member.required.MemberRepository;
import lecture.splearn.domain.member.Member;
import lecture.splearn.domain.member.MemberFixture;
import lecture.splearn.domain.member.MemberRegisterRequest;
import lecture.splearn.domain.member.MemberStatus;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.assertj.MvcTestResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@RequiredArgsConstructor
@Import(TestSecurityConfig.class)
public class MemberApiTest {

    final MockMvcTester mvcTester;
    final ObjectMapper objectMapper;
    final MemberRepository memberRepository;
    final MemberRegister memberRegister;

    @Test
    void register() throws JsonProcessingException, UnsupportedEncodingException {
        MemberRegisterRequest request = MemberFixture.createMemberRegisterRequest();
        MvcTestResult result = mvcTester.post()
                .uri("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)).exchange();
        assertThat(result)
                .hasStatusOk()
                .bodyJson().hasPathSatisfying("$.memberId", value -> assertThat(value).isNotNull())
                .hasPathSatisfying("$.email", value -> assertThat(value).isEqualTo(request.email()));

        MemberRegisterResponse response = objectMapper.readValue(result.getResponse().getContentAsString(), MemberRegisterResponse.class);

        Member member = memberRepository.findById(response.memberId()).orElseThrow();
        assertThat(member.getEmail().address()).isEqualTo(request.email());
        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void duplicateEmail() throws JsonProcessingException {
        memberRegister.register(MemberFixture.createMemberRegisterRequest());
        MemberRegisterRequest request = MemberFixture.createMemberRegisterRequest();

        MvcTestResult result = mvcTester.post()
                .uri("/api/members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)).exchange();

        assertThat(result)
                .apply(MockMvcResultHandlers.print())
                .hasStatus(HttpStatus.CONFLICT);
    }
}
