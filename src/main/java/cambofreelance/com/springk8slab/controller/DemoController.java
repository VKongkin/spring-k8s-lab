package cambofreelance.com.springk8slab.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final String instance;

    @Value("${app.greeting:Hellooo}")
    private String appGreeting;

    @Value("${app.db-password}")
    private String dbPassword;

    public DemoController(@Value("${HOSTNAME:local}") String instance) {
        this.instance = instance;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
                "message", appGreeting,
                "instance", instance,
                "dbPasswordLength", String.valueOf(dbPassword.length())
        );
    }

    @GetMapping("/greeting")
    public Map<String, String> greeting(@RequestParam String q) {
        return Map.of(
                "message", "Mr/Ms "+q+": "+appGreeting,
                "instance", instance,
                "dbPasswordRaw", dbPassword,
                "dbPasswordLength", String.valueOf(dbPassword.length())
        );
    }
}
