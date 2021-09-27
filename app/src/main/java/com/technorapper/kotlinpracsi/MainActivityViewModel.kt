package com.technorapper.kotlinpracsi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*


class MainActivityViewModel : ViewModel() {
    override fun onCleared() {

        super.onCleared()
    }


    private val _downloading: MutableLiveData<Boolean> = MutableLiveData()
    val downloading: LiveData<Boolean> = _downloading
    fun setStateEvent(mainStateEvent: MainStateEvent) {
        viewModelScope.launch {


        }


    }

    fun testSime() {
        CoroutineScope(Dispatchers.IO).launch {
            var abv = launch { 123 }
            var abc = runBlocking { 123 }
            var resultOneDeferred = async { println("test one ${System.currentTimeMillis()}") }
            var resultTwoDeferred = async { println("test three ${System.currentTimeMillis()}") }
            var value = async { println("test two ${System.currentTimeMillis()}") }.await()
            async { println("test four ${System.currentTimeMillis()}") }.await()
            // val combinedResult = resultOneDeferred.await() + resultTwoDeferred.await()
            awaitAll(async {
                println("test five ${System.currentTimeMillis()}")
            }, async {
                println("test six ${System.currentTimeMillis()}")
            }, async {
                println("test seven ${System.currentTimeMillis()}")
            })

            coroutineScope {
                launch { call1() }
                launch { call2() }
                launch { call3() }
            }
        }
        runInParallel()
        GlobalScope.launch(Dispatchers.IO) { }

        Log.d(TAG, "After all finishings")

    }

    fun ekHor() {


    }

    var TAG = "test"
    suspend fun call1() = withContext(Dispatchers.IO) {
        Log.d(TAG, "Call 1 started")
        delay(2000)
        Log.d(TAG, "Call 1 fiished")
    }

    suspend fun call2() = withContext(Dispatchers.IO) {
        Log.d(TAG, "Call 2 started")
        delay(5000)
        Log.d(TAG, "Call 2 finished")
    }

    suspend fun call3() = withContext(Dispatchers.IO) {
        Log.d(TAG, "Call 3 started")
        delay(1000)
        Log.d(TAG, "Call 3 finished")
    }

    private var job: Job = Job()
    private var scope =
        CoroutineScope(Dispatchers.Main + job) // creating the scope to run the coroutine. It consists of Dispatchers.Main (coroutine will run in the Main context) and job to handle the cancellation of the coroutine.

    fun runInParallel() {
        scope.launch { // launch a coroutine
            // runs in parallel
            val deferredList = listOf(
                scope.async { println("test eight ${System.currentTimeMillis()}") },
                scope.async { println("test nine  ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") },
                scope.async { println("test tem ${System.currentTimeMillis()}") }
            )

            deferredList.awaitAll() // wait for all data to be processed without blocking the UI thread

            // do some stuff after data has been processed, for example update UI
        }

        fun scopeOperator() {

            var letW = Person2("Alice", 20, "Amsterdam").let {
                println(it)
                it.name = "London"
                it.age = 22;
                println(it)
                22
            }//value

            var runW = Person2("Alice", 20, "Amsterdam").run {
                println(this.age)
                name = "London"
                age = 22;
                22
            }//Value


            var applyW = Person2("Alice", 20, "Amsterdam").apply {
                println(this)
                name = "London"
                age = 22;

            }//Person

            var withW = with(Person2("Alice", 20, "Amsterdam")){
                "22"

            }//value

            var lalsoW = Person2("Alice", 20, "Amsterdam").also {
                println(it)
                it.name = "London"
                it.age = 22;
                println(it)

            }//Person


        }
    }

    sealed class MainStateEvent {

        object FetchImages : MainStateEvent()

    }
}



