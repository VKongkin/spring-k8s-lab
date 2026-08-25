package cambofreelance.com.springk8slab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<?> getHello(){
        HashMap<String, String> obj = new HashMap<>();
        obj.put("message","Hello from kubernetes");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
}
