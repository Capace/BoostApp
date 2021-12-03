package com.vv.boostapp.util

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Constants {

    const val BASE_URL = "http://192.168.0.236:8080/"
    const val QUESTIONS = "$BASE_URL/r1"

    const val PATH = "selectedPath"
    const val answer = "userAnswer"

    const val KEY_JWT_TOKEN = "jwt_token"
    const val KEY_USER_ID = "userId"

    const val MIN_PASS_LENGTH = 6
    const val MIN_USERNAME_LENGTH = 4

    const val SHARED_PREF_NAME = "shared_pref"

    val smallPadding = 4.dp
    val mediumPadding = 8.dp
    val largePadding = 12.dp
    val extraLargePadding = 24.dp

    val smallElevation = 2.dp
    val mediumElevation = 4.dp
    val bigElevation = 6.dp
    val veryBigElevation = 6.dp

    val smallClip = 4.dp
    val mediumClip = 8.dp
    val largeClip = 12.dp

    val smallHeight = 4.dp
    val mediumHeight = 8.dp
    val bigHeight = 12.dp

    val smallFont = 12.sp
    val mediumFont = 16.sp
    val bigFont = 20.sp
}