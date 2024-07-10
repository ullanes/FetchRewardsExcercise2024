package ulysisllanes.fetchrewardstakehome

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ulysisllanes.fetchrewardstakehome.subunits.recyclerview.DataListAdapter

@AndroidEntryPoint
class DisplayListViewActivity : ComponentActivity() {

    private val viewModel: DisplayListViewModel by viewModels<DisplayListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_list_view)
        val recyclerViewDataList = findViewById<RecyclerView>(R.id.recyclerViewDataList)
        val errorView = findViewById<LinearLayout>(R.id.errorView)
        val tvRetry = findViewById<TextView>(R.id.tvRetry)
        viewModel.getDataList()
        viewModel.dataList.observe(this, Observer { data ->
            if (data != null) {
                recyclerViewDataList.also {
                    it.layoutManager = LinearLayoutManager(this)
                    it.setHasFixedSize(true)
                    it.adapter = DataListAdapter(data)
                }
            } else {
                recyclerViewDataList.visibility = View.GONE
                errorView.visibility = View.VISIBLE
                tvRetry.setOnClickListener{
                    view-> onRestart()
                }

                Toast.makeText(
                    this,
                    "API Error, check network connection or try again later.",
                    Toast.LENGTH_LONG
                ).show()

            }
        })

    }


    override fun onRestart() {
        super.onRestart()
        finish()
        startActivity(intent)
    }

}

