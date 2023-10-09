package no.falldal.springboottask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartsRepositoryUnitTest {
    @MockBean
    PartsRepository partsRepository = new PartsRepository();

    @BeforeEach
    void clearRepository() {
        partsRepository.getPartsList().clear();
    }

    @Test
    void testRepositoryAddPart() {
        partsRepository.getPartsList().clear();

        partsRepository.addPart(new Part("Gear", 1));
        assertEquals(1, partsRepository.getPartsList().size());
        assertEquals("Gear", partsRepository.getPartsList().get(0).name());
    }

    @Test
    void testRepositoryGetSinglePart() {
        partsRepository.addPart(new Part("Screw", 2));
        partsRepository.addPart(new Part("Nail", 3));
        assertEquals("Nail", partsRepository.getPart(new Part("Nail", 3)).name());
    }

    @Test
    void testRepositoryUpdatePart() {
        partsRepository.getPartsList().clear();

        partsRepository.addPart(new Part("Cog", 4));
        partsRepository.updatePart(new Part("Cog", 4), new Part("Cog", 5));
        assertEquals(1, partsRepository.getPartsList().size());
        assertEquals(5, partsRepository.getPartsList().get(0).price());
    }

    @Test
    void testRepositoryDeletePart() {
        partsRepository.getPartsList().clear();

        partsRepository.addPart(new Part("Spring", 6));
        assertEquals(1, partsRepository.getPartsList().size());
        partsRepository.deletePart(new Part("Spring", 6));
        assertEquals(0, partsRepository.getPartsList().size());
    }
}
