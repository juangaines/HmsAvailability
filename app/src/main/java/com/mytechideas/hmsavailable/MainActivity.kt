package com.mytechideas.hmsavailable

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.huawei.hms.api.ConnectionResult
import com.huawei.hms.api.HuaweiApiAvailability
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hmas_available.text= "Is Hms Available: ${isHmsAvailable(this)}";


    }

    fun isHmsAvailable(context: Context?): Boolean {
        var isAvailable = false
        if (null != context) {
            val result =
                HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context)
            isAvailable = ConnectionResult.SUCCESS == result
        }
        Log.i(TAG, "isHmsAvailable: $isAvailable")
        return isAvailable
    }

    companion object{
        val TAG: String =MainActivity::class.java.simpleName
    }
}