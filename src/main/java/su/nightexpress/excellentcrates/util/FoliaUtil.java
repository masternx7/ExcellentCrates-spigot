package su.nightexpress.excellentcrates.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class FoliaUtil {

    public static void teleport(@NotNull Plugin plugin, @NotNull Player player, @NotNull Location location) {
        if (SchedulerFactory.isFoliaServer()) {
            SchedulerFactory.getScheduler().runAtLocation(plugin, location, () -> {
                player.teleport(location);
            });
        } else {
            player.teleport(location);
        }
    }

    public static void runAtEntity(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task) {
        SchedulerFactory.getScheduler().runAtEntity(plugin, entity, task);
    }

    public static void runAtLocation(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task) {
        SchedulerFactory.getScheduler().runAtLocation(plugin, location, task);
    }

    public static void runAtEntityLater(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task, long delay) {
        SchedulerFactory.getScheduler().runAtEntityLater(plugin, entity, task, delay);
    }

    public static void runAtLocationLater(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task, long delay) {
        SchedulerFactory.getScheduler().runAtLocationLater(plugin, location, task, delay);
    }

    public static void runTask(@NotNull Plugin plugin, @NotNull Runnable task) {
        SchedulerFactory.getScheduler().runTask(plugin, task);
    }

    public static void runTaskLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        SchedulerFactory.getScheduler().runTaskLater(plugin, task, delay);
    }

    public static void runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        SchedulerFactory.getScheduler().runTaskTimer(plugin, task, delay, period);
    }

    public static void runAsync(@NotNull Plugin plugin, @NotNull Runnable task) {
        SchedulerFactory.getScheduler().runTaskAsync(plugin, task);
    }

    public static void runAsyncLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        SchedulerFactory.getScheduler().runTaskLaterAsync(plugin, task, delay);
    }

    public static void runAsyncTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        SchedulerFactory.getScheduler().runTaskTimerAsync(plugin, task, delay, period);
    }
}
