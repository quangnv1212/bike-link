package com.example.bikelinklist.models

import java.io.Serializable

data class Place(val titles: String, val description: String, val latitude: Double, val longitude: Double) : Serializable

