package me.infamous.predicate;

import eu.pb4.predicate.impl.PredicatesInit;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = PredicateAPIMod.MODID)
public class ModEventHandler {

    @SubscribeEvent
    static void onModLoadingComplete(FMLLoadCompleteEvent event){
        PredicatesInit.initialize();
    }
}
