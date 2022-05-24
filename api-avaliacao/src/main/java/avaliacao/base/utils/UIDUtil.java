package avaliacao.base.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class UIDUtil {

    private static final Integer SHORT_ID_LENGTH = 8;

    public static String generate() {
        return java.util.UUID.randomUUID().toString();
    }

    public static String generateShort() {
        return RandomStringUtils.randomAlphanumeric(SHORT_ID_LENGTH);
    }
}