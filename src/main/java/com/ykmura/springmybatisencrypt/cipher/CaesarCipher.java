package com.ykmura.springmybatisencrypt.cipher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CaesarCipher {

    @Value("${caesar-cipher.shift:0}")
    private int shiftValue;

    private String shift(String str, int s) {
        if (s < 0) {
            s += 26;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (!Character.isAlphabetic(ch)) {
                sb.append(ch);
                continue;
            }

            int base = Character.isUpperCase(ch) ? 'A' : 'a';
            char newCh = (char) ((ch + s - base) % 26 + base);
            sb.append(newCh);
        }
        return sb.toString();
    }

    public String encipher(String text) {
        if (text == null) {
            return null;
        }

        return shift(text, shiftValue);
    }

    public String decipher(String text) throws Exception {
        if (text == null) {
            return null;
        }

        return shift(text, -shiftValue);
    }
}
