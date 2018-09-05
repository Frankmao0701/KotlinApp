package frank.com.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class FouthActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fouth)
        println("length 为::"+getStringLenth(11))

    }
    fun getStringLenth(str : Any):Int{
        if (str is String)
            return str.length
        return 0
    }
}