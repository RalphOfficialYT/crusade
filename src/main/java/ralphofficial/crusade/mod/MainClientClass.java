package ralphofficial.crusade.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.impl.networking.ClientSidePacketRegistryImpl;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.pack.ResourcePackOrganizer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import ralphofficial.crusade.mod.entities.DynamiteEntity;
import ralphofficial.crusade.mod.packets.DynamiteEntitySpawnPacket;

import java.util.UUID;

public class MainClientClass implements ClientModInitializer {

    public static final Identifier PacketID = new Identifier(MainClass.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.DynamiteEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
        receiveEntityPacket();

    }

    public void receiveEntityPacket() {

        //I literally have no clue whats going on here.

        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = DynamiteEntitySpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = DynamiteEntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = DynamiteEntitySpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.setPitch(pitch);
                e.setYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }

}
