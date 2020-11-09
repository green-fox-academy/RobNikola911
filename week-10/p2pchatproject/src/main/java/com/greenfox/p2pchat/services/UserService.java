package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.dto.ApiResponseDTO;
import com.greenfox.p2pchat.dto.UserRequestDTO;
import com.greenfox.p2pchat.dto.UserResponseDTO;
import com.greenfox.p2pchat.models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {


    public void registerUser(UserRequestDTO userRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        //REQUEST
        HttpEntity<UserRequestDTO> request = new HttpEntity<>(userRequestDTO);
        //RESPONSE
        ResponseEntity<UserResponseDTO> response = restTemplate
                .exchange("https://sage-chat.herokuapp.com/api/user/register", HttpMethod.POST, request, UserResponseDTO.class);
//       UserResponseDTO responseBody = response.getBody();

    }

    public String loginUser(UserRequestDTO userRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        //REQUEST
        HttpEntity<UserRequestDTO> request = new HttpEntity<>(userRequestDTO);
        //RESPONSE
        ResponseEntity<ApiResponseDTO> response = restTemplate
                .exchange("https://sage-chat.herokuapp.com/api/user/login", HttpMethod.POST, request, ApiResponseDTO.class);
        ApiResponseDTO responseBody = response.getBody();
        if (!responseBody.getApiKey().isEmpty()){
            return response.getBody().getApiKey();
        }
        return null;
    }
}
