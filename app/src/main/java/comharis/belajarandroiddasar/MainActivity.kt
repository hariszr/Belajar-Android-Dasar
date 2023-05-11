package comharis.belajarandroiddasar

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")

    private lateinit var welcomeTv : TextView
    private lateinit var nameEt : EditText
    private lateinit var loginBtn : Button
    private lateinit var registerTv : TextView

    private fun initComponents(){
        welcomeTv = findViewById(R.id.welcomeTv)
        nameEt = findViewById(R.id.nameEt)
        loginBtn = findViewById(R.id.loginBtn)
        registerTv = findViewById(R.id.registerTv)
    }

    private fun checkFingerprint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Feature Fingerprint ON")
        } else {
            Log.w("FEATURE", "Feature Fingerprint OFF")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q){
            Log.i("SDK", "Disable feature, because version sdk is lower than 31")
        } else {
            Log.i("SDK", "Enable feature")
        }
    }

    private fun printHello(name: String){
        Log.i("DEBUG", name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        welcomeTv.text = resources.getString(R.string.app_name)

        loginBtn.setOnClickListener {
            val firstName = "Udin"
            printHello(firstName)

            checkFingerprint()
            checkPlatformVersion()

            val sampel = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            Log.i("RAW", sampel)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }

            Log.i("ASSETS", json)

//            resources.getDrawable(R.drawable.photos, theme)

            Log.d("Haris", "This is debug log")
            Log.i("Haris", "This is info log")
            Log.w("Haris", "This is Warning log")
            Log.e("Haris", "This is error log")

            val name = nameEt.text.toString()
            registerTv.text = "Hi $name"

        }
    }
}