package lecture.oauth.common.config;

import lecture.oauth.common.auth.JwtTokenFilter;
import lecture.oauth.member.service.GoogleOauth2LoginSuccess;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    public static final String[] UNCHECKED_URL = {"/member/create", "/member/doLogin", "/member/pims/doLogin", "/member/google/doLogin", "/member/kakao/doLogin", "/oauth2/**"};
    private final JwtTokenFilter jwtTokenFilter;
    private final GoogleOauth2LoginSuccess googleOauth2LoginSuccess;

    @Bean
    public PasswordEncoder makePassword() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain myFilter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors.configurationSource(configurationSource()))
                .csrf(AbstractHttpConfigurer::disable) //csrf비활성화
//                Basic인증 비활성화
//                Basic인증은 사용자이름과 비밀번호를 Base64로 인코딩하여 인증값으로 활용
                .httpBasic(AbstractHttpConfigurer::disable)
//                세션방식을 비활성화
                .sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 특정 url패턴에 대해서는 인증처리(Authentication객체생성) 제외
                .authorizeHttpRequests(a->
                        a.requestMatchers(UNCHECKED_URL)
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
//                UsernamePasswordAuthenticationFilter 이 클래스에서 폼로그인 인증을 처리
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
//                oauth로그인이 성공했을경우 실행할 클래스 정의
                .oauth2Login(o -> o.successHandler(googleOauth2LoginSuccess))
                .build();
    }

    @Bean
    public CorsConfigurationSource configurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(List.of("*")); //모든 HTTP메서드 허용
        configuration.setAllowedHeaders(List.of("*")); //모든 헤더값 허용
        configuration.setAllowCredentials(true); //자격증명허용

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        모든 url패턴에 대해서 cors 허용 설정
        source.registerCorsConfiguration("/**", configuration);
        return  source;
    }
}
