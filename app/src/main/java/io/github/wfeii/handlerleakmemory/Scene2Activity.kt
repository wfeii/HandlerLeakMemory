package io.github.wfeii.handlerleakmemory

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * @author wf3 on 2018.10.30
 */
class Scene2Activity : AppCompatActivity() {

    private val mHandler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            Toast.makeText(this@Scene2Activity, "haha", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val msg = Message.obtain()
        msg.what = WHAT_MSG
        mHandler.sendMessageDelayed(msg, 10_000)
    }

    override fun onDestroy() {
        mHandler.removeMessages(WHAT_MSG)
        super.onDestroy()
    }

    companion object {
        private const val WHAT_MSG = 2
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, Scene2Activity::class.java))
        }
    }
}