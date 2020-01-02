package com.example.czm.mutil.permission;

/**
 * Created by Lunger on 2017/2/7.
 */

public interface Rationale extends CancelablePermission
{
    /**
     * Go request permission.
     */
    void resume();
}
