package no.falldal.springboottask.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PartsService {
    private final PartsRepository partsRepository;

    @Autowired
    public PartsService(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    public ArrayList<Part> getParts() {
        return partsRepository.getPartsList();
    }

    public void addPart(Part part) {
        partsRepository.addPart(part);
    }

    public void deletePart(Part part) {
        partsRepository.deletePart(part);
    }

    public void updatePart(Part oldPart, Part newPart) {
        partsRepository.updatePart(oldPart, newPart);
    }
}