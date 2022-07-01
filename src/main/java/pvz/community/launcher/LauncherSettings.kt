package pvz.community.launcher

data class LauncherSettings(val DEBUG_MODE: Boolean = false, val FIRST_LAUNCH: Boolean = true) {
    var MAX_FPS = 60
        private set

}