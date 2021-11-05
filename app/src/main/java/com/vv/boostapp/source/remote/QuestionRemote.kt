package com.vv.boostapp.source.remote

import android.net.http.HttpResponseCache.install
import com.vv.boostapp.util.Constants
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.text.get

class QuestionRemote @Inject constructor(){

    private val client = HttpClient(Android){
        install(JsonFeature){
            serializer = KotlinxSerializer()
        }
    }
    suspend fun getQuestions(path:String?): List<Question> = withContext(Dispatchers.IO){
        client.get(Constants.BASE_URL + path)
    }

/*{
        return client.get{
            url(Constants.BASE_URL + path)
        }
    }*/
}