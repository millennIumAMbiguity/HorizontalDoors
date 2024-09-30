package millenniumambiguity.horizontaldoors.platform;

import millenniumambiguity.horizontaldoors.Constants;
import millenniumambiguity.horizontaldoors.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> $class) {

        final T loadedService = ServiceLoader.load($class)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + $class.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, $class);
        return loadedService;
    }
}