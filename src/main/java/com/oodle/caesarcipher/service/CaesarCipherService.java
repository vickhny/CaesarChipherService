package com.oodle.caesarcipher.service;

import com.oodle.caesarcipher.dto.DecryptedMsgDTO;
import com.oodle.caesarcipher.dto.EncryptedMsgDTO;

public interface CaesarCipherService {

    DecryptedMsgDTO decryptText(EncryptedMsgDTO encryptedMsgDTO);

    EncryptedMsgDTO encryptText(DecryptedMsgDTO decryptedMsgDTOs);
}
