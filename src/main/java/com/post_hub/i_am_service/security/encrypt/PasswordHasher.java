package com.post_hub.i_am_service.security.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String first_password = bCryptPasswordEncoder.encode("Test1111");
        String second_password = bCryptPasswordEncoder.encode("Test1111");
        String third_password = bCryptPasswordEncoder.encode("Test1111");

        System.out.println(first_password);
        System.out.println(second_password);
        System.out.println(third_password);
    }
}
