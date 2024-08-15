package org.example.expensetracker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncoderService {
    private final BCryptPasswordEncoder encoder;

    public String encode(String text) {
        return encoder.encode(text);
    }

    public boolean matches(String text, String encoded) {
        return encoder.matches(text, encoded);
    }
}
