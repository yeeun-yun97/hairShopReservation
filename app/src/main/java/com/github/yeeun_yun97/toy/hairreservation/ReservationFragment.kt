package com.github.yeeun_yun97.toy.hairreservation

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItem(pair: Pair<String, String>) {
        val nameTextView = itemView.findViewById<TextView>(R.id.reservationNameTextView)
        val contentTextView = itemView.findViewById<TextView>(R.id.reservationContentTextView)
        nameTextView.setText(pair.first)
        contentTextView.setText(pair.second)
    }
}

class PriceVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItem(pair: Pair<String, String>) {
        val nameTextView = itemView.findViewById<TextView>(R.id.serviceNameTextView)
        val contentTextView = itemView.findViewById<TextView>(R.id.servicePriceTextView)
        nameTextView.setText(pair.first)
        contentTextView.setText(pair.second)
    }
}


class ReservationFragment : Fragment() {

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

    private fun moveToPhoneNumCheck() {
        val phoneEditText = requireView().findViewById<TextInputEditText>(R.id.phoneNumberTextView)
        val scrollView = requireView().findViewById<ScrollView>(R.id.reservationScrollView)
        scrollView.smoothScrollTo(0, phoneEditText.bottom)
        phoneEditText.requestFocus()
    }

    private fun setViewCustomer(view: View) {

    }

    private fun setViewPrice(view: View) {
        view.findViewById<View>(R.id.price).findViewById<TextView>(R.id.titleTextView)
            .setText("결제정보")
        val recyclerView = view.findViewById<RecyclerView>(R.id.priceRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = object : RecyclerView.Adapter<PriceVH>() {
            private val list = listOf(Pair("메뉴가격", "20,000"))

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceVH {
                val view =
                    LayoutInflater.from(context)
                        .inflate(R.layout.item_selected_service, parent, false)
                return PriceVH(view)
            }

            override fun onBindViewHolder(holder: PriceVH, position: Int) = holder.setItem(list[position])
            override fun getItemCount(): Int = list.size
        }
        val textHtml = """
            <ul>
            	<li>고객님의 헤어/네일 상태에 따라 선택한 시술이 불가능하거나 추가 비용이 발생할 수 있습니다.</li>
            	<li>시술 예약시간 2시간 전까지 취소시 100% 취소/환불이 가능하며, 이후 취소하거나 미방문일 경우, 10%의 페널티가 부과되어 90% 취소/환불 됩니다.</li>
            	<li>시술 예약시간 2시간 전까지 '날짜 및 시간' 변경 가능합니다.</li>
            	<li>시술 예약 변경은 예약당 3회까지 가능합니다.</li>
            </ul>
        """.trimIndent()
        view.findViewById<TextView>(R.id.priceAnnouncementTextView)
            .setText(Html.fromHtml(textHtml, Html.FROM_HTML_MODE_COMPACT))
    }

    private fun setViewReservation(view: View) {
        view.findViewById<View>(R.id.reservation).findViewById<TextView>(R.id.titleTextView)
            .setText("예약정보")
        val recyclerView = view.findViewById<RecyclerView>(R.id.reservationRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = object : RecyclerView.Adapter<Vh>() {
            private val list = listOf(
                Pair("날짜/시간", "2022년 8월 4일 목요일 오후 05:00"),
                Pair("매장/담당", "이철 헤어커커 일산 차병원점 \n스타일리스트 민희"),
                Pair("선택메뉴", "여성컷")
            )

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
                val view =
                    LayoutInflater.from(context).inflate(R.layout.item_reservation, parent, false)
                return Vh(view)
            }
            override fun onBindViewHolder(holder: Vh, position: Int) { holder.setItem(list[position]) }
            override fun getItemCount(): Int = list.size
        }
    }
}