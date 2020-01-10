package com.example.templatepage.database

//object Data {
//    var items = arrayListOf(
//        GarbageCategory(1,"Newspaper","Paper"),
//        GarbageCategory(2,"Food Container","Plastic"),
//        GarbageCategory(3,"Sauce Bottle","Glass"),
//        GarbageCategory(4,"Cardboard","Paper")
//    )
//}
object GarbageData {
    var items = arrayListOf(
        Garbage("Paper","blue_bin"),
        Garbage("Plastic","orange_bin"),
        Garbage("Glass","brown_bin"),
        Garbage("Non-Recyclable","grey_bin")
    )
}