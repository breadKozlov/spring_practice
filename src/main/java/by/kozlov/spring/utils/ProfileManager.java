package by.kozlov.spring.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProfileManager {

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    public List<String> getActiveProfiles() {
        List<String> list = new ArrayList<>();
        for (String profileName : activeProfiles.split(",")) {
            System.out.println("Currently active profile - " + profileName);
            list.add(profileName);
        }
        return list;
    }
}
