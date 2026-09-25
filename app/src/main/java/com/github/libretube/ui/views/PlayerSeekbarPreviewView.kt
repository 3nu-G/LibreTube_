package com.github.libretube.ui.views

import android.content.Context
import android.text.format.DateUtils
import android.util.AttributeSet
import android.widget.LinearLayout
import com.github.libretube.R
import com.github.libretube.databinding.PlayerFastSeekSecondsViewBinding
import android.view.LayoutInflater

class PlayerSeekbarPreviewView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val binding = PlayerFastSeekSecondsViewBinding.inflate(LayoutInflater.from(context), this, true)

    var seconds: Int = 0
        set(value) {
            // Fast-seek resets this counter to zero before the first real seek increment.
            // Some Android resource configurations cannot resolve R.plurals.seconds for zero,
            // so keep the internal reset out of plural formatting entirely.
            binding.tvSeconds.text = if (value > 0) {
                context.resources.getQuantityString(
                    R.plurals.seconds,
                    value,
                    value
                )
            } else {
                ""
            }
            field = value
        }

    init {
        orientation = VERTICAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }
}
