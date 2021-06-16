package me.vaimok.nekoplus.manager;

import me.vaimok.nekoplus.event.events.PacketEvent;
import me.vaimok.nekoplus.features.Feature;
import me.vaimok.nekoplus.features.command.Command;
import me.vaimok.nekoplus.nekoplus;
import me.vaimok.nekoplus.util.TextUtil;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public
class ReloadManager extends Feature {

    public String prefix;

    public
    void init ( String prefix ) {
        this.prefix = prefix;
        MinecraftForge.EVENT_BUS.register ( this );
        if ( ! fullNullCheck ( ) ) {
            Command.sendMessage ( TextUtil.RED + "Phobos has been unloaded. Type " + prefix + "reload to reload." );
        }
    }

    public
    void unload ( ) {
        MinecraftForge.EVENT_BUS.unregister ( this );
    }

    @SubscribeEvent
    public
    void onPacketSend ( PacketEvent.Send event ) {
        if ( event.getPacket ( ) instanceof CPacketChatMessage ) {
            CPacketChatMessage packet = event.getPacket ( );
            if ( packet.getMessage ( ).startsWith ( this.prefix ) && packet.getMessage ( ).contains ( "reload" ) ) {
                nekoplus.load ( );
                event.setCanceled ( true );
            }
        }
    }
}
