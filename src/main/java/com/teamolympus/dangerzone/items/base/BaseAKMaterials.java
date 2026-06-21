package com.teamolympus.dangerzone.items.base;

import com.teamolympus.dangerzone.misc.DangerZone;

public class BaseAKMaterials extends BaseAKItem{
    public BaseAKMaterials(String name) {
        super(name);
        this.setTextureName(DangerZone.MAT_PREFIX + name);
    }
}
