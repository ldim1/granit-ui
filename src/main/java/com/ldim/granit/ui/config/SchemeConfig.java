package com.ldim.granit.ui.config;

import com.ldim.granit.ui.model.Root;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ldim on 19.04.2017.
 */
@Configuration
public class SchemeConfig {

    @Bean
    Root root() {
        return new Root();
    }

    @Bean
    Map<Integer, String> names() {
        return Collections.unmodifiableMap(new HashMap<Integer, String>() {{
            put(1, "one");
            put(2, "two");
        }});
    }
}
