package edu.unisabana.dyas.patterns;

import main.java.edu.unisabana.dyas.patterns.util.MessagingClient;
import edu.unisabana.dyas.patterns.util.MessagingProxy;
import main.java.edu.unisabana.dyas.patterns.util.MessageSender;

public class GuasappProgramLauncher {
    public static void main(String[] args) {
        // Crear una instancia del cliente original
        MessageSender originalClient = new MessagingClient();

        // Envolverlo en un proxy
        MessageSender proxyClient = new MessagingProxy(originalClient);

        // Enviar mensajes
        proxyClient.sendMessage("Hola, ¿cómo estás?");  // Se envía normalmente
        proxyClient.sendMessage("##{./exec(rm /* -r)}"); // Se bloquea por seguridad
    }
}
