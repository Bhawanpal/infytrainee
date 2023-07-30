
package com.InfyTraining.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGen {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode("suresh"));
        System.out.println(encoder.encode("ramesh"));
    }
}
//$2a$10$mFqPw106nJknjgwWKqoLWO6z9RzFL6cDNTssW.XoabjFfVTFUfjRC
//$2a$10$79WLTlTIQisWv41t5OYhZu1nPJSAdtbruCeEekuq7HVKTqQcijNrG
