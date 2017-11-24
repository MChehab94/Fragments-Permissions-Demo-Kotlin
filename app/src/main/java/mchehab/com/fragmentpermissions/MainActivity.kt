package mchehab.com.fragmentpermissions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            fragmentManager.beginTransaction().add(R.id.frameLayout, PermissionFragment()).commit()
        }

    }
}
