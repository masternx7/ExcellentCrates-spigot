package su.nightexpress.excellentcrates.util;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class FoliaSchedulerImpl implements FoliaScheduler {

    @Override
    public void runTask(@NotNull Plugin plugin, @NotNull Runnable task) {
        Bukkit.getGlobalRegionScheduler().run(plugin, scheduledTask -> task.run());
    }

    @Override
    public void runTaskLater(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        Bukkit.getGlobalRegionScheduler().runDelayed(plugin, scheduledTask -> task.run(), delay);
    }

    @Override
    public void runTaskTimer(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        Bukkit.getGlobalRegionScheduler().runAtFixedRate(plugin, scheduledTask -> task.run(), delay, period);
    }

    @Override
    public void runTaskAsync(@NotNull Plugin plugin, @NotNull Runnable task) {
        Bukkit.getAsyncScheduler().runNow(plugin, scheduledTask -> task.run());
    }

    @Override
    public void runTaskLaterAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay) {
        Bukkit.getAsyncScheduler().runDelayed(plugin, scheduledTask -> task.run(), delay * 50, TimeUnit.MILLISECONDS);
    }

    @Override
    public void runTaskTimerAsync(@NotNull Plugin plugin, @NotNull Runnable task, long delay, long period) {
        Bukkit.getAsyncScheduler().runAtFixedRate(plugin, scheduledTask -> task.run(), delay * 50, period * 50, TimeUnit.MILLISECONDS);
    }

    @Override
    public void runAtEntity(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task) {
        if (entity.isValid()) {
            entity.getScheduler().run(plugin, scheduledTask -> task.run(), null);
        }
    }

    @Override
    public void runAtLocation(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task) {
        if (location.getWorld() != null) {
            Bukkit.getRegionScheduler().run(plugin, location, scheduledTask -> task.run());
        }
    }

    @Override
    public void runAtEntityLater(@NotNull Plugin plugin, @NotNull Entity entity, @NotNull Runnable task, long delay) {
        if (entity.isValid()) {
            entity.getScheduler().runDelayed(plugin, scheduledTask -> task.run(), null, delay);
        }
    }

    @Override
    public void runAtLocationLater(@NotNull Plugin plugin, @NotNull Location location, @NotNull Runnable task, long delay) {
        if (location.getWorld() != null) {
            Bukkit.getRegionScheduler().runDelayed(plugin, location, scheduledTask -> task.run(), delay);
        }
    }

    @Override
    public void cancelTasks(@NotNull Plugin plugin) {
        Bukkit.getGlobalRegionScheduler().cancelTasks(plugin);
        Bukkit.getAsyncScheduler().cancelTasks(plugin);
    }

    @Override
    public boolean isFolia() {
        return true;
    }
}
