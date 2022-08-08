package com.github.yeeun_yun97.toy.hairreservation.ui

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.yeeun_yun97.toy.hairreservation.R
import com.github.yeeun_yun97.toy.hairreservation.ui.adapter.PriceRecyclerAdapter
import com.github.yeeun_yun97.toy.hairreservation.ui.adapter.ReservationRecyclerAdapter
import com.github.yeeun_yun97.toy.hairreservation.viewModel.ReservationViewModel
import com.google.android.material.textfield.TextInputEditText

class ReservationFragment : Fragment() {
    private val viewModel: ReservationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 예약정보 데이터 *임시*
        setViewReservation(view)
        setViewPrice(view)
        setViewCustomer(view)

        // click listener 설정::
        view.findViewById<Button>(R.id.paymentButton).setOnClickListener { moveToPhoneNumCheck() }
    }

    private fun setViewCustomer(view: View) {

    }

    private fun setViewPrice(view: View) {
        view.findViewById<View>(R.id.price).findViewById<TextView>(R.id.titleTextView).setText("결제정보")
        val recyclerView = view.findViewById<RecyclerView>(R.id.priceRecyclerView)
        val adapter = PriceRecyclerAdapter()
        adapter.setList(viewModel.getPriceList())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        val textHtml = viewModel.getAnnounceText()
        view.findViewById<TextView>(R.id.priceAnnouncementTextView)
            .setText(Html.fromHtml(textHtml, Html.FROM_HTML_MODE_COMPACT))
    }

    private fun setViewReservation(view: View) {
        view.findViewById<View>(R.id.reservation).findViewById<TextView>(R.id.titleTextView).setText("예약정보")
        val recyclerView = view.findViewById<RecyclerView>(R.id.reservationRecyclerView)
        val adapter = ReservationRecyclerAdapter()
        adapter.setList(viewModel.getReservationList())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    // on click event
    private fun moveToPhoneNumCheck() {
        val phoneEditText = requireView().findViewById<TextInputEditText>(R.id.phoneNumberTextView)
        val scrollView = requireView().findViewById<ScrollView>(R.id.reservationScrollView)
        scrollView.smoothScrollTo(0, phoneEditText.bottom)
        phoneEditText.requestFocus()
    }


}