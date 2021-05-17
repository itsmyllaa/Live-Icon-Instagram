package com.example.instagram

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        handler.post(runnable)
    }

    private val runnable: Runnable
      get() = Runnable {
          anim_1.animate()
              .scaleX(2f)
              .scaleY(2f)
              .alpha(.1f)
              .setDuration(950)
              .withEndAction {
                  anim_1.scaleX = .3f
                  anim_1.scaleY = .3f
                  anim_1.alpha = 1f
              }
          anim_2.animate()
              .scaleX(1.5f)
              .scaleY(1.5f)
              .alpha(.2f)
              .setDuration(850)
              .withEndAction {
                  anim_2.scaleX = .7f
                  anim_2.scaleY = .7f
                  anim_2.alpha = 1f
              }

          val scale: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            me_card,
              PropertyValuesHolder.ofFloat("scaleX", .7f),
              PropertyValuesHolder.ofFloat("scaleY", .7f)
          )

          scale.duration = 500
          scale.repeatCount = ObjectAnimator.INFINITE
          scale.repeatMode = ObjectAnimator.REVERSE
          scale.start()

          handler.postDelayed(runnable, 1000)
      }

}