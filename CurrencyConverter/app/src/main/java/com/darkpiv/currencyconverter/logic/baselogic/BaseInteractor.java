package com.darkpiv.currencyconverter.logic.baselogic;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.darkpiv.currencyconverter.util.PreConditions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by darkpiv on 19/12/2016.
 */

public class BaseInteractor {

    public static BaseInteractor instance;

    public static BaseInteractor getInstance() {
        if (instance == null) instance = new BaseInteractor();
        return instance;
    }

    private static final int NUMBER_OF_THREADS = 5;

    private ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
    private ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private Handler handler = new Handler(Looper.getMainLooper());

    private ScheduledFuture<?> scheduledFuture;

    protected void runOnUiThread(@NonNull Runnable runnable) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");

        handler.post(runnable);
    }

    protected void runOnBackground(@NonNull Runnable runnable) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");

        if (executor.isShutdown()) {
            executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        }

        final Future<?> task = executor.submit(runnable);

        if (task.isDone()) {
            executor.shutdown();
        }
    }

    protected void runScheduledTaskOnBackground(@NonNull Runnable runnable, @NonNull Long time, @NonNull TimeUnit unit) {
        PreConditions.checkNotNull(runnable, "runnable shouldn't be null");
        PreConditions.checkNotNull(time, "time shouldn't be null");
        PreConditions.checkNotNull(unit, "unit shouldn't be null");

        scheduledFuture = scheduledExecutor.schedule(runnable, time, unit);
    }

    protected void cancelScheduledTask() {
        if (null != scheduledFuture) {
            scheduledFuture.cancel(true);
        }
    }

    public void removeAllCallbackAndMessages() {
        handler.removeCallbacksAndMessages(null);
    }
}
