package ralphofficial.crusade.mod.itemClasses;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ralphofficial.crusade.mod.entities.DynamiteEntity;

public class DynamiteItem extends Item {
    public DynamiteItem(Settings settings) {
        super(settings);
    }

    //Detects right click and spawns a DynamiteEntity
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){

        //Sounds and item cooldown
        ItemStack stack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_WITCH_THROW, SoundCategory.NEUTRAL, 0.5f, 0.5f);
        user.getItemCooldownManager().set(this, 5);

        //Spawns the DynamiteEntity
        if(!world.isClient){

            DynamiteEntity dynamiteEntity = new DynamiteEntity(world, user);
            dynamiteEntity.setItem(stack);
            dynamiteEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f,1.5f,0f);
            world.spawnEntity(dynamiteEntity);

        }

        //Reduces item no. by 1 if not in creative mode
        if(!user.getAbilities().creativeMode){

            stack.decrement(1);

        }

        return TypedActionResult.success(stack, world.isClient);

    }

}
