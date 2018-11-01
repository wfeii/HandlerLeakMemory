package io.github.wfeii.handlerleakmemory

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * @author wf3 on 2018.10.31
 */
class Scene3Activity : AppCompatActivity() {
    private val mCallback = object : WeakReferenceHandler.Callback {
        override fun handleMessage(msg: Message) {
            Toast.makeText(this@Scene3Activity, "haha", Toast.LENGTH_LONG).show()
        }
    }
    private val mHandler = WeakReferenceHandler(mCallback)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val msg = Message.obtain()
        msg.what = WHAT_MSG
        mHandler.sendMessageDelayed(msg, 10_000)
    }

    companion object {
        private const val WHAT_MSG = 3
        fun startActivity(activity: Activity) {
            activity.startActivity(Intent(activity, Scene3Activity::class.java))
        }
    }
}