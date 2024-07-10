package ulysisllanes.fetchrewardstakehome

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ulysisllanes.fetchrewardstakehome.subunits.api.Coroutine
import ulysisllanes.fetchrewardstakehome.subunits.datamodel.FetchData
import ulysisllanes.fetchrewardstakehome.subunits.repository.FetchRepository
import kotlinx.coroutines.Job
import ulysisllanes.fetchrewardstakehome.subunits.api.AsyncResult
import javax.inject.Inject

@HiltViewModel
class DisplayListViewModel @Inject constructor(
    private val fetchRepository: FetchRepository
) : ViewModel() {
    private lateinit var job: Job
    private val _dataList = MutableLiveData<FetchData?>()
    val dataList: MutableLiveData<FetchData?>
        get() = _dataList

    fun getDataList() {
        job = Coroutine.ioThenMain(
            { fetchRepository.getData() },
            {
                when (it) {
                    is AsyncResult.Success -> {
                        _dataList.value = it.data
                        sortAndFilter()
                    }

                    is AsyncResult.Error -> {
                        _dataList.value = null
                    }

                    null -> {
                        _dataList.value = null
                    }
                }
            }
        )
    }

    private fun sortAndFilter() {
        _dataList.value?.removeAll { it.name == "" || it.name == null }
        _dataList.value?.sortBy { it.id }
        _dataList.value?.sortBy { it.listId }
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}