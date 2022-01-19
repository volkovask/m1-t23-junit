package cookie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneCookieFactoryTest {

    private static FortuneController goodFactoryController;
    private static FortuneController badFactoryController;

    @BeforeAll
    public static void beforeAll() {
        goodFactoryController = create(true);
        badFactoryController = create(false);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        assertEquals("positive", goodFactoryController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        assertEquals("negative", badFactoryController.tellFortune().getFortuneText());
    }

    private static FortuneController create(boolean isPositive) {
        final FortuneConfig config = new FortuneConfig(isPositive);
        final FortuneCookieFactory factory = new FortuneCookieFactory(
                config,
                singletonList("positive"),
                singletonList("negative")
        );
        return new FortuneController(factory);
    }
}
