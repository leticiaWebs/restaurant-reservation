package com.example.restaurant.reservation.domain.Enums;


public enum FoodType {
    CONFEITARIA("confeitaria"),
    PADARIA("padaria"),
    SORVETERIA("sorveteria"),
    CHINESA("chinesa"),
    ITALIANA("italiana"),
    INDIANA("indiana"),
    PORTUGUESA("portuguesa"),
    PEIXES("peixes"),
    VEGANO("vegano"),
    FRANCESA("francesa"),
    MEXICANA("mexicana"),
    CONTEMPORANEA("comtemporanea");

    private final String description;


    FoodType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
