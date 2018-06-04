package guru.springframework.services;

/**
 * This class is used to create GreetingsServices based on a given language.
 */
public class GreetingSerivceFactory {
    private final GreetingRepository greetingRepository;

    public GreetingSerivceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String language) {
        switch (language) {
            case "es":
                return new PrimarySpanishGreetingService(greetingRepository);
            case "de":
                return new PrimaryGermanGreetingService(greetingRepository);
            case "en":
            default: return new PrimaryGreetingService(greetingRepository);
        }
    }
}
