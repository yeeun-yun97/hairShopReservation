package com.github.yeeun_yun97.toy.hairreservation.data


class Repository {
    private val reservationDataList = listOf(
        Pair("날짜/시간", "2022년 8월 4일 목요일 오후 05:00"),
        Pair("매장/담당", "이철 헤어커커 일산 차병원점 \n스타일리스트 민희"),
        Pair("선택메뉴", "여성컷")
    )

    private val priceDataList = listOf(Pair("메뉴가격", "20,000"))

    private val announceMessage = """
            <ul>
            	<li>고객님의 헤어/네일 상태에 따라 선택한 시술이 불가능하거나 추가 비용이 발생할 수 있습니다.</li>
            	<li>시술 예약시간 2시간 전까지 취소시 100% 취소/환불이 가능하며, 이후 취소하거나 미방문일 경우, 10%의 페널티가 부과되어 90% 취소/환불 됩니다.</li>
            	<li>시술 예약시간 2시간 전까지 '날짜 및 시간' 변경 가능합니다.</li>
            	<li>시술 예약 변경은 예약당 3회까지 가능합니다.</li>
            </ul>
        """.trimIndent()

    fun getReservationDataList() = reservationDataList
    fun getPriceDataList() = priceDataList
    fun getAnnounceMessage() = announceMessage


}