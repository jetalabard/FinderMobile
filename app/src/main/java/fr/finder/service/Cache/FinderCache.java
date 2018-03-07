package fr.finder.service.Cache;

import android.app.Activity;

import java.util.Date;

import fr.finder.service.ImplementationService.ServiceCache;


/**
 * Created by jerem on 05/03/2018.
 */

public class FinderCache {

    private Date date;

    private String cachable;

    private long DeadLineValidity;

    public FinderCache(Activity activity, String listToCache)
    {
        date = new Date();
        DeadLineValidity = new ServiceCache(activity).getDeadlineValidity();
        cachable = listToCache;
    }

    public boolean isDateValid() {
        Date now = new Date();
        long interval = now.getTime() - date.getTime();
        return interval < DeadLineValidity;
    }

    public String getCachable() {
        return cachable;
    }
}
