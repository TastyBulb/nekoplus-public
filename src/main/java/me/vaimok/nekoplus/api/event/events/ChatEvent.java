package me.vaimok.nekoplus.api.event.events;
/*
 * @author Crystallinqq on 6/29/2020
 */

import me.vaimok.nekoplus.api.event.EventStage;
import net.minecraftforge.fml.common.eventhandler.Cancelable;

@Cancelable
public
class ChatEvent extends EventStage {
    private final String msg;

    public
    ChatEvent ( String msg ) {
        this.msg = msg;
    }

    public
    String getMsg ( ) {
        return this.msg;
    }
}
