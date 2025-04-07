package com.pepponechoi.cinema.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedisKeyResolver {
    private static final String KEY_DELIMITER = ":";

    public static String getKey(Object id, String domain, String... subdomains) {
        List<String> parts = new ArrayList<>();
        parts.add(domain);
        parts.addAll(Arrays.asList(subdomains));
        parts.add(id.toString());
        return String.join(KEY_DELIMITER, parts);
    }

}
