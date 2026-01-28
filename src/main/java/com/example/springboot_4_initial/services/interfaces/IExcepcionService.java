package com.example.springboot_4_initial.services.interfaces;

import java.util.Map;

public interface IExcepcionService {
    public abstract Map<String, Object> generateMessageException(String error, String details, String errorBackend);
}
