package com.erano.appetiserexam.util;

import android.os.Build;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import javax.inject.Named;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Eraño Payawal on 2019-08-17.
 * hunterxer31@gmail.com
 */
public class RxSchedulerConfiguration {

    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    public Scheduler getComputationThread() {
        return getThreadPoolExecutor(coreNumber());
    }

    private Scheduler getThreadPoolExecutor(@Named("coreNumber") int coreNUmber) {
        /**
         * to get well-balanced computation performance we use: NumThread = NumCore + 1
         */
        return Schedulers.from(Executors.newFixedThreadPool(coreNUmber + 1));
    }

    private int coreNumber() {
        if (Build.VERSION.SDK_INT >= 17) {
            return Runtime.getRuntime().availableProcessors();
        }
        return getNumCoresOldPhones();
    }

    /**
     * Gets the number of cores available in this device, across all processors.
     * Requires: Ability to peruse the filesystem at "/sys/devices/system/cpu"
     *
     * @return The number of cores, or 1 if failed to get result
     */
    private int getNumCoresOldPhones() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                return Pattern.matches("cpu[0-9]+", pathname.getName());
            }
        }

        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            //Default to return 1 core
            return 1;
        }
    }

}
