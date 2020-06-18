package inn.mroyek.movieappcleanarchitecture.helper.extension

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrl(url: String) {
    Glide.with(this.context)
        .load(url)
        .thumbnail(0.3f)
        .placeholder(ColorDrawable(Color.LTGRAY))
        .apply { RequestOptions.fitCenterTransform() }
        .into(this)
}