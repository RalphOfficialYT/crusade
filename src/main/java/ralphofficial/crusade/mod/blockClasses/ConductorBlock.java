package ralphofficial.crusade.mod.blockClasses;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import ralphofficial.crusade.mod.ModItems;

public class ConductorBlock extends Block {
    public ConductorBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(CHARGED, false));
    }

    //Creates "CHARGED" blockstate
    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(CHARGED);
    }

    @Override
    //Detects when bolt conductor is right clicked
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if(hand == Hand.MAIN_HAND && !isChargeItem(itemStack) && isChargeItem(player.getStackInHand(Hand.OFF_HAND))) {
            return ActionResult.PASS;
        }else if(isChargeItem(itemStack)){

            //Sets blockstate "CHARGED" property to true if player is holding an Amethyst Orb

            world.setBlockState(pos, state.with(CHARGED, true));
            player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 1, 2);
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }

        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        //Checks whether the player has stepped on the block. If the "CHARGED" property is true, it will summon lightning.

        if (world.getBlockState(pos).get(CHARGED)){

            LightningEntity lightning = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
            lightning.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightning);

        }

        world.setBlockState(pos, state.with(CHARGED, false));

        super.onSteppedOn(world, pos, state, entity);
    }

    private static boolean isChargeItem(ItemStack stack) {
        return stack.isOf(ModItems.AMETHYST_ORB);
    }

}
