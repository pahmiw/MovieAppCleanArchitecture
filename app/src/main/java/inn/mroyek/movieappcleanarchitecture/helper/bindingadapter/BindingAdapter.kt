package inn.mroyek.movieappcleanarchitecture.helper.bindingadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import inn.mroyek.movieappcleanarchitecture.data.vo.IMAGE_BASE_URL_BACKDROP
import inn.mroyek.movieappcleanarchitecture.data.vo.IMAGE_BASE_URL_POSTER

@BindingAdapter("loadImage")
fun loadPotraitImage(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) return

    val url = IMAGE_BASE_URL_POSTER + imageUrl

    Glide.with(view.context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(0.2f)
        .placeholder(ColorDrawable(Color.LTGRAY))
        .into(view)
}

@BindingAdapter("loadBackdrop")
fun loadBackDrop(view: ImageView, imageUrl: String?) {
    if (imageUrl.isNullOrEmpty()) return

    val url = IMAGE_BASE_URL_BACKDROP + imageUrl

    Glide.with(view.context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(0.2f)
        .placeholder(ColorDrawable(Color.LTGRAY))
        .into(view)
}