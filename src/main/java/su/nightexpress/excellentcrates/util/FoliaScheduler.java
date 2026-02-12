package su.nightexpress.excellentcrates.util;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface FoliaScheduler {

    void runTask(@NotNull Plugin plugin, @NotNull Runnable task);

    void runTaskLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay);

    void runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period);

    void runTaskAsync(@NotNull Plugin plugin, @NotNull Runnable task);

    void runTaskLaterAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay);

    void runTaskTimerAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period);

    void runAtEntity(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task);

    void runAtLocation(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task);

    void runAtEntityLater(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task, long delay);

    void runAtLocationLater(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task, long delay);

    void cancelTasks(@NotNull Plugin plugin);

    boolean isFolia();
}
