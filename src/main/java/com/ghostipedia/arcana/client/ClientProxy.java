package com.ghostipedia.arcana.client;

import com.ghostipedia.arcana.common.CommonProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {
    public ClientProxy() {
        super();
        init();
    }
    public static void init() {

    }
}
