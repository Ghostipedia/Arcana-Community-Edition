package com.ghostipedia.arcana.common;

import com.ghostipedia.arcana.api.registry.ArcanaRegistration;
import com.ghostipedia.arcana.api.registry.registrate.ArcanaRegistrate;
import com.ghostipedia.arcana.blocks.ArcanaBlocks;
import com.ghostipedia.arcana.common.data.ArcanaCreativeModTabs;
import com.ghostipedia.arcana.common.data.ArcanaDatagen;
import com.ghostipedia.arcana.items.ArcanaItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {
    public CommonProxy(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);

    }
    public static void init(){
        ArcanaCreativeModTabs.init();
        ArcanaItems.init();
        ArcanaBlocks.init();
        ArcanaRegistration.REGISTRATE.registerRegistrate();
        ArcanaDatagen.init();
    }
    @SubscribeEvent
    public void modConstruct(FMLConstructModEvent event){
        event.enqueueWork(CommonProxy::init);
    }
}
