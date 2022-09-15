package de.onecode.gameofthrones.model

import com.google.gson.annotations.SerializedName

data class HouseModel(

    @SerializedName("url")
    var url: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("region")
    var region: String? = null,
    @SerializedName("coatOfArms")
    var coatOfArms: String? = null,
    @SerializedName("words")
    var words: String? = null,
    @SerializedName("titles")
    var titles: ArrayList<String> = arrayListOf(),
    @SerializedName("seats")
    var seats: ArrayList<String> = arrayListOf(),
    @SerializedName("currentLord")
    var currentLord: String? = null,
    @SerializedName("heir")
    var heir: String? = null,
    @SerializedName("overlord")
    var overlord: String? = null,
    @SerializedName("founded")
    var founded: String? = null,
    @SerializedName("founder")
    var founder: String? = null,
    @SerializedName("diedOut")
    var diedOut: String? = null,
    @SerializedName("ancestralWeapons")
    var ancestralWeapons: ArrayList<String> = arrayListOf(),
    @SerializedName("cadetBranches")
    var cadetBranches: ArrayList<String> = arrayListOf(),
    @SerializedName("swornMembers")
    var swornMembers: ArrayList<String> = arrayListOf()

)
