package net.lucas.mccourse.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(4)
            .saturationModifier(0.5f).statusEffect(new StatusEffectInstance(StatusEffects.GLOWING), 0.25f)
            .build();
}
