package ralphofficial.crusade.mod.entities;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.minecraft.world.explosion.ExplosionBehavior;
import ralphofficial.crusade.mod.MainClientClass;
import ralphofficial.crusade.mod.ModEntities;
import ralphofficial.crusade.mod.ModItems;
import ralphofficial.crusade.mod.packets.DynamiteEntitySpawnPacket;

public class DynamiteEntity extends ThrownItemEntity {

    public DynamiteEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public DynamiteEntity(World world, LivingEntity owner) {
        super(ModEntities.DynamiteEntityType, owner, world);
    }

    public DynamiteEntity(World world, double x, double y, double z) {
        super(ModEntities.DynamiteEntityType, x, y, z, world);
    }

    //The item texture the thrown entity will use
    @Override
    protected Item getDefaultItem() {
        return ModItems.DYNAMITE;
    }

    public void explode() {

        if(!this.world.isClient){

            System.out.println("test");
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 2F, Explosion.DestructionType.BREAK);

        }

    }

    //Is called when dynamite collides with blocks and entities
    protected void onCollision(HitResult hitResult){

        if(!this.world.isClient){

            this.explode();
            this.world.sendEntityStatus(this,(byte)3);
            this.discard();

        }

    }

    //Spawn packet shit which i dont know a single thing about
    @Override
    public Packet<?> createSpawnPacket() {
        return DynamiteEntitySpawnPacket.create(this, MainClientClass.PacketID);
    }
}
