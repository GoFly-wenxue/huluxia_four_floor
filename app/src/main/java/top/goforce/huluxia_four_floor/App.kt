package top.goforce.huluxia_four_floor

import android.app.Application
import top.goforce.huluxia_four_floor.util.SharePreferenceUtil

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        SharePreferenceUtil.init(this)
    }
}