package ulysisllanes.fetchrewardstakehome.subunits.repository

import ulysisllanes.fetchrewardstakehome.subunits.api.FetchAPIRequest
import ulysisllanes.fetchrewardstakehome.subunits.api.FetchDataAPI
import javax.inject.Inject


class FetchRepository @Inject constructor(
    private val fetchAPI: FetchDataAPI
) : FetchAPIRequest() {

    suspend fun getData() = fetchAPIRequest { fetchAPI.getDataList() }
}