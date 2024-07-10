package ulysisllanes.fetchrewardstakehome.subunits.recyclerview

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ulysisllanes.fetchrewardstakehome.R
import ulysisllanes.fetchrewardstakehome.databinding.DataItemBinding
import ulysisllanes.fetchrewardstakehome.subunits.datamodel.FetchData

class DataListAdapter(
    private val dataList: FetchData
) : RecyclerView.Adapter<DataListAdapter.DataListViewHolder> (){
//something
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataListViewHolder(
            DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.data_item,
            parent,
            false
            )
        )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.dataItem.data = dataList[position]
        if(dataList[position].listId == 1)  holder.dataItem.tvIDListNum.setTextColor(Color.RED)
        if(dataList[position].listId == 2)  holder.dataItem.tvIDListNum.setTextColor(Color.BLACK)
        if(dataList[position].listId == 3)  holder.dataItem.tvIDListNum.setTextColor(Color.CYAN)
        if(dataList[position].listId == 4)  holder.dataItem.tvIDListNum.setTextColor(Color.MAGENTA)
    }

    inner class DataListViewHolder(
        val dataItem : DataItemBinding
    ) : RecyclerView.ViewHolder(dataItem.root)

}