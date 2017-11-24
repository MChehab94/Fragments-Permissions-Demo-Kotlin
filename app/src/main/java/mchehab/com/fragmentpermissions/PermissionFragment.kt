package mchehab.com.fragmentpermissions

import android.Manifest
import android.os.Bundle
import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.OnNeverAskAgain
import permissions.dispatcher.OnPermissionDenied
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class PermissionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_permission, container, false)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            readContactsWithPermissionCheck()
        }
        return view
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    @NeedsPermission(Manifest.permission.READ_CONTACTS)
    fun readContacts(){

    }

    @OnNeverAskAgain(Manifest.permission.READ_CONTACTS)
    fun neverAskAgain(){
        Toast.makeText(activity, "Never Ask Again!", Toast.LENGTH_LONG).show()
    }

    @OnPermissionDenied(Manifest.permission.READ_CONTACTS)
    fun permissionDenied(){
        Toast.makeText(activity, "Denied!", Toast.LENGTH_LONG).show()
    }

}// Required empty public constructor