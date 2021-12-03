package com.vv.boostapp.di

import android.content.Context
import androidx.room.Room
import com.vv.boostapp.source.local.QuestionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appcontext: Context
    ) =
        Room.databaseBuilder(appcontext, QuestionDatabase::class.java, "database_db")
            .build()


    @Singleton
    @Provides
    fun provideDao(db: QuestionDatabase) = db.getQuestions()
}