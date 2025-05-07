package AISS.BitbucketMiner.service;

import AISS.BitbucketMiner.model.UserData.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) { this.restTemplate = restTemplate; }

    public UserData getUserData(String id) {
        String uri = "https://api.bitbucket.org/2.0/users/" + id;
        UserData user = restTemplate.getForObject(uri, UserData.class);
        return user;
    }
}
