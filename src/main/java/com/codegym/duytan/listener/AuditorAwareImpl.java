package com.codegym.duytan.listener;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNullApi;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
    }
}
