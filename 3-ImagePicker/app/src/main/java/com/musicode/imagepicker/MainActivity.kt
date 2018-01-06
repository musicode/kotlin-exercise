package com.musicode.imagepicker

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.IOError
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val ALBUM_REQUEST_CODE = 100
    private val CAMERA_REQUEST_CODE = 200

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        album_button.setOnClickListener {
            takeImageFromAlbum()
        }

        camera_button.setOnClickListener {
            takeImageFromCamera()
        }

    }

    fun takeImageFromAlbum() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, ALBUM_REQUEST_CODE)

    }

    fun takeImageFromCamera() {


        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        // 检测是否有相机应用
        if (intent.resolveActivity(packageManager) == null) {
            return
        }

        // 从 android 6 开始，读写 SDK 被列为危险权限
        // 如果不放在缓存目录，都要进行运行时权限处理才行
        val outputImage = File(externalCacheDir, "output_image.jpg")

        try {
            if (outputImage.exists()) {
                outputImage.delete()
            }
            outputImage.createNewFile()
        }
        catch (e: IOException) {

        }

        // android 7 开始，直接使用本地真实路径被认为是不安全的，会抛出 FileUriExposedException
        if (Build.VERSION.SDK_INT >= 24) {
            imageUri = FileProvider.getUriForFile(this, "com.musicode.imagepicker", outputImage)
        }
        else {
            imageUri = Uri.fromFile(outputImage)
        }



        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(intent, CAMERA_REQUEST_CODE)

    }

    fun displayImage(bitmap: Bitmap) {
        image_view.setImageBitmap(bitmap)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            ALBUM_REQUEST_CODE -> {
                if (resultCode === Activity.RESULT_OK && data != null) {
                    displayImage(data.extras.get("data") as Bitmap)
                }
            }

            CAMERA_REQUEST_CODE -> {
                if (resultCode === Activity.RESULT_OK) {
                    displayImage(
                        BitmapFactory.decodeStream(contentResolver.openInputStream(imageUri))
                    )
                }
            }
            else -> {

            }
        }
    }

}
