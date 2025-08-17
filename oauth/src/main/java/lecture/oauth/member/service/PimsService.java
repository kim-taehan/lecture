package lecture.oauth.member.service;

import lecture.oauth.member.dto.AccessTokenDto;
import lecture.oauth.member.dto.GoogleProfileDto;
import lecture.oauth.member.dto.PimsProfileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class PimsService {

    @Value("${oauth.pims.client-id}")
    private String pimsClientId;

    @Value("${oauth.pims.client-secret}")
    private String pimsClientSecret;

    @Value("${oauth.pims.redirect-uri}")
    private String pimsRedirectUri;


    public AccessTokenDto getAccessToken(String code){
        RestClient restClient = RestClient.create();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", pimsClientId);
        params.add("client_secret", pimsClientSecret);
        params.add("redirect_uri", pimsRedirectUri);
        params.add("grant_type", "authorization_code");

        ResponseEntity<AccessTokenDto> response =  restClient.post()
                .uri("http://localhost:9000/oauth2/token")
                .headers(headers -> {
                    headers.setBasicAuth(pimsClientId, pimsClientSecret); // 🔑 Basic Auth 추가
                    headers.set("Content-Type", "application/x-www-form-urlencoded");
                })
                .body(params)
                .retrieve()
                .toEntity(AccessTokenDto.class);
//
        System.out.println("응답 accesstoken JSON " + response.getBody());
        return response.getBody();
    }


    public PimsProfileDto getPimsProfile(String accessToken) {
        RestClient restClient = RestClient.create();

        // 우리 서버에 /userinfo 엔드포인트를 만들어두었다고 가정
        ResponseEntity<PimsProfileDto> response = restClient.get()
                .uri("http://localhost:9000/userinfo")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .toEntity(PimsProfileDto.class);
        return response.getBody();
    }
}
