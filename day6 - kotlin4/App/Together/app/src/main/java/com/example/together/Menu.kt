package com.example.together

data class Menu (
    val name: String,
    val price: Int,
    val image: Int,
    val category: Category,
    var quantity: Int = 0
)

enum class Category {
    Burger, Pizza, Beer, Coffee
}

object MenuManager {
    // 메뉴 아이템 리스트
    val menuItems = mutableListOf<Menu>()

    init {
        // 초기 메뉴 항목 추가

        menuItems.add(Menu("치즈버거", 5000, R.drawable.burger, Category.Burger))
        menuItems.add(Menu("치킨버거", 6000, R.drawable.chicken_burger, Category.Burger))
        menuItems.add(Menu("새우버거", 6500, R.drawable.shirimp_burger, Category.Burger))
        menuItems.add(Menu("불고기버거", 7000, R.drawable.bulgogi_burger, Category.Burger))

        menuItems.add(Menu("페페로니", 10000, R.drawable.pizza, Category.Pizza))
        menuItems.add(Menu("콤비네이션", 10000, R.drawable.combination, Category.Pizza))
        menuItems.add(Menu("쉬림프피자", 12000, R.drawable.shrimp_pizza, Category.Pizza))
        menuItems.add(Menu("포테이토피자", 11000, R.drawable.potato_pizza, Category.Pizza))

        menuItems.add(Menu("코로나", 8000, R.drawable.beer, Category.Beer))
        menuItems.add(Menu("기네스", 10000, R.drawable.guinness, Category.Beer))
        menuItems.add(Menu("버드와이저", 9000, R.drawable.budweiser, Category.Beer))
        menuItems.add(Menu("빅웨이브", 10000, R.drawable.bigwave, Category.Beer))

        menuItems.add(Menu("에스프레소", 4000, R.drawable.coffee, Category.Coffee))
        menuItems.add(Menu("아메리카노", 5000, R.drawable.americano, Category.Coffee))
        menuItems.add(Menu("라떼", 6000, R.drawable.latte, Category.Coffee))
        menuItems.add(Menu("오렌지카노", 7000, R.drawable.orangecano, Category.Coffee))
    }

    // 모든 메뉴의 총 개수 계산
    fun totalQuantity(): Int {
        return menuItems.sumOf { it.quantity } // 각 메뉴의 수량을 합산
    }

    // 모든 메뉴의 총 금액 계산
    fun totalPrice(): Int {
        return menuItems.sumOf { it.quantity * it.price } // 각 메뉴의 가격과 수량을 곱하여 합산
    }

    // 메뉴 수량 초기화
    fun reset() {
        for (menu in menuItems) {
            menu.quantity = 0
        }
    }
}