package com.github.jizumer.rps.core.domain;

import java.util.UUID;

public final class UuidGenerator {
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
