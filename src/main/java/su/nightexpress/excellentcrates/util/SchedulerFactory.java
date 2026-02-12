package su.nightexpress.excellentcrates.util;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

public class SchedulerFactory {

    private static FoliaScheduler scheduler;
    private static Boolean isFolia;

    @NotNull
    public static FoliaScheduler getScheduler() {
        if (scheduler == null) {
            scheduler = createScheduler();
        }
        return scheduler;
    }

    @NotNull
    private static FoliaScheduler createScheduler() {
        if (isFoliaServer()) {
            return new FoliaSchedulerImpl();
        } else {
            return new BukkitSchedulerImpl();
        }
    }

    public static boolean isFoliaServer() {
        if (isFolia != null) {
            return isFolia;
        }

        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            isFolia = true;
        } catch (ClassNotFoundException e) {
            isFolia = false;
        }

        return isFolia;
    }

    @NotNull
    public static String getServerVersion() {
        String version = Bukkit.getVersion();
        if (isFoliaServer()) {
            return "Folia (" + version + ")";
        }
        return version;
    }
}
