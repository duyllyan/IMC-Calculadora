package br.com.duyllyan.imccalculator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IMC (
    val classificacao : Int,
    val imagem : Int
) : Parcelable