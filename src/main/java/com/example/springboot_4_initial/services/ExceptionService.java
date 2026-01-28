package com.example.springboot_4_initial.services;

import com.example.springboot_4_initial.services.interfaces.IExcepcionService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExceptionService  implements IExcepcionService {
    @Override
    public Map<String, Object> generateMessageException(String error, String details, String errorBackend) {
        Map<String, Object> errroMessage = new HashMap<>();
        errroMessage.put("error", error);
        errroMessage.put("details", details);
        errroMessage.put("message", errorBackend);
        return errroMessage;
    }
}
