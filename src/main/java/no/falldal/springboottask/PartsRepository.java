package no.falldal.springboottask;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
public class PartsRepository {
    private final ArrayList<Part> partsList;

    public PartsRepository() {
        partsList = new ArrayList<>();

        partsList.add(new Part("Part1", 100));
        partsList.add(new Part("Part2", 200));
    }

    public void addPart(Part part) {
        partsList.add(part);
    }

    public Part getPart(Part part) {
        if (partsList.contains(part)) {
            return part;
        }

        return null;
    }

    public void updatePart(Part oldPart, Part newPart) {
        for (int i = 0; i < partsList.size(); i++) {
            if (partsList.get(i).equals(oldPart)) {
                partsList.set(i, newPart);
                break;
            }
        }
    }

    public void deletePart(Part part) {
        for (int i = 0; i < partsList.size(); i++) {
            if (partsList.get(i).equals(part)) {
                partsList.remove(part);
            }
        }
    }
}
