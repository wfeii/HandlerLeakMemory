package io.github.wfeii.handlerleakmemory

import android.os.Handler
import android.os.Message
import android.util.Log
import java.lang.ref.WeakReference

/**
 * @author wf3 on 2018.10.31
 */
class WeakReferenceHandler<T : WeakReferenceHandler.Callback> : Handler {
    private var mWeakReference: WeakReference<T>

    constructor(callback: T) : super() {
        mWeakReference = WeakReference(callback)
    }

    override fun handleMessage(msg: Message) {
        val callback = mWeakReference.get()
        if (callback != null) {
            callback.handleMessage(msg)
        } else {
            Log.e(TAG, "mWeakReference.get() is null ")
        }
    }

    interface Callback {
        fun handleMessage(msg: Message)
    }

    companion object {
        private const val TAG = "WeakReferenceHandler"
    }
}