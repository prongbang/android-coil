package com.prongbang.androidcoil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initView()
	}

	private fun initView() {
		imageView1.load("https://prongbang.github.io/assets/images/profile.png") {
			crossfade(true)
		}

		val requestGift = ImageRequest.Builder(imageView2.context)
				.data("https://media.giphy.com/media/EMie1mAAIk51e/giphy.gif")
				.target(imageView2)
				.build()
		val imageLoaderGift = ImageLoader.Builder(imageView2.context)
				.componentRegistry { add(GifDecoder()) }
				.build()
		imageLoaderGift.enqueue(requestGift)

		val requestSvg = ImageRequest.Builder(imageView3.context)
				.data("https://image.flaticon.com/icons/svg/270/270780.svg")
				.target(imageView3)
				.build()
		val imageLoaderSvg = ImageLoader.Builder(imageView3.context)
				.componentRegistry { add(SvgDecoder(imageView3.context)) }
				.build()
		imageLoaderSvg.enqueue(requestSvg)
	}
}