package com.example.mymichelin.data

import android.annotation.SuppressLint
import com.example.mymichelin.model.Restaurant

class Datasource {
    @SuppressLint("ResourceType")
    fun loadRestaurant():List<Restaurant>{
        return mutableListOf<Restaurant>(
            Restaurant(1,"석관동","세종대",4.5,"떡볶이 맛집."),
            Restaurant(2,"진미","금호동 금남시장",5.0,"내 최애 야채곱창집"),
            Restaurant(3,"버거점프","서울숲",4.0,"여기 마미손이랑 동업하나봄"),
            Restaurant(4,"서브웨이","어디든 있음",4.0,"샌드위치는 역시 .."),
            Restaurant(5,"뱃놈","세종대",5.0,"솔직히 여기보다 맛있는 조개구이 집은 어디에도 없음"),
            Restaurant(6,"이름 모를 식당 1","어딘가는 위치하겠지",1.5,"이제 쓸말 떨어짐"),
            Restaurant(7,"얘들아","살짝",1.5,"쓸말도 떨어졌는데"),
            Restaurant(8,"데이터","학교",4.5,"솔직히"),
            Restaurant(9,"일일히","데이터베이스",4.5,"이거 내가 데이터 쌓아야하니까"),
            Restaurant(10,"넣기","수업",4.5,"해야지.."),
            Restaurant(11,"빡세다","과제같음",4.5,"근데 진짜 앱 디자인 난 못하겠어.."),


            )
    }
}