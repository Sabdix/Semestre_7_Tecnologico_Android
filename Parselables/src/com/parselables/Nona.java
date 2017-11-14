
package com.parselables;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * @author sabdi
 */
public class Nona implements Parcelable {
    int Edad;
    String description;
    
    public Nona() {
        Edad = 21;
        description = "lalalalal";
    }
    
    public Nona(Parcel in) {
        readFromParcel(in);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Edad);
        dest.writeString(description);
        
    }
    
    private void readFromParcel(Parcel in) {
        Edad = in.readInt();
        description = in.readString();
    }
    
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Nona createFromParcel(Parcel in) {
                return new Nona(in);
        }

        public Nona[] newArray(int size) {
            return new Nona[size];
        }
    };
}
