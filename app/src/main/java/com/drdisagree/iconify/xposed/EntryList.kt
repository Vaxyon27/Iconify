package com.drdisagree.iconify.xposed

import com.drdisagree.iconify.xposed.modules.LockscreenClock
import com.drdisagree.iconify.xposed.modules.LockscreenWidgets
import com.drdisagree.iconify.xposed.modules.VolumePanel
import com.drdisagree.iconify.xposed.modules.utils.SettingsLibUtils
import com.drdisagree.iconify.xposed.utils.HookCheck

object EntryList {

    private val topPriorityCommonModPacks = listOf(
        SettingsLibUtils::class.java,
        HookCheck::class.java
    )

    private val systemUICommonModPacks = listOf(
        VolumePanel::class.java,
        LockscreenClock::class.java,
        LockscreenWidgets::class.java
    )

    fun getEntries(packageName: String): ArrayList<Class<out ModPack>> {
        val modPacks = ArrayList<Class<out ModPack>>()

        modPacks.addAll(topPriorityCommonModPacks)

        if (packageName == SYSTEMUI_PACKAGE && !HookEntry.isChildProcess) {
            modPacks.addAll(systemUICommonModPacks)
        }

        return modPacks
    }
}
