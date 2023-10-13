package no.falldal.springboottask.parts;

import no.falldal.springboottask.parts.exceptions.PartsRepositoryExceptions;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
public class PartsRepository {
    private final ArrayList<Part> partsList;

    private final Logger logger = LoggerFactory.getLogger(PartsRepository.class);

    public PartsRepository() {

        partsList = new ArrayList<>();

        partsList.add(new Part("Part1", 100));
        partsList.add(new Part("Part2", 200));
    }

    public void addPart(Part part) {
        if (part.name().equals("fish")) {
            throw new PartsRepositoryExceptions();
        }
        partsList.add(part);
    }

    public Part getPart(Part part) {
        if (partsList.contains(part)) {
            return part;
        }

        return null;
    }

    public void updatePart(Part oldPart, Part newPart) {
        if (partsList.contains(oldPart)) {
            partsList.set(partsList.indexOf(oldPart), newPart);
            logger.info(String.format("Updated %s (%s) -> %s (%s)", oldPart.name(), oldPart.price(), newPart.name(), newPart.price()));
        } else {
            logger.info(String.format("Unable to update %s (%s) -> %s (%s)", oldPart.name(), oldPart.price(), newPart.name(), newPart.price()));
        }
    }

    public void deletePart(Part part) {
        if (partsList.contains(part)) {
            partsList.remove(part);
            logger.info(String.format("%s (%s) deleted.", part.name(), part.price()));
        } else {
            logger.info(String.format("%s (%s) not found.", part.name(), part.price()));
        }
    }
}
