package com.github.yeeun_yun97.toy.hairreservation.viewModel

import androidx.lifecycle.ViewModel
import com.github.yeeun_yun97.toy.hairreservation.data.Repository

class ReservationViewModel : ViewModel() {
    private val repo = Repository()

    fun getReservationList() = repo.getReservationDataList()

    fun getPriceList() = repo.getPriceDataList()

    fun getAnnounceText() = repo.getAnnounceMessage()

}