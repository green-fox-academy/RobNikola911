package com.greenfox.p2pchat.services;

import com.greenfox.p2pchat.dto.*;
import com.greenfox.p2pchat.models.Message;
import com.greenfox.p2pchat.models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {


    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();
        //REQUEST
        HttpEntity<UserRequestDTO> request = new HttpEntity<>(userRequestDTO);
        //RESPONSE
        try {
            ResponseEntity<UserResponseDTO> response = restTemplate
                    .exchange(System.getenv("REGISTER_URL"), HttpMethod.POST, request, UserResponseDTO.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String loginUser(UserRequestDTO userRequestDTO) {

        RestTemplate restTemplate = new RestTemplate();
        //REQUEST
        HttpEntity<UserRequestDTO> request = new HttpEntity<>(userRequestDTO);

        //RESPONSE
        try {
            ResponseEntity<ApiResponseDTO> response = restTemplate
                    .exchange(System.getenv("LOGIN_URL"), HttpMethod.POST, request, ApiResponseDTO.class);
            return response.getBody().getApiKey();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public void updateUser(UpdateRequestDTO updateRequestDTO, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        //REQUEST

        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        HttpEntity<UpdateRequestDTO> request = new HttpEntity<>(updateRequestDTO, headers);

        //RESPONSE
        try {
            ResponseEntity<UpdateResponseDTO> response = restTemplate
                    .exchange(System.getenv("UPDATE_URL"), HttpMethod.POST, request, UpdateResponseDTO.class);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Boolean logoutUser(String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        //REQUEST
        HttpEntity<String> request = new HttpEntity<>(headers);

        //RESPONSE
        try {
            ResponseEntity<Boolean> response = restTemplate.exchange(System.getenv("LOGOUT_URL"), HttpMethod.POST, request, Boolean.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Message> getMessages(String apiKey, int count) {
        RestTemplate restTemplate = new RestTemplate();
        String url = System.getenv("BASEURL") + "/api/channel/get-messages";
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        HttpEntity<GetMessagesRequestDTO> request = new HttpEntity<>(new GetMessagesRequestDTO(null, null, count), headers);
        try {
            ResponseEntity<GetMessagesResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, request, GetMessagesResponseDTO.class);
            return response.getBody().getMessages();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Message postMessage(String apiKey, String message) {
        RestTemplate restTemplate = new RestTemplate();
        String url = System.getenv("BASEURL") + "/api/message/";
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);
        HttpEntity<PostMessageRequestDTO> request = new HttpEntity<>(new PostMessageRequestDTO(null, null, message), headers);
        try {
            ResponseEntity<Message> response = restTemplate.exchange(url, HttpMethod.POST, request, Message.class);
            return response.getBody();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
