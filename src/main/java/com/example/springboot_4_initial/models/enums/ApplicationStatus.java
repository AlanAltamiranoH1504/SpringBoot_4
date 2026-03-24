package com.example.springboot_4_initial.models.enums;

public enum ApplicationStatus {
    RECEIVED("Recibida"),
    REVIEWING("En Revisión"),
    INTERVIEW_SCHEDULED("Entrevista Programada"),
    TESTING_PHASE("En Pruebas"),
    REJECTED("Rechazado"),
    OFFER_EXTENDED("Oferta Enviada"),
    HIRED("Contratado");

    private final String description;

    ApplicationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
