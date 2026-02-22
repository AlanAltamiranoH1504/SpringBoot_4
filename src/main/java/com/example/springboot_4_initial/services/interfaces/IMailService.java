package com.example.springboot_4_initial.services.interfaces;

public interface IMailService {
    public abstract void send_mail_confirm_account_reclutador(String to, String subject, String name_user, String url, int randome_number);
}
