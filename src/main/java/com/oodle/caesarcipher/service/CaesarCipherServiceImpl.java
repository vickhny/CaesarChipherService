package com.oodle.caesarcipher.service;

import com.oodle.caesarcipher.dto.DecryptedMsgDTO;
import com.oodle.caesarcipher.dto.EncryptedMsgDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CaesarCipherServiceImpl implements CaesarCipherService {

    final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Value("${oodle.cipher.offset:4}")
    private int SHIFT;

    @Override
    public DecryptedMsgDTO decryptText(EncryptedMsgDTO encryptedMsgDTO) {
        String decryptedMSG = "";
        Boolean decrypted = false;
        for (int i = 0; i < alph.length() - 1; i++) {
            decryptedMSG = decrypt(encryptedMsgDTO.getCiphertext(), i);
            for (String crib : encryptedMsgDTO.getCribs()) {
                if (decryptedMSG.contains(crib)) {
                    decrypted = true;
                } else {
                    decrypted = false;
                    break;
                }
            }
            if (decrypted == true) {
                break;
            }
        }

        return DecryptedMsgDTO.builder()
                .plaintext(decryptedMSG)
                .build();
    }

    @Override
    public EncryptedMsgDTO encryptText(DecryptedMsgDTO decryptedMsgDTO) {
        return EncryptedMsgDTO.builder().ciphertext(encrypt(decryptedMsgDTO.getPlaintext(), SHIFT)).build();
    }

    private String encrypt(String plainT, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < plainT.length(); i++) {
            if (Character.isUpperCase(plainT.charAt(i))) {
                char ch = (char) (((int) plainT.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) plainT.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decrypt(String cipherT, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < cipherT.length(); i++) {
            if (Character.isUpperCase(cipherT.charAt(i))) {
                char ch = (char) (((int) cipherT.charAt(i) +
                        shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) cipherT.charAt(i) +
                        shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }
}