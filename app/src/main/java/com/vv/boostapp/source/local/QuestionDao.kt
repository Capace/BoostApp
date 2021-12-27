package com.vv.boostapp.source.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Query("select * from questions order by value")
    suspend fun queryAll(): List<LocalQuestion>

    @Query("select count(*) from questions")
    suspend fun count(): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(questions: List<LocalQuestion>)

    @Query("delete from questions")
    suspend fun nukeTable()


}