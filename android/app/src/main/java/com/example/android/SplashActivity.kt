package com.example.android // Ellenőrizd, hogy ez megegyezik a manifesztben hivatkozott package-el

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splashactivity) // Ellenőrizd, hogy van-e egy activity_splash.xml fájl a layout mappában

        // Késleltetés és MainActivity indítása
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 3 másodperc késleltetés
    }
}
