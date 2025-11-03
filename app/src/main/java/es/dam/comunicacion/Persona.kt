package es.dam.comunicacion

import android.os.Parcel
import android.os.Parcelable

data class Persona(
    val nombre: String?,
    val apellidos: String?,
    val edad: Int
): Parcelable{

    //Convierte un parcel en un objeto de tipo Persona
    constructor(source: Parcel):this(
        source.readString()!!,
        source.readString()!!,
        source.readInt()
    )

    override fun describeContents(): Int {
        return 0;
    }

    // Convierte el objeto persona en un parcel
    override fun writeToParcel(p0: Parcel, p1: Int) {
        p0.writeString(nombre);
        p0.writeString(apellidos);
        p0.writeInt(edad);
    }

    companion object CREATOR : Parcelable.Creator<Persona> {
        override fun createFromParcel(parcel: Parcel): Persona {
            return Persona(parcel)
        }

        override fun newArray(size: Int): Array<Persona?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombre $apellidos $edad"
    }
}