package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import retrofit2.HttpException
import java.io.IOException
import androidx.recyclerview.widget.RecyclerView.Adapter
// Or the specific adapter classyou're using

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TOdoAdapter // Use consistent naming (lowercase 't')
    private lateinit var myAdapter: TOdoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView() // Call this before fetching data

        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                Log.e(TAG, "You might not have internet connection: ${e.message}") // Include error message
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response: ${e.message}") // Include error message
                binding.progressBar.isVisible = false
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null) {
                todoAdapter.todos = response.body()!! // Use the correct adapter variable
            } else {
                Log.e(TAG, "Response not successful")
            }
            binding.progressBar.isVisible = false // Use the correct progress bar ID
        }
    }

    private fun setUpRecyclerView() = binding.rvtodos.apply {
        todoAdapter = TOdoAdapter() // Use the correct adapter variable
        binding.rvtodos.adapter = todoAdapter
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}