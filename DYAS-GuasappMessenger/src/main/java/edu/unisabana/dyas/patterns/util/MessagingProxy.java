/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unisabana.dyas.patterns.util;

import main.java.edu.unisabana.dyas.patterns.util.MessageSender;

public class MessagingProxy implements MessageSender {
    private final MessageSender originalClient;

    public MessagingProxy(MessageSender originalClient) {
        this.originalClient = originalClient;
    }

    @Override
    public void sendMessage(String message) {
        if (containsMaliciousContent(message)) {
            System.out.println("Mensaje bloqueado debido a contenido peligroso.");
        } else {
            originalClient.sendMessage(message);
        }
    }

    private boolean containsMaliciousContent(String message) {
        // Patrón para detectar comandos peligrosos
        return message.matches(".*\\#\\#\\{.*(exec|rm|sudo|chmod|chown|wget|curl|bash|sh|python).*\\}.*");
    }
}
