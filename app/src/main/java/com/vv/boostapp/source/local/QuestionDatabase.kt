package com.vv.boostapp.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [LocalQuestion::class], version = 1)
@TypeConverters(Converters::class)
abstract class QuestionDatabase: RoomDatabase() {
    abstract fun getQuestions(): QuestionDao
}