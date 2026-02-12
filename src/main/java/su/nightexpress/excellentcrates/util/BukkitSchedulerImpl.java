package su.nightexpress.excellentcrates.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class BukkitSchedulerImpl implements FoliaScheduler {

    @Override
    public void runTask(@NotNull Plugin plugin, @NotNull Runnable task) {
        Bukkit.getScheduler().runTask(plugin, task);
    }

    @Override
    public void runTaskLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, task, delay);
    }

    @Override
    public void runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        Bukkit.getScheduler().runTaskTimer(plugin, task, delay, period);
    }

    @Override
    public void runTaskAsync(@NotNull Plugin plugin, @NotNull Runnable task) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
    }

    @Override
    public void runTaskLaterAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, task, delay);
    }

    @Override
    public void runTaskTimerAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, task, delay, period);
    }

    @Override
    public void runAtEntity(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task) {
        Bukkit.getScheduler().runTask(plugin, task);
    }

    @Override
    public void runAtLocation(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task) {
        Bukkit.getScheduler().runTask(plugin, task);
    }

    @Override
    public void runAtEntityLater(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, task, delay);
    }

    @Override
    public void runAtLocationLater(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, task, delay);
    }

    @Override
    public void cancelTasks(@NotNull Plugin plugin) {
        Bukkit.getScheduler().cancelTasks(plugin);
    }

    @Override
    public boolean isFolia() {
        return false;
    }
}
