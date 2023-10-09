package no.falldal.springboottask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class PartsController {
    private final PartsService partsService;

    @Autowired
    public PartsController(PartsService partsService) {
        this.partsService = partsService;
    }

    @GetMapping()
    public String getWelcomeMessage() {
        return "Welcome to my API page :)";
    }

    @GetMapping("/parts")
    public ArrayList<Part> getParts() {
        return partsService.getParts();
    }

    @PostMapping("/parts")
    public void addPart(@RequestBody Part part) {
        partsService.addPart(part);
    }

    @DeleteMapping("/parts")
    public void deletePart(@RequestBody Part part) {
        partsService.deletePart(part);
    }

    @PutMapping("/parts")
    public void updatePart(@RequestBody Part[] parts) {
        partsService.updatePart(parts[0], parts[1]);
    }
}
