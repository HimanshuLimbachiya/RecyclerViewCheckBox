package win10.example.com.recyclerviewcheckbox

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Abhin.
 */
@Parcelize
data class DataClass(var imageUrl : String,var checked : Boolean = false):Parcelable