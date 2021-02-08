package com.oodle.caesarcipher.controller;

import com.oodle.caesarcipher.dto.DecryptedMsgDTO;
import com.oodle.caesarcipher.dto.EncryptedMsgDTO;
import com.oodle.caesarcipher.service.CaesarCipherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/oodle")
@Api(value = "Cracking the Caesar Cipher")
public class CaesarCipherController {

    @Autowired
    private CaesarCipherService caesarCipherService;

    @ApiOperation(value = "Decrypt Cipher Text to plain text")
    @PostMapping("/decrypt")
    public ResponseEntity<?> decryptText(@RequestBody @Validated EncryptedMsgDTO encryptedMsgDTO) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(caesarCipherService.decryptText(encryptedMsgDTO));
    }

    @ApiOperation(value = "Encrypt plain text to cipher text")
    @PostMapping("/encrypt")
    public ResponseEntity<?> uploadProducts(@RequestBody @Validated DecryptedMsgDTO decryptedMsgDTO) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(caesarCipherService.encryptText(decryptedMsgDTO));
    }
}
