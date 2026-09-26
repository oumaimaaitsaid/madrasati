package com.admin.school.components;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PasswordMaker {
    public String generateStrictPassword() {
        PasswordGenerator gen = new PasswordGenerator();

        CharacterRule lowerCaseRule = new CharacterRule(EnglishCharacterData.LowerCase, 2);
        CharacterRule upperCaseRule = new CharacterRule(EnglishCharacterData.UpperCase, 2);
        CharacterRule digitRule = new CharacterRule(EnglishCharacterData.Digit, 2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() { return "INSUFFICIENT_SPECIAL"; }
            public String getCharacters() { return "!@#$%^&*()_+"; }
        };
        CharacterRule specialCharRule = new CharacterRule(specialChars, 2);

        // Generates a 12-character password matching all the above criteria
        return gen.generatePassword(12, lowerCaseRule, upperCaseRule, digitRule, specialCharRule);
    }
}
