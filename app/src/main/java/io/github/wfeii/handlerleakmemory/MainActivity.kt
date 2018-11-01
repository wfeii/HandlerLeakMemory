package io.github.wfeii.handlerleakmemory

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * @author wf3 on 2018.10.30
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.scene1).setOnClickListener {
            Scene1Activity.startActivity(this@MainActivity)
        }

        findViewById<View>(R.id.scene2).setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                Scene3Activity.startActivity(this@MainActivity)
            }
        })
        findViewById<View>(R.id.scene3).setOnClickListener {
            Scene3Activity.startActivity(this)
        }
    }
}