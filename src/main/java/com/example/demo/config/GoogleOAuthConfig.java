package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.github.cdimascio.dotenv.Dotenv;

@Component
public class GoogleOAuthConfig {

    private final Dotenv dotenv;

    @Autowired
    public GoogleOAuthConfig(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public String getClientId() {
        return dotenv.get("GOOGLE_CLIENT_ID");
    }

    public String getClientSecret() {
        return dotenv.get("GOOGLE_CLIENT_SECRET");
    }
}