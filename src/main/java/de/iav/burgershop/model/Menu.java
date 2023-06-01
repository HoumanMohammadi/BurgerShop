package de.iav.burgershop.model;

public record Menu (String id,
                    String name,
                    double price,
                    Food mainDish,
                    Food sideDish,
                    Beverage beverage
){




}
