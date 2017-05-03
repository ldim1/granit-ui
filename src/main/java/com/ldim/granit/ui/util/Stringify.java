package com.ldim.granit.ui.util;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by agent on 27.04.2017.
 */
public class Stringify<K, V> {
    public String from(Map<K, V> map) {
        return map.entrySet().stream().collect(Collectors.
                toMap(k -> String.format("\"%d\"", k.getKey()), Map.Entry::getValue)).toString().replace('=', ':');
    }
}
