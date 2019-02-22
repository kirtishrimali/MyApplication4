package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reference.*
import android.content.ActivityNotFoundException
import android.widget.CompoundButton
import android.widget.Toast


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ReferenceActivity : AppCompatActivity() {

    val FBURL = "https://www.facebook.com/myteamXI/"
    var FACEBOOK_PAGE_ID = "1600562606933560"
    val TWITTERURL = "https://twitter.com/myteam_11?lang=en"
    val GOOGLEURL = "https://plus.google.com/100296144106514455449"
    val INSTAGRAMURL = "https://www.instagram.com/myteam11_official/"
    val YOUTUBEURL = "https://www.youtube.com/channel/UCx2lhoCRvtoVCDXb2K4FYoQ"
    val LINKDINURL=  "https://www.linkedin.com/company/myteam11/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setTheme(R.style.AppThemeDark)

        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_reference)

        setListeners()
        setThemeToggle()
    }

    private fun setListeners() {
        button1.setOnClickListener {
            val facebookIntent = Intent(Intent.ACTION_VIEW)
            val facebookUrl = getFacebookPageURL(this)
            facebookIntent.data = Uri.parse(facebookUrl)
            startActivity(facebookIntent)
        }

        button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TWITTERURL))
            startActivity(intent)
        }

        button3.setOnClickListener {
            val PACKAGE = "com.linkedin.android"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(LINKDINURL))
            if(appInstalledOrNot(this, PACKAGE)) {
                intent.setPackage(PACKAGE)
            }
             startActivity(intent)
//            openLinkedInPage()
        }

        button4.setOnClickListener {
            val instaintent = this.packageManager.getLaunchIntentForPackage("com.instagram.android")
            val uri = Uri.parse(INSTAGRAMURL)
            val likeIng = Intent(Intent.ACTION_VIEW, uri)

            likeIng.setPackage("com.instagram.android")

            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW,
                        Uri.parse(INSTAGRAMURL)))
            }
        }

        button5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(YOUTUBEURL)
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)
        }
    }

    fun getFacebookPageURL(context: Context): String {

        if (appInstalledOrNot(context, "com.facebook.katana")) {
            try {
                return "fb://page/$FACEBOOK_PAGE_ID"
                // previous version, maybe relevant for old android APIs ?
                // return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } catch (e: Exception) {
            }

        } else {
            return FBURL
        }
        return FBURL
    }

    fun openGPlus(profile: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setClassName("com.google.android.apps.plus",
                    "com.google.android.apps.plus.phone.UrlGatewayActivity")
            intent.putExtra("customAppUri", profile)
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/$profile/posts")))
        }
    }

    fun openLinkedInPage(linkedId: String) {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://add/%@$linkedId"))
        val packageManager = packageManager
        val list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        if (list.isEmpty()) {
            intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=$linkedId"))
        }
        startActivity(intent)
    }

    private fun appInstalledOrNot(context: Context, uri: String): Boolean {
        val pm = context.packageManager
        try {
            pm.getPackageInfo(uri,0)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
        }

        return false
    }

    private fun setThemeToggle(){
        toggleButton.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this,"Theme light",Toast.LENGTH_SHORT).show()
                Utils.changeToTheme(this, Utils.THEME_LIGHT)

            } else {
                Toast.makeText(this,"Theme dark",Toast.LENGTH_SHORT).show()
                Utils.changeToTheme(this, Utils.THEME_DARK)
            }
        })
    }




}
