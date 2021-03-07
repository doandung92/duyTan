package com.codegym.duytan.listener;

import org.springframework.data.domain.*;

import java.util.*;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
