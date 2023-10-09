package no.falldal.springboottask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

public class PartsServiceUnitTest {
    @MockBean
    PartsRepository partsRepository = new PartsRepository();

    @MockBean
    PartsService partsService = new PartsService(partsRepository);

    @BeforeEach
    void clearRepository() {
        partsService.getParts().clear();
    }

    @Test
    void testServiceGetParts() {
        assertThat(partsService.getParts()).isEmpty();
    }

    @Test
    void testServiceAddPart() {
        assertThat(partsService.getParts()).isEmpty();
        partsService.addPart(new Part("Part1", 1));
        partsService.addPart(new Part("Part2", 2));
        assertThat(partsService.getParts().size()).isEqualTo(2);
    }

    @Test
    void testServiceDeleteParts() {
        Part testPart = new Part("Part3", 3);

        partsService.addPart(testPart);
        assertThat(partsService.getParts().get(0)).isEqualTo(testPart);

        partsService.deletePart(testPart);
        assertThat(partsService.getParts()).isEmpty();
    }

    @Test
    void testServiceUpdatePart() {
        Part oldPart = new Part("Old", 0);
        Part newPart = new Part("New", 1000);

        partsService.addPart(oldPart);
        assertThat(partsService.getParts().get(0)).isEqualTo(oldPart);

        partsService.updatePart(oldPart, newPart);
        assertThat(partsService.getParts().get(0)).isEqualTo(newPart);
    }
}
