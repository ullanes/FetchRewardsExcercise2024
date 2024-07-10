package ulysisllanes.fetchrewardstakehome.subunits.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ulysisllanes.fetchrewardstakehome.DisplayListViewModel
import ulysisllanes.fetchrewardstakehome.subunits.repository.FetchRepository
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
class DataListViewModelFactory @Inject constructor(
    private val fetchRepository: FetchRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T :ViewModel> create(modelClass: Class<T>): T{
        return DisplayListViewModel(fetchRepository) as T
    }
}